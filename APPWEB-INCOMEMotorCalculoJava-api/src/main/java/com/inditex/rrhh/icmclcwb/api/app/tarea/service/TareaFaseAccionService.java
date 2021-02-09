/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

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
    void create(@Valid @NotNull TareaDto tareaDto);

    /**
     * @param idTarea
     * @param idFase
     * @param idPuntoEjecucion
     * @return
     */
    List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucionAndPeso(@NotNull Long idTarea,
            @NotNull Integer idFase, @NotNull Integer idPuntoEjecucion,
            @NotNull Long peso);

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
    void updateFechaFinAndEstadoAndActivo(@Valid @NotNull TareaFaseAccionDto tareaFaseAccionDto,
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
    List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucionAndPeso(
            @NotNull Long idTarea, @NotNull Integer idFase, @NotNull Integer idAccion,
            @NotNull Integer idPuntoEjecucion, @NotNull Long peso);

}
