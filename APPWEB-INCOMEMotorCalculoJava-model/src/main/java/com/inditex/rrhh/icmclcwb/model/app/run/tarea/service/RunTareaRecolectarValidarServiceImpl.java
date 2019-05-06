package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
    public RunTareaDto run(@NotNull @Valid RunTareaDto runTarea) {

        if (validarProperties.isEnabled()) {
            List<CompletableFuture<?>> cf = new ArrayList<>();

            CompletableFuture<Void> cfEstructura = runTareaRecolectarValidarEstructurasAsyncService.run(runTarea);
            AsyncUtils.exceptionally(cfEstructura, cf);

            CompletableFuture<Void> cfTiendaHistorico = runTareaRecolectarValidarTiendaHistoricoAsyncService
                    .run(runTarea);
            AsyncUtils.exceptionally(cfTiendaHistorico, cf);

            CompletableFuture<Void> cfTiendaEmpleadoPresenciaSeccion = runTareaRecolectarValidarTiendaEmpleadoPresenciaSeccionAsyncService
                    .run(runTarea);
            AsyncUtils.exceptionally(cfTiendaEmpleadoPresenciaSeccion, cf);

            CompletableFuture<Void> cfTiendaPresenciaSeccion = runTareaRecolectarValidarTiendaPresenciaSeccionAsyncService
                    .run(runTarea);
            AsyncUtils.exceptionally(cfTiendaPresenciaSeccion, cf);

            CompletableFuture<Void> cfTiendaVentaSeccion = runTareaRecolectarValidarTiendaVentaSeccionAsyncService
                    .run(runTarea);
            AsyncUtils.exceptionally(cfTiendaVentaSeccion, cf);

            CompletableFuture<Void> cfAmbito = runTareaRecolectarValidarAmbitoAsyncService.run(runTarea);
            AsyncUtils.exceptionally(cfAmbito, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            List<RunTareaValidarDto> runTareaValidarDto = runTarea.getRunTareaValidar().stream()
                    .filter(e -> !e.getDuplicated().isEmpty()).collect(Collectors.toList());

            if (validarProperties.isLogging() && !runTareaValidarDto.isEmpty()) {
                log.debug("RunTareaRecolectarValidarServiceImpl :: Valores duplicados :: [{}]", runTareaValidarDto);
            }

            if (validarProperties.isException() && !runTareaValidarDto.isEmpty()) {
                throw new IcmclcwbException("Valores duplicados");
            }
        }

        return runTarea;

    }

}