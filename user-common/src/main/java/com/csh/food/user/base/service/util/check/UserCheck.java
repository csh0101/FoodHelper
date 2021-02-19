package com.csh.food.user.base.service.util.check;

import com.alibaba.spring.util.BeanUtils;
import com.csh.food.user.base.domain.dto.UserDTO;
import com.csh.food.user.base.domain.entity.UserEntity;
import com.csh.food.user.base.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserCheck {

    @Resource
    UserMapper userMapper;

    public boolean is_Exists(UserEntity userEntity){
        Integer exists = userMapper.is_Exists(userEntity);
        return Objects.nonNull(exists);
    }
}
