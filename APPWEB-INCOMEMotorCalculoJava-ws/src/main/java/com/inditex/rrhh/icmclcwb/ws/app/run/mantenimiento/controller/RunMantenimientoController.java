package com.inditex.rrhh.icmclcwb.ws.app.run.mantenimiento.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.dto.RunMantenimientoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.service.RunMantenimientoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/run/mantenimiento")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}), tags = { "RunMantenimientoController" })
public class RunMantenimientoController {

    @Autowired
    private RunMantenimientoService runMantenimientoService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("Realiza el mantenimiento")
    public RunMantenimientoDto run() {
        return this.runMantenimientoService.run();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("Realiza el mantenimiento de una tarea")
    public RunMantenimientoDto runIdTarea(@PathVariable @Valid @NotNull @Positive final Long id) {
        return this.runMantenimientoService.runIdTarea(id);
    }

}
