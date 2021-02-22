package com.csh.food.bucket.base.mapper;

import com.csh.food.bucket.base.domain.entity.FoodEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
@Mapper
public interface FoodMapper {

    @Insert("insert into food (food_name,food_calorie) values (#{foodName},#{foodCalorie})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
     Integer foodIncr(FoodEntity foodEntity);
}
