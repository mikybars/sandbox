package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoPersonaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Service
@Validated
public class PeriodoPersonaServiceImpl implements PeriodoPersonaService {

    @Autowired
    private PeriodoPersonaRepositoryCustom periodoPersonaRepositoryCustom;

    @Override
    public void mergePeriodoPersona(@NotNull RunTareaDto tareaDto) {
        periodoPersonaRepositoryCustom.mergePeriodoPersona(tareaDto);
    }
}
