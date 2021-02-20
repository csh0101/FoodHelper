package com.csh.food.dubbo.base.util.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OConverter<T> {
    public static <T> Object OConverter(T data){
        return data;
    }
    public static <T> List<Object> OListConverter(List<T> list){
        return list.stream().map(OConverter::OConverter).collect(Collectors.toList());
    }
}
