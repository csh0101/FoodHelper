package com.csh.food.dubbo.base.pic;

import com.csh.food.res.baidu.pic.Baidu_Info;
import lombok.Data;

import java.io.Serializable;

@Data
public class FoodPicInfoEntity implements Serializable {
    String foodName;

    float foodProbability;

    float foodCalorie;

    Baidu_Info baiduInfo;
}
