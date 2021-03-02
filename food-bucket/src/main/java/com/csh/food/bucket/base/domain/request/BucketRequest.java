package com.csh.food.bucket.base.domain.request;

import lombok.Data;

import java.util.List;

@Data
public class BucketRequest {
    String BucketName;
    List<FoodRequest> foods;
    Integer id;
}
