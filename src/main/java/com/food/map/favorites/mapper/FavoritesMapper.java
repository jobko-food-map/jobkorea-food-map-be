package com.food.map.favorites.mapper;

import com.food.map.favorites.dto.Favorites;
import com.food.map.favorites.dto.FavoritesReq;
import com.food.map.favorites.dto.FavoritesRes;
import com.food.map.favorites.repository.FavoritesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface FavoritesMapper {
    Favorites to(FavoritesEntity source);

    @Mapping(ignore = true, target = "id")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    FavoritesEntity to(FavoritesReq source);

    FavoritesRes toRes(Favorites source);
}
