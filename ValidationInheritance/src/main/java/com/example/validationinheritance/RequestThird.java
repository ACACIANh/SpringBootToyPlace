package com.example.validationinheritance;

import lombok.Getter;

@Getter
public class RequestThird extends AbstractRequest {
	private int negativeInt;
	private long max10;
	private boolean isFirst;

	// lombok 에서 자동생성해주는 메소드가 isFirst() 이므로 메소드 직접 명시하거나 Boolean type 사용하면 해결
	public boolean getIsFirst() {
		return isFirst;
	}
}
