package com.inditex.rrhh.icmclcwb.model.app.run.tarea.consolidar.service;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarPeriodoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Service
@Validated
public class RunTareaConsolidarPeriodoServiceImpl implements RunTareaConsolidarPeriodoService {

    @Autowired
    private PeriodoCalculoPersonaService periodoCalculoPersonaService;

    @Autowired
    private PeriodoPersonaService periodoPersonaService;

    @Autowired
    private PeriodoLocalizacionService periodoLocalizacionService;

    @Autowired
    private PeriodoLocalizacionPersonaService periodoLocalizacionPersonaService;

    @Override
    public void mergePeriodoCalculoPersona(@NotNull final RunTareaDto tareaDto) {
        periodoCalculoPersonaService.mergePeriodoCalculoPersona(tareaDto);
    }

    @Override
    public void mergePeriodoPersona(@NotNull final RunTareaDto tareaDto) {
        periodoPersonaService.mergePeriodoPersona(tareaDto);
    }

    @Override
    public void mergePeriodoLocalizacion(@NotNull final RunTareaDto tareaDto) {
        periodoLocalizacionService.mergePeriodoLocalizacion(tareaDto);
    }

    @Override
    public void mergePeriodoLocalizacionPersona(@NotNull final RunTareaDto tareaDto) {
        periodoLocalizacionPersonaService.mergePeriodoLocalizacionPersona(tareaDto);
    }

}
