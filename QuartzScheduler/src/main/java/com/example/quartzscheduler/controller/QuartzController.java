package com.example.quartzscheduler.controller;

import com.example.quartzscheduler.dto.JobRequest;
import com.example.quartzscheduler.service.QuartzService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@Slf4j
@RestController
@RequestMapping( "/api/v1" )
@RequiredArgsConstructor
public class QuartzController {

	private final QuartzService quartzService;

	@PostMapping( value = "/job" )
	public ResponseEntity< ? > addScheduleJob( @Valid @RequestBody JobRequest jobRequest ) throws SchedulerException, ParseException, ClassNotFoundException {
		quartzService.tryAddScheduleJob( jobRequest );
		return ResponseEntity.ok().build();
	}

	@DeleteMapping( value = "/job" )
	public ResponseEntity< ? > deleteScheduleJob( @Valid @RequestBody JobRequest jobRequest ) throws SchedulerException {
		quartzService.tryDeleteScheduleJob( jobRequest );
		return ResponseEntity.ok().build();
	}
}
