package com.example.quartzscheduler.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.quartz.JobDataMap;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class JobRequest {

	private String scheduleName;

	private String jobGroup = "DEV";

	private String retry = "N";

	@NotBlank( message = "JobName is required." )
	private String jobName;

	@NotBlank( message = "JobClass is required." )
	private String jobClass;            // todo: enum 으로 관리

	//@NotBlank(message = "cronExpression is required.")
	private String cronExpression;

	private String scheduleState;       // todo: enum or dto 분리

	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
	private LocalDateTime startDateAt;

	private long repeatIntervalInSeconds;

	private int repeatCount;

	private JobDataMap jobDataMap;

	private String desc;

	private String reason;
}
