package com.example.validationinheritance;

import jakarta.validation.constraints.Max;
import lombok.Getter;

@Getter
public class RequestSecond extends AbstractRequest {
	@Max( 10L )
	private long max10;
}
