package com.inditex.rrhh.icmclcwb.api.app.service.test;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.test.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.SsoDto;

public interface TestService {
	
	RelojDto reloj();
	
	SsoDto sso();
	
	void errorSync() throws Exception;
	
	CompletableFuture<Void> errorAsync() throws Exception;

}