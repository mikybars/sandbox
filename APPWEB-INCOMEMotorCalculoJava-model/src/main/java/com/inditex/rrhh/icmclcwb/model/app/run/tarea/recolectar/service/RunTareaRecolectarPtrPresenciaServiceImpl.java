package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCadenaPresenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;

@Service
@Validated
public class RunTareaRecolectarPtrPresenciaServiceImpl implements RunTareaRecolectarPtrPresenciaService {

    @Autowired
    @Qualifier("meta4Properties")
    private Map<String, Meta4PropertiesDto> meta4Properties;

    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;

    @Autowired
    @Qualifier(value = "recolectarProperties")
    private RecolectarPropertiesDto recolectarProperties;

    @Autowired
    private TareaCadenaPresenciaService tareaCadenaPresenciaService;

    @Autowired
    private RunTareaAmbitoRecolectarPtrPresenciaService runTareaAmbitoRecolectarPtrPresenciaService;

    @Override
    public void tiposHorasByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(
                item -> runTareaAmbitoRecolectarPtrPresenciaService.tiposHorasByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void presenciaTotalLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrPresenciaService
                .presenciaTotalLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void presenciaDetalleComisionablePersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrPresenciaService
                .presenciaDetalleComisionablePersonaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void presenciaDetalleComisionableLocalizacionPersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrPresenciaService
                .presenciaDetalleComisionableLocalizacionPersonaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void presenciaEmpleadoTiendaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrPresenciaService
                .presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void presenciaTotalCadenaByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrPresenciaService
                .presenciaTotalCadenaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void updateActivoCadenaByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        tareaCadenaPresenciaService.updateActivoCadenaByRunTarea(runTarea.getTarea());
    }
}
