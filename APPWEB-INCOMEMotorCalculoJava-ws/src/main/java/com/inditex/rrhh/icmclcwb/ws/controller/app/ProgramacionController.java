package com.inditex.rrhh.icmclcwb.ws.controller.app;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ProgramacionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/programacion")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class ProgramacionController {

	@Autowired
	private ProgramacionService programacionService;

	@PostMapping
	@ApiOperation(value = "Inserta una nueva programación", response = ProgramacionDto.class)
	public @Valid ProgramacionDto insert(@Valid @RequestBody ProgramacionDto programacion) {
		return programacionService.createProgramacion(programacion);
	}

	@GetMapping(path = "/run/")
	@ApiOperation("Revisa si hay programaciones pendientes de lanzar y en caso afirmativo genera los trabajos necesarios asociados a la programación")
	@PreAuthorize("hasAuthority('admin')")
	public List<TrabajoDto> run() {
		return programacionService.run();
	}

}