package com.csh.food.bucket.base.domain.response;

import com.csh.food.res.baidu.pic.Baidu_Info;
import lombok.Data;

@Data
public class PicAnalysisResponse {

    String foodName;

    float foodProbability;

    float foodCalorie;

    Baidu_Info baiduInfo;
}
