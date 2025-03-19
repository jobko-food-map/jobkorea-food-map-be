package com.food.map.vote.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(title = "유저 정보")
public record VoteReq(
    @NotBlank
    @Schema(description = "유저 아이디", example = "am-m")
    String userId,

    @Min(1)
    @Schema(description = "제보 아이디", example = "1")
    Long reportId,

    @Schema(description = "승인 여부", example = "true")
    boolean isApprove
){
}
