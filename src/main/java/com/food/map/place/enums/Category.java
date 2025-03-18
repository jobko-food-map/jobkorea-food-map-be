package com.food.map.place.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    FOOD("음식점"),
    CAFE("카페"),
    ETC("기타");
    private final String description;
}
