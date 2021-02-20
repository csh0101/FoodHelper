package com.csh.food.pic.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.imageclassify.AipImageClassify;
import com.csh.food.dubbo.base.pic.converter.DishConverter;
import com.csh.food.dubbo.base.pic.entity.DishEntity;
import com.csh.food.dubbo.base.util.converter.OConverter;
import com.csh.food.res.baidu.pic.Baidu_Dish;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodAipImageClassifyUtil {
    public static final String APP_ID = "23665194";
    public static final String APP_KEY = "cGKcpSTNK1pSd3gi362vU96L";
    public static final String SECRET_KEY = "jGIPo5V8dabKt2MubUcu5Vt7sNA1VQYl";
    public static final AipImageClassify client = new AipImageClassify(APP_ID,APP_KEY,SECRET_KEY);
    public static List<DishEntity> dishImageAnalysis(byte[] pic){
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("top_num", "3");
        options.put("filter_threshold", "0.95");
        options.put("baike_num", "5");
        //str
        String tp = client.dishDetect(pic,options).toString();
        //object
        JSONObject ob = JSONObject.parseObject(tp);
        String res = ob.get("result").toString();
        List<Baidu_Dish> DishList = new ArrayList<>();
        JSONArray ary = JSON.parseArray(res);

        for (Object o : ary) {
//            Object o = ary.get(i);
//            JSONObject obj = JSONObject.parseObject(o.toString());
//            Baidu_Dish dish = JSONObject.parseObject(String.valueOf(obj),Baidu_Dish.class);
            Baidu_Dish dish = (Baidu_Dish) o;
            DishList.add(dish);
        }
        return DishConverter.bdDishToEList(DishList);

    }
}
