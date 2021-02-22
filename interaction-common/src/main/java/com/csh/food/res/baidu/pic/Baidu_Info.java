package com.csh.food.res.baidu.pic;

import lombok.Data;

import java.io.Serializable;

@Data
public class Baidu_Info implements Serializable {
    String baike_url;
    String image_url;
    String description;
}
