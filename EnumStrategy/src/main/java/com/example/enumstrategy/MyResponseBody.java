package com.example.enumstrategy;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class MyResponseBody {

	private MyFirstEnum myEnum;
	private String content;

	public MyResponseBody( MyRequestBody requestBody ) {
		this.myEnum = requestBody.getMyEnum();
		this.content = requestBody.getContent();
	}
}
