package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarMeta4IcmWsCalcIncomeService {

    void personaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void localizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void condicionPersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void tiendasComisionableByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void presenciaManualByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void empleadosPresenciaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void festivosByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void coefJornadaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void flagCalculaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void configuracionVentaOnlineByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void agrupacionesCadenaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void localizacionesOnlineByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void estructurasDesplazamientoByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void estructurasPoliticasByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

}
