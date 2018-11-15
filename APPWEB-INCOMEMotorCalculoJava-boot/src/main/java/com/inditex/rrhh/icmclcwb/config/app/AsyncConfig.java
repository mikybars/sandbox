package com.inditex.rrhh.icmclcwb.config.app;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.inditex.rrhh.icmclcwb.config.app.interceptor.MyAsyncUncaughtExceptionHandler;

//@Configuration
//@EnableAsync
//@EnableScheduling
// Se usa la propia configuración del arquetipo de Inditex
@Deprecated
public class AsyncConfig extends AsyncConfigurerSupport implements AsyncConfigurer {

	@Autowired
    private Logger LOG;
	
	@Autowired
    private MyAsyncUncaughtExceptionHandler myAsyncUncaughtExceptionHandler;
	
	@Override
    public Executor getAsyncExecutor() {
		LOG.debug("Creating Async Task Executor"); 
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(7);
        executor.setMaxPoolSize(42);
        executor.setQueueCapacity(11);
        executor.setThreadNamePrefix("MyExecutor-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return myAsyncUncaughtExceptionHandler;
    }
	
}