/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

}
