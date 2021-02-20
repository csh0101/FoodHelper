package com.csh.food.dubbo.base.service.pic;

import com.csh.food.dubbo.base.pic.FoodPicInfoEntity;
import com.csh.food.dubbo.base.vo.DVO;

import java.util.List;

public interface FoodPicInfoService {
     DVO foodPicAnalysis(byte[] file);
}
