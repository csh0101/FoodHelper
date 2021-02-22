package com.csh.food.user.base.controller;

import com.csh.food.user.base.convert.RegisterUserConverter;
import com.csh.food.user.base.domain.dto.UserDTO;
import com.csh.food.user.base.domain.request.LoginRequest;
import com.csh.food.user.base.domain.request.RefreshRequest;
import com.csh.food.user.base.domain.request.RegisterRequest;
import com.csh.food.user.base.domain.response.LoginResponse;
import com.csh.food.jwt.base.util.JWTUtil;
import com.csh.food.res.base.response.ResponseCodeEnum;
import com.csh.food.res.base.response.ResponseResult;
import com.csh.food.user.base.domain.response.RegisterResponse;
import com.csh.food.user.base.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {
    @Value("${token.auth.secretKey}")
    private String secretKey;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @author csh0101
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody @Validated LoginRequest loginRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseResult.error(ResponseCodeEnum.PARAMETER_ILLEGAL.getCode(),ResponseCodeEnum.PARAMETER_ILLEGAL.getMessage());
        }
        String userName = loginRequest.getUserName();
        String userPassword = loginRequest.getUserPassword();
        //todo 更改逻辑
        if(!("hello".equals(userName) && "world".equals(userPassword))){
            return ResponseResult.error(ResponseCodeEnum.LOGIN_ERROR.getCode(), ResponseCodeEnum.LOGIN_ERROR.getMessage());
        }
        // 生成token
        String token = JWTUtil.generateToken(userName,secretKey);
        //
        String refreshToken = UUID.randomUUID().toString().replace("-","");

        // 放入缓存
        HashOperations<String,String,String> hashOperations = stringRedisTemplate.opsForHash();
        //设置缓存
        hashOperations.put(userName,"token",token);
        hashOperations.put(userName,"refreshToken",refreshToken);
        stringRedisTemplate.expire(userName,JWTUtil.TOKEN_EXPIRE_TIME, TimeUnit.MICROSECONDS);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);
        loginResponse.setRefreshToken(refreshToken);
        loginResponse.setUserName(userName);

        return ResponseResult.success(loginResponse);

        //
    }

    /**
     * 退出
     * @author csh031027
     */
    @GetMapping("/logout")
    public ResponseResult logout(@RequestParam("userId") String userId){
        HashOperations<String,String,String> hashOperations = stringRedisTemplate.opsForHash();
        hashOperations.delete(userId);
        return ResponseResult.success();
    }

    @PostMapping("/register")
    public ResponseResult register(@RequestBody RegisterRequest registerRequest){
        return userService.registerUser(registerRequest);
    }

    @PostMapping("/refreshToken")
    public ResponseResult refreshToken(@RequestBody @Validated RefreshRequest refreshRequest, BindingResult bindingResult){
        String userId = refreshRequest.getUserId();
        String refreshToken = refreshRequest.getRefreshToken();
        HashOperations<String,String,String> hashOperations = stringRedisTemplate.opsForHash();
        String originalRefreshToken = hashOperations.get(userId,"refreshToken");
        if(StringUtils.isBlank(originalRefreshToken) || !originalRefreshToken.equals(refreshToken)){
            return ResponseResult.error(ResponseCodeEnum.REFRESH_TOKEN_INVAILD.getCode(), ResponseCodeEnum.REFRESH_TOKEN_INVAILD.getMessage());
        }
        //生成新的token
        String newToken = JWTUtil.generateToken(userId,secretKey);
        hashOperations.put(userId,"token",newToken);
        stringRedisTemplate.expire(userId,JWTUtil.TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);
        return ResponseResult.success(newToken);
    }
}
