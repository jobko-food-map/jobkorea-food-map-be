package com.food.map.vote.dto;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder(toBuilder = true)
public record Vote(
    Long id,

    String userId,

    Long reportId,

    LocalDateTime createdAt,

    boolean isApprove
){
}
