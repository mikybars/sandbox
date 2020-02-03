package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.concurrent.CompletableFuture;

public interface RunTareaAmbitoRecolectarPtrVentaEmpleadoService {

    void ventaFisicaLocalizacionPersonaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito);

    //TODO [javierev] Eliminar esta prueba!
    CompletableFuture<Void> ventaFisicaLocalizacionPersonaByRunTareaAndTareaAmbito(@NotNull @Positive Integer idPais, @NotNull @Positive Integer idEmpresa);

}
