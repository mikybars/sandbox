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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarTiendaEmpleadoPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarTiendaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarTiendaPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarTiendaVentaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarValidarService;
import com.inditex.rrhh.icmclcwb.api.app.validar.properties.dto.ValidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaRecolectarValidarServiceImpl implements RunTareaRecolectarValidarService {

    @Autowired
    private RunTareaRecolectarValidarEstructurasAsyncService runTareaRecolectarValidarEstructurasAsyncService;

    @Autowired
    private RunTareaRecolectarValidarTiendaHistoricoAsyncService runTareaRecolectarValidarTiendaHistoricoAsyncService;

    @Autowired
    private RunTareaRecolectarValidarTiendaEmpleadoPresenciaSeccionAsyncService runTareaRecolectarValidarTiendaEmpleadoPresenciaSeccionAsyncService;

    @Autowired
    private RunTareaRecolectarValidarTiendaPresenciaSeccionAsyncService runTareaRecolectarValidarTiendaPresenciaSeccionAsyncService;

    @Autowired
    private RunTareaRecolectarValidarTiendaVentaSeccionAsyncService runTareaRecolectarValidarTiendaVentaSeccionAsyncService;

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

                CompletableFuture<List<RunTareaValidarDto>> cfTiendaHistorico = runTareaRecolectarValidarTiendaHistoricoAsyncService
                        .run(runTarea);
                AsyncUtils.exceptionally(cfTiendaHistorico, cf);

                CompletableFuture<List<RunTareaValidarDto>> cfTiendaEmpleadoPresenciaSeccion = runTareaRecolectarValidarTiendaEmpleadoPresenciaSeccionAsyncService
                        .run(runTarea);
                AsyncUtils.exceptionally(cfTiendaEmpleadoPresenciaSeccion, cf);

                CompletableFuture<List<RunTareaValidarDto>> cfTiendaPresenciaSeccion = runTareaRecolectarValidarTiendaPresenciaSeccionAsyncService
                        .run(runTarea);
                AsyncUtils.exceptionally(cfTiendaPresenciaSeccion, cf);

                CompletableFuture<List<RunTareaValidarDto>> cfTiendaVentaSeccion = runTareaRecolectarValidarTiendaVentaSeccionAsyncService
                        .run(runTarea);
                AsyncUtils.exceptionally(cfTiendaVentaSeccion, cf);

                CompletableFuture<List<RunTareaValidarDto>> cfAmbito = runTareaRecolectarValidarAmbitoAsyncService
                        .run(runTarea);
                AsyncUtils.exceptionally(cfAmbito, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/
                List<RunTareaValidarDto> runTareaValidar = new ArrayList<>();
                runTareaValidar.addAll(AsyncUtils.get(cfEstructura));
                runTareaValidar.addAll(AsyncUtils.get(cfTiendaHistorico));
                runTareaValidar.addAll(AsyncUtils.get(cfTiendaEmpleadoPresenciaSeccion));
                runTareaValidar.addAll(AsyncUtils.get(cfTiendaPresenciaSeccion));
                runTareaValidar.addAll(AsyncUtils.get(cfTiendaVentaSeccion));
                runTareaValidar.addAll(AsyncUtils.get(cfAmbito));

                List<RunTareaValidarDto> runTareaValidarDuplicated = runTareaValidar.stream().filter(item -> {
                    // TODO Revisar NullPointerException, lo da en el item
                    boolean result = false;
                    if (item == null) {
                        log.error("Nullpointer: {}", runTarea);
                    } else {
                        result = CollectionUtils.isNotEmpty(item.getDuplicated());
                    }
                    return result;
                }).collect(Collectors.toList());

                if (CollectionUtils.isNotEmpty(runTareaValidarDuplicated)) {
                    if (validarProperties.isLogging()) {
                        log.debug("RunTareaRecolectarValidarServiceImpl :: Valores duplicados :: [{}]",
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