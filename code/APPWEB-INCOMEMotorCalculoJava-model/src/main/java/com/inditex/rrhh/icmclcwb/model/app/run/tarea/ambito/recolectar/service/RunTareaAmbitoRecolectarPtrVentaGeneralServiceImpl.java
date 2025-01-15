package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoChallengeEnum;
import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionVentaAsyncService;
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
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrAgruparSeccionEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaAmbitoRecolectarPtrVentaGeneralServiceImpl
    implements RunTareaAmbitoRecolectarPtrVentaGeneralService {

  protected final Map<String, PtrPropertiesDto> ventaGeneralProperties;

  private final TareaMapper tareaMapper;

  private final RecolectarPropertiesDto recolectarProperties;

  private final PtrVentaGeneralAsyncService ptrVentaGeneralAsyncService;

  private final TareaLocalizacionVentaAsyncService tareaLocalizacionVentaAsyncService;

  private final TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  private final TareaAgrupacionVentaAsyncService tareaAgrupacionVentaAsyncService;

  private final TareaAgrupacionCadenaService tareaAgrupacionCadenaService;

  private final TareaLocalizacionPresupuestoVentaAsyncService tareaLocalizacionPresupuestoVentaAsyncService;

  private final TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  private final TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  private final Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  @Override
  public void ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final PeriodoDto periodo = this.tareaLocalizacionPresupuestoService
          .findPeriodoPresupuestoYTrabajo(tarea.getId());
      final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId())
          .stream()
          .map(IdEmpresaDto::getStdIdLegEnt)
          .collect(Collectors.toList());
      for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
          this.tareaLocalizacionHistoricoService
              .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(tarea.getId(),
                  tareaAmbito.getCclIdOrigen(), empresasAmbito),
          this.ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO)
              .getFilter()
              .getMaxPageSize())) {
        final PtrVentaTotalizadoRequestDto request = this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoPeriodoDtoToPtrVentaTotalizadoRequestDto(tarea,
                tareaAmbito, periodo, this.recolectarProperties);
        request.setTienda(iter.stream()
            .map(IdLocalizacionLocalDto::getId)
            .map(Integer::valueOf)
            .collect(Collectors.toList()));
        request.setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
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
  public void ventaFisicaCadenaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId())
          .stream()
          .map(IdEmpresaDto::getStdIdLegEnt)
          .collect(Collectors.toList());
      final PeriodoDto periodo = this.tareaLocalizacionPresupuestoService
          .findPeriodoPresupuestoYTrabajo(tarea.getId());
      final List<TareaAgrupacionCadenasDto> agrupaciones = this.tareaAgrupacionCadenaService
          .findAgrupacionesByTarea(tarea);
      final List<IdCadenaDto> cadenas = this.tareaLocalizacionHistoricoService
          .findIdCadenaDtoByIdTareaAndCclIdOrigen(tarea.getId(), tareaAmbito.getCclIdOrigen(),
              TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_VENTA.getId());
      if (CollectionUtils.isNotEmpty(cadenas)) {

        final PtrVentaTotalizadoRequestDto request = this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoIdCadenaDtoToPtrVentaTotalizadoRequestDto(
                tarea, tareaAmbito, periodo, this.recolectarProperties, cadenas);

        request.setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_CADENA);
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
            this.tareaAgrupacionVentaAsyncService.savePtrVentaTotalizadoResponse(data, tarea, agrupaciones),
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
  public void ventaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito) {
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
              Collections.singletonList(TipoVentaConceptoChallengeEnum.VENTA_CAJA.getId()))) {
        final PtrVentaTotalizadoRequestDto request = this.tareaMapper
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaTotalizadoRequestDto(
                trabajo, tarea,
                tareaAmbito, iter);
        request
            .setTienda(this.tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea(tarea.getId(),
                    iter.getIdTipoPresupuesto(),
                    iter.getFechaInicio(), iter.getFechaFin())
                .stream()
                .map(x -> Integer.valueOf(x.getId()))
                .collect(Collectors.toList()));
        request.setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
        request.setAgrupacion(PtrGroupTypeEnum.OPERACION_TIENDA_SECCION);
        request.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
        request.setOperacion(PtrConstants.OPERACION_VENTA_CAJA);
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
            this.tareaLocalizacionPresupuestoVentaAsyncService.savePtrVentaTotalizadoResponse(data,
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
  public void devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito) {
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
              Collections.singletonList(
                  TipoVentaConceptoChallengeEnum.DEVOLUCIONES_OTRAS_TIENDAS.getId()))) {
        final PtrVentaTotalizadoRequestDto request = this.tareaMapper
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaTotalizadoRequestDto(
                trabajo, tarea,
                tareaAmbito, iter);
        request
            .setTienda(this.tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea(tarea.getId(),
                    iter.getIdTipoPresupuesto(),
                    iter.getFechaInicio(), iter.getFechaFin())
                .stream()
                .map(x -> Integer.valueOf(x.getId()))
                .collect(Collectors.toList()));
        request.setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
        request.setAgrupacion(PtrGroupTypeEnum.OPERACION_TIENDA_SECCION);
        request.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
        request.setOperacion(PtrConstants.OPERACION_DEVOLUCION_OTRAS_TIENDAS);
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
            this.tareaLocalizacionPresupuestoVentaAsyncService.savePtrVentaTotalizadoResponse(data,
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
  public void devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(
      @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito) {
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
              Collections.singletonList(
                  TipoVentaConceptoChallengeEnum.DEVOLUCIONES_OTRAS_TIENDAS.getId()))) {
        final PtrVentaTotalizadoRequestDto request = this.tareaMapper
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaTotalizadoRequestDto(
                trabajo, tarea,
                tareaAmbito, iter);
        request
            .setTienda(this.tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea(tarea.getId(),
                    iter.getIdTipoPresupuesto(),
                    iter.getFechaInicio(), iter.getFechaFin())
                .stream()
                .map(x -> Integer.valueOf(x.getId()))
                .collect(Collectors.toList()));
        request.setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
        request.setAgrupacion(PtrGroupTypeEnum.OPERACION_TIENDA_SECCION);
        request.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
        request.setOperacion(PtrConstants.OPERACION_DEVOLUCION_VENTA_ORIGINAL_OTRA_TIENDA);
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
            this.tareaLocalizacionPresupuestoVentaAsyncService.savePtrVentaTotalizadoResponse(data,
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
  public void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(
      @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final PeriodoDto periodo = this.tareaLocalizacionPresupuestoService
          .findPeriodoPresupuestoYTrabajo(tarea.getId());
      final List<IdCadenaDto> cadenas = this.tareaLocalizacionHistoricoService
          .findIdCadenaDtoByIdTareaAndCclIdOrigen(tarea.getId(), tareaAmbito.getCclIdOrigen(),
              TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId());
      if (CollectionUtils.isNotEmpty(cadenas)) {

        final PtrVentaTotalizadoRequestDto request = this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoIdCadenaDtoToPtrVentaTotalizadoRequestDto(
                tarea, tareaAmbito, periodo, this.recolectarProperties, cadenas);

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

}
