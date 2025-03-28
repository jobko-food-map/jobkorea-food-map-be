package com.food.map.favorites.dto;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder(toBuilder = true)
public record FavoritesRes(
    Long id,

    String userId,

    Long placeId,

    LocalDateTime createdAt
){
}
