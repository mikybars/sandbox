package com.inditex.rrhh.icmclcwb.api.app.test.service;

import java.util.concurrent.CompletableFuture;

public interface TestExceptionAsyncService {

	CompletableFuture<Void> icmclcwbException() throws Exception;

}