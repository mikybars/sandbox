package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarTiendaVentaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaValidarAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaVentaSeccion;

@Service
@Validated
public class RunTareaRecolectarValidarTiendaVentaSeccionServiceImpl
        implements RunTareaRecolectarValidarTiendaVentaSeccionService {

    @Autowired
    private TareaValidarAsyncService tareaValidarAsyncService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public RunTareaDto run(@NotNull @Valid RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            RunTareaValidarDto validation = new RunTareaValidarDto();

            CompletableFuture<Integer> cfData = tareaValidarAsyncService
                    .countTiendaVentaSeccion(runTarea.getTarea().getId());
            AsyncUtils.exceptionally(cfData, cf);
            AsyncUtils.waitAllOfIsOk(cf, cf);
            validation.setCount(AsyncUtils.get(cfData));
            validation.setType(TareaTiendaVentaSeccion.class.getSimpleName());
            runTarea.getRunTareaValidar().add(validation);
            return runTarea;
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

}
