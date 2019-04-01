package com.inditex.rrhh.icmclcwb.model.app.test.service;

import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class TestExceptionAsyncServiceImpl implements TestExceptionAsyncService {

    @Autowired
    private TestExceptionService testExceptionService;

    @Override
    public CompletableFuture<Void> icmclcwbException() {
        testExceptionService.icmclcwbException();
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}