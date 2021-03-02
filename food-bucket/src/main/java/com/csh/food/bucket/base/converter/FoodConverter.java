package com.csh.food.bucket.base.converter;

import com.csh.food.bucket.base.domain.entity.FoodEntity;
import com.csh.food.bucket.base.domain.request.FoodRequest;
import org.springframework.beans.BeanUtils;

public class FoodConverter {
    public static  FoodEntity RTE(FoodRequest request){
        FoodEntity entity = new FoodEntity();
        BeanUtils.copyProperties(request,entity);
        return entity;
    }
}
