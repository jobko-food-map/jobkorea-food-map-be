package com.food.map.place.dto;

import com.food.map.place.enums.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
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

    @Schema(name = "카테고리", example = "FOOD")
    Category category,

    @Schema(name = "x축", example ="111")
    String locationX,

    @Schema(name = "y축", example ="222")
    String locationY,

    @Schema(name = "생성일", example ="2022-01-02 00:00:00")
    LocalDateTime createdAt
){
}
