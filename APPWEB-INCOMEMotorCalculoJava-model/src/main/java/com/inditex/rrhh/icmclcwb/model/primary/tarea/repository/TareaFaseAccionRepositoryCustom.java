/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccion;

/**
 * @author mdelrio
 *
 */
public interface TareaFaseAccionRepositoryCustom {

    /**
     * @param src
     * @return
     */
    List<TareaFaseAccion> save(List<TareaFaseAccion> src);


    /**
     * @param idTarea
     * @param idFase
     * @param idPuntoEjecucion
     * @param peso
     * @return
     */
    List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
            @NotNull @Positive Long idTarea, @NotNull Integer idFase, @NotNull Integer idPuntoEjecucion);

    /**
     * @param idTarea
     * @param idFase
     * @param idPuntoEjecucion
     * @return
     */
    List<Long> findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(@NotNull @Positive Long idTarea,
            @NotNull Integer idFase, @NotNull Integer idPuntoEjecucion);


    /**
     * @param tareaFaseAccionDto
     */
    void updateFechaInicio(@NotNull TareaFaseAccionDto tareaFaseAccionDto);


    /**
     * @param tareaFaseAccionDto
     * @param estadoTareaFaseAccionDto
     */
    void updateFechaFinAndEstado(@NotNull TareaFaseAccionDto tareaFaseAccionDto,
            @NotNull EstadoTareaFaseAccionDto estadoTareaFaseAccionDto);


    /**
     * @param tareaFaseAccionDto
     * @param estadoTareaFaseAccionDto
     */
    void updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(@NotNull TareaFaseDto tareaFaseDto,
            @NotNull EstadoTareaFaseAccionDto estadoTareaFaseAccionActualDto,
            @NotNull EstadoTareaFaseAccionDto estadoTareaFaseAccionDto);


    /**
     * @param idTarea
     * @param idFase
     * @param idAccion
     * @param idPuntoEjecucion
     * @param peso
     * @return
     */
    List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(
            @NotNull @Positive Long idTarea, @NotNull Integer idFase, @NotNull Integer idAccion,
            @NotNull Integer idPuntoEjecucion);


    /**
     * @param tareaFaseAccionDto
     * @return
     */
    Integer countReintentosByIdTareaAndIdAccionAndIdEstado(@NotNull TareaFaseAccionDto tareaFaseAccionDto,
            @NotNull TareaFaseDto tareaFaseDto);


    /**
     * @param idTareaFaseAccion
     * @return
     */
    TareaFaseAccionDto findById(@NotNull @Positive Long idTareaFaseAccion);

}
