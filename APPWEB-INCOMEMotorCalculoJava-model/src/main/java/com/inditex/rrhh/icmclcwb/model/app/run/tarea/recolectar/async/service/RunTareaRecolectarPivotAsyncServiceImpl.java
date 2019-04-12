package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPivotAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaVentaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Deprecated
@Service
public class RunTareaRecolectarPivotAsyncServiceImpl implements RunTareaRecolectarPivotAsyncService {

    @Autowired
    private TareaTiendaPresenciaSeccionAsyncService tareaTiendaPresenciaSeccionAsyncService;

    @Autowired
    private TareaTiendaVentaSeccionAsyncService tareaTiendaVentaSeccionAsyncService;

    @Deprecated
    @Override
    public CompletableFuture<Void> pivot(final RunTareaDto runTarea) {
        TareaDto tarea = runTarea.getTarea();
        tareaTiendaPresenciaSeccionAsyncService.pivot(tarea);
        tareaTiendaVentaSeccionAsyncService.pivot(tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
