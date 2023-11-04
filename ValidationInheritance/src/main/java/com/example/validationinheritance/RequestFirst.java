package com.example.validationinheritance;

import jakarta.validation.constraints.Negative;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RequestFirst extends AbstractRequest {
	@Negative
	private int negativeInt;

	private RequestFirst() {
	}

	public RequestFirst( String name, int negativeInt ) {
		super( name );
		this.negativeInt = negativeInt;
	}
}
