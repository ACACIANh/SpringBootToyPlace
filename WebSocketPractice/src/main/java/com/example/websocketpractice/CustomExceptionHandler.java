package com.example.websocketpractice;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.ExceptionWebSocketHandlerDecorator;

@Slf4j
@Component
public class CustomExceptionHandler extends ExceptionWebSocketHandlerDecorator {

	private static final Log logger = LogFactory.getLog( CustomExceptionHandler.class );

	public CustomExceptionHandler( CustomSocketHandler delegate ) {
		super( delegate );
	}

	@Override
	public void handleMessage( WebSocketSession session, WebSocketMessage< ? > message ) {
		try {
			this.getDelegate().handleMessage( session, message );
		} catch ( CustomException ex ) {
			log.error( ex.getClass().getSimpleName() );
		} catch ( Exception ex ) {
			tryCloseWithError( session, ex, logger );
		}
	}
}
