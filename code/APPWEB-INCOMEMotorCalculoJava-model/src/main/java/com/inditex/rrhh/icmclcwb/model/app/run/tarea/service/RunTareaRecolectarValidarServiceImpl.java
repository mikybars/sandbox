package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarAmbitoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarEstructurasAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarTiposHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarValidarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.validar.properties.dto.ValidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarValidarServiceImpl implements RunTareaRecolectarValidarService {

  private static final Logger LOG = LoggerFactory.getLogger(RunTareaRecolectarValidarServiceImpl.class);

  private final RunTareaRecolectarValidarEstructurasAsyncService runTareaRecolectarValidarEstructurasAsyncService;

  private final RunTareaRecolectarValidarLocalizacionHistoricoAsyncService runTareaRecolectarValidarLocalizacionHistoricoAsyncService;

  private final RunTareaRecolectarValidarTiposHoraAsyncService runTareaRecolectarValidarTiposHoraAsyncService;

  private final RunTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService runTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService;

  private final RunTareaRecolectarValidarLocalizacionPresenciaAsyncService runTareaRecolectarValidarLocalizacionPresenciaAsyncService;

  private final RunTareaRecolectarValidarLocalizacionVentaAsyncService runTareaRecolectarValidarLocalizacionVentaAsyncService;

  private final RunTareaRecolectarValidarAmbitoAsyncService runTareaRecolectarValidarAmbitoAsyncService;

  private final ValidarPropertiesDto validarProperties;

  private final TareaFaseService tareaFaseService;

  @Auditoria
  @Validation(fase = 2)
  @TimerFunctionalMetric(metricName = "RunTareaRecolectarValidarService.run.timer",
      metricGroupName = "RunTareaRecolectarValidarServiceeGroup",
      metricDescription = "RunTareaRecolectarValidarService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaRecolectarValidarService.run.counter",
      metricGroupName = "RunTareaRecolectarValidarServiceGroup",
      metricDescription = "RunTareaRecolectarValidarService.run.counter")
  @Override
  public void run(@NonNull @Valid final RunTareaDto runTarea) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      this.tareaFaseService.updateFechaInicio(
          this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
              FaseEnum.VALIDAR_RECOLECCION.getId()));

      if (this.validarProperties.isEnabled()) {
        final CompletableFuture<List<RunTareaValidarDto>> cfEstructura = this.runTareaRecolectarValidarEstructurasAsyncService
            .run(runTarea);
        AsyncUtils.exceptionally(cfEstructura, cf);

        final CompletableFuture<List<RunTareaValidarDto>> cfLocalizacionHistorico =
            this.runTareaRecolectarValidarLocalizacionHistoricoAsyncService
                .run(runTarea);
        AsyncUtils.exceptionally(cfLocalizacionHistorico, cf);

        final CompletableFuture<List<RunTareaValidarDto>> cfTiposHora = this.runTareaRecolectarValidarTiposHoraAsyncService
            .run(runTarea);
        AsyncUtils.exceptionally(cfTiposHora, cf);

        final CompletableFuture<List<RunTareaValidarDto>> cfLocalizacionPersonaPresencia =
            this.runTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService
                .run(runTarea);
        AsyncUtils.exceptionally(cfLocalizacionPersonaPresencia, cf);

        final CompletableFuture<List<RunTareaValidarDto>> cfLocalizacionPresencia =
            this.runTareaRecolectarValidarLocalizacionPresenciaAsyncService
                .run(runTarea);
        AsyncUtils.exceptionally(cfLocalizacionPresencia, cf);

        final CompletableFuture<List<RunTareaValidarDto>> cfLocalizacionVenta = this.runTareaRecolectarValidarLocalizacionVentaAsyncService
            .run(runTarea);
        AsyncUtils.exceptionally(cfLocalizacionVenta, cf);

        final CompletableFuture<List<RunTareaValidarDto>> cfAmbito = this.runTareaRecolectarValidarAmbitoAsyncService
            .run(runTarea);
        AsyncUtils.exceptionally(cfAmbito, cf);

        /*-------------------------------------------------------------*/
        AsyncUtils.waitAllOfIsOk(cf, cf);
        /*-------------------------------------------------------------*/
        final List<RunTareaValidarDto> runTareaValidar = new ArrayList<>();
        runTareaValidar.addAll(AsyncUtils.get(cfEstructura));
        runTareaValidar.addAll(AsyncUtils.get(cfLocalizacionHistorico));
        runTareaValidar.addAll(AsyncUtils.get(cfLocalizacionPersonaPresencia));
        runTareaValidar.addAll(AsyncUtils.get(cfLocalizacionPresencia));
        runTareaValidar.addAll(AsyncUtils.get(cfLocalizacionVenta));
        runTareaValidar.addAll(AsyncUtils.get(cfAmbito));
        runTareaValidar.addAll(AsyncUtils.get(cfTiposHora));

        final List<RunTareaValidarDto> runTareaValidarDuplicated = runTareaValidar.stream()
            .filter(item -> CollectionUtils.isNotEmpty(item.getDuplicated()))
            .collect(Collectors.toList());

        if (CollectionUtils.isNotEmpty(runTareaValidarDuplicated)) {
          if (this.validarProperties.isLogging()) {
            RunTareaRecolectarValidarServiceImpl.LOG.warn(
                "Trabajo[{}]Tarea[{}] :: RunTareaRecolectarValidarServiceImpl :: Valores duplicados :: [{}]",
                runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), runTareaValidarDuplicated);
          }
          if (this.validarProperties.isException()) {
            throw new IcmclcwbException("Valores duplicados");
          }
        }
      }

      this.tareaFaseService.updateFechaFinAndEstado(
          this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
              FaseEnum.VALIDAR_RECOLECCION.getId()),
          EstadoTareaFaseEnum.OK.getDto());

    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      this.tareaFaseService.updateFechaFinAndEstado(
          this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
              FaseEnum.VALIDAR_RECOLECCION.getId()),
          EstadoTareaFaseEnum.KO.getDto());
      throw e;
    }
  }

}
