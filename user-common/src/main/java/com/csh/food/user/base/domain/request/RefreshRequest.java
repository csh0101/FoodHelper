package com.csh.food.user.base.domain.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RefreshRequest {

    @NotEmpty
    String userId;

    @NotEmpty
    String refreshToken;
}
