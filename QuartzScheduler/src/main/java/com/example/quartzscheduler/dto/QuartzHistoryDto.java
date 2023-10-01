package com.example.quartzscheduler.dto;

import com.example.quartzscheduler.entity.QuartzHistoryLog;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor
@Builder
public class QuartzHistoryDto {

	private String scheduleName;
	private String triggerName;
	private String triggerGroup;
	private String jobName;
	private String jobGroup;
	private String jobClass;
	private String scheduleState;
	private String cronExpression;
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
	private LocalDateTime createTime;
	private String reason;

	public QuartzHistoryLog toEntity() {
		return QuartzHistoryLog.builder()
				.scheduleName( this.scheduleName )
				.triggerName( this.triggerName )
				.triggerGroup( this.triggerGroup )
				.jobName( this.jobName )
				.jobGroup( this.jobGroup )
				.jobClass( this.jobClass )
				.scheduleState( this.scheduleState )
				.cronExpression( this.cronExpression )
				.createTime( this.createTime )
				.reason( this.reason )
				.build();
	}
}
