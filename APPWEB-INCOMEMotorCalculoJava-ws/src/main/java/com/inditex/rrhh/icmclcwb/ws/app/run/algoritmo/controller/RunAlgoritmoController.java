package com.inditex.rrhh.icmclcwb.ws.app.run.algoritmo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.run.calcular.service.RunAlgoritmoService;
import com.inditex.rrhh.icmclcwb.dto.RunAlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.service.RunAlgoritmoApi;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/run/algoritmo")
public class RunAlgoritmoController implements RunAlgoritmoApi {

    @Autowired
    private RunAlgoritmoService runAlgoritmoService;

    @GetMapping("/{id}")
    @ApiOperation("Obtiene un run algoritmo")
    public @Valid ResponseEntity<RunAlgoritmoDTO> findById(@PathVariable @Valid @NotNull @Positive final Integer id) {
        return new ResponseEntity<>(this.runAlgoritmoService.findById(id), HttpStatus.OK);
    }

    @Override
    @GetMapping
    @ApiOperation("Devuelve el listado de run algoritmos")
    public @Valid ResponseEntity<List<RunAlgoritmoDTO>> findAll() {
        return new ResponseEntity<>(this.runAlgoritmoService.findAll(), HttpStatus.OK);
    }

}
