/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;

/**
 * @author mdelrio
 *
 */
public interface RunTareaPrevalidarDuranteService {

    /**
     * @param runTareaDto
     * @param faseDto
     */
    void run(@NotNull @Valid RunTareaDto runTareaDto,
            @NotNull @Valid FaseDto faseDto,
            @NotNull @Valid AccionDto accionDto);

}
