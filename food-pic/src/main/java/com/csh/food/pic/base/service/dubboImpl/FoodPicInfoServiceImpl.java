package com.csh.food.pic.base.service.dubboImpl;

import com.csh.food.dubbo.base.entity.FoodPicInfoEntity;
import com.csh.food.dubbo.base.service.FoodPicInfoService;
import com.csh.food.pic.base.analysis.FoodAipImageClassify;
import org.apache.dubbo.config.annotation.Service;

@Service
public class FoodPicInfoServiceImpl implements FoodPicInfoService {


    @Override
    public FoodPicInfoEntity foodPicAnalysis(byte[] pic) {
        FoodAipImageClassify.dishImageAnalysis(pic);
    }
}
