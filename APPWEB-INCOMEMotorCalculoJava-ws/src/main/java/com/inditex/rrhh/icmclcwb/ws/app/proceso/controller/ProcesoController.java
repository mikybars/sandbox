package com.inditex.rrhh.icmclcwb.ws.app.proceso.controller;

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

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/proceso")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class ProcesoController {

	@Autowired
	private ProcesoService procesoService;

	@PostMapping
	@ApiOperation("Crea un nuevo proceso")
	public @Valid ProcesoDto createProceso(@Valid @RequestBody final ProcesoDto proceso) {
		return procesoService.createProceso(proceso);
	}
	
	@GetMapping
    @ApiOperation("Obtiene todos los procesos")
    public @Valid List<ProcesoDto> findAllProceso() {
        return procesoService.findAllProceso();
    }
	
	@GetMapping("/{id}")
    @ApiOperation("Obtiene un proceso")
    public @Valid ProcesoDto findProceso(@PathVariable @Valid @NotNull @Positive final Long id) {
        return procesoService.findProceso(id);
    }

}