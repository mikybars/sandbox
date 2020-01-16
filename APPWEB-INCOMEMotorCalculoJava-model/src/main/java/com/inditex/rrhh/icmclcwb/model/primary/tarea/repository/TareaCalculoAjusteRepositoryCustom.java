package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaCalculoAjusteRepositoryCustom {

    void antiguedad(@NotNull TareaDto tarea);

    void bajaIt(@NotNull TareaDto tarea);

    void vacaciones(@NotNull TareaDto tarea);

    void maxGarantizado(@NotNull TareaDto tarea);

    void minGarantizado(@NotNull TareaDto tarea);

    void carencia(@NotNull TareaDto tarea);

}
