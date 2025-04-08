package com.food.map.place.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<PlaceEntity, Long> {
    PlaceEntity findByPlaceName(String placeName);

    List<PlaceEntity> findByIsApprove(boolean isApprove);
}
