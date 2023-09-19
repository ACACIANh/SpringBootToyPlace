package com.example.enumstrategy;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface CodeEnum< C, E extends CodeEnum< C, E > > {

	C getCode();

	Map< C, E > indexForCode();

	default Optional< E > findByCode( C code ) {
		// static 으로 불가능 똥같은 시도
		return Optional.ofNullable( indexForCode().get( code ) );
	}

	static < T, E extends CodeEnum< T, E > > Map< T, E > getIndexInitialize( Class< E > enumClass ) {
		return Arrays.stream( enumClass.getEnumConstants() )
				.collect( Collectors.toMap( CodeEnum::getCode, Function.identity() ) );
	}
}
