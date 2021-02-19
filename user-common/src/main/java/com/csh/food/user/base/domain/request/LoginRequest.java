package com.csh.food.user.base.domain.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class LoginRequest {
    @NotEmpty(message = "用户名不可为空")
    String userName;
    @Size(min = 5 , max = 12 , message = "密度的长度应该在5-12之间")
    String userPassword;
}
