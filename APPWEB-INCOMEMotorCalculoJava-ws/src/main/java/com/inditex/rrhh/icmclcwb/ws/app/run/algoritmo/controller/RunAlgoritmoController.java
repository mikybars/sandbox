package com.inditex.rrhh.icmclcwb.ws.app.run.algoritmo.controller;

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

import com.inditex.rrhh.icmclcwb.api.app.run.calcular.dto.RunAlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.calcular.service.RunAlgoritmoService;
import io.swagger.annotations.ApiOperation;

// @Validated
@RestController
@RequestMapping(path = "/run/algoritmo")
// @Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}), tags = {
// "RunAlgoritmoController" })
public class RunAlgoritmoController {

    @Autowired
    private RunAlgoritmoService runAlgoritmoService;

    @GetMapping("/{id}")
    @ApiOperation("Obtiene un run algoritmo")
    public @Valid RunAlgoritmoDto findById(@PathVariable @Valid @NotNull @Positive final Integer id) {
        return this.runAlgoritmoService.findById(id);
    }

    @GetMapping
    @ApiOperation("Devuelve el listado de run algoritmos")
    public @Valid List<RunAlgoritmoDto> findAll() {
        return this.runAlgoritmoService.findAll();
    }

}
