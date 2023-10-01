package com.example.quartzscheduler.component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler ) {

		log.info( "RECV [{}:{}] --({})--> [X] - {} {}",
				request.getRemoteAddr(), request.getRemotePort(), request.getProtocol(), request.getMethod(), request.getRequestURI() );
		return true;
	}

	@Override
	public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView ) {

		log.info( "SEND [X] --({})--> [{}:{}] - {} {} ==> status={}",
				request.getProtocol(), request.getRemoteAddr(), request.getRemotePort(),
				request.getMethod(), request.getRequestURI(), response.getStatus() );
	}
}

