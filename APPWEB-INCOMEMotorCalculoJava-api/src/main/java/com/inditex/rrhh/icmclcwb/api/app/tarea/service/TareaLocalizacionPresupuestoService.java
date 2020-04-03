package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPageDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface TareaLocalizacionPresupuestoService {

    void save(@Valid final List<PresupuestosWlocResultItemDto> src, @Valid final TareaDto tarea);

    TareaLocalizacionPresupuestoListDto findPresupuestos(@Valid final TareaDto tarea);

    PeriodoDto findPeriodoPresupuestoYTrabajo(@NotNull final Long idTarea);

    List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(@NotNull Long idTarea, @NotNull PtrPageDto page,
            RecolectarPropertiesDto recolectarProperties);

    List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(@NotNull Long idTarea, @NotNull PtrPageDto page);

}
