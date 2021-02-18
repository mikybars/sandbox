/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;

/**
 * @author mdelrio
 *
 */
public interface TareaFaseAccionService {

    /**
     * @param tareaFaseAccion
     * @return
     */
    List<TareaFaseAccionDto> save(@Valid @NotNull @NotEmpty List<TareaFaseAccionDto> tareaFaseAccion);

    /**
     * @param tareaFaseAccion
     * @return
     */
    List<TareaFaseAccionDto> saveAll(@Valid @NotNull @NotEmpty List<TareaFaseAccionDto> tareaFaseAccion);

    /**
     * @param tareaDto
     */
    void create(@Valid @NotNull RunTareaDto tareaDto);

    /**
     * @param idTarea
     * @param idFase
     * @param idPuntoEjecucion
     * @return
     */
    List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(@NotNull Long idTarea,
            @NotNull Integer idFase, @NotNull Integer idPuntoEjecucion);

    /**
     * @param idTarea
     * @param idFase
     * @param idPuntoEjecucion
     * @return
     */
    List<Long> findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(@NotNull Long idTarea, @NotNull Integer idFase,
            @NotNull Integer idPuntoEjecucion);

    /**
     * @param tareaFaseAccionDto
     * @param estadoTareaFaseDto
     */
    void updateFechaFinAndEstado(@Valid @NotNull TareaFaseAccionDto tareaFaseAccionDto,
            @Valid @NotNull EstadoTareaFaseAccionDto estadoTareaFaseAccionDto);

    /**
     * @param tareaFaseAccionDto
     */
    void updateFechaInicio(@Valid @NotNull TareaFaseAccionDto tareaFaseAccionDto);

    /**
     * @param tareaFaseAccionDto
     * @param estadoTareaFaseAccionDto
     */
    void updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaFaseAndEstadoActual(
            @Valid @NotNull TareaFaseDto tareaFaseDto,
            @Valid @NotNull EstadoTareaFaseAccionDto estadoTareaFaseAccionActualDto,
            @Valid @NotNull EstadoTareaFaseAccionDto estadoTareaFaseAccionDto);

    /**
     * @param idTareaFaseAccion
     * @return
     */
    TareaFaseAccionDto findById(@Valid @NotNull @Positive Long idTareaFaseAccion);

    /**
     * @param idTarea
     * @param idFase
     * @param idAccion
     * @param idPuntoEjecucion
     * @param peso
     * @return
     */
    List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(
            @NotNull Long idTarea, @NotNull Integer idFase, @NotNull Integer idAccion,
            @NotNull Integer idPuntoEjecucion);

    /**
     * @param tareaFaseAccionDto
     * @return
     */
    Integer countReintentosByIdTareaAndIdAccionAndIdEstado(@NotNull TareaFaseAccionDto tareaFaseAccionDto,
            @NotNull TareaFaseDto tareaFaseDto);

    /**
     * @param tareaFaseAccionDto
     * @param estadoTareaFaseAccionDto
     */
    void updateFechaInicioAndFechaFinAndEstado(@Valid @NotNull TareaFaseAccionDto tareaFaseAccionDto,
            @Valid @NotNull EstadoTareaFaseAccionDto estadoTareaFaseAccionDto);

}
