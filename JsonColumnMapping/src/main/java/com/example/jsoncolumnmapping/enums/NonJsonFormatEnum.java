package com.example.jsoncolumnmapping.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum NonJsonFormatEnum {

	FIRST( 0, "first" ),
	SECOND( 1, "second" );

	private final Integer code;
	private final String description;
}
