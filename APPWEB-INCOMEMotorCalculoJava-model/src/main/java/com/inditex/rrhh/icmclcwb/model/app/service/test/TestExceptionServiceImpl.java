package com.inditex.rrhh.icmclcwb.model.app.service.test;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestExceptionService;

import java.util.Random;
import java.util.stream.LongStream;

import org.springframework.stereotype.Service;

@Service
public class TestExceptionServiceImpl implements TestExceptionService {

	@Override
	public void applicationException() throws Exception {
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		Thread.sleep(time);
		throw new ApplicationException("Asynchronous error");
	}

}