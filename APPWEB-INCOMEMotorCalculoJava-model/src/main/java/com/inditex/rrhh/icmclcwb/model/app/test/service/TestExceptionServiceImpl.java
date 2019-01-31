package com.inditex.rrhh.icmclcwb.model.app.test.service;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionService;
import com.inditex.rrhh.icmclcwb.model.app.util.TestUtils;

import org.springframework.stereotype.Service;

@Service
public class TestExceptionServiceImpl implements TestExceptionService {

	@Override
	public void applicationException() throws Exception {
	    TestUtils.threadSleep();
		throw new ApplicationException("Asynchronous error");
	}

}