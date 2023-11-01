package com.example.eventpractice;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

	private final ApplicationEventPublisher eventPublisher;

	@GetMapping( "/v1/main/echo" )
	public String echoSound( @RequestParam String sound ) {
		eventPublisher.publishEvent( new EchoEvent( sound ) );
		return sound;
	}
}
