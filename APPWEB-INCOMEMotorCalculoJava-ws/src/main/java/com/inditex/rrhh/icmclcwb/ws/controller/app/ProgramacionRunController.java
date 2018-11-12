package com.inditex.rrhh.icmclcwb.ws.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ProgramacionRunService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/programacion/run")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class ProgramacionRunController {

	@Autowired
	private ProgramacionRunService programacionRunService;

	@GetMapping
	@ApiOperation("Revisa si hay programaciones pendientes de lanzar y en caso afirmativo genera los trabajos necesarios asociados a la programación")
	@PreAuthorize("hasAuthority('admin')")
	public List<TrabajoDto> run() {
		return programacionRunService.run();
	}

}