package com.example.springrestdocs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDocsTestController {

	@GetMapping( "/v1/restDocsTest" )
	public String restDocsTestAPI() {
		return "result : rest docs";
	}
}
