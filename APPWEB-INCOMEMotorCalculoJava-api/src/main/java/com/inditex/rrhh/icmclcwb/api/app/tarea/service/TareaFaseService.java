/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;

/**
 * @author mdelrio
 *
 */
public interface TareaFaseService {

    /**
     * @param tareaFase
     * @return
     */
    List<TareaFaseDto> save(@Valid @NotNull @NotEmpty List<TareaFaseDto> tareaFase);

    /**
     * @return
     */
    List<TareaFaseDto> findAll();

    /**
     * @param tareaDto
     * @param tareaFase
     * @return
     */
    List<TareaFaseDto> create(@Valid @NotNull TareaDto tareaDto);

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
    void updateFechaFinAndEstado(@Valid @NotNull TareaFaseDto tareaFaseDto,
            @Valid @NotNull EstadoTareaFaseDto estadoTareaFaseDto);

    /**
     * @param idTarea
     * @return
     */
    List<TareaFaseDto> findTareaFaseDtoByIdTarea(@NotNull Long idTarea);

}
