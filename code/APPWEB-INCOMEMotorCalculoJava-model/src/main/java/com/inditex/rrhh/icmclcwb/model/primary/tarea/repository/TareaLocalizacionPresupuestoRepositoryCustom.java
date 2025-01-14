package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuesto;

import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionPresupuestoRepositoryCustom {

  List<TareaLocalizacionPresupuesto> save(final List<TareaLocalizacionPresupuesto> src);

  List<TareaLocalizacionPresupuestoDto> findPresupuestos(TareaDto tarea);

  PeriodoDto findPeriodoPresupuestoYTrabajo(Long idTarea);

  void updateActivoBandaExcepcion(TareaDto tarea);

  void updateActivoBandasSinExcepcion(TareaDto tarea);

  List<String> findLocalizacionOrdinalTarea(@NonNull Long idTarea, @NonNull Integer cclIdCodOrigen,
      @NonNull Integer cclIdSeccion, @NonNull LocalDate fechaInicio, @NonNull LocalDate fechaFin,
      @NonNull Integer idTipoPresupuesto);

}
