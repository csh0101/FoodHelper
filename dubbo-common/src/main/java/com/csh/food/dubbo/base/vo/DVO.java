package com.csh.food.dubbo.base.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DVO implements Serializable {
    List<Object> objList;
}
