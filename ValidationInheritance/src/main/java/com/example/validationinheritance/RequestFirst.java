package com.example.validationinheritance;

import jakarta.validation.constraints.Negative;
import lombok.Getter;

@Getter
public class RequestFirst extends AbstractRequest {
	@Negative
	private int negativeInt;
}
