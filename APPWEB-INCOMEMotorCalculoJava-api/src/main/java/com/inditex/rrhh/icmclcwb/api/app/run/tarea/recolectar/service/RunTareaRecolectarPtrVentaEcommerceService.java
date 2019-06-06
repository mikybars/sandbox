package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarPtrVentaEcommerceService {

    void ventaOnlinePickingLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ventaOnlineIpodLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ventaOnlineIpodDetalleOperacionLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ventaOnlineIpodDetalleVendedorLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ventaOnlineIpodDetalleLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

}
