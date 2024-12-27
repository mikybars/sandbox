package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface TareaFaseAccionService {

  /**
   * Some javadoc.
   *
   * @param tareaFaseAccion Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseAccionDto> save(@Valid @NonNull @NotEmpty List<TareaFaseAccionDto> tareaFaseAccion);

  /**
   * Some javadoc.
   *
   * @param tareaDto Some javadoc.
   */
  void create(@Valid @NonNull RunTareaDto tareaDto);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @param idFase Some javadoc.
   * @param idPuntoEjecucion Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(@NonNull Long idTarea,
      @NonNull Integer idFase, @NonNull Integer idPuntoEjecucion);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @param idFase Some javadoc.
   * @param idPuntoEjecucion Some javadoc.
   * @return Some javadoc.
   */
  List<Long> findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(@NonNull Long idTarea, @NonNull Integer idFase,
      @NonNull Integer idPuntoEjecucion);

  /**
   * Some javadoc.
   *
   * @param tareaFaseAccionDto Some javadoc.
   * @param estadoTareaFaseAccionDto Some javadoc.
   */
  void updateFechaFinAndEstado(@Valid @NonNull TareaFaseAccionDto tareaFaseAccionDto,
      @Valid @NonNull EstadoTareaFaseAccionDto estadoTareaFaseAccionDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseAccionDto Some javadoc.
   */
  void updateFechaInicio(@Valid @NonNull TareaFaseAccionDto tareaFaseAccionDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   * @param estadoTareaFaseAccionActualDto Some javadoc.
   * @param estadoTareaFaseAccionDto Some javadoc.
   */
  void updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(
      @Valid @NonNull TareaFaseDto tareaFaseDto,
      @Valid @NonNull EstadoTareaFaseAccionDto estadoTareaFaseAccionActualDto,
      @Valid @NonNull EstadoTareaFaseAccionDto estadoTareaFaseAccionDto);

  /**
   * Some javadoc.
   *
   * @param idTareaFaseAccion Some javadoc.
   * @return Some javadoc.
   */
  TareaFaseAccionDto findById(@Valid @NonNull @Positive Long idTareaFaseAccion);

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
      @NonNull Long idTarea, @NonNull Integer idFase, @NonNull Integer idAccion,
      @NonNull Integer idPuntoEjecucion);

  /**
   * Some javadoc.
   *
   * @param tareaFaseAccionDto Some javadoc.
   * @return Some javadoc.
   */
  Integer countReintentosByIdTareaAndIdAccionAndIdEstado(@NonNull TareaFaseAccionDto tareaFaseAccionDto,
      @NonNull TareaFaseDto tareaFaseDto);

}
