package com.example.swaggerpractice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Operation( summary = "test echo", description = "hello api example" )
	@ApiResponses( {
			@ApiResponse( responseCode = "200", description = "OK !!" ),
			@ApiResponse( responseCode = "400", description = "BAD REQUEST !!" ),
			@ApiResponse( responseCode = "404", description = "NOT FOUND !!" ),
			@ApiResponse( responseCode = "500", description = "INTERNAL SERVER ERROR !!" )
	} )
	@GetMapping( "/v1/main/echo" )
	public String echoSound( @Parameter( description = "메아리", required = true, example = "Hello" ) @RequestParam String sound,
	                         @Parameter( description = "아무것도아님", required = false, example = "not" ) @RequestParam( required = false ) String nothing
	) {
		return sound;
	}
}
