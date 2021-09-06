package com.inditex.rrhh.icmclcwb.ws.app.run.programacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import com.inditex.rrhh.icmclcwb.dto.RunProgramacionDTO;
import com.inditex.rrhh.icmclcwb.service.RunProgramacionApi;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/run/programacion")
public class RunProgramacionController implements RunProgramacionApi {

    @Autowired
    private RunProgramacionService runProgramacionService;

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("Revisa si hay programaciones pendientes de lanzar y en caso afirmativo genera las acciones necesarias")
    public ResponseEntity<List<RunProgramacionDTO>> create() {
        return this.runProgramacionService.create();
    }

}
