package com.csh.food.dubbo.base.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class FoodPicInfoEntity implements Serializable {
    String foodDescription;

    String foodName;

    String foodCalorie;
}
