package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarPtrVentaGeneralService {

    void ventaFisicaLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ventaFisicaCadenaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ventaRangoFisicaLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@NotNull @Valid RunTareaDto runTarea);

    void devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(
            @NotNull @Valid RunTareaDto runTarea);

    void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(@NotNull @Valid RunTareaDto runTarea);

}
