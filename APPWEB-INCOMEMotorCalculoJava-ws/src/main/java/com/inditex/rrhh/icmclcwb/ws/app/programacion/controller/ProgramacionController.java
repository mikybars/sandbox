package com.inditex.rrhh.icmclcwb.ws.app.programacion.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
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
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation(value = "Crea una nueva programación", response = ProgramacionDto.class)
    public @Valid ProgramacionDto create(@Valid @RequestBody final ProgramacionDto programacion) {
        return programacionService.create(programacion);
    }

    @GetMapping("/reset")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation(value = "Resetea la fecha de siguiente ejecución de las programaciones")
    public void reset() {
        programacionService.reset();
    }

    @GetMapping("/activa")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation(value = "Activa las programaciones")
    public void activa() {
        programacionService.activa();
    }

}