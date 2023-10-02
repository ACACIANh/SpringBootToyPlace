package com.example.quartzscheduler.service;

import com.example.quartzscheduler.component.QuartzCreator;
import com.example.quartzscheduler.cronjob.JobFinder;
import com.example.quartzscheduler.dto.JobRequest;
import com.example.quartzscheduler.exception.ServiceErrorCode;
import com.example.quartzscheduler.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
@RequiredArgsConstructor
public class QuartzService {

	private final SchedulerFactoryBean schedulerFactoryBean;
	private final QuartzCreator quartzCreator;
	private final QuartzHistoryService quartzHistoryService;

	public void tryAddScheduleJob( JobRequest jobRequest ) throws ClassNotFoundException, ParseException, SchedulerException {
		if ( isJobExists( jobRequest ) ) {      // todo: 개선 요소 - exception 으로 처리?
			throw new ServiceException( ServiceErrorCode.JOB_IS_ALREADY_EXIST );
		}
		jobRequest.setScheduleState( "ADD" );
		this.addScheduleJob( jobRequest );
	}

	private void addScheduleJob( JobRequest jobRequest ) throws ParseException, SchedulerException {
		Class< ? extends QuartzJobBean > jobClass = JobFinder.findByName( jobRequest.getJobClass() )
				.orElseThrow( () -> new ServiceException( ServiceErrorCode.JOB_IS_ALREADY_EXIST ) )
				.getJobClass();
		JobDetail jobDetail = quartzCreator.createJob( jobRequest, jobClass );
		Trigger trigger = quartzCreator.createTrigger( jobRequest );

		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		scheduler.scheduleJob( jobDetail, trigger );
		jobRequest.setScheduleName( scheduler.getSchedulerName() );
		quartzHistoryService.save( jobRequest );
	}

	public boolean isJobExists( JobRequest jobRequest ) throws SchedulerException {
		JobKey jobKey = jobKey = new JobKey( jobRequest.getJobName(), jobRequest.getJobGroup() );
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		return scheduler.checkExists( jobKey );
	}

	public void tryDeleteScheduleJob( JobRequest jobRequest ) throws SchedulerException {
		if ( !isJobExists( jobRequest ) ) {
			throw new ServiceException( ServiceErrorCode.JOB_IS_NOT_EXIST );
		}
		jobRequest.setScheduleState( "DELETE" );
		this.deleteScheduleJob( jobRequest );
		quartzHistoryService.save( jobRequest );
	}

	private void deleteScheduleJob( JobRequest jobRequest ) throws SchedulerException {
		JobKey jobKey = JobKey.jobKey( jobRequest.getJobName(), jobRequest.getJobGroup() );
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		scheduler.deleteJob( jobKey );
	}
}
