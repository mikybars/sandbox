package com.inditex.rrhh.icmclcwb.ws.app.algoritmo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/algoritmo")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}), tags = { "AlgoritmoController" })
public class AlgoritmoController {

    @Autowired
    private AlgoritmoService algoritmoService;

    @GetMapping
    @ApiOperation("Devuelve el listado de algoritmos")
    public @Valid List<AlgoritmoDto> findAll() {
        return this.algoritmoService.findAll();
    }

    @GetMapping("/checkDuplicatedActives")
    @ApiOperation("Comprueba si hay algoritmos activos solapandose")
    public @Valid Boolean checkDuplicatedActives() {
        return this.algoritmoService.checkDuplicatedActives();
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtiene un algoritmo")
    public @Valid AlgoritmoDto findById(@PathVariable @Valid @NotNull @Positive final Integer id) {
        return this.algoritmoService.findById(id);
    }

}
