package com.csh.food.user.base.service;

import com.csh.food.user.base.domain.dto.UserDTO;
import com.csh.food.user.base.domain.response.RegisterResponse;
import com.sun.org.apache.xpath.internal.operations.Bool;

public interface UserService {
    public RegisterResponse registerUser(UserDTO userDTO);
}
