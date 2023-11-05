package com.example.redisinheritance;

import lombok.ToString;

@ToString
public class Bird extends Animal {

	private String feather;

	public Bird( String name, String feather ) {
		super( name );
		this.feather = feather;
	}
}
