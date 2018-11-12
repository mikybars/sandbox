package com.inditex.rrhh.icmclcwb.model.app.service.test;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestAsyncService;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.LongStream;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TestAsyncServiceImpl implements TestAsyncService {

	@Autowired
	private Logger LOG;

	@Async
	@Override
	public CompletableFuture<Void> errorAsync() throws Exception {
		LOG.info("Inicio :: TestAsyncService.errorAsync()");
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		LOG.info("TestAsyncService.errorAsync() :: Thread.sleep({})", time);
		Thread.sleep(time);
		throw new ApplicationException("Asynchronous error");
	}

}