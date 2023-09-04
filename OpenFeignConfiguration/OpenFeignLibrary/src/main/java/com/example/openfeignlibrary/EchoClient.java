package com.example.openfeignlibrary;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient( value = "echoClient", url = "${remoteHost}" )
public interface EchoClient {

	@RequestMapping( method = RequestMethod.GET, value = "/v1/echo" )
	String echo( @RequestParam String echo );

	@RequestMapping( method = RequestMethod.GET, value = "/v1/echo" )
	Response echoResponse( @RequestParam String echo );
}
