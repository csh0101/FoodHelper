package com.csh.food.dubbo.base.pic.entity;

import com.csh.food.res.baidu.pic.Baidu_Info;
import lombok.Data;

import java.io.Serializable;

@Data
public class DishEntity implements Serializable {
    String foodName;

    float foodProbability;

    float foodCalorie;

    Baidu_Info baiduInfo;

}
