package com.csh.food.bucket.base.domain.entity;

import com.csh.food.bucket.base.domain.dto.FoodDTO;
import lombok.Data;

import java.util.List;

@Data
public class BucketEntity {
    Integer id;
    String BucketName;
    List<FoodDTO> bucketFoods;
    float bucketCalorie;
}
