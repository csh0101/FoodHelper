package com.csh.food.bucket.base.controller;

import com.csh.food.bucket.base.service.FoodTellService;
import com.csh.food.res.base.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@Slf4j
public class PicController {

    @Autowired
    FoodTellService foodTellService;

    @RequestMapping("/picAnalysis")
    public ResponseResult picAnalysis(@RequestParam(value = "file")MultipartFile file){
        return foodTellService.foodPicAnalysis(file);
    }
}
