package com.inditex.rrhh.icmclcwb.ws.controller.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ProgramacionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.Data;

@Validated
@RestController
@RequestMapping(path = "/programacion")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class ProgramacionController {

	@Autowired
	private ProgramacionService programacionService;

	@PostMapping
	@ApiOperation("Inserta una nueva programación")
	public @Valid ProgramacionDto insert(@Valid @RequestBody final ProgramacionDto programacion) {
		return programacionService.createProgramacion(programacion);
	}

	@GetMapping(path = "/run/")
	@ApiOperation("Revisa si hay programaciones pendientes de lanzar y en caso afirmativo, genera el trabajo")
	@PreAuthorize("hasAuthority('admin')")
	public List<ProgramacionTrabajoDto> run() throws Exception {
		return programacionService.run();
	}

	// TODO Eliminar cuando no sea necesario
	@GetMapping(path = "/init/")
	@ApiOperation("Inicializa datos de prueba")
	@PreAuthorize("hasAuthority('admin')")
	public Boolean init() throws Exception {
		return programacionService.init();
	}

	// TODO Eliminar cuando no sea necesario
	@GetMapping(path = "/test/")
	public Clock clock() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		return new Clock();
	}

	// TODO Eliminar cuando no sea necesario
	@Data
	public class Clock {
		private LocalDate localDate = LocalDate.now();
		private LocalTime localTime = LocalTime.now();
		private LocalDateTime localDateTime = LocalDateTime.now();
	}

}