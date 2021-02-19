package com.csh.food.user.base.service.serviceImpl;
import com.csh.food.user.base.convert.RegisterUserConverter;
import com.csh.food.user.base.domain.dto.UserDTO;
import com.csh.food.user.base.domain.entity.UserEntity;
import com.csh.food.user.base.domain.response.RegisterResponse;
import com.csh.food.user.base.mapper.UserMapper;
import com.csh.food.user.base.service.UserService;
import com.csh.food.user.base.service.util.check.UserCheck;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    UserCheck userCheck;
    @Override
    public RegisterResponse registerUser(UserDTO userDTO) {
        RegisterResponse registerResponse = new RegisterResponse();
        UserEntity userEntity = RegisterUserConverter.UserEntityConverter(userDTO);
        if(userCheck.is_Exists(userEntity)){
            registerResponse.setSuccess(false);
            registerResponse.setId(-1);
        }else{
            registerResponse.setId(userMapper.userIncr(userEntity));
            registerResponse.setSuccess(true);
        }
        return registerResponse;
    }
}
