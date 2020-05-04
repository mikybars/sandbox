package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;

public interface TareaLocalizacionPresupuestoService {

    void save(@Valid @NotNull @NotEmpty final List<PresupuestosWlocResultItemDto> src,
            @Valid @NotNull final TareaDto tarea);

    TareaLocalizacionPresupuestoListDto findPresupuestos(@Valid @NotNull final TareaDto tarea);

    PeriodoDto findPeriodoPresupuestoYTrabajo(@NotNull final Long idTarea);

    List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(@NotNull Long idTarea,
            @NotNull PtrFilterPropertiesDto filterProperties,
            RecolectarPropertiesDto recolectarProperties);

    List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(@NotNull Long idTarea,
            @NotNull PtrFilterPropertiesDto filterProperties);

}
