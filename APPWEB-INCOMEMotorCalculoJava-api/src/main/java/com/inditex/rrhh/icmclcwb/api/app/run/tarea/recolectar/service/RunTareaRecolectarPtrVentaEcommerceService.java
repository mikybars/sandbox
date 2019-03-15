package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;

public interface RunTareaRecolectarPtrVentaEcommerceService {

    void ventaOnlinePicking(@Valid RunTareaDto runTarea, @Valid RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void ventaOnlineiPod(@Valid RunTareaDto runTarea, @Valid RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void ventaOnlineIpodIndividualDetalle(@Valid RunTareaDto runTarea,
            @Valid RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void ventaOnlineEntregaTienda(@Valid RunTareaDto runTarea,
            @Valid RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void ventaOnlineEntregaDomicilio(@Valid RunTareaDto runTarea,
            @Valid RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void ventaOnlineIpodLocalizacionSeccionByRunTarea(@Valid RunTareaDto runTarea);

    void ventaOnlinePickingLocalizacionSeccionByRunTarea(@Valid RunTareaDto runTarea);

    void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@Valid RunTareaDto runTarea);

    void ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(@Valid RunTareaDto runTarea);

}
