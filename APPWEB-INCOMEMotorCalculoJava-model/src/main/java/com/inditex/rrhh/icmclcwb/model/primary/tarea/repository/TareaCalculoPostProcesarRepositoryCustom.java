package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersona;

public interface TareaCalculoPostProcesarRepositoryCustom {

    void antiguedad(@NotNull TareaDto tarea);

    void bajaIt(@NotNull TareaDto tarea);

    void vacaciones(@NotNull TareaDto tarea);

    void maxGarantizado(@NotNull TareaDto tarea);

    void minGarantizado(@NotNull TareaDto tarea);

    void carencia(@NotNull TareaDto tarea);

}
