package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

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

}
