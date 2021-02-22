package com.csh.food.bucket.base.controller;


import com.csh.food.bucket.base.domain.request.FoodRequest;
import com.csh.food.bucket.base.service.FoodService;
import com.csh.food.bucket.base.service.FoodTellService;
import com.csh.food.res.base.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class FoodController {

    @Autowired
    FoodService foodService;

    @RequestMapping(value = "/food",method = RequestMethod.POST)
    public ResponseResult foodAdd(@RequestBody FoodRequest request){
        return foodService.foodAdd(request);
    }
}
