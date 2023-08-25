package com.example.jsoncolumnmapping.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;

@JsonFormat(
		shape = JsonFormat.Shape.OBJECT
)
@RequiredArgsConstructor
public enum JsonFormatEnum {

	FIRST( 0, "first" ),
	SECOND( 1, "second" );

	private final Integer code;
	private final String description;
}
