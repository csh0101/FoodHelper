package com.csh.food.bucket.base.service;

import com.csh.food.dubbo.base.vo.DVO;
import com.csh.food.res.base.response.ResponseResult;
import org.springframework.web.multipart.MultipartFile;


public interface FoodTellService {
    ResponseResult foodPicAnalysis(MultipartFile file);

}
