package com.example.quartzscheduler.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ServiceErrorCode implements ErrorCode {

	// @formatter:off
	INTERNAL_GLOBAL_ERROR   ( HttpStatus.INTERNAL_SERVER_ERROR  , "internal server error" ),
	JOB_CLASS_NOT_FOUND     ( HttpStatus.BAD_REQUEST            , "job class not found" ),
	JOB_IS_ALREADY_EXIST    ( HttpStatus.BAD_REQUEST            , "job is already exist" ),
	JOB_IS_NOT_EXIST        ( HttpStatus.BAD_REQUEST            , "job is not exist" ),
	;
	// @formatter:on

	private final HttpStatus httpStatus;
	private final String message;

	ServiceErrorCode( HttpStatus httpStatus, String message ) {
		this.httpStatus = httpStatus;
		this.message = message;
	}
}
