package com.food.map.place.mapper;

import com.food.map.place.dto.Place;
import com.food.map.place.repository.PlaceEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PlaceMapper {
    PlaceEntity to(Place source);

    Place to(PlaceEntity source);
}
