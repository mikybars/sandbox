/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;

/**
 * @author mdelrio
 *
 */
public interface RunTareaPrevalidarDespuesService {

    /**
     * @param runTareaDto
     * @param faseDto
     */
    List<ValidacionDto> run(@NotNull @Valid RunTareaDto runTareaDto, @NotNull @Valid FaseDto faseDto);

}
