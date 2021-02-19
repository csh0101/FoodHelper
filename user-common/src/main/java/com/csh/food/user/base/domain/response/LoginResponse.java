package com.csh.food.user.base.domain.response;

import lombok.Data;

@Data
public class LoginResponse {
    String token;
    String refreshToken;
    String userName;
}
