package com.csh.food.bucket.base.converter;

import com.csh.food.bucket.base.domain.dto.FoodDTO;
import com.csh.food.bucket.base.domain.entity.BucketEntity;
import com.csh.food.bucket.base.domain.entity.FoodEntity;
import com.csh.food.bucket.base.domain.request.BucketRequest;
import com.csh.food.bucket.base.domain.request.FoodRequest;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BucketConverter {
    public static BucketEntity RTE(BucketRequest request){
        BucketEntity entity = new BucketEntity();
        BeanUtils.copyProperties(request,entity);
        List<FoodRequest> foods = request.getFoods();
        if(Objects.nonNull(foods)){
            List<FoodDTO> ets = foods.stream().map(req -> {
                FoodDTO fd = new FoodDTO();
                BeanUtils.copyProperties(fd, req);
                return fd;
            }).collect(Collectors.toList());
            entity.setBucketFoods(ets);
        }
        return entity;
    }
}
