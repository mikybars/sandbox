package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccion;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

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
      @NonNull @Positive Long idTarea, @NonNull Integer idFase, @NonNull Integer idPuntoEjecucion);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @param idFase Some javadoc.
   * @param idPuntoEjecucion Some javadoc.
   * @return Some javadoc.
   */
  List<Long> findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(@NonNull @Positive Long idTarea,
      @NonNull Integer idFase, @NonNull Integer idPuntoEjecucion);

  /**
   * Some javadoc.
   *
   * @param tareaFaseAccionDto Some javadoc.
   */
  void updateFechaInicio(@NonNull TareaFaseAccionDto tareaFaseAccionDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseAccionDto Some javadoc.
   * @param estadoTareaFaseAccionDto Some javadoc.
   */
  void updateFechaFinAndEstado(@NonNull TareaFaseAccionDto tareaFaseAccionDto,
      @NonNull EstadoTareaFaseAccionDto estadoTareaFaseAccionDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   * @param estadoTareaFaseAccionActualDto Some javadoc.
   * @param estadoTareaFaseAccionDto Some javadoc.
   */
  void updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(@NonNull TareaFaseDto tareaFaseDto,
      @NonNull EstadoTareaFaseAccionDto estadoTareaFaseAccionActualDto,
      @NonNull EstadoTareaFaseAccionDto estadoTareaFaseAccionDto);

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
      @NonNull @Positive Long idTarea, @NonNull Integer idFase, @NonNull Integer idAccion,
      @NonNull Integer idPuntoEjecucion);

  /**
   * Some javadoc.
   *
   * @param tareaFaseAccionDto Some javadoc.
   * @param tareaFaseDto Some javadoc.
   * @return Some javadoc.
   */
  Integer countReintentosByIdTareaAndIdAccionAndIdEstado(@NonNull TareaFaseAccionDto tareaFaseAccionDto,
      @NonNull TareaFaseDto tareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param idTareaFaseAccion Some javadoc.
   * @return Some javadoc.
   */
  TareaFaseAccionDto findById(@NonNull @Positive Long idTareaFaseAccion);

}
