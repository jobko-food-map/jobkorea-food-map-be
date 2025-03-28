package com.food.map.favorites.dto;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder(toBuilder = true)
public record Favorites(
    Long id,

    String userId,

    String placeId,

    LocalDateTime createdAt
){
}
