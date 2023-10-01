package com.example.quartzscheduler.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TriggerListenerComponent implements TriggerListener {

	@Override
	public String getName() {
		return "TriggerListenerComponent";
	}

	@Override  //Trigger 실행시, 리스너중 가장 먼저 실행됨
	public void triggerFired( Trigger trigger, JobExecutionContext context ) {

	}

	@Override //Trigger 중단 여부를 확인하는 메소드
	public boolean vetoJobExecution( Trigger trigger, JobExecutionContext context ) {
		return false;
	}

	@Override //Trigger 수행 실패 후 실행
	public void triggerMisfired( Trigger trigger ) {

	}

	@Override //Trigger 수행 완료 후 실행
	public void triggerComplete( Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode ) {

	}
}
