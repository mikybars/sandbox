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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaValidarAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;

@Service
@Validated
public class RunTareaRecolectarValidarAmbitoServiceImpl implements RunTareaRecolectarValidarAmbitoService {

    @Autowired
    private TareaValidarAsyncService tareaValidarAsyncService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public List<RunTareaValidarDto> run(@NotNull @Valid final RunTareaDto runTarea) {
        List<RunTareaValidarDto> result = new ArrayList<>();
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            CompletableFuture<List<String>> cfValidAmbito = tareaValidarAsyncService
                    .validateAmbito(runTarea.getTarea().getId());
            AsyncUtils.exceptionally(cfValidAmbito, cf);
            AsyncUtils.waitAllOfIsOk(cf, cf);
            result.add(RunTareaValidarDto.builder().type(Tarea.class.getSimpleName()).build());
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
        return result;
    }

}
