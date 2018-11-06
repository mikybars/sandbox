package com.inditex.rrhh.icmclcwb.ws.controller.app.poc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.poc.PocTiendaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/poc/tienda")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class PocTiendaController {

	@Autowired
	private PocTiendaService pocTiendaService;

	@GetMapping
	@ApiOperation("Obtiene todas las tiendas")
	public List<PocTiendaDto> findAll() {
		return pocTiendaService.findAll();
	}

}