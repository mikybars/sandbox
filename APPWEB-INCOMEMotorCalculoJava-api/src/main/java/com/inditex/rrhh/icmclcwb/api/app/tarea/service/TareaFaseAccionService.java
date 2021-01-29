/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

}
