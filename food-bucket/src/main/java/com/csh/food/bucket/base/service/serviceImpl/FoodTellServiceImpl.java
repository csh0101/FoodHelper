package com.csh.food.bucket.base.service.serviceImpl;

import com.csh.food.bucket.base.converter.PicAnalysisConverter;
import com.csh.food.bucket.base.domain.response.PicAnalysisResponse;
import com.csh.food.bucket.base.service.FoodTellService;
import com.csh.food.bucket.constant.PicConst;
import com.csh.food.dubbo.base.pic.FoodPicInfoEntity;
import com.csh.food.dubbo.base.service.pic.FoodPicInfoService;
import com.csh.food.dubbo.base.util.converter.JConverter;
import com.csh.food.dubbo.base.vo.DVO;
import com.csh.food.res.base.response.HttpResponseCodeEnum;
import com.csh.food.res.base.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Slf4j
public class FoodTellServiceImpl implements FoodTellService {

    @Reference(protocol = "dubbo",version = "1.0.0",interfaceClass = FoodPicInfoService.class)
    FoodPicInfoService foodPicInfoService;

    @Override
    public ResponseResult foodPicAnalysis(MultipartFile file) {
        DVO dvo = null;
        if(file.getSize() > PicConst.size){
            return ResponseResult.error(HttpResponseCodeEnum.Condition.getCode(),HttpResponseCodeEnum.Condition.getMessage(),"图片应该小于4MB");
        }
        try{
            dvo = foodPicInfoService.foodPicAnalysis(file.getBytes());
        }catch (Exception e){
            log.info("error info is"+e.getMessage());
            return ResponseResult.error(null);
        }
        //TODO 写一个嵌套类的泛型转换器 放在公共包里面
        List<Object> objs = dvo.getObjList();
        List<FoodPicInfoEntity> es = JConverter.jesConverter(objs);
        List<PicAnalysisResponse> response = PicAnalysisConverter.ETR(es);
        return ResponseResult.success(response);
    }
}
