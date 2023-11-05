package com.example.redisinheritance;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash( "Animal" )
@AllArgsConstructor
public class Animal {

	@Id
	private String name;
}
