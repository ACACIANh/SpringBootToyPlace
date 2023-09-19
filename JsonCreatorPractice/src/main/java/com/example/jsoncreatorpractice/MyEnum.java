package com.example.jsoncreatorpractice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@JsonFormat( shape = JsonFormat.Shape.OBJECT )
@RequiredArgsConstructor
@Getter
public enum MyEnum {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@formatter:off
	//==================================================================================================================
	FIRST   ( 1, "first" ),
	SECOND  ( 2, "second"),
	THIRD   ( 3, "third" )
	;
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@formatter:on

	private final Integer code;
	private final String description;

	private static final Map< Integer, MyEnum > INDEX_FOR_CODE = new LinkedHashMap<>();

	static {
		Arrays.stream( MyEnum.values() ).forEach( e -> INDEX_FOR_CODE.put( e.code, e ) );
	}

//	@JsonCreator( mode = JsonCreator.Mode.DELEGATING )
//	public static MyEnum fromCode( Integer code ) {
//		log.info( "fromCode" );
//		return INDEX_FOR_CODE.get( code );
//	}

//	@JsonCreator
//	public static MyEnum fromJson( @JsonProperty Integer code ) {
//		log.info( "fromJson" );
//		return INDEX_FOR_CODE.get( code );
//	}

//	@JsonCreator
//	public static MyEnum fromJsonMap( Map< Object, Object > properties ) {
//		Object o = properties.get( "code" );
//		if ( null == o ) {
//			return null;
//		}
//		log.info( "fromJsonMap" );
//		return INDEX_FOR_CODE.get( o );
//	}

	@JsonCreator
	public static MyEnum fromAll( Object property ) {
		log.info( "fromAll" );
		if ( Integer.class.isAssignableFrom( property.getClass() ) ) {
			log.info( "fromAll.Integer" );
			return INDEX_FOR_CODE.get( property );
		}
		if ( Map.class.isAssignableFrom( property.getClass() ) ) {
			log.info( "fromAll.Map" );
			Object code = ( ( Map ) property ).get( "code" );
			if ( null == code ) {
				return null;
			}
			return INDEX_FOR_CODE.get( code );
		}
		return null;
	}
}
