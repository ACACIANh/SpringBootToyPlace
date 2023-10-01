package com.example.quartzscheduler.quartz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobListenerComponent implements JobListener {

	@Override
	public String getName() {
		return "JobListenerComponent";
	}

	/**
	 * Job 수행 전
	 *
	 * @param context
	 */
	@Override
	public void jobToBeExecuted( JobExecutionContext context ) {
		JobKey jobKey = context.getJobDetail().getKey();
		log.info( "jobToBeExecuted :: jobKey : {}", jobKey );
	}

	/**
	 * Job 중단된 상태
	 *
	 * @param context
	 */
	@Override
	public void jobExecutionVetoed( JobExecutionContext context ) {
		JobKey jobKey = context.getJobDetail().getKey();
		log.info( "jobExecutionVetoed :: jobKey : {}", jobKey );
	}

	/**
	 * Job 수행 완료 후
	 * retry N : Job Exception 발생 시 해당 Trigger,Job Pause
	 * retry Y : Job Exception 발생 시 등록된 기존 Cron Expression 시간에 맞춰 재시도 / 총 3번 실패 시 해당 Trigger 중지
	 *
	 * @param context
	 * @param jobException
	 */
	@Override
	public void jobWasExecuted( JobExecutionContext context, JobExecutionException jobException ) {
		JobKey jobKey = context.getJobDetail().getKey();
		log.info( "jobWasExecuted :: jobKey : {}", jobKey );
	}
}
