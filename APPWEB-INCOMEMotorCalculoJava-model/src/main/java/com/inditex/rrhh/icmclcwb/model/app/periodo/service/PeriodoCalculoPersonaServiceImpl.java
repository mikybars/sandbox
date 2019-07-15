package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoCalculoPersonaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Service
@Validated
public class PeriodoCalculoPersonaServiceImpl implements PeriodoCalculoPersonaService {

    @Autowired
    private PeriodoCalculoPersonaRepositoryCustom periodoCalculoPersonaRepositoryCustom;

    @Override
    public void mergePeriodoCalculoPersona(@NotNull RunTareaDto tareaDto) {
        periodoCalculoPersonaRepositoryCustom.mergePeriodoCalculoPersona(tareaDto);
    }

}
