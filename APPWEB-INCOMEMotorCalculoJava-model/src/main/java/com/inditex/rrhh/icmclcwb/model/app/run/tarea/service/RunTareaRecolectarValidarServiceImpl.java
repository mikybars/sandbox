package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarAmbitoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarEstructurasAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarTiposHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarValidarService;
import com.inditex.rrhh.icmclcwb.api.app.validar.properties.dto.ValidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaRecolectarValidarServiceImpl implements RunTareaRecolectarValidarService {

    @Autowired
    private RunTareaRecolectarValidarEstructurasAsyncService runTareaRecolectarValidarEstructurasAsyncService;

    @Autowired
    private RunTareaRecolectarValidarLocalizacionHistoricoAsyncService runTareaRecolectarValidarLocalizacionHistoricoAsyncService;

    @Autowired
    private RunTareaRecolectarValidarTiposHoraAsyncService runTareaRecolectarValidarTiposHoraAsyncService;

    @Autowired
    private RunTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService runTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService;

    @Autowired
    private RunTareaRecolectarValidarLocalizacionPresenciaAsyncService runTareaRecolectarValidarLocalizacionPresenciaAsyncService;

    @Autowired
    private RunTareaRecolectarValidarLocalizacionVentaAsyncService runTareaRecolectarValidarLocalizacionVentaAsyncService;

    @Autowired
    private RunTareaRecolectarValidarAmbitoAsyncService runTareaRecolectarValidarAmbitoAsyncService;

    @Autowired
    @Qualifier("validarProperties")
    private ValidarPropertiesDto validarProperties;

    @Autowired
    private Logger log;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            if (validarProperties.isEnabled()) {
                CompletableFuture<List<RunTareaValidarDto>> cfEstructura = runTareaRecolectarValidarEstructurasAsyncService
                        .run(runTarea);
                AsyncUtils.exceptionally(cfEstructura, cf);

                CompletableFuture<List<RunTareaValidarDto>> cfLocalizacionHistorico = runTareaRecolectarValidarLocalizacionHistoricoAsyncService
                        .run(runTarea);
                AsyncUtils.exceptionally(cfLocalizacionHistorico, cf);

                CompletableFuture<List<RunTareaValidarDto>> cfTiposHora = runTareaRecolectarValidarTiposHoraAsyncService
                        .run(runTarea);
                AsyncUtils.exceptionally(cfTiposHora, cf);

                CompletableFuture<List<RunTareaValidarDto>> cfLocalizacionPersonaPresencia = runTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService
                        .run(runTarea);
                AsyncUtils.exceptionally(cfLocalizacionPersonaPresencia, cf);

                CompletableFuture<List<RunTareaValidarDto>> cfLocalizacionPresencia = runTareaRecolectarValidarLocalizacionPresenciaAsyncService
                        .run(runTarea);
                AsyncUtils.exceptionally(cfLocalizacionPresencia, cf);

                CompletableFuture<List<RunTareaValidarDto>> cfLocalizacionVenta = runTareaRecolectarValidarLocalizacionVentaAsyncService
                        .run(runTarea);
                AsyncUtils.exceptionally(cfLocalizacionVenta, cf);

                CompletableFuture<List<RunTareaValidarDto>> cfAmbito = runTareaRecolectarValidarAmbitoAsyncService
                        .run(runTarea);
                AsyncUtils.exceptionally(cfAmbito, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/
                List<RunTareaValidarDto> runTareaValidar = new ArrayList<>();
                runTareaValidar.addAll(AsyncUtils.get(cfEstructura));
                runTareaValidar.addAll(AsyncUtils.get(cfLocalizacionHistorico));
                runTareaValidar.addAll(AsyncUtils.get(cfLocalizacionPersonaPresencia));
                runTareaValidar.addAll(AsyncUtils.get(cfLocalizacionPresencia));
                runTareaValidar.addAll(AsyncUtils.get(cfLocalizacionVenta));
                runTareaValidar.addAll(AsyncUtils.get(cfAmbito));
                runTareaValidar.addAll(AsyncUtils.get(cfTiposHora));

                List<RunTareaValidarDto> runTareaValidarDuplicated = runTareaValidar.stream()
                        .filter(item -> CollectionUtils.isNotEmpty(item.getDuplicated())).collect(Collectors.toList());

                if (CollectionUtils.isNotEmpty(runTareaValidarDuplicated)) {
                    if (validarProperties.isLogging()) {
                        log.warn("RunTareaRecolectarValidarServiceImpl :: Valores duplicados :: [{}]",
                                runTareaValidarDuplicated);
                    }
                    if (validarProperties.isException()) {
                        throw new IcmclcwbException("Valores duplicados");
                    }
                }
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}