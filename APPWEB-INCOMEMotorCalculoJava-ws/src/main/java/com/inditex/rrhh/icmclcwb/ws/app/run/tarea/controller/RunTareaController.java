package com.inditex.rrhh.icmclcwb.ws.app.run.tarea.controller;

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

import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/run/tarea")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}), tags = { "RunTareaController" })
public class RunTareaController {

    @Autowired
    private RunService runService;

    @GetMapping("/prevalidar/{id}")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("Realiza la validacion de una tarea")
    public void runTareaPreValidar(@PathVariable @Valid @NotNull @Positive final Long id) {
        this.runService.runTareaPreValidar(id);
    }

}
