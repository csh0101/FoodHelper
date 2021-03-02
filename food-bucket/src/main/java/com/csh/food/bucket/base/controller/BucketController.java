package com.csh.food.bucket.base.controller;


import com.csh.food.bucket.base.domain.request.BucketRequest;
import com.csh.food.bucket.base.service.BucketService;
import com.csh.food.res.base.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BucketController {

    @Autowired
    BucketService bucketService;

    @RequestMapping(value = "/bucket",method = RequestMethod.PUT)
    public ResponseResult BucketAdd(@RequestBody BucketRequest request){
        return bucketService.BucketAdd(request);
    }
}
