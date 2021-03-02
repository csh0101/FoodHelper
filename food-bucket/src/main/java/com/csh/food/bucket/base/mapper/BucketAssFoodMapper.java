package com.csh.food.bucket.base.mapper;

import com.csh.food.bucket.base.domain.entity.BucketAssFoodEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BucketAssFoodMapper {
    @Insert("<script>" +
            "insert into bucket_food(id,food_id,bucket_id)" +
            "values" +
            "<foreach collection='result' item='item'  separator=','>"+
            "(#{item.id}"+",#{item.foodId},#{item.bucketId})\n"+
            " </foreach> </script>")
    Boolean InsertBucketAssFoods(@Param("result") List<BucketAssFoodEntity> list);
}
