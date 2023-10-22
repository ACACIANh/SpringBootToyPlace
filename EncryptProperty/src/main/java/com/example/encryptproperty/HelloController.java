package com.example.encryptproperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value( "${data.origin}" )
	private String dataOrigin;
	@Value( "${data.encrypted}" )
	private String dataEncrypted;

	@GetMapping( "/v1/hello" )
	String hello() {

		return dataOrigin + ":" + dataEncrypted;
	}
}
