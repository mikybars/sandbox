package com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.properties.dto.RunAjustePropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.async.ajustar.personas.CalculoAjusteMaximoGarantizadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjuste;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteMaximoGarantizadoRepositoryCustom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RunAjusteMaximoGarantizadoProcesar implements RunAjuste {

  private static final Logger LOG = LoggerFactory.getLogger(RunAjusteMaximoGarantizadoProcesar.class);

  @Autowired
  @Qualifier("runAjusteProperties")
  private RunAjustePropertiesDto runAjusteProperties;

  @Autowired
  private TareaCalculoAjusteMaximoGarantizadoRepositoryCustom tareaCalculoAjusteMaximoGarantizadoRepositoryCustom;

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Autowired
  private CalculoAjusteMaximoGarantizadoAsyncService calculoAjusteMaximoGarantizadoAsyncService;

  @Override
  public void execute(final RunTareaDto runTarea, final AlgoritmoAjusteDto algoritmoAjuste) {
    RunAjusteMaximoGarantizadoProcesar.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteMaximoGarantizadoProcesar :: Ids",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId());
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAjusteMaximoGarantizadoRepositoryCustom
        .ids(runTarea.getTarea());
    RunAjusteMaximoGarantizadoProcesar.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Fin :: RunAjusteMaximoGarantizadoProcesar :: Ids: {}",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), ids);

    final List<CompletableFuture<?>> cf = new ArrayList<>();
    for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
        ids,
        this.runAjusteProperties.getAjuste().getBatchSize())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.runAjusteProperties.getAjuste().getThreadSize());

      RunAjusteMaximoGarantizadoProcesar.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteMaximoGarantizadoProcesar :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
      try {
        final CompletableFuture<Void> cfAjuste = this.calculoAjusteMaximoGarantizadoAsyncService
            .ajustar(
                algoritmoAjuste, runTarea.getTarea(),
                personas);
        AsyncUtils.exceptionally(cfAjuste, cf);
      } catch (final Exception e) {
        AsyncUtils.cancel(cf);
        RunAjusteMaximoGarantizadoProcesar.LOG.error("RunAjusteMaximoGarantizadoProcesar :: KO :: Personas: {}", personas.size(), e);
        this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
      }
      RunAjusteMaximoGarantizadoProcesar.LOG.info("Fin :: RunAjusteMaximoGarantizadoProcesar :: Personas: {}", personas.size());

      AsyncUtils.waitAllOfIsOk(cf, cf);
    }
  }

  @Override
  public String getSqlCalcular(final AlgoritmoAjusteDto algoritmoAjuste) {
    return this.tareaCalculoAjusteMaximoGarantizadoRepositoryCustom.getSqlAjustar(algoritmoAjuste);
  }

}
