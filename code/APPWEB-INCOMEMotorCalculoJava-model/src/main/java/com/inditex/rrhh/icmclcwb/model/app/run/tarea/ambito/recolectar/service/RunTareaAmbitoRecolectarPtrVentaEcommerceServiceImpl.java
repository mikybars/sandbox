package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoChallengeEnum;
import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.LocalizacionesAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresupuestoVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionCadenaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrAgruparSeccionEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrExcluirIpodEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrIncluirVentaPatEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaAmbitoRecolectarPtrVentaEcommerceServiceImpl
    implements RunTareaAmbitoRecolectarPtrVentaEcommerceService {

  protected final Map<String, PtrPropertiesDto> ventaEcommerceProperties;

  private final PtrVentaEcommerceAsyncService ptrVentaEcommerceAsyncService;

  private final TareaLocalizacionVentaAsyncService tareaLocalizacionVentaAsyncService;

  private final TareaLocalizacionPersonaVentaAsyncService tareaLocalizacionPersonaVentaAsyncService;

  private final TareaAgrupacionVentaAsyncService tareaAgrupacionVentaAsyncService;

  private final TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  private final TareaAgrupacionCadenaService tareaAgrupacionCadenaService;

  private final TareaLocalizacionPresupuestoVentaAsyncService tareaLocalizacionPresupuestoVentaAsyncService;

  private final TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  private final Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  private final TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  private final TareaMapper tareaMapper;

  private final RecolectarPropertiesDto recolectarProperties;

  @Override
  public void ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final Long idTarea = runTarea.getTarea().getId();
      final PtrFilterPropertiesDto filter = this.ventaEcommerceProperties
          .get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO)
          .getFilter();
      final List<TareaAgrupacionCadenasDto> agrupaciones = this.tareaAgrupacionCadenaService
          .findAgrupacionesByTarea(tarea);
      final String cclIdOrigen = tareaAmbito.getCclIdOrigen();
      final List<IdCadenaDto> cadenas = this.tareaLocalizacionHistoricoService
          .findIdCadenaDtoByIdTareaAndCclIdOrigen(idTarea, cclIdOrigen,
              Arrays.asList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_VENTA.getId(),
                  TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()));
      if (CollectionUtils.isNotEmpty(cadenas)) {
        final List<PeriodoDto> periodos = this.tareaLocalizacionPresupuestoService
            .findListaPeriodosPresupestoYTrabajo(idTarea, filter, this.recolectarProperties);
        for (final PeriodoDto periodo : periodos) {
          final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
          final PtrVentaOnlineEntregaDomicilioRequestDto paramVentaOnlineEntregaDomicilio = this.tareaMapper
              .mergeTareaDtoAndTareaAmbitoAndPeriodoDtoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
                  tarea, tareaAmbito, periodo, cadenas);
          paramVentaOnlineEntregaDomicilio.setCadena(cadenas.stream()
              .map(IdCadenaDto::getId)
              .map(Integer::valueOf)
              .collect(Collectors.toList()));
          paramVentaOnlineEntregaDomicilio.setAgrupacion(PtrGroupTypeEnum.FECHA_CADENA);
          paramVentaOnlineEntregaDomicilio.setAgruparSeccion(PtrAgruparSeccionEnum.FALSE.getValue());
          paramVentaOnlineEntregaDomicilio.setProducto(this.meta4IcmWsCalcIncomeSessionService
              .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
              .stream()
              .map(ConfiguracionProductoVentaResultItemDto::getIdProducto)
              .collect(Collectors.toList()));

          final CompletableFuture<PtrVentaOnlineEntregaDomicilioResponseDto> cfData = this.ptrVentaEcommerceAsyncService
              .ventaOnlineEntregaDomicilio(paramVentaOnlineEntregaDomicilio);

          AsyncUtils.exceptionally(cfData, cf, cfPersist);

          final PtrVentaOnlineEntregaDomicilioResponseDto data = AsyncUtils.get(cfData);

          AsyncUtils.checkAsyncAvaliable(cfPersist,
              filter
                  .getMaxPersistenceSize());
          AsyncUtils.exceptionally(this.tareaAgrupacionVentaAsyncService
              .savePtrVentaOnlineEntregaDomicilioResponse(data, tarea, agrupaciones), cf, cfPersist);
        }
        AsyncUtils.waitAllOfIsOk(cf, cf);
      }
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
          .findIdCadenaDtoByIdTareaAndCclIdOrigen(
              tarea.getId(), tareaAmbito.getCclIdOrigen(), TipoVentaConceptoEnum.ENTREGA_TIENDA.getId());

      final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId())
          .stream()
          .map(IdEmpresaDto::getStdIdLegEnt)
          .collect(Collectors.toList());

      for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
          this.tareaLocalizacionHistoricoService
              .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(tarea.getId(),
                  tareaAmbito.getCclIdOrigen(), empresasAmbito),
          this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA)
              .getFilter()
              .getMaxPageSize())) {
        final List<PeriodoDto> periodos = this.tareaLocalizacionPresupuestoService
            .findListaPeriodosPresupestoYTrabajo(tarea.getId(), filter, this.recolectarProperties);
        for (final PeriodoDto periodo : periodos) {
          final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
          final PtrVentaOnlineEntregaTiendaRequestDto paramVentaOnlineEntregaTienda = this.tareaMapper
              .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrVentaOnlineEntregaTiendaRequestDto(
                  tarea, tareaAmbito, periodo);
          paramVentaOnlineEntregaTienda.setCadena(
              cadenas.stream()
                  .map(IdCadenaDto::getId)
                  .map(Integer::valueOf)
                  .collect(Collectors.toList()));
          paramVentaOnlineEntregaTienda.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
          paramVentaOnlineEntregaTienda.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
          paramVentaOnlineEntregaTienda.setTienda(iter.stream()
              .map(IdLocalizacionLocalDto::getId)
              .map(Integer::valueOf)
              .collect(Collectors.toList()));
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
  public void ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final PtrFilterPropertiesDto filter = this.ventaEcommerceProperties
          .get(PtrPropertiesConstants.VENTA_ONLINE_PICKING)
          .getFilter();
      final List<IdCadenaDto> cadenas = this.tareaLocalizacionHistoricoService
          .findIdCadenaDtoByIdTareaAndCclIdOrigen(
              tarea.getId(), tareaAmbito.getCclIdOrigen(), TipoVentaConceptoEnum.SINT.getId());

      final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId())
          .stream()
          .map(IdEmpresaDto::getStdIdLegEnt)
          .collect(Collectors.toList());

      for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
          this.tareaLocalizacionHistoricoService
              .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(tarea.getId(),
                  tareaAmbito.getCclIdOrigen(), empresasAmbito),
          this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING)
              .getFilter()
              .getMaxPageSize())) {
        final List<PeriodoDto> periodos = this.tareaLocalizacionPresupuestoService
            .findListaPeriodosPresupestoYTrabajo(tarea.getId(), filter, this.recolectarProperties);
        for (final PeriodoDto periodo : periodos) {
          final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
          final PtrVentaOnlinePickingRequestDto paramVentaOnlinePicking = this.tareaMapper
              .mergeTareaDtoAndTareaAmbitoDtoPeriodoDtoToPtrVentaOnlinePickingRequestDto(tarea, tareaAmbito,
                  periodo);
          paramVentaOnlinePicking.setCadena(
              cadenas.stream()
                  .map(IdCadenaDto::getId)
                  .map(Integer::valueOf)
                  .collect(Collectors.toList()));
          paramVentaOnlinePicking.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
          paramVentaOnlinePicking.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
          paramVentaOnlinePicking.setTienda(iter.stream()
              .map(IdLocalizacionLocalDto::getId)
              .map(Integer::valueOf)
              .collect(Collectors.toList()));
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
  public void ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final PtrFilterPropertiesDto filter = this.ventaEcommerceProperties
          .get(PtrPropertiesConstants.VENTA_ONLINE_IPOD)
          .getFilter();
      final List<IdCadenaDto> cadenas = this.tareaLocalizacionHistoricoService
          .findIdCadenaDtoByIdTareaAndCclIdOrigen(
              tarea.getId(), tareaAmbito.getCclIdOrigen(), TipoVentaConceptoEnum.IPOD.getId());
      final LocalizacionesAmbitoDto localizaciones = new LocalizacionesAmbitoDto(
          runTarea.getTrabajo().getTipoAmbito().getId());

      if (TipoAmbitoEnum.PERSONA.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())
          || TipoAmbitoEnum.LOCALIZACION.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())) {
        localizaciones.setLocalizaciones(
            this.tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
                    runTarea.getTarea().getId(), tareaAmbito.getCclIdOrigen()));
      }
      if (CollectionUtils.isNotEmpty(cadenas) && localizaciones.hasData()) {
        final List<PeriodoDto> periodos = this.tareaLocalizacionPresupuestoService
            .findListaPeriodosPresupestoYTrabajo(tarea.getId(), filter, this.recolectarProperties);
        for (final PeriodoDto periodo : periodos) {
          final PtrVentaOnlineIpodRequestDto paramVentaOnlineIpod = this.tareaMapper
              .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrVentaOnlineIpodRequestDto(tarea, tareaAmbito,
                  periodo);
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
  public void ventaOnlineIpodLocalizacionPersonaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      final TareaDto tarea = runTarea.getTarea();
      final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId())
          .stream()
          .map(IdEmpresaDto::getStdIdLegEnt)
          .collect(Collectors.toList());
      for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
          this.tareaLocalizacionHistoricoService
              .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntAndTipoCalculoInAmbitoLocalizacion(
                  tarea.getId(),
                  tareaAmbito.getCclIdOrigen(),
                  empresasAmbito,
                  Arrays.asList(TipoCalculoEnum.POR_VENTA.getId(),
                      TipoCalculoEnum.POR_VENTA_INDIVIDUAL.getId())),
          this.ventaEcommerceProperties
              .get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE)
              .getFilter()
              .getMaxPageSize())) {

        final PtrVentaOnlineIpodIndividualDetalleRequestDto paramVentaOnlineIpod = this.tareaMapper
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodIndividualDetalleRequestDto(
                trabajo, tarea, tareaAmbito, this.recolectarProperties);
        paramVentaOnlineIpod
            .setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
        paramVentaOnlineIpod.setTienda(iter.stream()
            .map(IdLocalizacionLocalDto::getId)
            .map(Integer::valueOf)
            .collect(Collectors.toList()));
        paramVentaOnlineIpod.setProducto(this.meta4IcmWsCalcIncomeSessionService
            .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
            .stream()
            .map(ConfiguracionProductoVentaResultItemDto::getIdProducto)
            .collect(Collectors.toList()));
        paramVentaOnlineIpod
            .setAgrupacion(PtrGroupSellerTypeEnum.OPERACION_FECHA_VENDEDOR_TIENDA_SECCION);
        paramVentaOnlineIpod.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());

        final CompletableFuture<PtrVentaOnlineIpodIndividualDetalleResponseDto> cfData = this.ptrVentaEcommerceAsyncService
            .ventaOnlineiPodIndividualDetalle(paramVentaOnlineIpod);
        AsyncUtils.exceptionally(cfData, cf, cfPersist);

        final PtrVentaOnlineIpodIndividualDetalleResponseDto data = AsyncUtils.get(cfData);

        if (CollectionUtils.isNotEmpty(data.getVentaOnlineIpodIndividual())) {
          AsyncUtils.checkAsyncAvaliable(cfPersist,
              this.ventaEcommerceProperties
                  .get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE)
                  .getFilter()
                  .getMaxPageSize());
          AsyncUtils.exceptionally(
              this.tareaLocalizacionPersonaVentaAsyncService
                  .savePtrVentaOnlineIpodIndividualDetalleResultItem(
                      data.getVentaOnlineIpodIndividual(), tarea),
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
  public void ventaRangoOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      final TareaDto tarea = runTarea.getTarea();
      final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId())
          .stream()
          .map(IdEmpresaDto::getStdIdLegEnt)
          .collect(Collectors.toList());
      for (final IdLocalizacionLocalPresupuestoDto iter : this.tareaLocalizacionHistoricoService
          .findTiendasPresupuestosByStdIdLegEntAndIdTarea(empresasAmbito, tarea.getId(),
              Collections.singletonList(TipoVentaConceptoChallengeEnum.IPOD.getId()))) {
        final PtrVentaOnlineIpodRequestDto paramVentaOnlineIpod = this.tareaMapper
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaOnlineIpodRequestDto(
                trabajo, tarea,
                tareaAmbito, iter);
        paramVentaOnlineIpod.setAgrupacion(PtrGroupTypeEnum.TIENDA_SECCION);
        paramVentaOnlineIpod.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
        paramVentaOnlineIpod
            .setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
        paramVentaOnlineIpod
            .setTienda(this.tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea(tarea.getId(),
                    iter.getIdTipoPresupuesto(),
                    iter.getFechaInicio(), iter.getFechaFin())
                .stream()
                .map(x -> Integer.valueOf(x.getId()))
                .collect(Collectors.toList()));
        paramVentaOnlineIpod.setProducto(this.meta4IcmWsCalcIncomeSessionService
            .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
            .stream()
            .map(ConfiguracionProductoVentaResultItemDto::getIdProducto)
            .collect(Collectors.toList()));
        final CompletableFuture<PtrVentaOnlineIpodResponseDto> cfData = this.ptrVentaEcommerceAsyncService
            .ventaOnlineiPod(paramVentaOnlineIpod);
        AsyncUtils.exceptionally(cfData, cf, cfPersist);
        final PtrVentaOnlineIpodResponseDto data = AsyncUtils.get(cfData);
        AsyncUtils.checkAsyncAvaliable(cfPersist, this.ventaEcommerceProperties
            .get(PtrPropertiesConstants.VENTA_ONLINE_IPOD)
            .getFilter()
            .getMaxPersistenceSize());
        AsyncUtils.exceptionally(
            this.tareaLocalizacionPresupuestoVentaAsyncService.savePtrVentaOnlineIpodResponse(data,
                iter,
                tarea),
            cf, cfPersist);
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }

  }

  @Override
  public void ventaRangoOnlineSintLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      final TareaDto tarea = runTarea.getTarea();
      final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId())
          .stream()
          .map(IdEmpresaDto::getStdIdLegEnt)
          .collect(Collectors.toList());
      for (final IdLocalizacionLocalPresupuestoDto iter : this.tareaLocalizacionHistoricoService
          .findTiendasPresupuestosByStdIdLegEntAndIdTarea(empresasAmbito, tarea.getId(),
              Collections.singletonList(TipoVentaConceptoChallengeEnum.SINT.getId()))) {
        final PtrVentaOnlinePickingRequestDto paramVentaOnlinePicking = this.tareaMapper
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaOnlinePickingRequestDto(
                trabajo, tarea,
                tareaAmbito, iter);
        paramVentaOnlinePicking.setAgrupacion(PtrGroupTypeEnum.TIENDA_SECCION);
        paramVentaOnlinePicking.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
        paramVentaOnlinePicking
            .setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
        paramVentaOnlinePicking
            .setTienda(this.tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea(tarea.getId(),
                    iter.getIdTipoPresupuesto(),
                    iter.getFechaInicio(), iter.getFechaFin())
                .stream()
                .map(x -> Integer.valueOf(x.getId()))
                .collect(Collectors.toList()));
        paramVentaOnlinePicking.setProducto(this.meta4IcmWsCalcIncomeSessionService
            .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
            .stream()
            .map(ConfiguracionProductoVentaResultItemDto::getIdProducto)
            .collect(Collectors.toList()));
        paramVentaOnlinePicking.setVentaPAT(PtrIncluirVentaPatEnum.TRUE.getValue());
        paramVentaOnlinePicking.setExcluirIpod(PtrExcluirIpodEnum.TRUE.getValue());

        final CompletableFuture<PtrVentaOnlinePickingResponseDto> cfData = this.ptrVentaEcommerceAsyncService
            .ventaOnlinePicking(paramVentaOnlinePicking);
        AsyncUtils.exceptionally(cfData, cf, cfPersist);

        final PtrVentaOnlinePickingResponseDto data = AsyncUtils.get(cfData);

        AsyncUtils.checkAsyncAvaliable(cfPersist, this.ventaEcommerceProperties
            .get(PtrPropertiesConstants.VENTA_ONLINE_PICKING)
            .getFilter()
            .getMaxPersistenceSize());
        AsyncUtils.exceptionally(
            this.tareaLocalizacionPresupuestoVentaAsyncService.savePtrVentaOnlinePickingResponse(
                data, iter,
                tarea),
            cf, cfPersist);
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(
      @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      final TareaDto tarea = runTarea.getTarea();
      final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId())
          .stream()
          .map(IdEmpresaDto::getStdIdLegEnt)
          .collect(Collectors.toList());
      for (final IdLocalizacionLocalPresupuestoDto iter : this.tareaLocalizacionHistoricoService
          .findTiendasPresupuestosByStdIdLegEntAndIdTarea(empresasAmbito, tarea.getId(),
              Collections.singletonList(TipoVentaConceptoChallengeEnum.ENTREGA_TIENDA.getId()))) {

        final PtrVentaOnlineEntregaTiendaRequestDto paramVentaOnlineEntregaTiendaRequest = this.tareaMapper
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaOnlineEntregaTiendaRequestDto(
                trabajo, tarea,
                tareaAmbito, iter);
        paramVentaOnlineEntregaTiendaRequest.setAgrupacion(PtrGroupTypeEnum.TIENDA_SECCION);
        paramVentaOnlineEntregaTiendaRequest.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
        paramVentaOnlineEntregaTiendaRequest
            .setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
        paramVentaOnlineEntregaTiendaRequest
            .setTienda(this.tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea(tarea.getId(),
                    iter.getIdTipoPresupuesto(),
                    iter.getFechaInicio(), iter.getFechaFin())
                .stream()
                .map(x -> Integer.valueOf(x.getId()))
                .collect(Collectors.toList()));
        paramVentaOnlineEntregaTiendaRequest.setProducto(this.meta4IcmWsCalcIncomeSessionService
            .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
            .stream()
            .map(ConfiguracionProductoVentaResultItemDto::getIdProducto)
            .collect(Collectors.toList()));

        final CompletableFuture<PtrVentaOnlineEntregaTiendaResponseDto> cfData = this.ptrVentaEcommerceAsyncService
            .ventaOnlineEntregaTienda(paramVentaOnlineEntregaTiendaRequest);
        AsyncUtils.exceptionally(cfData, cf, cfPersist);

        final PtrVentaOnlineEntregaTiendaResponseDto data = AsyncUtils.get(cfData);

        AsyncUtils.checkAsyncAvaliable(cfPersist, this.ventaEcommerceProperties
            .get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA)
            .getFilter()
            .getMaxPersistenceSize());
        AsyncUtils.exceptionally(
            this.tareaLocalizacionPresupuestoVentaAsyncService
                .savePtrVentaOnlineEntregaTiendaResponse(data,
                    iter, tarea),
            cf, cfPersist);
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTareaAndTareaAmbito(
      @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      final TareaDto tarea = runTarea.getTarea();
      final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId())
          .stream()
          .map(IdEmpresaDto::getStdIdLegEnt)
          .collect(Collectors.toList());
      for (final IdLocalizacionLocalPresupuestoDto iter : this.tareaLocalizacionHistoricoService
          .findTiendasPresupuestosByStdIdLegEntAndIdTarea(empresasAmbito, tarea.getId(),
              Collections.singletonList(TipoVentaConceptoChallengeEnum.ENTREGA_DOMICILIO.getId()))) {
        final PtrVentaOnlineEntregaDomicilioRequestDto paramVentaOnlineEntregaTiendaRequest = this.tareaMapper
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
                trabajo, tarea,
                tareaAmbito, iter);
        paramVentaOnlineEntregaTiendaRequest.setAgrupacion(PtrGroupTypeEnum.TIENDA_SECCION);
        paramVentaOnlineEntregaTiendaRequest.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
        paramVentaOnlineEntregaTiendaRequest
            .setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
        paramVentaOnlineEntregaTiendaRequest.setProducto(this.meta4IcmWsCalcIncomeSessionService
            .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
            .stream()
            .map(ConfiguracionProductoVentaResultItemDto::getIdProducto)
            .collect(Collectors.toList()));

        final CompletableFuture<PtrVentaOnlineEntregaDomicilioResponseDto> cfData = this.ptrVentaEcommerceAsyncService
            .ventaOnlineEntregaDomicilio(paramVentaOnlineEntregaTiendaRequest);
        AsyncUtils.exceptionally(cfData, cf, cfPersist);

        final PtrVentaOnlineEntregaDomicilioResponseDto data = AsyncUtils.get(cfData);

        AsyncUtils.checkAsyncAvaliable(cfPersist, this.ventaEcommerceProperties
            .get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO)
            .getFilter()
            .getMaxPersistenceSize());
        AsyncUtils.exceptionally(
            this.tareaLocalizacionPresupuestoVentaAsyncService
                .savePtrVentaOnlineEntregaDomicilioResponse(
                    data,
                    iter, tarea),
            cf, cfPersist);
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
