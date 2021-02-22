package com.csh.food.bucket.base.service;

import com.csh.food.bucket.base.domain.request.FoodRequest;
import com.csh.food.res.base.response.ResponseResult;


public interface FoodService {
    ResponseResult foodAdd(FoodRequest request);
}
