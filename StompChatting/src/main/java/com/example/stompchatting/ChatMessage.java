package com.example.stompchatting;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ChatMessage {

	private String sender;
	private String contents;
	private MessageType messageType;
}
