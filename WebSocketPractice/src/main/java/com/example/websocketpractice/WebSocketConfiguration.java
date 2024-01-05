package com.example.websocketpractice;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfiguration implements WebSocketConfigurer {

	private final SocketTextHandler socketTextHandler;

	@Override
	public void registerWebSocketHandlers( WebSocketHandlerRegistry registry ) {
		registry.addHandler( socketTextHandler, "ws/user" )
				.setAllowedOrigins( "*" );
	}
}
