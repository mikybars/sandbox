/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.calcular;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

public interface RunPrevalidar {

    /**
     * @param runTarea
     */
    @Async("validacionExecutor")
    CompletableFuture<List<ValidacionDto>> execute(@NotNull @Valid RunTareaDto runTarea,
            @NotNull @Valid TareaFaseAccionDto tareaFaseAccion);

}
