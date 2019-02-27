package com.inditex.rrhh.icmclcwb.ws.app.algoritmo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.service.AlgoritmoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/algoritmo")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class AlgoritmoController {
    
    @Autowired
    AlgoritmoService algoritmoService;

    @GetMapping
    @ApiOperation("Comprueba si hay algoritmos activos solapandose")
    public @Valid Boolean checkDuplicatedActives() {
        return algoritmoService.checkDuplicatedActives();
    }
}
