package com.food.map.place.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(title = "플레이스 정보")
public record Place(
    @Schema(description = "플레이스 번호", example = "1")
    Long id,

    @Schema(description = "플레이스 이름", example = "플레이스1")
    String placeName,

    @Schema(name = "설명", example = "디스크립션1")
    String placeDesc,

    @Schema(name = "카테고리", example = "맛집1")
    String category,

    @Schema(name = "location_x", example ="x축")
    String locationX,

    @Schema(name = "location_y", example ="y축")
    String locationY
){
}
