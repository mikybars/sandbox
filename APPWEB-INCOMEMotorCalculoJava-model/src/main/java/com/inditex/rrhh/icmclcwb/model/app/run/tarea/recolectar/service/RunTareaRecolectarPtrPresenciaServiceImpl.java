package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class RunTareaRecolectarPtrPresenciaServiceImpl implements RunTareaRecolectarPtrPresenciaService {

    @Autowired
    private RunTareaAmbitoRecolectarPtrPresenciaService runTareaAmbitoRecolectarPtrPresenciaService;

    @Override
    public void tiposHorasByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(
                item -> runTareaAmbitoRecolectarPtrPresenciaService.tiposHorasByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void presenciaDetalleComisionablePersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrPresenciaService
                .presenciaDetallePersonaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void presenciaEmpleadoTiendaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrPresenciaService
                .presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(runTarea, item));
    }
}
