package com.example.validationinheritance;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

	private final HandlerFirst handlerFirst;
	private final HandlerSecond handlerSecond;

	@PostMapping( "/v1/first" )
	public ResponseEntity< ? > first( @RequestBody RequestFirst request ) {
		handlerFirst.handle( request );
		return ResponseEntity.ok( request );
	}

	@PostMapping( "/v1/second" )
	public ResponseEntity< ? > second( @RequestBody RequestSecond request ) {
		handlerSecond.handle( request );
		return ResponseEntity.ok( request );
	}
}
