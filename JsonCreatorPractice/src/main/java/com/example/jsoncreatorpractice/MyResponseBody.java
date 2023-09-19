package com.example.jsoncreatorpractice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class MyResponseBody {

	private MyEnum myEnum;
	private String content;

	public MyResponseBody( MyRequestBody requestBody ) {
		this.myEnum = requestBody.getMyEnum();
		this.content = requestBody.getContent();
	}
}
