/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.async.ajuste.condiciones;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones.RunAjusteVacacionesProcesar;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjusteAsync;

/**
 * @author javierev
 */
@Component("vacacionesV1")
public class RunAjusteAsyncVacacionesProcesar implements RunAjusteAsync {

    @Autowired
    private RunAjusteVacacionesProcesar runAjusteVacacionesProcesar;

    @Override
    public CompletableFuture<Void> execute(
            final RunTareaDto runTarea,
            final AlgoritmoAjusteDto algoritmoAjuste) {
        this.runAjusteVacacionesProcesar.execute(runTarea, algoritmoAjuste);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
