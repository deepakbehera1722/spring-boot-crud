package com.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
@EnableAsync
@SpringBootApplication
public class SpringBootAsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAsyncApplication.class, args);
	}
	@Bean("asyncExecution")
	public TaskExecutor getAsyncExcutor()
	{
		ThreadPoolTaskExecutor excutors= new ThreadPoolTaskExecutor();
		excutors.setCorePoolSize(20);
		excutors.setMaxPoolSize(1000);
		excutors.setWaitForTasksToCompleteOnShutdown(true);
		excutors.setThreadNamePrefix("AsynC-");
		return excutors;
	}

}
