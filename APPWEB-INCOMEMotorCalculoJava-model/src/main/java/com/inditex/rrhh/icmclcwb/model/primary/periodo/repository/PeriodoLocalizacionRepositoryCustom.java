package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoLocalizacion;

public interface PeriodoLocalizacionRepositoryCustom {

    List<PeriodoLocalizacion> save(List<PeriodoLocalizacion> src);

    void mergePeriodoLocalizacion(@NotNull RunTareaDto tareaDto);

}
