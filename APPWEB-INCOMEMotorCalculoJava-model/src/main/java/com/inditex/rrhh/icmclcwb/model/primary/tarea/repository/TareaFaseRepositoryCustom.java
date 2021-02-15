/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFase;

/**
 * @author mdelrio
 *
 */
public interface TareaFaseRepositoryCustom {

    /**
     * @param src
     * @return
     */
    List<TareaFase> save(List<TareaFase> src);

    /**
     * @param idTarea
     * @param idFase
     * @return
     */
    TareaFaseDto findTareaFaseDtoByIdTareaAndIdFase(@NotNull @Positive Long idTarea,
            @NotNull @Positive Integer idFase);

    /**
     * @param tareaFaseDto
     */
    void updateFechaInicio(@NotNull TareaFaseDto tareaFaseDto);

    /**
     * @param idTarea
     * @return
     */
    List<TareaFaseDto> findTareaFaseDtoByIdTarea(@NotNull @Positive Long idTarea);

    /**
     * @param tareaDto
     * @param estadoTareaFaseActualDto
     * @param estadoTareaFaseDto
     */
    void updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(@NotNull TareaDto tareaDto,
            @NotNull EstadoTareaFaseDto estadoTareaFaseActualDto, @NotNull EstadoTareaFaseDto estadoTareaFaseDto);

    /**
     * @param tareaFaseDto
     * @param estadoTareaFaseDto
     */
    void updateFechaFinAndEstado(@NotNull TareaFaseDto tareaFaseDto, @NotNull EstadoTareaFaseDto estadoTareaFaseDto);

    /**
     * @param tareaFaseDto
     * @param estadoTareaFaseDto
     */
    void updateFechaInicioAndFechaFinAndEstado(@NotNull TareaFaseDto tareaFaseDto,
            @NotNull EstadoTareaFaseDto estadoTareaFaseDto);

    /**
     * @param tareaDto
     */
    void updateActivoByIdTarea(@NotNull TareaDto tareaDto);

    /**
     * @param tareaFaseDto
     */
    void updateActivoByIdTareaFase(@NotNull TareaFaseDto tareaFaseDto);

}
