package com.example.eventpractice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventListenerSecond {
	@Async
	@EventListener( classes = EchoEvent.class )
	public void handle( EchoEvent echoEvent ) {
		log.info( "Class: {}, message: {}", EventListenerSecond.class.getSimpleName(), echoEvent.getMessage() );
	}
}