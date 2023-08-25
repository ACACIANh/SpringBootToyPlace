package com.example.jsoncolumnmapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class JsonColumnMappingApplication {

	public static void main( String[] args ) {
		SpringApplication.run( JsonColumnMappingApplication.class, args );
	}

}
