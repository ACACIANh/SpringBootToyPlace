package com.example.validationinheritance;

import jakarta.validation.Valid;

public interface AbstractHandler {

	void handle( @Valid AbstractRequest request );

	AbstractRequest parse( RequestThird third );
}
