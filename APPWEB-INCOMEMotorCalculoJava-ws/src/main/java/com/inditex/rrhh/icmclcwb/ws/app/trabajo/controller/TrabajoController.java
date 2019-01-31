package com.inditex.rrhh.icmclcwb.ws.app.trabajo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/trabajo")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class TrabajoController {

	@Autowired
	private TrabajoService trabajoService;

	@PostMapping
	@ApiOperation("Inserta un nuevo trabajo")
	public @Valid TrabajoDto insert(@Valid @RequestBody final TrabajoDto trabajo) {
		return trabajoService.createTrabajo(trabajo);
	}

}