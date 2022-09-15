package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.LocalizacionesAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.primary.service.PrimaryVentasMonacoAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrAgruparSeccionEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrExcluirIpodEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrIncluirVentaPatEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.service.VentasMonacoService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VentasMonacoServiceImpl implements VentasMonacoService {

  @Autowired
  private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  @Autowired
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @Autowired
  private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  @Autowired
  private TareaMapper tareaMapper;

  @Autowired
  private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  @Autowired
  private PtrVentaGeneralAsyncService ptrVentaGeneralAsyncService;

  @Autowired
  private PrimaryVentasMonacoAsyncService primaryVentasMonacoAsyncService;

  @Autowired
  private PtrVentaEcommerceAsyncService ptrVentaEcommerceAsyncService;

  @Autowired
  @Qualifier("ventaGeneralProperties")
  private Map<String, PtrPropertiesDto> ventaGeneralProperties;

  @Autowired
  @Qualifier("recolectarProperties")
  private RecolectarPropertiesDto recolectarProperties;

  @Autowired
  @Qualifier("ventaEcommerceProperties")
  private Map<String, PtrPropertiesDto> ventaEcommerceProperties;

  @Override
  public CompletableFuture<Void> ventaFisicaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  private void ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final PeriodoDto periodo = this.tareaLocalizacionPresupuestoService
          .findPeriodoPresupuestoYTrabajo(tarea.getId());
      for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
          this.tareaLocalizacionHistoricoService
              .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(tarea.getId(),
                  tareaAmbito.getCclIdOrigen(), Arrays.asList(AppConstants.STD_ID_LEG_ENT_MONACO)),
          this.ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO)
              .getFilter()
              .getMaxPageSize())) {
        final PtrVentaTotalizadoRequestDto request = this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoPeriodoDtoToPtrVentaTotalizadoRequestDto(tarea,
                tareaAmbito, periodo, this.recolectarProperties);
        request.setPais(AppConstants.ID_ORIGEN_MONACO_PTR);
        request.setEmpresa(Arrays.asList(Integer.valueOf(AppConstants.STD_ID_LEG_ENT_MONACO)));
        request.setTienda(iter.stream()
            .map(IdLocalizacionLocalDto::getId)
            .map(Integer::valueOf)
            .collect(Collectors.toList()));
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
        request.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
        request.setProducto(this.meta4IcmWsCalcIncomeSessionService
            .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
            .stream()
            .map(ConfiguracionProductoVentaResultItemDto::getIdProducto)
            .collect(Collectors.toList()));

        final CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = this.ptrVentaGeneralAsyncService
            .ventaTotalizado(request);
        AsyncUtils.exceptionally(cfData, cf, cfPersist);
        final PtrVentaTotalizadoResponseDto data = AsyncUtils.get(cfData);
        AsyncUtils.checkAsyncAvaliable(cfPersist, this.ventaGeneralProperties
            .get(PtrPropertiesConstants.VENTA_TOTALIZADO)
            .getFilter()
            .getMaxPersistenceSize());
        AsyncUtils.exceptionally(
            this.primaryVentasMonacoAsyncService.savePtrVentaTotalizadoResponse(data, tarea),
            cf, cfPersist);
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public CompletableFuture<Void> ventaOnlineIpodLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  private void ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final PtrFilterPropertiesDto filter = this.ventaEcommerceProperties
          .get(PtrPropertiesConstants.VENTA_ONLINE_IPOD)
          .getFilter();

      final List<IdCadenaDto> cadenas = this.tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(
          tarea.getId(), tareaAmbito.getCclIdOrigen(), AppConstants.STD_ID_LEG_ENT_MONACO, TipoVentaConceptoEnum.IPOD.getId());

      final LocalizacionesAmbitoDto localizaciones = new LocalizacionesAmbitoDto(
          runTarea.getTrabajo().getTipoAmbito().getId());

      if (TipoAmbitoEnum.PERSONA.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())
          || TipoAmbitoEnum.LOCALIZACION.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())) {
        localizaciones.setLocalizaciones(
            this.tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
                    runTarea.getTarea().getId(), tareaAmbito.getCclIdOrigen(), Arrays.asList(AppConstants.STD_ID_LEG_ENT_MONACO)));
      }
      if (CollectionUtils.isNotEmpty(cadenas) && localizaciones.hasData()) {
        final List<PeriodoDto> periodos = this.tareaLocalizacionPresupuestoService
            .findListaPeriodosPresupestoYTrabajo(tarea.getId(), filter, this.recolectarProperties);
        for (final PeriodoDto periodo : periodos) {
          final PtrVentaOnlineIpodRequestDto paramVentaOnlineIpod = this.tareaMapper
              .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrVentaOnlineIpodRequestDto(tarea, tareaAmbito,
                  periodo);
          paramVentaOnlineIpod.setPais(AppConstants.ID_ORIGEN_MONACO_PTR);
          paramVentaOnlineIpod.setCadena(
              cadenas.stream()
                  .map(IdCadenaDto::getId)
                  .map(Integer::valueOf)
                  .collect(Collectors.toList()));
          paramVentaOnlineIpod.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
          paramVentaOnlineIpod.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
          paramVentaOnlineIpod.setTienda(localizaciones.getLocalizaciones());
          paramVentaOnlineIpod.setProducto(this.meta4IcmWsCalcIncomeSessionService
              .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
              .stream()
              .map(ConfiguracionProductoVentaResultItemDto::getIdProducto)
              .collect(Collectors.toList()));

          final CompletableFuture<PtrVentaOnlineIpodResponseDto> cfData = this.ptrVentaEcommerceAsyncService
              .ventaOnlineiPod(paramVentaOnlineIpod);
          AsyncUtils.exceptionally(cfData, cf, cfPersist);

          final PtrVentaOnlineIpodResponseDto data = AsyncUtils.get(cfData);

          AsyncUtils.checkAsyncAvaliable(cfPersist, filter.getMaxPersistenceSize());
          AsyncUtils.exceptionally(
              this.primaryVentasMonacoAsyncService.savePtrVentaOnlineIpodResponse(data, tarea),
              cf, cfPersist);
        }
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public CompletableFuture<Void> ventaOnlinePickingLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  private void ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final PtrFilterPropertiesDto filter = this.ventaEcommerceProperties
          .get(PtrPropertiesConstants.VENTA_ONLINE_PICKING)
          .getFilter();
      final List<IdCadenaDto> cadenas = this.tareaLocalizacionHistoricoService
          .findIdCadenaDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(
              tarea.getId(), tareaAmbito.getCclIdOrigen(), AppConstants.STD_ID_LEG_ENT_MONACO, TipoVentaConceptoEnum.SINT.getId());

      final LocalizacionesAmbitoDto localizaciones = new LocalizacionesAmbitoDto(
          runTarea.getTrabajo().getTipoAmbito().getId());

      if (TipoAmbitoEnum.PERSONA.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())
          || TipoAmbitoEnum.LOCALIZACION.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())) {
        localizaciones.setLocalizaciones(
            this.tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
                    runTarea.getTarea().getId(), tareaAmbito.getCclIdOrigen(), Arrays.asList(AppConstants.STD_ID_LEG_ENT_MONACO)));
      }

      if (CollectionUtils.isNotEmpty(cadenas) && localizaciones.hasData()) {
        final List<PeriodoDto> periodos = this.tareaLocalizacionPresupuestoService
            .findListaPeriodosPresupestoYTrabajo(tarea.getId(), filter, this.recolectarProperties);
        for (final PeriodoDto periodo : periodos) {
          final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
          final PtrVentaOnlinePickingRequestDto paramVentaOnlinePicking = this.tareaMapper
              .mergeTareaDtoAndTareaAmbitoDtoPeriodoDtoToPtrVentaOnlinePickingRequestDto(tarea, tareaAmbito,
                  periodo);
          paramVentaOnlinePicking.setPais(AppConstants.ID_ORIGEN_MONACO_PTR);
          paramVentaOnlinePicking.setCadena(
              cadenas.stream()
                  .map(IdCadenaDto::getId)
                  .map(Integer::valueOf)
                  .collect(Collectors.toList()));
          paramVentaOnlinePicking.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
          paramVentaOnlinePicking.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
          paramVentaOnlinePicking.setTienda(localizaciones.getLocalizaciones());
          paramVentaOnlinePicking.setProducto(this.meta4IcmWsCalcIncomeSessionService
              .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
              .stream()
              .map(ConfiguracionProductoVentaResultItemDto::getIdProducto)
              .collect(Collectors.toList()));
          paramVentaOnlinePicking.setVentaPAT(PtrIncluirVentaPatEnum.TRUE.getValue());
          paramVentaOnlinePicking.setExcluirIpod(PtrExcluirIpodEnum.FALSE.getValue());

          final CompletableFuture<PtrVentaOnlinePickingResponseDto> cfData = this.ptrVentaEcommerceAsyncService
              .ventaOnlinePicking(paramVentaOnlinePicking);
          AsyncUtils.exceptionally(cfData, cf, cfPersist);

          final PtrVentaOnlinePickingResponseDto data = AsyncUtils.get(cfData);

          AsyncUtils.checkAsyncAvaliable(cfPersist, filter.getMaxPersistenceSize());
          AsyncUtils.exceptionally(
              this.primaryVentasMonacoAsyncService.savePtrVentaOnlinePickingResponse(data, tarea), cf,
              cfPersist);
        }
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);

    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public CompletableFuture<Void> ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  private void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final PtrFilterPropertiesDto filter = this.ventaEcommerceProperties
          .get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA)
          .getFilter();
      final TareaDto tarea = runTarea.getTarea();
      final List<IdCadenaDto> cadenas = this.tareaLocalizacionHistoricoService
          .findIdCadenaDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(
              tarea.getId(), tareaAmbito.getCclIdOrigen(), AppConstants.STD_ID_LEG_ENT_MONACO,
              TipoVentaConceptoEnum.ENTREGA_TIENDA.getId());

      final LocalizacionesAmbitoDto localizaciones = new LocalizacionesAmbitoDto(
          runTarea.getTrabajo().getTipoAmbito().getId());

      if (TipoAmbitoEnum.PERSONA.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())
          || TipoAmbitoEnum.LOCALIZACION.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())) {
        localizaciones.setLocalizaciones(
            this.tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
                    runTarea.getTarea().getId(), tareaAmbito.getCclIdOrigen(), Arrays.asList(AppConstants.STD_ID_LEG_ENT_MONACO)));
      }

      if (CollectionUtils.isNotEmpty(cadenas) && localizaciones.hasData()) {
        final List<PeriodoDto> periodos = this.tareaLocalizacionPresupuestoService
            .findListaPeriodosPresupestoYTrabajo(tarea.getId(), filter, this.recolectarProperties);
        for (final PeriodoDto periodo : periodos) {
          final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
          final PtrVentaOnlineEntregaTiendaRequestDto paramVentaOnlineEntregaTienda = this.tareaMapper
              .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrVentaOnlineEntregaTiendaRequestDto(
                  tarea, tareaAmbito, periodo);
          paramVentaOnlineEntregaTienda.setPais(AppConstants.ID_ORIGEN_MONACO_PTR);
          paramVentaOnlineEntregaTienda.setCadena(
              cadenas.stream()
                  .map(IdCadenaDto::getId)
                  .map(Integer::valueOf)
                  .collect(Collectors.toList()));
          paramVentaOnlineEntregaTienda.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
          paramVentaOnlineEntregaTienda.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
          paramVentaOnlineEntregaTienda.setTienda(localizaciones.getLocalizaciones());
          paramVentaOnlineEntregaTienda.setProducto(this.meta4IcmWsCalcIncomeSessionService
              .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
              .stream()
              .map(ConfiguracionProductoVentaResultItemDto::getIdProducto)
              .collect(Collectors.toList()));

          final CompletableFuture<PtrVentaOnlineEntregaTiendaResponseDto> cfData = this.ptrVentaEcommerceAsyncService
              .ventaOnlineEntregaTienda(paramVentaOnlineEntregaTienda);

          AsyncUtils.exceptionally(cfData, cf, cfPersist);

          final PtrVentaOnlineEntregaTiendaResponseDto data = AsyncUtils.get(cfData);

          AsyncUtils.checkAsyncAvaliable(cfPersist, filter.getMaxPersistenceSize());
          AsyncUtils.exceptionally(
              this.primaryVentasMonacoAsyncService.savePtrVentaOnlineEntregaTiendaResponse(data,
                  tarea),
              cf,
              cfPersist);
        }
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);

    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public CompletableFuture<Void> ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(
      final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(runTarea, item));
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  private void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final PeriodoDto periodo = this.tareaLocalizacionPresupuestoService
          .findPeriodoPresupuestoYTrabajo(tarea.getId());
      final List<IdCadenaDto> cadenas = this.tareaLocalizacionHistoricoService
          .findIdCadenaDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(tarea.getId(), tareaAmbito.getCclIdOrigen(),
              AppConstants.STD_ID_LEG_ENT_MONACO, TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId());
      if (CollectionUtils.isNotEmpty(cadenas)) {

        final PtrVentaTotalizadoRequestDto request = this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoIdCadenaDtoToPtrVentaTotalizadoRequestDto(
                tarea, tareaAmbito, periodo, this.recolectarProperties, cadenas);

        request.setPais(AppConstants.ID_ORIGEN_MONACO_PTR);
        request.setEmpresa(null);
        request.setCadena(
            cadenas.stream().map(IdCadenaDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
        request.setAgruparSeccion(PtrAgruparSeccionEnum.FALSE.getValue());
        request.setProducto(this.meta4IcmWsCalcIncomeSessionService
            .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
            .stream()
            .map(ConfiguracionProductoVentaResultItemDto::getIdProducto)
            .collect(Collectors.toList()));

        final CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = this.ptrVentaGeneralAsyncService
            .ventaTotalizado(request);
        AsyncUtils.exceptionally(cfData, cf, cfPersist);
        final PtrVentaTotalizadoResponseDto data = AsyncUtils.get(cfData);
        AsyncUtils.checkAsyncAvaliable(cfPersist, this.ventaGeneralProperties
            .get(PtrPropertiesConstants.VENTA_TOTALIZADO)
            .getFilter()
            .getMaxPersistenceSize());
        AsyncUtils.exceptionally(
            this.primaryVentasMonacoAsyncService.savePtrVentaTotalizadoResponseRepartoOnline(data,
                tarea),
            cf,
            cfPersist);
        AsyncUtils.waitAllOfIsOk(cf, cf);
      }
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
