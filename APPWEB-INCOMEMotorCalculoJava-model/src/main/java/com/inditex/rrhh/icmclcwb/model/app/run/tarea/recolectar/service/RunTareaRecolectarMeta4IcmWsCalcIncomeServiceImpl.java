package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionCadenaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionConfiguracionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionOnlineHistoricoAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class RunTareaRecolectarMeta4IcmWsCalcIncomeServiceImpl
        implements RunTareaRecolectarMeta4IcmWsCalcIncomeService {

    @Autowired
    private TareaAgrupacionConfiguracionAsyncService tareaAgrupacionConfiguracionAsyncService;

    @Autowired
    private TareaAgrupacionCadenaAsyncService tareaAgrupacionCadenaAsyncService;

    @Autowired
    private TareaLocalizacionOnlineHistoricoAsyncService tareaTiendaOnlineHistoricoAsyncService;

    @Autowired
    private RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;

    @Override
    public void personaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .personaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void localizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .localizacionByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void empleadosPresenciaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .empleadosPresenciaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void festivosByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .festivosByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void coefJornadaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .coefJornadaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void flagCalculaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .flagCalculaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void presenciaManualByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .presenciaManualByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void condicionPersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .condicionPersonaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void tiendasComisionableByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .tiendasComisionableByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void configuracionVentaOnlineByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .configuracionVentaOnlineByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void agrupacionesCadenaByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .agrupacionesCadenaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void localizacionesOnlineByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .localizacionesOnlineByRunTareaAndTareaAmbito(runTarea, item));
    }

}
