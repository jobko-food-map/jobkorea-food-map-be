package com.food.map.place.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    ALL("전체"),
    ASIAN("아시안"),
    CHINESE("중식"),
    KOREAN("한식"),
    WESTERN("양식"),
    JAPANESE("일식"),
    DESSERT("디저트"),
    COFFEE("카페");

    private final String description;
}
