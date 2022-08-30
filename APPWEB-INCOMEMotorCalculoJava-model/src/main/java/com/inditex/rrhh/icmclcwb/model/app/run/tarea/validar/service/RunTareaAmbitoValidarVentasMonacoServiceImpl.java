package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarVentasMonacoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.primary.service.PrimaryVentasMonacoAsyncService;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.service.VentasMonacoService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaAmbitoValidarVentasMonacoServiceImpl implements RunTareaAmbitoValidarVentasMonacoService {

  @Autowired
  private PrimaryVentasMonacoAsyncService primaryVentasMonacoAsyncService;

  @Autowired
  private VentasMonacoService ventasMonacoService;

  @Autowired
  private ValidacionMapper validacionMapper;

  @Override
  public ValidacionDto execute(
      @Valid final RunTareaDto runTarea,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {

    this.primaryVentasMonacoAsyncService.createTempMonacoPtr();

    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfWait = new ArrayList<>();

    try {
      // Localizacion y seccion
      final CompletableFuture<Void> cfVentaFisicaLocalizacionSeccion = this.ventasMonacoService
          .ventaFisicaLocalizacionSeccionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentaFisicaLocalizacionSeccion, cf, cfWait);

      final CompletableFuture<Void> cfOnlineIpodLocalizacionSeccion = this.ventasMonacoService
          .ventaOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfOnlineIpodLocalizacionSeccion, cf, cfWait);

      final CompletableFuture<Void> cfOnlinePickingLocalizacionSeccion = this.ventasMonacoService
          .ventaOnlinePickingLocalizacionSeccionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfOnlinePickingLocalizacionSeccion, cf, cfWait);

      final CompletableFuture<Void> cfOnlineEntregaTiendaLocalizacionSeccion = this.ventasMonacoService
          .ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfOnlineEntregaTiendaLocalizacionSeccion, cf, cfWait);

      // Ventas fisicas para su uso en el reparto de la venta online
      final CompletableFuture<Void> cfVentaFisicaRepartoOnline = this.ventasMonacoService
          .ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentaFisicaRepartoOnline, cf, cfWait);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cfWait);
      /*-------------------------------------------------------------*/
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }

    this.primaryVentasMonacoAsyncService.mergeIntoTareaLocalizacionVenta(runTarea.getTarea());
    this.primaryVentasMonacoAsyncService.deleteTempMonacoPtr();

    return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);
  }
}
