package com.csh.food.res.baidu.pic;

import lombok.Data;

@Data
public class Baidu_Dish {
    String name;
    float calorie;
    float probability;
    Baidu_Info baike_info;
}
