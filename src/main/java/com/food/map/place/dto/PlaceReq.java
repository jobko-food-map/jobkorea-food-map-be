package com.food.map.place.dto;

import com.food.map.place.enums.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(title = "플레이스 정보")
public record PlaceReq(

    @Schema(description = "플레이스 이름", example = "플레이스1")
    String placeName,

    @Schema(description = "설명", example = "디스크립션1")
    String placeDesc,

    @Schema(description = "카테고리", example = "FOOD")
    Category category,

    @Schema(description = "location_x", example ="x축")
    String locationX,

    @Schema(description = "location_y", example ="y축")
    String locationY
){
}
