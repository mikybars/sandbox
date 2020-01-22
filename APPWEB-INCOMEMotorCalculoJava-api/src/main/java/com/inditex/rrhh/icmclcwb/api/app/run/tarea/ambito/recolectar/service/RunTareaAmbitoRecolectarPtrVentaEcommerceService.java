package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import java.util.concurrent.CompletableFuture;

public interface RunTareaAmbitoRecolectarPtrVentaEcommerceService {

    void ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @Valid TareaAmbitoDto tareaAmbito);

    void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @Valid TareaAmbitoDto tareaAmbito);

    void ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @Valid TareaAmbitoDto tareaAmbito);

    void ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito);

    void ventaOnlineIpodLocalizacionPersonaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito);

    //TODO [javierev] Eliminar esta prueba!
    CompletableFuture<Void> ventaOnlineIpodLocalizacionPersonaBusquedaPorVenta(@NotNull @Positive Integer idPais, @NotNull @Positive Integer idEmpresa);

}
