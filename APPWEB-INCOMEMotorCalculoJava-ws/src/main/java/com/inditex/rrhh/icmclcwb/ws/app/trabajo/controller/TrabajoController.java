package com.inditex.rrhh.icmclcwb.ws.app.trabajo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@ApiOperation("Crea un nuevo trabajo")
	public @Valid TrabajoDto createTrabajo(@Valid @RequestBody final TrabajoDto trabajo) {
		return trabajoService.createTrabajo(trabajo);
	}
	
	@GetMapping
    @ApiOperation("Obtiene todos los trabajos")
    public @Valid List<TrabajoDto> findAllTrabajo() {
        return trabajoService.findAllTrabajo();
    }
	
	@GetMapping("/{id}")
    @ApiOperation("Obtiene un trabajo")
    public @Valid TrabajoDto findTrabajo(@PathVariable @Valid @NotNull @Positive final Long id) {
        return trabajoService.findTrabajo(id);
    }

}