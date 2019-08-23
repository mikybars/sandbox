package com.inditex.rrhh.icmclcwb.ws.app.run.limpieza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.service.RunLimpiezaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/run/limpieza")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class RunLimpiezaController {

    @Autowired
    private RunLimpiezaService runLimpiezaService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("Realiza la limpieza de datos")
    public void run() {
        runLimpiezaService.run();
    }

}