package com.inditex.rrhh.icmclcwb.ws.controller.ptr.presencia.mock;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.model.mock.calculo.service.PopulateMockCalculoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;



@Profile({"standalone"})
@RestController
@RequestMapping(path = "/populate")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class PopulateMockCalculoController {
	
	@Autowired
	private PopulateMockCalculoService populateMockCalculoService;
	
	@Autowired
	private Logger logger;
		
	@PostMapping(path = "/load")
	@ApiOperation("Carga datos scpritps con datos mock para pruebas de cálculo")
	public void load() {
		logger.info("Llamamos al servicio de cagra de datos mock");
		populateMockCalculoService.loadMock();	    	    	    
	}
	
		
	@DeleteMapping(path = "/delete")
	@ApiOperation("Borra los datos mock")
	public void delete() {
		logger.info("Llamamos al servicio de borrado de datos mock");
		populateMockCalculoService.deleteMock();
	}
	
	
}
