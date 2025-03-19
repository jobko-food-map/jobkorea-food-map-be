package com.food.map.vote.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(title = "투표 정보")
public record VoteRes(
    @Schema(description = "투표 번호", example = "1")
    Long id,

    @Schema(description = "제보 아이디", example = "1")
    Long reportId,

    @Schema(description = "유저 아이디", example = "나다")
    String userId,

    @Schema(description = "생성일", example ="2022-01-02 00:00:00")
    LocalDateTime createdAt
){
}
