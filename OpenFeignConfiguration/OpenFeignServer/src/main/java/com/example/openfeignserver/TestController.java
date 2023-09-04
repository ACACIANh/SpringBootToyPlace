package com.example.openfeignserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping( "/v1/echo" )
	public String echo( @RequestParam String echo ) {
		return echo;
	}
}
