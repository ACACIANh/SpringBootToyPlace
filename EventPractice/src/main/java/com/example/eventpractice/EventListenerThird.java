package com.example.eventpractice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventListenerThird {
	@Async
	@EventListener( classes = AbstractEvent.class )
	public void handle( AbstractEvent echoEvent ) {
		log.info( "listener class: {}, event class: {}", this.getClass().getSimpleName(), echoEvent.getClass().getSimpleName() );
	}
}
