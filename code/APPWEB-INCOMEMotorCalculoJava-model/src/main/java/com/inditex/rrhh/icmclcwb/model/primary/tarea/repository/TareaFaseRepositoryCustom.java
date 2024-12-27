package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFase;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface TareaFaseRepositoryCustom {

  /**
   * Some javadoc.
   *
   * @param src Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFase> save(List<TareaFase> src);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @param idFase Some javadoc.
   * @return Some javadoc.
   */
  TareaFaseDto findTareaFaseDtoByIdTareaAndIdFase(@NonNull @Positive Long idTarea,
      @NonNull @Positive Integer idFase);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   */
  void updateFechaInicio(@NonNull TareaFaseDto tareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseDto> findTareaFaseDtoByIdTarea(@NonNull @Positive Long idTarea);

  /**
   * Some javadoc.
   *
   * @param tareaDto Some javadoc.
   * @param estadoTareaFaseActualDto Some javadoc.
   * @param estadoTareaFaseDto Some javadoc.
   */
  void updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(@NonNull TareaDto tareaDto,
      @NonNull EstadoTareaFaseDto estadoTareaFaseActualDto, @NonNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   * @param estadoTareaFaseDto Some javadoc.
   */
  void updateFechaFinAndEstado(@NonNull TareaFaseDto tareaFaseDto, @NonNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   * @param estadoTareaFaseDto Some javadoc.
   */
  void updateFechaInicioAndFechaFinAndEstado(@NonNull TareaFaseDto tareaFaseDto,
      @NonNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param tareaDto Some javadoc.
   */
  void updateActivoByIdTarea(@NonNull TareaDto tareaDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   */
  void updateActivoByIdTareaFase(@NonNull TareaFaseDto tareaFaseDto);

}
