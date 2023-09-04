package com.example.swaggerpractice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(
		info = @Info( title = "Swagger Title",
				description = "Swagger Description",
				version = "v1" ) )
@RequiredArgsConstructor
@Configuration
public class SwaggerConfiguration {
	@Bean
	public GroupedOpenApi chatOpenApi() {
		String[] paths = { "/**" };

		return GroupedOpenApi.builder()
				.group( "Group API v1" )
				.pathsToMatch( paths )
				.build();
	}
}
