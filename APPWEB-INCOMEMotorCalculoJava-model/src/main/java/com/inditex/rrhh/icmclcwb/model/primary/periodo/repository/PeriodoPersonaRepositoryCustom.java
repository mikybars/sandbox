package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoPersona;

public interface PeriodoPersonaRepositoryCustom {

    List<PeriodoPersona> save(List<PeriodoPersona> src);

    void mergePeriodoPersona(@NotNull RunTareaDto tareaDto);

}
