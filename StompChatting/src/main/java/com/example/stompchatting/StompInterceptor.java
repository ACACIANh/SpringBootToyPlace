package com.example.stompchatting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StompInterceptor implements ChannelInterceptor {

	@Override
	public Message< ? > preSend( Message< ? > message, MessageChannel channel ) {
		MessageHeaderAccessor accessor = MessageHeaderAccessor.getAccessor( message, MessageHeaderAccessor.class );
		return message;
	}
}
