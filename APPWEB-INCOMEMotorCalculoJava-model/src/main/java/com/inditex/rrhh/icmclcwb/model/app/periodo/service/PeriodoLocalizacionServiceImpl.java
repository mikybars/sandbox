package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoLocalizacionRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Service
@Validated
public class PeriodoLocalizacionServiceImpl implements PeriodoLocalizacionService {

    @Autowired
    private PeriodoLocalizacionRepositoryCustom periodoLocalizacionRepositoryCustom;

    @Override
    public void mergePeriodoLocalizacion(@NotNull RunTareaDto tareaDto) {
        periodoLocalizacionRepositoryCustom.mergePeriodoLocalizacion(tareaDto);
    }
}
