package com.inditex.rrhh.icmclcwb.ws.app.validacion.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaValidarService;
import com.inditex.rrhh.icmclcwb.service.ValidacionApi;

@RestController
public class ValidacionController implements ValidacionApi {

    @Autowired
    private TareaValidarService tareaValidarService;

    @Override
    public @Valid ResponseEntity<Map<String, Object>> validateByIdTarea(
            @PathVariable @Valid @NotNull @Positive final Long idTarea) {
        return new ResponseEntity<>(this.tareaValidarService.validateByIdTarea(idTarea), HttpStatus.OK);
    }

    @Override
    public @Valid ResponseEntity<List<Map<String, Object>>> validateByIdTrabajo(
            @PathVariable @Valid @NotNull @Positive final Long idTrabajo) {
        return new ResponseEntity<>(this.tareaValidarService.validateByIdTrabajo(idTrabajo), HttpStatus.OK);
    }

}
