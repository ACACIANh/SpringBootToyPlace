package com.example.jsoncolumnmapping.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@JsonFormat(
		shape = JsonFormat.Shape.OBJECT
)
@RequiredArgsConstructor
@Getter
public enum JsonFormatEnum {

	FIRST( 0, "first" ),
	SECOND( 1, "second" );

	private final Integer code;
	private final String description;
}
