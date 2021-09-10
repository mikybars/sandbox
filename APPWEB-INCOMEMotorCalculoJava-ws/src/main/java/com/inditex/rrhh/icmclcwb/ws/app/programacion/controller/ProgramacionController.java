package com.inditex.rrhh.icmclcwb.ws.app.programacion.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import io.swagger.annotations.ApiOperation;

// @Validated
@RestController
@RequestMapping(path = "/programacion")
// @Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}), value =
// "ProgramacionController",
// tags = { "ProgramacionController" })
public class ProgramacionController {

    @Autowired
    private ProgramacionService programacionService;

    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation(value = "Crea una nueva programación", response = ProgramacionDTO.class)
    public @Valid ProgramacionDTO create(@Valid @RequestBody final ProgramacionDTO programacion) {
        return this.programacionService.create(programacion);
    }

    @GetMapping("/reset")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation(value = "Resetea la fecha de siguiente ejecución de las programaciones")
    public void reset() {
        this.programacionService.reset();
    }

    @GetMapping("/activa")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation(value = "Activa las programaciones")
    public void activa() {
        this.programacionService.activa();
    }

    @GetMapping("/activa/{id}")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation(value = "Activa la programacion")
    public void activa(@PathVariable @Positive @NotNull final Long id) {
        this.programacionService.activa(id);
    }

    @GetMapping("/desactiva")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation(value = "Desactiva las programaciones")
    public void desactiva() {
        this.programacionService.desactiva();
    }

    @GetMapping("/desactiva/{id}")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation(value = "Desactiva la programacion")
    public void desactiva(@PathVariable @Positive @NotNull final Long id) {
        this.programacionService.desactiva(id);
    }

}
