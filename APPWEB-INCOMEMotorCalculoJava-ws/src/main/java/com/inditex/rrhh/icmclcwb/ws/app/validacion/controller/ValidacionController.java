package com.inditex.rrhh.icmclcwb.ws.app.validacion.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaValidarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/validacion")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}), tags = { "ValidacionController" })
public class ValidacionController {

    @Autowired
    private TareaValidarService tareaValidarService;

    @GetMapping("/tarea/{idTarea}")
    @ApiOperation("Realiza validaciones para una tarea")
    public @Valid Map<String, Object> validateByIdTarea(@PathVariable @Valid @NotNull @Positive final Long idTarea) {
        return this.tareaValidarService.validateByIdTarea(idTarea);
    }

    @GetMapping("/trabajo/{idTrabajo}")
    @ApiOperation("Realiza validaciones para un trabajo")
    public @Valid List<Map<String, Object>> validateByIdTrabajo(
            @PathVariable @Valid @NotNull @Positive final Long idTrabajo) {
        return this.tareaValidarService.validateByIdTrabajo(idTrabajo);
    }

}
