package com.food.map.place.mapper;

import com.food.map.place.dto.Place;
import com.food.map.place.dto.PlaceReq;
import com.food.map.place.repository.PlaceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PlaceMapper {
    PlaceEntity to(Place source);

    Place to(PlaceEntity source);

    @Mapping(ignore = true, target = "id")
    Place to(PlaceReq source);
}
