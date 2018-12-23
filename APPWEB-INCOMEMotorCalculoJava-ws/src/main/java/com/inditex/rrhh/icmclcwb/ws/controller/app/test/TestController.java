package com.inditex.rrhh.icmclcwb.ws.controller.app.test;

import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Profile({ "standalone", "des" })
@Validated
@RestController
@RequestMapping(path = "/test")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class TestController {

	@Autowired
	private TestService testService;
	
	@Autowired
	@Qualifier("ptrVentaClient")
	private RestClient ptrVentaClient;	
	
	@Autowired
	@Qualifier("ptrPresenciaClient")	
	private RestClient ptrPresenciaClient;
	

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
	
	//*************
	
	@GetMapping(path = "/ptrPresencias/path")
	@ApiOperation("Test PTR Presencias path, GET")	
	public String testPathPTRPresecnias(String path) throws Exception {		
		String pathD = URLDecoder.decode(path, "UTF-8");
		return ptrPresenciaClient.getForObject(pathD, String.class);
	}
	
	@GetMapping(path = "/ptrVentas/path")
	@ApiOperation("Test PTR Ventas path, GET")	
	public String testPathPTRVentas(String path) throws Exception {		
		String pathD = URLDecoder.decode(path, "UTF-8");
		return ptrVentaClient.getForObject(pathD, String.class);

	}	

	//*************
}