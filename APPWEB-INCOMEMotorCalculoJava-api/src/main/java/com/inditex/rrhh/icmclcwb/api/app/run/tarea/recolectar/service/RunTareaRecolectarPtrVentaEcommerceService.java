package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarPtrVentaEcommerceService {

    void ventaOnlinePickingLocalizacionSeccionByRunTarea(@Valid RunTareaDto runTarea);

    void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@Valid RunTareaDto runTarea);

    void ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(@Valid RunTareaDto runTarea);

    void ventaOnlineIpodLocalizacionByRunTarea(@Valid RunTareaDto runTarea);

    void ventaOnlinePickingLocalizacionByRunTarea(@Valid RunTareaDto runTarea);

    void ventaOnlineEntregaTiendaLocalizacionByRunTarea(@Valid RunTareaDto runTarea);

    void ventaOnlineEntregaDomicilioLocalizacionByRunTarea(@Valid RunTareaDto runTarea);

    void ventaOnlineIpodDetalleLocalizacionByRunTarea(@Valid RunTareaDto runTarea);

    void ventaOnlineIpodLocalizacionSeccionByRunTarea(@Valid RunTareaDto runTarea);

    void ventaOnlineIpodDetalleOperacionLocalizacionByRunTarea(@Valid RunTareaDto runTarea);

    void ventaOnlineIpodDetalleVendedorLocalizacionByRunTarea(@Valid RunTareaDto runTarea);

}
