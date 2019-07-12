package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoLocalizacionPersonaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Service
@Validated
public class PeriodoLocalizacionPersonaServiceImpl implements PeriodoLocalizacionPersonaService {

    @Autowired
    private PeriodoLocalizacionPersonaRepositoryCustom periodoLocalizacionPersonaRepositoryCustom;

    @Override
    public void mergePeriodoLocalizacionPersona(@NotNull RunTareaDto tareaDto) {
        periodoLocalizacionPersonaRepositoryCustom.mergePeriodoLocalizacionPersona(tareaDto);
    }
}
