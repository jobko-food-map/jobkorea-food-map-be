package com.food.map.place.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<PlaceEntity, Long> {
    PlaceEntity findByPlaceName(String placeName);

    PlaceEntity findByPlaceId(String placeId);
}
