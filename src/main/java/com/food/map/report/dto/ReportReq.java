package com.food.map.report.dto;

import com.food.map.place.enums.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(title = "제보 정보")
public record ReportReq(

    @NotBlank
    @Schema(description = "유저 아이디", example = "유저2")
    String userId,

    @NotBlank
    @Schema(description = "플레이스 아이디", example = "12312312")
    String placeId,

    @Schema(description = "이름", example = "이름1")
    String placeName,

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
    String lng
){
}
