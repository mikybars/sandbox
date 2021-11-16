package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TareaFaseService {

  /**
   * Some javadoc.
   *
   * @param tareaFase Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseDto> save(@Valid @NotNull @NotEmpty List<TareaFaseDto> tareaFase);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseDto> create(@Valid @NotNull RunTareaDto runTareaDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   */
  void updateFechaInicio(@Valid @NotNull TareaFaseDto tareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @param idFase Some javadoc.
   * @return Some javadoc.
   */
  TareaFaseDto findTareaFaseDtoByIdTareaAndIdFase(@NotNull Long idTarea, @NotNull Integer idFase);

  /**
   * Some javadoc.
   *
   * @param tareaDto Some javadoc.
   * @param estadoTareaFaseActualDto Some javadoc.
   * @param estadoTareaFaseDto Some javadoc.
   */
  void updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(@Valid @NotNull TareaDto tareaDto,
      @Valid @NotNull EstadoTareaFaseDto estadoTareaFaseActualDto,
      @Valid @NotNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param idTarea Some javadoc.
   * @return Some javadoc.
   */
  List<TareaFaseDto> findTareaFaseDtoByIdTarea(@NotNull Long idTarea);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   * @param estadoTareaFaseDto Some javadoc.
   */
  void updateFechaFinAndEstado(@Valid @NotNull TareaFaseDto tareaFaseDto,
      @Valid @NotNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   * @param estadoTareaFaseDto Some javadoc.
   */
  void updateFechaInicioAndFechaFinAndEstado(@Valid @NotNull TareaFaseDto tareaFaseDto,
      @Valid @NotNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   */
  void updateActivo(@Valid @NotNull RunTareaDto runTareaDto);

  /**
   * Some javadoc.
   *
   * @param tareaFaseDto Some javadoc.
   */
  void updateActivoByIdTareaFase(@Valid @NotNull TareaFaseDto tareaFaseDto);

}
