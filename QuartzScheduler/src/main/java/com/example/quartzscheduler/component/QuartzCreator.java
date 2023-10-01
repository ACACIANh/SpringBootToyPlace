package com.example.quartzscheduler.component;

import com.example.quartzscheduler.dto.JobRequest;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
@RequiredArgsConstructor
public class QuartzCreator {
	// todo: 코드 개선
	private final ApplicationContext applicationContext;

	public JobDetail createJob( JobRequest jobRequest, Class< ? extends Job > jobClass ) {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
		factoryBean.setJobClass( jobClass );
		factoryBean.setDurability( false );
		factoryBean.setApplicationContext( applicationContext );
		factoryBean.setName( jobRequest.getJobName() );
		factoryBean.setGroup( jobRequest.getJobGroup() );
		factoryBean.setDescription( jobRequest.getDesc() );
		if ( jobRequest.getJobDataMap() != null ) {
			factoryBean.setJobDataMap( jobRequest.getJobDataMap() );
		}
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}

	public Trigger tryCreateTrigger( JobRequest jobRequest ) throws ParseException {
		String cronExpression = jobRequest.getCronExpression();
		if ( CronExpression.isValidExpression( cronExpression ) ) {
			return this.createTrigger( jobRequest );
		}
		throw new IllegalArgumentException( "cron expression invalid " + cronExpression );
	}

	public Trigger createTrigger( JobRequest jobRequest ) throws ParseException {
		CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
		factoryBean.setName( jobRequest.getJobName().concat( "Trigger" ) );
		factoryBean.setGroup( jobRequest.getJobGroup() );
		factoryBean.setCronExpression( jobRequest.getCronExpression() );
		factoryBean.setMisfireInstruction( SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW );

		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put( "failCnt", "0" );
		jobDataMap.put( "stop", "N" );
		jobDataMap.put( "retry", jobRequest.getRetry() );
		factoryBean.setJobDataMap( jobDataMap );
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}
}
