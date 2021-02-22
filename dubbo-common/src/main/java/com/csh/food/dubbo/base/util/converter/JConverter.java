package com.csh.food.dubbo.base.util.converter;

import com.csh.food.dubbo.base.pic.FoodPicInfoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JConverter {

    public static List<FoodPicInfoEntity> jesConverter(List<Object> list){
        List<FoodPicInfoEntity> res = new ArrayList<>();
        for(Object o : list){
            res.add((FoodPicInfoEntity)o);
        }
        return res;
    }
}
