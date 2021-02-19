package com.csh.food.user.base.convert;

import com.csh.food.user.base.domain.dto.UserDTO;
import com.csh.food.user.base.domain.entity.UserEntity;
import com.csh.food.user.base.domain.request.RegisterRequest;
import org.springframework.beans.BeanUtils;

public class RegisterUserConverter {

    /**
     * 将DTO转换成Entity
     * @param request
     * @return
     */
    public static UserDTO UserDTOConverter(RegisterRequest request){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(request,userDTO);
        return userDTO;
    }

    /**
     * 将DTO转换成Entity
     * @param userDTO
     * @return
     */
    public static UserEntity UserEntityConverter(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO,userEntity);
        return userEntity;
    }

}
