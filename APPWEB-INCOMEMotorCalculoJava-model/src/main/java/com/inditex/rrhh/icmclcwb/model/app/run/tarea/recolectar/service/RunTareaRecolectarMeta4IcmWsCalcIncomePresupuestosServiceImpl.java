package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomePresupuestosService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosServiceImpl
    implements RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService {

    @Autowired
    private RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomePresupuestosService runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;

    @Override
    public void personaByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .personaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void localizacionByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .localizacionByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void empleadosPresenciaByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .empleadosPresenciaByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void empleadosDesplazamientoByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .empleadosDesplazamientoByRunTareaAndTareaAmbito(runTarea, item));
    }
}
