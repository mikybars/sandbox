package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface TareaFaseAccionService {

  /**
   * Some javadoc.
   *
   * @param tareaFaseAccion Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseAccionDto> save(@Valid @NotNull @NotEmpty List<TareaFaseAccionDto> tareaFaseAccion);

  /**
   * Some javadoc.
   *
   * @param tareaDto Some javadoc.
   */
  void create(@Valid @NotNull RunTareaDto tareaDto);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @param idFase Some javadoc.
   * @param idPuntoEjecucion Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(@NotNull Long idTarea,
      @NotNull Integer idFase, @NotNull Integer idPuntoEjecucion);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @param idFase Some javadoc.
   * @param idPuntoEjecucion Some javadoc.
   * @return Some javadoc.
   */
  List<Long> findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(@NotNull Long idTarea, @NotNull Integer idFase,
      @NotNull Integer idPuntoEjecucion);

  /**
   * Some javadoc.
   *
   * @param tareaFaseAccionDto Some javadoc.
   * @param estadoTareaFaseAccionDto Some javadoc.
   */
  void updateFechaFinAndEstado(@Valid @NotNull TareaFaseAccionDto tareaFaseAccionDto,
      @Valid @NotNull EstadoTareaFaseAccionDto estadoTareaFaseAccionDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseAccionDto Some javadoc.
   */
  void updateFechaInicio(@Valid @NotNull TareaFaseAccionDto tareaFaseAccionDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   * @param estadoTareaFaseAccionActualDto Some javadoc.
   * @param estadoTareaFaseAccionDto Some javadoc.
   */
  void updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(
      @Valid @NotNull TareaFaseDto tareaFaseDto,
      @Valid @NotNull EstadoTareaFaseAccionDto estadoTareaFaseAccionActualDto,
      @Valid @NotNull EstadoTareaFaseAccionDto estadoTareaFaseAccionDto);

  /**
   * Some javadoc.
   *
   * @param idTareaFaseAccion Some javadoc.
   * @return Some javadoc.
   */
  TareaFaseAccionDto findById(@Valid @NotNull @Positive Long idTareaFaseAccion);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @param idFase Some javadoc.
   * @param idAccion Some javadoc.
   * @param idPuntoEjecucion Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(
      @NotNull Long idTarea, @NotNull Integer idFase, @NotNull Integer idAccion,
      @NotNull Integer idPuntoEjecucion);

  /**
   * Some javadoc.
   *
   * @param tareaFaseAccionDto Some javadoc.
   * @return Some javadoc.
   */
  Integer countReintentosByIdTareaAndIdAccionAndIdEstado(@NotNull TareaFaseAccionDto tareaFaseAccionDto,
      @NotNull TareaFaseDto tareaFaseDto);

}
