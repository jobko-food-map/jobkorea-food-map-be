package com.food.map.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(title = "유저 정보")
public record UserReq(
    @NotBlank
    @Schema(description = "유저 아이디", example = "am-m")
    String userId,

    @NotBlank
    @Schema(description = "유저 이름", example = "나다")
    String userName
){
}
