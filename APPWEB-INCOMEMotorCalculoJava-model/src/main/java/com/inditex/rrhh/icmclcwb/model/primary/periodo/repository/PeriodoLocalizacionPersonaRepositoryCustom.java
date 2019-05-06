package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoLocalizacionPersona;

public interface PeriodoLocalizacionPersonaRepositoryCustom {

    List<PeriodoLocalizacionPersona> save(List<PeriodoLocalizacionPersona> src);

    void mergePeriodoLocalizacionPersona(@NotNull RunTareaDto tareaDto);

}
