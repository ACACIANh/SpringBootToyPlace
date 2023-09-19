package com.example.enumstrategy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class MyRequestBody {

	private MyFirstEnum myEnum;
	private String content;
}
