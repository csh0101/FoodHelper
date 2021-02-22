package com.csh.food.res.baidu.pic;

import lombok.Data;

import java.io.Serializable;

@Data
public class Baidu_Dish implements Serializable {
    String name;
    float calorie;
    float probability;
    Baidu_Info baike_info;
}
