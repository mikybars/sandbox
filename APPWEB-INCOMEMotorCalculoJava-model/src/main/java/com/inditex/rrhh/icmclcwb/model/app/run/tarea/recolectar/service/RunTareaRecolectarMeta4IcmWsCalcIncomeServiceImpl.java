package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomeService;

@Service
@Validated
public class RunTareaRecolectarMeta4IcmWsCalcIncomeServiceImpl
        implements RunTareaRecolectarMeta4IcmWsCalcIncomeService {


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
    public void localizacionHistoricoByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .localizacionHistoricoByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void tiendasComisionableByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .tiendasComisionableByRunTareaAndTareaAmbito(runTarea, item));
    }

}
