package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaService;

@Service
@Validated
public class RunTareaRecolectarPtrPresenciaServiceImpl implements RunTareaRecolectarPtrPresenciaService {

    @Autowired
    private RunTareaAmbitoRecolectarPtrPresenciaService runTareaAmbitoRecolectarPtrPresenciaService;

    @Override
    public void tiposHorasByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea()
            .getAmbito()
            .stream()
            .forEach(
                    item -> this.runTareaAmbitoRecolectarPtrPresenciaService.tiposHorasByRunTareaAndTareaAmbito(
                            runTarea,
                            item));
    }

    @Override
    public void presenciaDetalleComisionablePersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea()
            .getAmbito()
            .stream()
            .forEach(item -> this.runTareaAmbitoRecolectarPtrPresenciaService
                .presenciaDetallePersonaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void presenciaEmpleadoTiendaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea()
            .getAmbito()
            .stream()
            .forEach(item -> this.runTareaAmbitoRecolectarPtrPresenciaService
                .presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(runTarea, item));
    }

}
