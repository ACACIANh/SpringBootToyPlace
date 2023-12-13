package com.example.securitybasic;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@GetMapping( "/" )
	public String index() {
		return "hello world";
	}

	@GetMapping( "/custom" )
	public String custom(
			@AuthenticationPrincipal UserDetails userDetails
	) {
		String user = userDetails.getUsername() + userDetails.getAuthorities();
		return "login user: " + user;
	}
}
