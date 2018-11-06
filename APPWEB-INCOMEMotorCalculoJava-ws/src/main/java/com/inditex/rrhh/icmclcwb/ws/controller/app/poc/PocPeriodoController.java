package com.inditex.rrhh.icmclcwb.ws.controller.app.poc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocPeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.poc.PocPeriodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/poc/periodo")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class PocPeriodoController {

	@Autowired
	private PocPeriodoService pocPeriodoService;

	@GetMapping
	@ApiOperation("Obtiene todos los periodos")
	public List<PocPeriodoDto> findAll() {
		return pocPeriodoService.findAll();
	}

}