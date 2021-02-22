package com.csh.food.bucket.base.service.serviceImpl;

import com.csh.food.bucket.base.converter.FoodConverter;
import com.csh.food.bucket.base.domain.entity.FoodEntity;
import com.csh.food.bucket.base.domain.request.FoodRequest;
import com.csh.food.bucket.base.domain.response.FoodResponse;
import com.csh.food.bucket.base.mapper.FoodMapper;
import com.csh.food.bucket.base.service.FoodService;
import com.csh.food.res.base.response.ResponseResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

    @Mapper
    FoodMapper foodMapper;

    @Override
    public ResponseResult foodAdd(FoodRequest request) {
        FoodEntity entity = FoodConverter.RTE(request);
        FoodResponse res = new FoodResponse();
        res.setId(foodMapper.foodIncr(entity));
        res.setFoodName(entity.getFoodName());
        return ResponseResult.success(entity);
    }
}
