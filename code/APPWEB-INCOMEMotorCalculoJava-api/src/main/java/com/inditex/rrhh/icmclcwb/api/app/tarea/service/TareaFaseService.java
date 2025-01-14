package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaFaseService {

  /**
   * Some javadoc.
   *
   * @param tareaFase Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseDto> save(@Valid @NonNull @NotEmpty List<TareaFaseDto> tareaFase);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseDto> create(@Valid @NonNull RunTareaDto runTareaDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   */
  void updateFechaInicio(@Valid @NonNull TareaFaseDto tareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @param idFase Some javadoc.
   * @return Some javadoc.
   */
  TareaFaseDto findTareaFaseDtoByIdTareaAndIdFase(@NonNull Long idTarea, @NonNull Integer idFase);

  /**
   * Some javadoc.
   *
   * @param tareaDto Some javadoc.
   * @param estadoTareaFaseActualDto Some javadoc.
   * @param estadoTareaFaseDto Some javadoc.
   */
  void updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(@Valid @NonNull TareaDto tareaDto,
      @Valid @NonNull EstadoTareaFaseDto estadoTareaFaseActualDto,
      @Valid @NonNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseDto> findTareaFaseDtoByIdTarea(@NonNull Long idTarea);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   * @param estadoTareaFaseDto Some javadoc.
   */
  void updateFechaFinAndEstado(@Valid @NonNull TareaFaseDto tareaFaseDto,
      @Valid @NonNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   * @param estadoTareaFaseDto Some javadoc.
   */
  void updateFechaInicioAndFechaFinAndEstado(@Valid @NonNull TareaFaseDto tareaFaseDto,
      @Valid @NonNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   */
  void updateActivo(@Valid @NonNull RunTareaDto runTareaDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   */
  void updateActivoByIdTareaFase(@Valid @NonNull TareaFaseDto tareaFaseDto);

}
