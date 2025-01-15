package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFase;

import jakarta.validation.constraints.Positive;

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
  TareaFaseDto findTareaFaseDtoByIdTareaAndIdFase(@NotNull @Positive Long idTarea,
      @NotNull @Positive Integer idFase);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   */
  void updateFechaInicio(@NotNull TareaFaseDto tareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseDto> findTareaFaseDtoByIdTarea(@NotNull @Positive Long idTarea);

  /**
   * Some javadoc.
   *
   * @param tareaDto Some javadoc.
   * @param estadoTareaFaseActualDto Some javadoc.
   * @param estadoTareaFaseDto Some javadoc.
   */
  void updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(@NotNull TareaDto tareaDto,
      @NotNull EstadoTareaFaseDto estadoTareaFaseActualDto, @NotNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   * @param estadoTareaFaseDto Some javadoc.
   */
  void updateFechaFinAndEstado(@NotNull TareaFaseDto tareaFaseDto, @NotNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   * @param estadoTareaFaseDto Some javadoc.
   */
  void updateFechaInicioAndFechaFinAndEstado(@NotNull TareaFaseDto tareaFaseDto,
      @NotNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param tareaDto Some javadoc.
   */
  void updateActivoByIdTarea(@NotNull TareaDto tareaDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   */
  void updateActivoByIdTareaFase(@NotNull TareaFaseDto tareaFaseDto);

}
