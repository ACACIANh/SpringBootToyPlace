package com.example.jsoncreatorpractice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler( Exception.class )
	public ResponseEntity< Object > handleException( Exception e ) {
		return ResponseEntity.badRequest().body( e.getMessage() );
	}
}
