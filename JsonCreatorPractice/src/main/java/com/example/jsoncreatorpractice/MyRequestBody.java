package com.example.jsoncreatorpractice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class MyRequestBody {

	private MyEnum myEnum;
	private String content;
}
