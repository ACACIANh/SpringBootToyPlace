package com.example.mailpractice;

import lombok.Getter;

@Getter
public class MailRequestBody {

	private String destination;
	private String subject;
	private String text;
}
