/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.calcular;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunPrevalidar {

    /**
     * @param runTarea
     */
    void execute(@NotNull @Valid RunTareaDto runTarea);

}
