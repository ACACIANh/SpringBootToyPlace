package com.example.validationinheritance;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public abstract class AbstractRequest {
	@NotBlank
	private String name;
}
