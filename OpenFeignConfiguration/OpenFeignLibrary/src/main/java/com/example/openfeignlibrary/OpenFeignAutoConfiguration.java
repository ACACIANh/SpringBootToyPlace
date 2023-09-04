package com.example.openfeignlibrary;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@AutoConfiguration
@ComponentScan( basePackageClasses = OpenFeignAutoConfiguration.class )
@EnableFeignClients( basePackageClasses = OpenFeignAutoConfiguration.class )
public class OpenFeignAutoConfiguration {

}
