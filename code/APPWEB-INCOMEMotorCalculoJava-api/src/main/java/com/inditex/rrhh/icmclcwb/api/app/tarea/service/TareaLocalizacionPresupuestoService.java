package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

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

  List<String> findLocalizacionOrdinalTarea(@NotNull Long idTarea, @NotNull Integer cclIdCodOrigen,
      @NotNull Integer cclIdSeccion, @NotNull LocalDate fechaInicio, @NotNull LocalDate fechaFin,
      @NotNull Integer idTipoPresupuesto);

}
