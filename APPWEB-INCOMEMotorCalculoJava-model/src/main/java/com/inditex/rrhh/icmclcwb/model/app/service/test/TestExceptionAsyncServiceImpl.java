package com.inditex.rrhh.icmclcwb.model.app.service.test;

import com.inditex.rrhh.icmclcwb.api.app.service.test.TestExceptionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestExceptionService;

import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestExceptionAsyncServiceImpl implements TestExceptionAsyncService {

    @Autowired
    private TestExceptionService testExceptionService;
    
    @Async
	@Override
	public CompletableFuture<Void> applicationException() throws Exception {
        testExceptionService.applicationException();
        return CompletableFuture.completedFuture(null);
	}

}