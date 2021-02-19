package com.csh.food.user.base.mapper;

import com.csh.food.user.base.domain.entity.UserEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    /**
     * 新增一条User数据
     * @param userEntity
     * @return
     */
    @Insert("insert into base_user (user_name,user_password) values (#{userName},#{userPassword})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public Integer userIncr(UserEntity userEntity);


    @Select("select id from base_user where user_name = #{userName}")
    public Integer is_Exists(UserEntity userEntity);
}
