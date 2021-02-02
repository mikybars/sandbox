/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;

/**
 * @author mdelrio
 *
 */
public interface AccionService {

    /**
     * @param id
     * @return
     */
    AccionDto findAccionDtoById(@NotNull Integer id);

}
