package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;

public interface TareaLimpiezaRepositoryCustom {

    void save(@NotNull @Valid TareaLimpiezaDto limpiezaDto);

    void updateFechaEjecucion(@NotNull @Positive Long idTareaLimpieza);

    void updateEstado(@NotNull @Positive Long idTareaLimpieza, @NotNull @Valid EstadoTareaLimpiezaDto estado);

}
