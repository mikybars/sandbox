package com.inditex.rrhh.icmclcwb.model.app.limpieza.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository.LimpiezaRepositoryCustom;

@Service
@Validated
public class LimpiezaServiceImpl implements LimpiezaService {

    @Autowired
    private LimpiezaRepositoryCustom limpiezaRepositoryCustom;

    @Autowired
    private TrabajoService trabajoService;

    @Override
    public void runTarea(@NotNull @Valid final TareaDto tarea) {
        tarea.getAmbito().forEach(item -> limpiezaRepositoryCustom.limpieza(tarea, item));
        limpiezaRepositoryCustom.consolidar(tarea, trabajoService.find(tarea.getIdTrabajo()));
    }

    @Override
    public void limpiezaTareaPersonaHistorico(@NotNull @Valid TareaDto tarea) {
        limpiezaRepositoryCustom.limpiezaTareaPersonaHistorico(tarea);
    }

    @Override
    public void limpiezaTareaLocalizacionHistorico(@NotNull @Valid TareaDto tarea) {
        limpiezaRepositoryCustom.limpiezaTareaLocalizacionHistorico(tarea);
    }

    @Override
    public void limpiezaTareaGlobalLocalizacionPersona(@NotNull @Valid TareaDto tarea) {
        limpiezaRepositoryCustom.limpiezaTareaGlobalLocalizacionPersona(tarea);
    }

    @Override
    public void limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(@NotNull @Valid TareaDto tarea) {
        limpiezaRepositoryCustom.limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(tarea);
    }

    @Override
    public void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(@NotNull @Valid TareaDto tarea) {
        limpiezaRepositoryCustom.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(tarea);
    }

    @Override
    public void limpiezaTareaAmbitoLocalizacion(@NotNull @Valid TareaDto tarea) {
        tarea.getAmbito().forEach(ambito -> limpiezaRepositoryCustom.limpiezaTareaAmbitoLocalizacion(tarea, ambito));
    }

    @Override
    public void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(@NotNull @Valid TareaDto tarea) {
        limpiezaRepositoryCustom.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(tarea);
    }

    @Override
    public void limpiezaTareaAmbitoGlobalPersona(@NotNull @Valid TareaDto tarea) {
        limpiezaRepositoryCustom.limpiezaTareaAmbitoGlobalPersona(tarea);
    }

}
