package com.food.map.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessErrorCodeException extends RuntimeException{
	private final ErrorCode errorCode;
}
