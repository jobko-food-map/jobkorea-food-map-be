package com.food.map.place.mapper;

import com.food.map.place.dto.Place;
import com.food.map.place.dto.PlaceReq;
import com.food.map.place.dto.PlaceRes;
import com.food.map.place.repository.PlaceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PlaceMapper {
    PlaceEntity to(Place source);

    @Mapping(target = "isApprove", source = "approve")
    Place to(PlaceEntity source);

    @Mapping(ignore = true, target = "id")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Place to(PlaceReq source);

    PlaceRes toRes(Place source);
}
