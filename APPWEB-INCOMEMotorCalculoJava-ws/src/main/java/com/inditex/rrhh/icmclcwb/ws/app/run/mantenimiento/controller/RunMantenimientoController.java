package com.inditex.rrhh.icmclcwb.ws.app.run.mantenimiento.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.service.RunMantenimientoService;
import com.inditex.rrhh.icmclcwb.dto.RunMantenimientoDTO;
import com.inditex.rrhh.icmclcwb.service.RunMantenimientoApi;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/run/mantenimiento")
public class RunMantenimientoController implements RunMantenimientoApi {

    @Autowired
    private RunMantenimientoService runMantenimientoService;

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("Realiza el mantenimiento")
    public ResponseEntity<RunMantenimientoDTO> run() {
        return new ResponseEntity<>(this.runMantenimientoService.run(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("Realiza el mantenimiento de una tarea")
    public ResponseEntity<RunMantenimientoDTO> runIdTarea(@PathVariable @Valid @NotNull @Positive final Long id) {
        return new ResponseEntity<>(this.runMantenimientoService.runIdTarea(id), HttpStatus.OK);
    }

}
