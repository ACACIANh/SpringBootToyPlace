package com.example.requestspecialcharacter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping( "/v1/echo/{path}" )
	public String echo(
			@PathVariable String path,
			@RequestParam String param
	) {
		return path + " / " + param;
	}
}
