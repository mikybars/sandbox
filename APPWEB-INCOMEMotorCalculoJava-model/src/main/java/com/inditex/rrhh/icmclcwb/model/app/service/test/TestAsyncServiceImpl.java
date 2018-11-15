package com.inditex.rrhh.icmclcwb.model.app.service.test;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestAsyncService;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.LongStream;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TestAsyncServiceImpl implements TestAsyncService {

	@Async
	@Override
	public CompletableFuture<Void> errorAsync() throws Exception {
		Random random = new Random();
		LongStream ls = random.longs(1000, 5000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		Thread.sleep(time);
		throw new ApplicationException("Asynchronous error");
	}

}