package com.inditex.rrhh.icmclcwb.interceptor;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {

	@Autowired
    private Logger LOG;

	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... params) {
		LOG.error("Method Name::" + method.getName());
		LOG.error("Exception occurred::" + ex, ex);
	}

}