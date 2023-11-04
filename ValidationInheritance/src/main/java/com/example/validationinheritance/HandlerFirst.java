package com.example.validationinheritance;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@Slf4j
public class HandlerFirst implements AbstractHandler {
	@Override
	public void handle( @Valid AbstractRequest request ) {
		log.info( request.getClass().getSimpleName() );
	}
}
