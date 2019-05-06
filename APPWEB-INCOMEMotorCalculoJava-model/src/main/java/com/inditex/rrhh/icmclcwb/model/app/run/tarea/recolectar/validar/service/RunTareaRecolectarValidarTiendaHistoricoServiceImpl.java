package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarTiendaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaValidarAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaHistorico;

@Service
@Validated
public class RunTareaRecolectarValidarTiendaHistoricoServiceImpl
        implements RunTareaRecolectarValidarTiendaHistoricoService {

    @Autowired
    private TareaValidarAsyncService tareaValidarAsyncService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            CompletableFuture<Integer> cfCountTiendaHistorico = tareaValidarAsyncService
                    .countTiendasHistorico(runTarea.getTarea().getId());
            AsyncUtils.exceptionally(cfCountTiendaHistorico, cf);
            CompletableFuture<List<String>> cfDuplicatedTiendaHistorico = tareaValidarAsyncService
                    .checkDuplicatedTiendasHistorico(runTarea.getTarea().getId());
            AsyncUtils.exceptionally(cfDuplicatedTiendaHistorico, cf);
            AsyncUtils.waitAllOfIsOk(cf, cf);
            runTarea.getRunTareaValidar()
                    .add(RunTareaValidarDto.builder().type(TareaTiendaHistorico.class.getSimpleName())
                            .count(AsyncUtils.get(cfCountTiendaHistorico))
                            .duplicated(
                                    AsyncUtils.get(cfDuplicatedTiendaHistorico).stream().collect(Collectors.toSet()))
                            .build());
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

}
