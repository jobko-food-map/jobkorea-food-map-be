package com.food.map.user.mapper;

import com.food.map.user.dto.User;
import com.food.map.user.dto.UserReq;
import com.food.map.user.dto.UserRes;
import com.food.map.user.repository.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
    UserEntity to(User source);

    User to(UserEntity source);

    @Mapping(ignore = true, target = "id")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    User to(UserReq source);

    UserRes toRes(User source);
}
