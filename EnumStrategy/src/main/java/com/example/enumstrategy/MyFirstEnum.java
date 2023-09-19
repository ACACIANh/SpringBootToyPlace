package com.example.enumstrategy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor
@JsonFormat( shape = JsonFormat.Shape.OBJECT )
public enum MyFirstEnum implements CodeEnum< Integer, MyFirstEnum > {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@formatter:off
	//==================================================================================================================
	FIRST   ( 1, "first"),
	SECOND  ( 2, "second");
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@formatter:on

	private final Integer code;
	private final String description;

	private static final Map< Integer, MyFirstEnum > INDEX_FOR_CODE = CodeEnum.getIndexInitialize( MyFirstEnum.class );

	@Override
	public Map< Integer, MyFirstEnum > indexForCode() {
		return INDEX_FOR_CODE;
	}

	@JsonCreator( mode = JsonCreator.Mode.DELEGATING )
	private static MyFirstEnum fromCode( Integer code ) {
		return INDEX_FOR_CODE.get( code );
	}

//	@JsonCreator
//	private static MyFirstEnum fromJson( Integer code ) {
//		return INDEX_FOR_CODE.get( code );
//	}
}
