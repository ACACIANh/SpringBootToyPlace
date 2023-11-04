package com.example.validationinheritance;

import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RequestSecond extends AbstractRequest {
	@Max( 10L )
	private long max10;

	private RequestSecond() {
	}

	public RequestSecond( String name, long max10 ) {
		super( name );
		this.max10 = max10;
	}
}
