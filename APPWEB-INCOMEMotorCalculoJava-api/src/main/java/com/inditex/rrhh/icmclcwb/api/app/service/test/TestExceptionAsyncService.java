package com.inditex.rrhh.icmclcwb.api.app.service.test;

import java.util.concurrent.CompletableFuture;

public interface TestExceptionAsyncService {

	CompletableFuture<Void> applicationException() throws Exception;

}