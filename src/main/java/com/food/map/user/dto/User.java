package com.food.map.user.dto;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder(toBuilder = true)
public record User(
    long id,

    String userId,

    String userName,

    LocalDateTime createdAt
){
}
