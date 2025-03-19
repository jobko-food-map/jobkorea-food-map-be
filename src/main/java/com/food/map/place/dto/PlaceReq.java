package com.food.map.place.dto;

import com.food.map.place.enums.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(title = "플레이스 정보")
public record PlaceReq(

    @NotBlank
    @Schema(description = "플레이스 이름", example = "플레이스1")
    String placeName,

    @NotBlank
    @Schema(description = "플레이스 아이디", example = "12312312")
    String placeId,

    @Schema(description = "설명", example = "디스크립션1")
    String placeDesc,

    @NotNull
    @Schema(description = "카테고리", example = "ASIAN")
    Category category,

    @NotBlank
    @Schema(description = "위도", example ="111")
    String lat,

    @NotBlank
    @Schema(description = "경도", example ="222")
    String lng,

    @Schema(description = "승인 여부", example ="false")
    Boolean isApprove
){
}
