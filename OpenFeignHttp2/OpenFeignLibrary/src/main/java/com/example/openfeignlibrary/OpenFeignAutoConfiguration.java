package com.example.openfeignlibrary;

import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@AutoConfiguration
@ComponentScan( basePackageClasses = OpenFeignAutoConfiguration.class )
@EnableFeignClients( basePackageClasses = OpenFeignAutoConfiguration.class )
public class OpenFeignAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public OkHttpClient client() {
		return new OkHttpClient.Builder().build();
	}
}
