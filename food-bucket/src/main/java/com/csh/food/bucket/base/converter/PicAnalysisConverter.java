package com.csh.food.bucket.base.converter;

import com.csh.food.bucket.base.domain.response.PicAnalysisResponse;
import com.csh.food.dubbo.base.pic.FoodPicInfoEntity;
import com.csh.food.dubbo.base.pic.entity.DishEntity;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class PicAnalysisConverter {
    public static  List<PicAnalysisResponse> ETR(List<FoodPicInfoEntity> list){
        return list.stream().map(ob->{
            PicAnalysisResponse response = new PicAnalysisResponse();
            BeanUtils.copyProperties(ob,response);
            return response;
        }).collect(Collectors.toList());
    }
}
