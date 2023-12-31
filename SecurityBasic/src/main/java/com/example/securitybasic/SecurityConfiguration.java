package com.example.securitybasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager userDetailsService( PasswordEncoder passwordEncoder ) {
		UserDetails user = User.withUsername( "user" )
				.password( passwordEncoder.encode( "9999" ) )
				.roles( "USER" )
				.build();

		UserDetails admin = User.withUsername( "admin" )
				.password( passwordEncoder.encode( "admin" ) )
				.roles( "USER", "ADMIN" )
				.build();

		return new InMemoryUserDetailsManager( user, admin );
	}

	@Bean
	public SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
		http
				.authorizeHttpRequests( registry -> registry
						.requestMatchers( "/custom/**" ).authenticated()
						.anyRequest().permitAll()
				)
				.formLogin( config -> config.defaultSuccessUrl( "/custom" ) )
				.logout( config -> config.logoutSuccessUrl( "/" ) )
		;
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
