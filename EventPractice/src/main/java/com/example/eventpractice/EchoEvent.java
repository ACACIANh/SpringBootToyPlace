package com.example.eventpractice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class EchoEvent {
	private final String message;
}
