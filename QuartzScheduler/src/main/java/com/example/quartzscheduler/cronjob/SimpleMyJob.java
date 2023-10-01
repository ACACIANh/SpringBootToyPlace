package com.example.quartzscheduler.cronjob;

import com.example.quartzscheduler.service.HelloService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@DisallowConcurrentExecution
public class SimpleMyJob extends QuartzJobBean {

	@Setter
	private HelloService helloService;
//	private final HelloService helloService;

	@Override
	protected void executeInternal( JobExecutionContext context ) throws JobExecutionException {
		log.info( "SimpleMyJob execute" );
		helloService.helloWord();
	}
}
