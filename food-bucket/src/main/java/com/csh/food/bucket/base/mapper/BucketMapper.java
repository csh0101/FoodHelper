package com.csh.food.bucket.base.mapper;

import com.csh.food.bucket.base.domain.entity.BucketEntity;
import com.csh.food.bucket.base.domain.entity.FoodEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface BucketMapper {
    @Insert("insert into bucket (bucket_name,bucket_calorie) values (#{bucketName},#{bucketCalorie})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    Integer BucketIncr(BucketEntity bucketEntity);

}
