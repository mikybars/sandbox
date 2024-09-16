package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.LocalizacionesAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrMonacoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
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
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RunTareaAmbitoRecolectarPtrMonacoServiceImpl implements RunTareaAmbitoRecolectarPtrMonacoService {

  @Autowired
  private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  @Autowired
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @Autowired
  private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  @Autowired
  private TareaLocalizacionPersonaPresenciaAsyncService tareaLocalizacionPersonaPresenciaAsyncService;

  @Autowired
  private TareaMapper tareaMapper;

  @Autowired
  private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  @Autowired
  private PtrVentaGeneralAsyncService ptrVentaGeneralAsyncService;

  @Autowired
  private PtrPresenciaAsyncService ptrPresenciaAsyncService;

  @Autowired
  private TareaLocalizacionVentaAsyncService tareaLocalizacionVentaAsyncService;

  @Autowired
  private PtrVentaEcommerceAsyncService ptrVentaEcommerceAsyncService;

  @Autowired
  @Qualifier("ventaGeneralProperties")
  private Map<String, PtrPropertiesDto> ventaGeneralProperties;

  @Autowired
  @Qualifier("presenciasProperties")
  private Map<String, PtrPropertiesDto> presenciasProperties;

  @Autowired
  @Qualifier("recolectarProperties")
  private RecolectarPropertiesDto recolectarProperties;

  @Autowired
  @Qualifier("ventaEcommerceProperties")
  private Map<String, PtrPropertiesDto> ventaEcommerceProperties;

  @Override
  public void ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
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
            this.tareaLocalizacionVentaAsyncService.savePtrVentaTotalizadoResponse(data, tarea),
            cf, cfPersist);
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
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
              this.tareaLocalizacionVentaAsyncService.savePtrVentaOnlineIpodResponse(data, tarea),
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
  public void ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
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
              this.tareaLocalizacionVentaAsyncService.savePtrVentaOnlinePickingResponse(data, tarea), cf,
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
  public void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
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
              this.tareaLocalizacionVentaAsyncService.savePtrVentaOnlineEntregaTiendaResponse(data,
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
  public void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
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
            this.tareaLocalizacionVentaAsyncService.savePtrVentaTotalizadoResponseRepartoOnline(data,
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

  @Override
  public void presenciaDetalleComisionablePersonaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final PtrFilterPropertiesDto filter = this.presenciasProperties
          .get(PtrPropertiesConstants.PRESENCIA_DETALLE)
          .getFilter();
      final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId())
          .stream()
          .map(IdEmpresaDto::getStdIdLegEnt)
          .collect(Collectors.toList());
      empresasAmbito.add(PtrConstants.EMPRESA_0);
      final List<IdLocalizacionLocalDto> ficticias = this.tareaLocalizacionHistoricoService
          .findLocalizacionFicticiaByIdOrigenAndIdEmpresa(tareaAmbito.getCclIdOrigen(), PtrConstants.EMPRESA_0);
      final List<IdLocalizacionLocalDto> localizaciones = this.tareaLocalizacionHistoricoService
          .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
              runTarea.getTarea().getId(), tareaAmbito.getCclIdOrigen(), Arrays.asList(AppConstants.STD_ID_LEG_ENT_MONACO));
      for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
          Stream.concat(localizaciones.stream(), ficticias.stream())
              .collect(Collectors.toList()),
          filter.getMaxPageSize())) {
        for (final PeriodoDto periodo : this.tareaLocalizacionPresupuestoService
            .findListaPeriodosPresupestoYTrabajo(
                tarea.getId(), filter, this.recolectarProperties)) {
          final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
          final PtrPresenciaDetalleRequestDto paramPresenciasDetalle = this.tareaMapper
              .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(tarea,
                  tareaAmbito, periodo);
          paramPresenciasDetalle.setOrigen(AppConstants.ID_ORIGEN_MONACO_PTR);
          paramPresenciasDetalle
              .setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
          paramPresenciasDetalle.setTienda(iter.stream()
              .map(IdLocalizacionLocalDto::getId)
              .map(Integer::valueOf)
              .collect(Collectors.toList()));
          paramPresenciasDetalle.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
          paramPresenciasDetalle
              .setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_TIPOHORA_SECCION.getValue());
          final CompletableFuture<PtrPresenciaDetalleResponseDto> cfData = this.ptrPresenciaAsyncService
              .presenciasDetalle(paramPresenciasDetalle);
          AsyncUtils.exceptionally(cfData, cf, cfPersist);
          final PtrPresenciaDetalleResponseDto data = AsyncUtils.get(cfData);
          if ((data != null) && CollectionUtils.isNotEmpty(data.getPresenciasDetalle())) {
            AsyncUtils.checkAsyncAvaliable(cfPersist, filter.getMaxPersistenceSize());
            data.getPresenciasDetalle().stream().forEach(e -> e.setOrigen(AppConstants.ID_ORIGEN_FRANCIA_PTR));
            AsyncUtils.exceptionally(this.tareaLocalizacionPersonaPresenciaAsyncService
                .savePtrPresenciaDetalle(data.getPresenciasDetalle(), tarea,
                    TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()),
                cf, cfPersist);
          }
        }
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void presenciaDetallePersonaIncluidoCommerceByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final PtrFilterPropertiesDto filter = this.presenciasProperties
          .get(PtrPropertiesConstants.PRESENCIA_DETALLE)
          .getFilter();
      final List<IdCadenaDto> cadenas = this.tareaLocalizacionHistoricoService
          .findIdCadenaDtoByIdTareaAndCclIdOrigen(tarea.getId(),
              tareaAmbito.getCclIdOrigen(),
              Arrays.asList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()));
      if (CollectionUtils.isNotEmpty(cadenas)) {
        for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
            this.tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdCadena(
                    tarea.getId(), tareaAmbito.getCclIdOrigen(),
                    cadenas.stream().map(IdCadenaDto::getId).collect(Collectors.toList())),
            filter.getMaxPageSize())) {
          for (final PeriodoDto periodo : this.tareaLocalizacionPresupuestoService
              .findListaPeriodosPresupestoYTrabajo(
                  tarea.getId(), filter, this.recolectarProperties)) {
            final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            final PtrPresenciaDetalleRequestDto paramPresenciasDetalle = this.tareaMapper
                .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(tarea,
                    tareaAmbito, periodo);
            paramPresenciasDetalle.setOrigen(AppConstants.ID_ORIGEN_MONACO_PTR);
            paramPresenciasDetalle
                .setCadena(
                    cadenas.stream().map(a -> Integer.valueOf(a.getId())).collect(Collectors.toList()));
            paramPresenciasDetalle.setTienda(iter.stream()
                .map(IdLocalizacionLocalDto::getId)
                .map(Integer::valueOf)
                .collect(Collectors.toList()));
            paramPresenciasDetalle.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
            paramPresenciasDetalle
                .setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_TIPOHORA_SECCION.getValue());
            final CompletableFuture<PtrPresenciaDetalleResponseDto> cfData = this.ptrPresenciaAsyncService
                .presenciasDetalle(paramPresenciasDetalle);
            AsyncUtils.exceptionally(cfData, cf, cfPersist);

            final PtrPresenciaDetalleResponseDto data = AsyncUtils.get(cfData);
            if ((data != null) && CollectionUtils.isNotEmpty(data.getPresenciasDetalle())) {
              AsyncUtils.checkAsyncAvaliable(cfPersist, filter.getMaxPersistenceSize());
              data.getPresenciasDetalle().stream().forEach(e -> e.setOrigen(AppConstants.ID_ORIGEN_FRANCIA_PTR));
              AsyncUtils.exceptionally(this.tareaLocalizacionPersonaPresenciaAsyncService
                  .savePtrPresenciaDetalle(data.getPresenciasDetalle(), tarea,
                      TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA_INCLUIDOECOMMERCE
                          .getId()),
                  cf, cfPersist);
            }
          }
        }
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }
}
