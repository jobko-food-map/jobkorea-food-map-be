package com.food.map.report.dto;

import com.food.map.place.enums.Category;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder(toBuilder = true)
public record Report(
    Long id,

    LocalDateTime createdAt,

    String userId,

    String placeId,

    String placeName,

    String placeDesc,

    Category category,

    String lat,

    String lng,

    int approveCount,

    int rejectCount
){
}
