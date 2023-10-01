package com.example.quartzscheduler.configuration;

import com.example.quartzscheduler.quartz.JobListenerComponent;
import com.example.quartzscheduler.quartz.TriggerListenerComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class QuartzConfiguration {

	private final ApplicationContext applicationContext;
	private final DataSource dataSource;
	private final QuartzProperties quartzProperties;

	private final TriggerListenerComponent triggerListenerComponent;
	private final JobListenerComponent jobListenerComponent;

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setAutoStartup( quartzProperties.isAutoStartup() );
		schedulerFactoryBean.setApplicationContext( applicationContext );
		schedulerFactoryBean.setDataSource( dataSource );
		schedulerFactoryBean.setJobFactory( springBeanJobFactory() );
		schedulerFactoryBean.setGlobalTriggerListeners( triggerListenerComponent );
		schedulerFactoryBean.setGlobalJobListeners( jobListenerComponent );
		schedulerFactoryBean.setOverwriteExistingJobs( true );
		schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown( true );

		Properties properties = new Properties();
		properties.putAll( quartzProperties.getProperties() );
		schedulerFactoryBean.setQuartzProperties( properties );
		return schedulerFactoryBean;
	}

//	@Bean
//	public Properties quartzProperties() throws IOException {
//		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
//		propertiesFactoryBean.setLocation( new ClassPathResource( "/quartz.properties" ) );
//		propertiesFactoryBean.afterPropertiesSet();
//		return propertiesFactoryBean.getObject();
//	}

	@Bean
	public SpringBeanJobFactory springBeanJobFactory() {
		AutowiringSpringBeanJobFactory autowiringSpringBeanJobFactory = new AutowiringSpringBeanJobFactory();
		autowiringSpringBeanJobFactory.setApplicationContext( applicationContext );
		return autowiringSpringBeanJobFactory;
	}
}
