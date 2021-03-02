package com.csh.food.bucket.base.service.serviceImpl;

import com.csh.food.bucket.base.converter.BucketConverter;
import com.csh.food.bucket.base.domain.dto.FoodDTO;
import com.csh.food.bucket.base.domain.entity.BucketAssFoodEntity;
import com.csh.food.bucket.base.domain.entity.BucketEntity;
import com.csh.food.bucket.base.domain.request.BucketRequest;
import com.csh.food.bucket.base.domain.request.FoodRequest;
import com.csh.food.bucket.base.domain.response.BucketResponse;
import com.csh.food.bucket.base.mapper.BucketAssFoodMapper;
import com.csh.food.bucket.base.mapper.BucketMapper;
import com.csh.food.bucket.base.service.BucketService;
import com.csh.food.res.base.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class BucketServiceImpl implements BucketService {

    @Resource
    BucketMapper bucketMapper;
    @Resource
    BucketAssFoodMapper bucketAssFoodMapper;
    @Override
    public ResponseResult BucketAdd(BucketRequest request) {
        BucketEntity entity = BucketConverter.RTE(request);
        BucketResponse res = new BucketResponse();
            List<FoodDTO> foods = getBucketFoods(request);
            float bucketCalorie = (float)request.getFoods().stream().mapToDouble(FoodRequest::getFoodCalorie).sum();
            entity.setBucketCalorie(bucketCalorie);
            Integer id = bucketMapper.BucketIncr(entity);
            res.setId(id);
            res.setBucketCalorie(bucketCalorie);
            res.setBucketName(res.getBucketName());
            List<BucketAssFoodEntity> ets = getBucketsAssFoods(id,foods);
            Boolean flag = bucketAssFoodMapper.InsertBucketAssFoods(ets);
            if(!flag) throw new IllegalStateException();
            return ResponseResult.success(entity);
    }

    private List<FoodDTO> getBucketFoods(BucketRequest request) {
        return request.getFoods().stream().map(reqs->{
            FoodDTO foodDTO = new FoodDTO();
            foodDTO.setFoodName(reqs.getFoodName());
            foodDTO.setFoodCalorie(reqs.getFoodCalorie());
            return foodDTO;
        }).collect(Collectors.toList());
    }
    //返回桶和食物的关系图
    private List<BucketAssFoodEntity> getBucketsAssFoods(Integer BucketId,List<FoodDTO> list){
        return list.stream().map(f->{
            BucketAssFoodEntity entity = new BucketAssFoodEntity();
            entity.setBucketId(BucketId);
            entity.setFoodId(f.getId());
            return entity;
        }).collect(Collectors.toList());
    }
}
