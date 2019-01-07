package com.inditex.rrhh.icmclcwb.ws.controller.app.test;

import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.calculo.TipoCalculoEnum;

import io.swagger.annotations.Api;
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
	private TrabajoRunCalcularService trabajoRunCalcularService;
	
	
	public static final Long GLOBAL_TIENDA = new Long(1L);

	private TrabajoRunDto trabajoRunDto = new TrabajoRunDto();
	
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
	
	
	//*************
			
	@GetMapping(path = "/calculo/trabajo")
	@ApiOperation("Test calculo trabajo, GET")	
	public void testPathPTRVentas(Long trabajo) throws Exception {				
		TrabajoDto trabajoDto = new TrabajoDto();
		trabajoDto.setId(trabajo);
		trabajoRunDto.setTrabajoDto(trabajoDto);
		Set<Long> tiposCalculo = new HashSet<>();  
		tiposCalculo.add(TipoCalculoEnum.GLOBAL_TIENDA.getId());		
		EstadoTrabajoDto  estado = new EstadoTrabajoDto(EstadoTrabajoEnum.PENDIENTE_CALCULO.getId()); 				
		trabajoDto.setEstado(estado);		
		trabajoRunDto.getTrabajoRunCalcular().setTiposCalculo(tiposCalculo);				
		trabajoRunCalcularService.run(trabajoRunDto);
	}	
	
	//*************
	
}