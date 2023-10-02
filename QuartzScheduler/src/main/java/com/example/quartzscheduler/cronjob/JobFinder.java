package com.example.quartzscheduler.cronjob;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.quartz.Job;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum JobFinder {
	//@formatter:off
	SIMPLE_MY_JOB(  "SimpleMyJob",   SimpleMyJob.class )
	//@formatter:on
	;

	private static final Map< String, JobFinder > INDEX_FOR_NAME = new LinkedHashMap<>();

	static {
		Arrays.stream( JobFinder.values() ).forEach( e -> INDEX_FOR_NAME.put( e.className.toLowerCase(), e ) );
	}

	private final String className;
	private final Class< ? extends QuartzJobBean > jobClass;

	public static Optional< JobFinder > findByName( String className ) {
		// todo: 개선 요소 - 검사 시 ignore case
		return Optional.ofNullable( INDEX_FOR_NAME.get( className.toLowerCase() ) );
	}
}
