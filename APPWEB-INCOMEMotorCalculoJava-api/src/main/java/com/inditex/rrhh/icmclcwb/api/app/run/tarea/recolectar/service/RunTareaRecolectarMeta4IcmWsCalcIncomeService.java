package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarMeta4IcmWsCalcIncomeService {

    void personaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void localizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void tiendasComisionableByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void presenciaManualByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void empleadosPresenciaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void festivosByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void coefJornadaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void flagCalculaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void configuracionVentaOnlineByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void agrupacionesCadenaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void localizacionesOnlineByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void empleadosDesplazamientoByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void estructurasPolByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void estructurasComByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ausenciasByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void configuraciones(@NotNull @Valid final RunTareaDto runTarea);

    void confChallengeDiasMinimosByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void presupuestosWlocByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void confPrecioHoraByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void confChallengeTipoVentaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void presupuestosRangoByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ventaCongeladaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void fechaAmbitoAndEmpresaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void desplazamientoRealByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void presenciaManualLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ventaManualLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

}
