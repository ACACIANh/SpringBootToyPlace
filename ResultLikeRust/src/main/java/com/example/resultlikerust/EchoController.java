package com.example.resultlikerust;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EchoController {

	private final EchoService echoService;

	@GetMapping( "/v1/echo" )
	public ResponseEntity< String > echo( @RequestParam String echo ) {

		Result< String, Throwable > result = echoService.echo( echo );
		if ( result.isOk() ) {
			return ResponseEntity.ok( result.ok().get() );
		}
		return ResponseEntity.badRequest().body( result.err().get().getMessage() );
	}
}
