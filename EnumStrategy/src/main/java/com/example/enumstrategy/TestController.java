package com.example.enumstrategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

	@GetMapping( "/v1/myEnum" )
	public ResponseEntity< Object > myEnum() {
		MyResponseBody someContent = new MyResponseBody( MyFirstEnum.FIRST.findByCode( 2 ).orElse( null ), "some content" );
		return ResponseEntity.ok( someContent );
	}

	@PostMapping( "/v1/myEnum" )
	public ResponseEntity< Object > myEnumJson( @RequestBody MyRequestBody requestBody ) {
		log.info( requestBody.toString() );
		MyResponseBody responseBody = new MyResponseBody( requestBody );
		return ResponseEntity.ok( responseBody );
	}
}
