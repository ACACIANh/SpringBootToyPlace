package com.example.validationinheritance;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

//	@ExceptionHandler( Exception.class )
//	public ResponseEntity< ? > handleExceptionInternal( final Exception e ) {
//		return ResponseEntity.status( 500 ).body( e.getMessage() );
//	}
}
