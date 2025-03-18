package com.food.map.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(title = "유저 정보")
public record User(
    @Schema(description = "유저 번호", example = "1")
    long id,

    @Schema(description = "유저 아이디", example = "am-m")
    String userId,

    @Schema(description = "유저 이름", example = "나다")
    String userName,

    @Schema(name = "생성일", example ="2022-01-02 00:00:00")
    LocalDateTime createdAt
){
}
