package com.inditex.rrhh.icmclcwb.api.app.service.test;

import java.util.concurrent.CompletableFuture;

public interface TestAsyncService {

	CompletableFuture<Void> errorAsync() throws Exception;

}