package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccion;

import jakarta.validation.constraints.Positive;

public interface TareaFaseAccionRepositoryCustom {

  /**
   * Some javadoc.
   *
   * @param src Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseAccion> save(List<TareaFaseAccion> src);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @param idFase Some javadoc.
   * @param idPuntoEjecucion Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
      @NotNull @Positive Long idTarea, @NotNull Integer idFase, @NotNull Integer idPuntoEjecucion);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @param idFase Some javadoc.
   * @param idPuntoEjecucion Some javadoc.
   * @return Some javadoc.
   */
  List<Long> findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(@NotNull @Positive Long idTarea,
      @NotNull Integer idFase, @NotNull Integer idPuntoEjecucion);

  /**
   * Some javadoc.
   *
   * @param tareaFaseAccionDto Some javadoc.
   */
  void updateFechaInicio(@NotNull TareaFaseAccionDto tareaFaseAccionDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseAccionDto Some javadoc.
   * @param estadoTareaFaseAccionDto Some javadoc.
   */
  void updateFechaFinAndEstado(@NotNull TareaFaseAccionDto tareaFaseAccionDto,
      @NotNull EstadoTareaFaseAccionDto estadoTareaFaseAccionDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   * @param estadoTareaFaseAccionActualDto Some javadoc.
   * @param estadoTareaFaseAccionDto Some javadoc.
   */
  void updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(@NotNull TareaFaseDto tareaFaseDto,
      @NotNull EstadoTareaFaseAccionDto estadoTareaFaseAccionActualDto,
      @NotNull EstadoTareaFaseAccionDto estadoTareaFaseAccionDto);

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
      @NotNull @Positive Long idTarea, @NotNull Integer idFase, @NotNull Integer idAccion,
      @NotNull Integer idPuntoEjecucion);

  /**
   * Some javadoc.
   *
   * @param tareaFaseAccionDto Some javadoc.
   * @param tareaFaseDto Some javadoc.
   * @return Some javadoc.
   */
  Integer countReintentosByIdTareaAndIdAccionAndIdEstado(@NotNull TareaFaseAccionDto tareaFaseAccionDto,
      @NotNull TareaFaseDto tareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param idTareaFaseAccion Some javadoc.
   * @return Some javadoc.
   */
  TareaFaseAccionDto findById(@NotNull @Positive Long idTareaFaseAccion);

}
