package com.csh.food.user.base.domain.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class UserEntity {

    String userName;

    String userPassword;
}
