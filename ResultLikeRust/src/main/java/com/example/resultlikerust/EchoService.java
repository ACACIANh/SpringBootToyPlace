package com.example.resultlikerust;

import org.springframework.stereotype.Service;

@Service
public class EchoService {

	public Result< String, Throwable > echo( String echo ) {

		if ( echo.equals( "echo" ) ) {
			return Result.ok( echo );
		}
		return Result.err( new RuntimeException( String.format( "%s is not matched", echo ) ) );
	}
}
