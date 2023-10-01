package com.example.quartzscheduler.service;

import com.example.quartzscheduler.dto.JobRequest;
import com.example.quartzscheduler.dto.QuartzHistoryDto;
import com.example.quartzscheduler.repository.QuartzHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class QuartzHistoryService {

	private final QuartzHistoryRepository quartzHistoryRepository;

	public void save( JobRequest jobRequest ) {
		QuartzHistoryDto quartzHistoryDto = QuartzHistoryDto
				.builder()
				.scheduleName( jobRequest.getScheduleName() )
				.jobName( jobRequest.getJobName() )
				.jobGroup( jobRequest.getJobGroup() )
				.jobClass( jobRequest.getJobClass() )
				.triggerName( jobRequest.getJobName().concat( "Trigger" ) )
				.triggerGroup( jobRequest.getJobGroup() )
				.scheduleState( jobRequest.getScheduleState() )
				.cronExpression( jobRequest.getCronExpression() )
				.reason( jobRequest.getReason() )
				.build();
		quartzHistoryRepository.save( quartzHistoryDto.toEntity() );
	}
}
