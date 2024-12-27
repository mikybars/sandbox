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
import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionPresupuestoService {

  void save(@Valid @NonNull @NotEmpty final List<PresupuestosWlocResultItemDto> src,
      @Valid @NonNull final TareaDto tarea);

  TareaLocalizacionPresupuestoListDto findPresupuestos(@Valid @NonNull final TareaDto tarea);

  PeriodoDto findPeriodoPresupuestoYTrabajo(@NonNull final Long idTarea);

  List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(@NonNull Long idTarea,
      @NonNull PtrFilterPropertiesDto filterProperties,
      RecolectarPropertiesDto recolectarProperties);

  List<PeriodoDto> findListaPeriodosPresupestoYTrabajo(@NonNull Long idTarea,
      @NonNull PtrFilterPropertiesDto filterProperties);

  List<String> findLocalizacionOrdinalTarea(@NonNull Long idTarea, @NonNull Integer cclIdCodOrigen,
      @NonNull Integer cclIdSeccion, @NonNull LocalDate fechaInicio, @NonNull LocalDate fechaFin,
      @NonNull Integer idTipoPresupuesto);

}
