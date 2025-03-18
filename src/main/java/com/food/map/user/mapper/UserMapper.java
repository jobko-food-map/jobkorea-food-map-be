package com.food.map.user.mapper;

import com.food.map.user.dto.User;
import com.food.map.user.repository.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserEntity to(User source);

    User to(UserEntity source);
}
