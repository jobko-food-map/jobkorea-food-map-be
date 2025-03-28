package com.food.map.favorites.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public record FavoritesReq(
    String userId,

    Long placeId
){
}
