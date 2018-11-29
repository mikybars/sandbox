package com.inditex.rrhh.icmclcwb.model.app.service.test;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestExceptionService;
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