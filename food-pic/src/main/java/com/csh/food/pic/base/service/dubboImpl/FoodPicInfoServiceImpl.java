package com.csh.food.pic.base.service.dubboImpl;

import com.csh.food.dubbo.base.pic.converter.DishConverter;
import com.csh.food.dubbo.base.pic.entity.DishEntity;
import com.csh.food.dubbo.base.service.pic.FoodPicInfoService;
import com.csh.food.dubbo.base.util.converter.OConverter;
import com.csh.food.dubbo.base.vo.DVO;
import com.csh.food.pic.base.util.FoodAipImageClassifyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(interfaceClass = FoodPicInfoService.class ,version = "1.0.0",protocol = {"dubbo"})
@Slf4j
public class FoodPicInfoServiceImpl implements FoodPicInfoService {

    @Override
    public DVO foodPicAnalysis(byte[] file) {
        List<DishEntity> etList = null;
        try{
            etList = FoodAipImageClassifyUtil.dishImageAnalysis(file);
        }catch (Exception e){
            log.info("error while call baidu api"+e.getMessage());
            return null;
        }
        DVO dvo = new DVO();
        dvo.setObjList(OConverter.OListConverter(DishConverter.dishToFood(etList)));
        return dvo;
    }
}
