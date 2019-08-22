package com.inditex.rrhh.icmclcwb.ws.app.run.programacion.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/run/programacion")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class RunProgramacionController {

	@Autowired
	private RunProgramacionService runProgramacionService;

	@GetMapping
	@PreAuthorize("hasAuthority('admin')")
	@ApiOperation("Revisa si hay programaciones pendientes de lanzar y en caso afirmativo genera las acciones necesarias")
	public List<RunProgramacionDto> run() {
	    List<RunProgramacionDto> result = runProgramacionService.run();
	    if(CollectionUtils.isEmpty(result)) {
	        throw new IcmclcwbException("Se han procesado cálculos, esto es un mock para validar la planificación de control-m");
	    }
	    return result;
	}

}