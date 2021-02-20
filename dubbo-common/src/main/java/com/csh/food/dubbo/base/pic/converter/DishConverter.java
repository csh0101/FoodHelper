package com.csh.food.dubbo.base.pic.converter;

import com.csh.food.dubbo.base.pic.FoodPicInfoEntity;
import com.csh.food.dubbo.base.pic.entity.DishEntity;
import com.csh.food.res.baidu.pic.Baidu_Dish;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class DishConverter {
    public static List<FoodPicInfoEntity> dishToFood(List<DishEntity> list){
        FoodPicInfoEntity food = new FoodPicInfoEntity();
       return list.stream().map(ob->{
           FoodPicInfoEntity entity  = new FoodPicInfoEntity();
           BeanUtils.copyProperties(ob,entity);
           return entity;
       }).collect(Collectors.toList());
    }
    public static List<DishEntity> bdDishToEList(List<Baidu_Dish> list){
        return list.stream().map(ob->{
            DishEntity entity = new DishEntity();
            entity.setBaiduInfo(ob.getBaike_info());
            entity.setFoodCalorie(ob.getCalorie());
            entity.setFoodProbability(ob.getProbability());
            entity.setFoodName(ob.getName());
            return entity;
        }).collect(Collectors.toList());
    }
}
