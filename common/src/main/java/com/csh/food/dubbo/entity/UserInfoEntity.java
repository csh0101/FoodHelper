package com.csh.food.dubbo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoEntity implements Serializable {
    private static final long serialVersionUID = 5930587011018957809L;

    private int uuid;

    private int userId;

    private String userName;

    
}
