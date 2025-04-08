package com.food.map.place.dto;

import com.food.map.place.enums.Category;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder(toBuilder = true)
public record Place(
    Long id,

    String placeId,

    String placeName,

    String placeDesc,

    Category category,

    String lat,

    String lng,

    LocalDateTime createdAt,

    boolean isApprove
){
}
