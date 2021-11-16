
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
   * @param tareaFase
   * @return
   */
  List<TareaFaseDto> save(@Valid @NotNull @NotEmpty List<TareaFaseDto> tareaFase);

  /**
   * @param tareaDto
   * @param tareaFase
   * @return
   */
  List<TareaFaseDto> create(@Valid @NotNull RunTareaDto runTareaDto);

  /**
   * @param tarea
   * @param estado
   */
  void updateFechaInicio(@Valid @NotNull TareaFaseDto tareaFaseDto);

  /**
   * @param idTarea
   * @param idFase
   * @return
   */
  TareaFaseDto findTareaFaseDtoByIdTareaAndIdFase(@NotNull Long idTarea, @NotNull Integer idFase);

  /**
   * @param tareaFaseDto
   * @param estadoTareaFaseDto
   */
  void updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(@Valid @NotNull TareaDto tareaDto,
      @Valid @NotNull EstadoTareaFaseDto estadoTareaFaseActualDto,
      @Valid @NotNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * @param idTarea
   * @return
   */
  List<TareaFaseDto> findTareaFaseDtoByIdTarea(@NotNull Long idTarea);

  /**
   * @param tareaFaseDto
   * @param estadoTareaFaseDto
   */
  void updateFechaFinAndEstado(@Valid @NotNull TareaFaseDto tareaFaseDto,
      @Valid @NotNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * @param tareaFaseDto
   * @param estadoTareaFaseDto
   */
  void updateFechaInicioAndFechaFinAndEstado(@Valid @NotNull TareaFaseDto tareaFaseDto,
      @Valid @NotNull EstadoTareaFaseDto estadoTareaFaseDto);

  /**
   * @param runTareaDto
   */
  void updateActivo(@Valid @NotNull RunTareaDto runTareaDto);

  /**
   * @param tareaFaseDto
   */
  void updateActivoByIdTareaFase(@Valid @NotNull TareaFaseDto tareaFaseDto);

}
