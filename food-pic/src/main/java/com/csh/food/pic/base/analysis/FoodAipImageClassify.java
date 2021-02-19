package com.csh.food.pic.base.analysis;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.util.AipClientConfiguration;
import com.csh.food.pic.base.domain.response.DishInfoResponse;
import org.json.JSONObject;

import java.util.HashMap;

public class FoodAipImageClassify {
    public static final String APP_ID = "23665194";
    public static final String APP_KEY = "cGKcpSTNK1pSd3gi362vU96L";
    public static final String SECRET_KEY = "jGIPo5V8dabKt2MubUcu5Vt7sNA1VQYl";
    public static final AipImageClassify client = new AipImageClassify(APP_ID,APP_KEY,SECRET_KEY);
    public static DishInfoResponse dishImageAnalysis(byte[] pic){
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("top_num", "3");
        options.put("filter_threshold", "0.7");
        options.put("baike_num", "5");
        JSONObject res = client.dishDetect(pic,options);
        return null;
    }
}
