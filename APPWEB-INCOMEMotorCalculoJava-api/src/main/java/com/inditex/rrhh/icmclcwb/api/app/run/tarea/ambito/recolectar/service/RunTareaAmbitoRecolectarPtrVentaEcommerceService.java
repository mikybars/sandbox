package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

public interface RunTareaAmbitoRecolectarPtrVentaEcommerceService {

    void ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @Valid TareaAmbitoDto tareaAmbito);

    void ventaOnlineEntregaDomicilioLocalizacionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @Valid TareaAmbitoDto tareaAmbito);

    void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @Valid TareaAmbitoDto tareaAmbito);

    void ventaOnlineEntregaTiendaLocalizacionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @Valid TareaAmbitoDto tareaAmbito);

    void ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @Valid TareaAmbitoDto tareaAmbito);

    void ventaOnlinePickingLocalizacionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @Valid TareaAmbitoDto tareaAmbito);

    void ventaOnlineIpodLocalizacionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito);

    void ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito);

    void ventaOnlineIpodDetalleVendedorLocalizacionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito);

    void ventaOnlineIpodDetalleLocalizacionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito);

    void ventaOnlineIpodDetalleOperacionLocalizacionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito);

}
