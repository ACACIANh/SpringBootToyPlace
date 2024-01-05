package com.example.websocketpractice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class SocketTextHandler extends CustomSocketHandler {

	private final Set< WebSocketSession > sessions = ConcurrentHashMap.newKeySet();

	@Override
	public void afterConnectionEstablished( WebSocketSession session ) throws Exception {
		sessions.add( session );
		log.info( session.getId() + " added" );
		session.sendMessage( new TextMessage( "welcome!" ) );
	}

	@Override
	protected void handleTextMessage( WebSocketSession session, TextMessage message ) throws Exception {
		String payload = message.getPayload();
		if ( "error1".equals( payload ) ) {
			throw new CustomException.CustomFirstException();
		}
		if ( "error2".equals( payload ) ) {
			throw new CustomException.CustomSecondException();
		}
		if ( "error3".equals( payload ) ) {
			throw new RuntimeException( "runtime error3" );
		}
		for ( var loopSession : sessions ) {
			loopSession.sendMessage( new TextMessage( session.getId() + " : " + payload + "!" ) );
		}
		log.info( session.getId() + " sendMessage" );
	}

	@Override
	public void handleTransportError( WebSocketSession session, Throwable exception ) throws Exception {
		log.error( "handleTransportError() call" );
	}

	@Override
	public void afterConnectionClosed( WebSocketSession session, CloseStatus status ) throws Exception {
		sessions.remove( session );
		log.info( session.getId() + " removed" );
	}
}
