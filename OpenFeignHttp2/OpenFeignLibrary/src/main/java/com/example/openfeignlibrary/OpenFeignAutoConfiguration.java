package com.example.openfeignlibrary;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@AutoConfiguration
@ComponentScan( basePackageClasses = OpenFeignAutoConfiguration.class )
@EnableFeignClients( basePackageClasses = OpenFeignAutoConfiguration.class )
public class OpenFeignAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public OkHttpClient client() {
		List< Protocol > http2 = List.of( Protocol.H2_PRIOR_KNOWLEDGE );
		return new OkHttpClient.Builder()
				.protocols( http2 )
				.build();
	}
}
