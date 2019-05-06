package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoCalculoPersona;

public interface PeriodoCalculoPersonaRepositoryCustom {

    List<PeriodoCalculoPersona> save(List<PeriodoCalculoPersona> src);

    void mergePeriodoCalculoPersona(@NotNull RunTareaDto tareaDto);

}
