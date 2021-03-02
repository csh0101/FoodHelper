package com.csh.food.bucket.base.service;

import com.csh.food.bucket.base.domain.request.BucketRequest;
import com.csh.food.bucket.base.domain.request.FoodRequest;
import com.csh.food.res.base.response.ResponseResult;

public interface BucketService {
    ResponseResult BucketAdd(BucketRequest request);
}
