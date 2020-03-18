package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
    public void estructurasComByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .estructurasComByRunTareaAndTareaAmbito(runTarea, item));
    }
    
    @Override
    public void estructurasPolByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .estructurasPolByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void tiendasComisionableByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .tiendasComisionableByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void configuracionVentaOnlineByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .configuracionVentaOnlineByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void agrupacionesCadenaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .agrupacionesCadenaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void localizacionesOnlineByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .localizacionesOnlineByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void empleadosDesplazamientoByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .empleadosDesplazamientoByRunTareaAndTareaAmbito(runTarea, item));
    }
    
    @Override
    public void ausenciasByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .ausenciasByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void configuraciones(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .configuracionByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void confChallengeDiasMinimosByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .confChallengeDiasMinimosByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void presupuestosWlocByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .presupuestosWlocByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void confPrecioHoraByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .confPrecioHoraByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void confChallengeTipoVentaByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .confChallengeTipoVentaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void presupuestosRangoByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .presupuestosRangoByRunTareaAndTareaAmbito(runTarea, item));
    }
    
    @Override
    public void ventaCongeladaByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
                .ventaCongeladaByRunTareaAndTareaAmbito(runTarea, item));
    }

}
