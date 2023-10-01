package com.example.quartzscheduler.controller;

import com.example.quartzscheduler.exception.ErrorCode;
import com.example.quartzscheduler.exception.ServiceErrorCode;
import com.example.quartzscheduler.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

	private final MessageSource messageSource;

	@ExceptionHandler( ServiceException.class )
	private ResponseEntity< ? > handleExceptionServer( final ServiceException serviceException ) {

		ErrorCode errorCode = serviceException.getErrorCode();
		return ResponseEntity.status( errorCode.getHttpStatus() )
				.body( errorCode.getMessage() );
	}

	@ExceptionHandler( Exception.class )
	public ResponseEntity< ? > handleExceptionInternal( final Exception e ) {

		ErrorCode errorCode = ServiceErrorCode.INTERNAL_GLOBAL_ERROR;
		return ResponseEntity.status( errorCode.getHttpStatus() )
				.body( e.getMessage() );
	}
}
