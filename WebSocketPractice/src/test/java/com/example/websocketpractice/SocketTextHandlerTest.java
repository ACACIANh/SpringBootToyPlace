package com.example.websocketpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SocketTextHandlerTest {

	private int port = 8080;
	@Autowired
	private SocketTextHandler socketTextHandler;
}