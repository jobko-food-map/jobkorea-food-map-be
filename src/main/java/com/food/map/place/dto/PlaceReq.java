package com.food.map.place.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(title = "플레이스 정보")
public record PlaceReq(

    @Schema(description = "플레이스 이름", example = "플레이스1")
    String placeName
){
}
