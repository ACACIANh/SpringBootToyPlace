package com.example.redisinheritance;

import lombok.ToString;

@ToString
public class Human extends Animal {

	private int finger;

	public Human( String name, int finger ) {
		super( name );
		this.finger = finger;
	}
}
