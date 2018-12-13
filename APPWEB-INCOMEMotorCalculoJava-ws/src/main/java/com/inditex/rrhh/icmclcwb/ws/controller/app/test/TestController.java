package com.inditex.rrhh.icmclcwb.ws.controller.app.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.dto.test.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.Authorization;

@Profile ({"standalone","des"})
@Validated
@RestController
@RequestMapping(path = "/test")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class TestController {

	@Autowired
	private TestService testService;

	@GetMapping(path = "/reloj/")
	public RelojDto reloj() {
		return testService.reloj();
	}

	@GetMapping(path = "/sso/")
	public SsoDto sso() {
		return testService.sso();
	}

	@GetMapping(path = "/error/sync/")
	public void errorSync() throws Exception {
		testService.errorSync();
	}

	@GetMapping(path = "/error/async/")
	public void errorAsync() throws Exception {
		testService.errorAsync();
	}

}