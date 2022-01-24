package com.inditex.rrhh.icmclcwb.api.app.test.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

@Async
public interface TestExceptionAsyncService {

  CompletableFuture<Void> icmclcwbException();

}
