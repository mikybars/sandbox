package com.inditex.rrhh.icmclcwb.ws.app.tarea.controller;

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

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/tarea")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class TareaController {

	@Autowired
	private TareaService tareaService;

	@PostMapping
	@ApiOperation("Crea un nuevo tarea")
	public @Valid TareaDto createTarea(@Valid @RequestBody final TareaDto tarea) {
		return tareaService.createTarea(tarea);
	}
	
	@GetMapping
    @ApiOperation("Obtiene todos los tareas")
    public @Valid List<TareaDto> findAllTarea() {
        return tareaService.findAllTarea();
    }
	
	@GetMapping("/{id}")
    @ApiOperation("Obtiene un tarea")
    public @Valid TareaDto findTarea(@PathVariable @Valid @NotNull @Positive final Long id) {
        return tareaService.findTarea(id);
    }

}