package com.inditex.rrhh.icmclcwb.model.app.service.test;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.aqsw.framework.service.aaa.classic.serviciossso.UserSSO;
import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestService;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TestServiceImpl implements TestService {

	@Autowired
	private Logger LOG;
	
	@Autowired
	private TestAsyncService testAsyncService;

	@Override
	public RelojDto reloj() {
		LOG.info("Inicio :: TestService.reloj()");
		RelojDto reloj = new RelojDto();
		LOG.info("Fin :: TestService.reloj(): {}", reloj);
		return reloj;
	}

	@Override
	public SsoDto sso() {
		LOG.info("Inicio :: TestService.reloj()");
		SsoDto result = new SsoDto();
		UserSSO userSso = SsoUtils.getUserSSO();
		LOG.info("userSso: {}", userSso);
		result.setResult(userSso.toString());
		LOG.info("Fin :: TestService.reloj(): {}", userSso);
		return result;
	}

	@Override
	public void errorSync() throws Exception {
		LOG.info("Inicio :: TestService.errorSync()");
		throw new ApplicationException("Synchronous error");
	}

	@Override
	public void errorAsync() throws Exception {
		LOG.info("Inicio :: TestService.errorAsync()");
		CompletableFuture<Void> cfErrorAsync1 = testAsyncService.errorAsync();
		cfErrorAsync1.exceptionally(e -> {
			LOG.error("TestService.errorAsync() :: cfErrorAsync1.exceptionally()", e);
	        return null;
	    });
		
		CompletableFuture<Void> cfErrorAsync2 = testAsyncService.errorAsync();
		cfErrorAsync2.exceptionally(e -> {
			LOG.error("TestService.errorAsync() :: cfErrorAsync2.exceptionally()", e);
	        return null;
	    });
		
		CompletableFuture.allOf(cfErrorAsync1, cfErrorAsync2).exceptionally(e -> {
			LOG.error("TestService.errorAsync() :: CompletableFuture.allOf().exceptionally()", e);
	        return null;
	    });
		LOG.info("Fin :: TestService.errorAsync()");
	}

}