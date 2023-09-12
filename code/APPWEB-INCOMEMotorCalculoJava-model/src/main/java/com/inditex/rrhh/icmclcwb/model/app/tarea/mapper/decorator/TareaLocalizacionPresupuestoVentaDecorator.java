package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoChallengeEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoVentaConceptoChallengeService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPresupuesto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConceptoChallenge;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuestoVenta;

import com.google.common.util.concurrent.AtomicDouble;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaLocalizacionPresupuestoVentaDecorator extends TareaLocalizacionPresupuestoVentaMapper {

  @Autowired
  private TareaLocalizacionPresupuestoVentaMapper delegate;

  @Autowired
  private TipoPresupuestoService tipoPresupuestoService;

  @Autowired
  private TipoVentaConceptoChallengeService tipoVentaConceptoChallengeService;

  @Autowired
  private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  @Override
  public List<TareaLocalizacionPresupuestoVenta> ventaCongeladaResultItemDtoToTareaLocalizacionPresupuestoVenta(
      final List<VentaCongeladaResultItemDto> src, final TareaDto tarea) {
    final List<TareaLocalizacionPresupuestoVenta> result = new ArrayList<>();
    if (src != null) {
      src.forEach(x -> {
        final TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = this.delegate
            .ventaCongeladaResultItemDtoToTareaLocalizacionPresupuestoVenta(x, tarea);
        final TipoPresupuestoDto presupuesto = this.tipoPresupuestoService
            .findByIcmIdTpPresupuesto(x.getIdTpPresupuesto());
        final TipoVentaConceptoChallengeDto concepto = this.tipoVentaConceptoChallengeService
            .findByIcmIdConceptoVenta(x.getIdConceptoVenta());
        tareaLocalizacionPresupuestoVenta.setActivo(Boolean.TRUE);
        tareaLocalizacionPresupuestoVenta
            .setTipoPresupuesto(TipoPresupuesto.builder().id(presupuesto.getId()).build());
        tareaLocalizacionPresupuestoVenta
            .setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(concepto.getId()).build());
        if (x.getIdSeccion().equals(AppConstants.SECCION_4.toString())) {
          if (x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.VENTA_CAJA.getIdMeta4())) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_CONGELADA_FISICA_CAJA_LOCALIZACION.getId())
                .build());
          }
          if (x.getIdConceptoVenta()
              .equals(TipoVentaConceptoChallengeEnum.DEVOLUCIONES_OTRAS_TIENDAS.getIdMeta4())) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_CONGELADA_FISICA_DEVOLUCION_LOCALIZACION.getId())
                .build());
          }
          if (x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.IPOD.getIdMeta4())) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_IPOD_LOCALIZACION.getId())
                .build());
          }
          if (x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.SINT.getIdMeta4())) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_SINT_LOCALIZACION.getId())
                .build());
          }
          if (x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.ENTREGA_TIENDA.getIdMeta4())) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId())
                .build());
          }
          if (x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.ENTREGA_DOMICILIO.getIdMeta4())) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId())
                .build());
          }
        }

        if (x.getIdSeccion().equals(AppConstants.SECCION_1.toString())
            || x.getIdSeccion().equals(AppConstants.SECCION_2.toString())
            || x.getIdSeccion().equals(AppConstants.SECCION_3.toString())) {
          if (x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.VENTA_CAJA.getIdMeta4())) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_CONGELADA_FISICA_CAJA_LOCALIZACION_SECCION.getId())
                .build());
          }
          if (x.getIdConceptoVenta()
              .equals(TipoVentaConceptoChallengeEnum.DEVOLUCIONES_OTRAS_TIENDAS.getIdMeta4())) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_CONGELADA_FISICA_DEVOLUCION_LOCALIZACION_SECCION.getId())
                .build());
          }
          if (x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.IPOD.getIdMeta4())) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_IPOD_LOCALIZACION_SECCION.getId())
                .build());
          }
          if (x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.SINT.getIdMeta4())) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_SINT_LOCALIZACION_SECCION.getId())
                .build());
          }
          if (x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.ENTREGA_TIENDA.getIdMeta4())) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId())
                .build());
          }
          if (x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.ENTREGA_DOMICILIO.getIdMeta4())) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId())
                .build());
          }
        }

        result.add(tareaLocalizacionPresupuestoVenta);
      });
    }
    return result;
  }

  @Override
  public List<TareaLocalizacionPresupuestoVenta> ventaTotalizadoResponseItemDtoToTareaLocalizacionPresupuestoVenta(
      final List<PtrVentaTotalizadoResultItemDto> src, final IdLocalizacionLocalPresupuestoDto iter,
      final TareaDto tarea) {
    final List<TareaLocalizacionPresupuestoVenta> dtoList = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.stream().forEach(item -> {
        final AtomicDouble importeSinIva = new AtomicDouble(0);
        final AtomicDouble importeConIva = new AtomicDouble(0);
        item.getListaSeccion().stream().forEach(venta -> {
          final List<String> ordinal = this.tareaLocalizacionPresupuestoService
              .findLocalizacionOrdinalTarea(tarea.getId(), item.getTienda(), venta.getSeccion(),
                  iter.getFechaInicio(), iter.getFechaFin(), iter.getIdTipoPresupuesto());
          ordinal.stream().forEach(a -> {
            final TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = this.delegate
                .responseItemDtoToTareaLocalizacionPresupuestoVenta(item, iter, tarea);
            tareaLocalizacionPresupuestoVenta.setOrdinal(Integer.valueOf(a));
            tareaLocalizacionPresupuestoVenta.setCclIdSeccion(String.valueOf(venta.getSeccion()));
            tareaLocalizacionPresupuestoVenta
                .setImporteSinImpuestos(venta.getImporteSinIVA().doubleValue());
            tareaLocalizacionPresupuestoVenta
                .setImporteConImpuestos(venta.getImporteConIVA().doubleValue());
            tareaLocalizacionPresupuestoVenta
                .setTipoPresupuesto(TipoPresupuesto.builder().id(iter.getIdTipoPresupuesto()).build());
            tareaLocalizacionPresupuestoVenta.setActivo(Boolean.TRUE);
            if (item.getOperacion().equals(AppConstants.OPERACION_VENTA_CAJA)) {
              tareaLocalizacionPresupuestoVenta
                  .setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder()
                      .id(TipoVentaConceptoChallengeEnum.VENTA_CAJA.getId())
                      .build());
              tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                  .id(TipoDatoEnum.VENTA_RANGO_FISICA_CAJA_LOCALIZACION_SECCION.getId())
                  .build());
            }
            if (item.getOperacion().equals(AppConstants.OPERACION_DEVOLUCION_OTRAS_TIENDAS)) {
              tareaLocalizacionPresupuestoVenta
                  .setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder()
                      .id(TipoVentaConceptoChallengeEnum.DEVOLUCIONES_OTRAS_TIENDAS.getId())
                      .build());
              tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                  .id(TipoDatoEnum.VENTA_RANGO_FISICA_DEVOLUCION_LOCALIZACION_SECCION.getId())
                  .build());
            }
            if (item.getOperacion().equals(AppConstants.OPERACION_DEVOLUCION_VENTA_ORIGINAL_OTRA_TIENDA)) {
              tareaLocalizacionPresupuestoVenta
                  .setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder()
                      .id(TipoVentaConceptoChallengeEnum.DEVOLUCIONES_OTRAS_TIENDAS.getId())
                      .build());
              tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                  .id(TipoDatoEnum.VENTA_RANGO_FISICA_DEVOLUCION_VENTA_ORIGINAL_OTRA_TIENDA_LOCALIZACION_SECCION
                      .getId())
                  .build());
            }
            dtoList.add(tareaLocalizacionPresupuestoVenta);
          });
          importeSinIva.getAndAdd(venta.getImporteSinIVA().doubleValue());
          importeConIva.getAndAdd(venta.getImporteConIVA().doubleValue());
        });

        final List<String> ordinalSeccion4 = this.tareaLocalizacionPresupuestoService
            .findLocalizacionOrdinalTarea(tarea.getId(), item.getTienda(), AppConstants.SECCION_4,
                iter.getFechaInicio(), iter.getFechaFin(), iter.getIdTipoPresupuesto());
        ordinalSeccion4.stream().forEach(a -> {
          final TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = this.delegate
              .responseItemDtoToTareaLocalizacionPresupuestoVenta(item, iter, tarea);
          tareaLocalizacionPresupuestoVenta.setOrdinal(Integer.valueOf(a));
          tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(importeConIva.doubleValue());
          tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(importeSinIva.doubleValue());
          tareaLocalizacionPresupuestoVenta
              .setTipoPresupuesto(TipoPresupuesto.builder().id(iter.getIdTipoPresupuesto()).build());
          tareaLocalizacionPresupuestoVenta.setActivo(Boolean.TRUE);
          tareaLocalizacionPresupuestoVenta.setCclIdSeccion(AppConstants.SECCION_4.toString());

          if (item.getOperacion().equals(AppConstants.OPERACION_VENTA_CAJA)) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(
                TipoDato.builder()
                    .id(TipoDatoEnum.VENTA_RANGO_FISICA_CAJA_LOCALIZACION.getId())
                    .build());
            tareaLocalizacionPresupuestoVenta
                .setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder()
                    .id(TipoVentaConceptoChallengeEnum.VENTA_CAJA.getId())
                    .build());
          }
          if (item.getOperacion().equals(AppConstants.OPERACION_DEVOLUCION_OTRAS_TIENDAS)) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_FISICA_DEVOLUCION_LOCALIZACION.getId())
                .build());
            tareaLocalizacionPresupuestoVenta
                .setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder()
                    .id(TipoVentaConceptoChallengeEnum.DEVOLUCIONES_OTRAS_TIENDAS.getId())
                    .build());
          }
          if (item.getOperacion().equals(AppConstants.OPERACION_DEVOLUCION_VENTA_ORIGINAL_OTRA_TIENDA)) {
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_FISICA_DEVOLUCION_VENTA_ORIGINAL_OTRA_TIENDA_LOCALIZACION
                    .getId())
                .build());
            tareaLocalizacionPresupuestoVenta
                .setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder()
                    .id(TipoVentaConceptoChallengeEnum.DEVOLUCIONES_OTRAS_TIENDAS.getId())
                    .build());
          }
          dtoList.add(tareaLocalizacionPresupuestoVenta);
        });
      });
    }
    return dtoList;
  }

  @Override
  public List<TareaLocalizacionPresupuestoVenta> ventaOnlineIpodResponseItemDtoToTareaLocalizacionPresupuestoVenta(
      final List<PtrVentaOnlineIpodResultItemDto> src, final IdLocalizacionLocalPresupuestoDto iter,
      final TareaDto tarea) {
    final List<TareaLocalizacionPresupuestoVenta> dtoList = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.stream().forEach(item -> {
        final AtomicDouble importeSinIva = new AtomicDouble(0);
        final AtomicDouble importeConIva = new AtomicDouble(0);
        item.getListaSeccion().stream().forEach(venta -> {
          final List<String> ordinal = this.tareaLocalizacionPresupuestoService
              .findLocalizacionOrdinalTarea(tarea.getId(), item.getTienda(), venta.getSeccion(),
                  iter.getFechaInicio(), iter.getFechaFin(), iter.getIdTipoPresupuesto());
          ordinal.stream().forEach(a -> {
            final TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = this.delegate
                .responseItemDtoToTareaLocalizacionPresupuestoVenta(item, iter, tarea);
            tareaLocalizacionPresupuestoVenta.setCclIdSeccion(String.valueOf(venta.getSeccion()));
            tareaLocalizacionPresupuestoVenta
                .setImporteSinImpuestos(venta.getImporteSinIVA().doubleValue());
            tareaLocalizacionPresupuestoVenta
                .setImporteConImpuestos(venta.getImporteConIVA().doubleValue());
            tareaLocalizacionPresupuestoVenta
                .setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder()
                    .id(TipoVentaConceptoChallengeEnum.IPOD.getId())
                    .build());
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_ONLINE_IPOD_LOCALIZACION_SECCION.getId())
                .build());
            tareaLocalizacionPresupuestoVenta
                .setTipoPresupuesto(TipoPresupuesto.builder().id(iter.getIdTipoPresupuesto()).build());
            tareaLocalizacionPresupuestoVenta.setActivo(Boolean.TRUE);
            tareaLocalizacionPresupuestoVenta.setOrdinal(Integer.valueOf(a));
            dtoList.add(tareaLocalizacionPresupuestoVenta);

          });
          importeSinIva.getAndAdd(venta.getImporteSinIVA().doubleValue());
          importeConIva.getAndAdd(venta.getImporteConIVA().doubleValue());
        });
        final List<String> ordinalSeccion4 = this.tareaLocalizacionPresupuestoService
            .findLocalizacionOrdinalTarea(tarea.getId(), item.getTienda(), AppConstants.SECCION_4,
                iter.getFechaInicio(), iter.getFechaFin(), iter.getIdTipoPresupuesto());
        ordinalSeccion4.stream().forEach(a -> {
          final TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = this.delegate
              .responseItemDtoToTareaLocalizacionPresupuestoVenta(item, iter, tarea);
          tareaLocalizacionPresupuestoVenta.setOrdinal(Integer.valueOf(a));
          tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(importeConIva.doubleValue());
          tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(importeSinIva.doubleValue());
          tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(
              TipoVentaConceptoChallenge.builder()
                  .id(TipoVentaConceptoChallengeEnum.IPOD.getId())
                  .build());
          tareaLocalizacionPresupuestoVenta.setTipoDato(
              TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_ONLINE_IPOD_LOCALIZACION.getId()).build());
          tareaLocalizacionPresupuestoVenta
              .setTipoPresupuesto(TipoPresupuesto.builder().id(iter.getIdTipoPresupuesto()).build());
          tareaLocalizacionPresupuestoVenta.setActivo(Boolean.TRUE);
          tareaLocalizacionPresupuestoVenta.setCclIdSeccion(AppConstants.SECCION_4.toString());

          dtoList.add(tareaLocalizacionPresupuestoVenta);
        });
      });
    }
    return dtoList;
  }

  @Override
  public List<TareaLocalizacionPresupuestoVenta> ventaOnlinePickingResponseItemDtoToTareaLocalizacionPresupuestoVenta(
      final List<PtrVentaOnlinePickingResultItemDto> src, final IdLocalizacionLocalPresupuestoDto iter,
      final TareaDto tarea) {
    final List<TareaLocalizacionPresupuestoVenta> dtoList = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.stream().forEach(item -> {
        final AtomicDouble importeSinIva = new AtomicDouble(0);
        final AtomicDouble importeConIva = new AtomicDouble(0);
        item.getListaSeccion().stream().forEach(venta -> {
          final List<String> ordinal = this.tareaLocalizacionPresupuestoService
              .findLocalizacionOrdinalTarea(tarea.getId(), item.getTienda(), venta.getSeccion(),
                  iter.getFechaInicio(), iter.getFechaFin(), iter.getIdTipoPresupuesto());
          ordinal.stream().forEach(a -> {
            final TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = this.delegate
                .responseItemDtoToTareaLocalizacionPresupuestoVenta(item, iter, tarea);
            tareaLocalizacionPresupuestoVenta.setCclIdSeccion(String.valueOf(venta.getSeccion()));
            tareaLocalizacionPresupuestoVenta
                .setImporteSinImpuestos(venta.getImporteSinIVA().doubleValue());
            tareaLocalizacionPresupuestoVenta
                .setImporteConImpuestos(venta.getImporteConIVA().doubleValue());
            tareaLocalizacionPresupuestoVenta
                .setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder()
                    .id(TipoVentaConceptoChallengeEnum.SINT.getId())
                    .build());
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_ONLINE_SINT_LOCALIZACION_SECCION.getId())
                .build());
            tareaLocalizacionPresupuestoVenta
                .setTipoPresupuesto(TipoPresupuesto.builder().id(iter.getIdTipoPresupuesto()).build());
            tareaLocalizacionPresupuestoVenta.setActivo(Boolean.TRUE);
            tareaLocalizacionPresupuestoVenta.setOrdinal(Integer.valueOf(a));

            dtoList.add(tareaLocalizacionPresupuestoVenta);
          });
          importeSinIva.getAndAdd(venta.getImporteSinIVA().doubleValue());
          importeConIva.getAndAdd(venta.getImporteConIVA().doubleValue());
        });
        final List<String> ordinalSeccion4 = this.tareaLocalizacionPresupuestoService
            .findLocalizacionOrdinalTarea(tarea.getId(), item.getTienda(), AppConstants.SECCION_4,
                iter.getFechaInicio(), iter.getFechaFin(), iter.getIdTipoPresupuesto());
        ordinalSeccion4.stream().forEach(a -> {
          final TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = this.delegate
              .responseItemDtoToTareaLocalizacionPresupuestoVenta(item, iter, tarea);
          tareaLocalizacionPresupuestoVenta.setOrdinal(Integer.valueOf(a));
          tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(importeConIva.doubleValue());
          tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(importeSinIva.doubleValue());
          tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(
              TipoVentaConceptoChallenge.builder()
                  .id(TipoVentaConceptoChallengeEnum.SINT.getId())
                  .build());
          tareaLocalizacionPresupuestoVenta.setTipoDato(
              TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_ONLINE_SINT_LOCALIZACION.getId()).build());
          tareaLocalizacionPresupuestoVenta
              .setTipoPresupuesto(TipoPresupuesto.builder().id(iter.getIdTipoPresupuesto()).build());
          tareaLocalizacionPresupuestoVenta.setActivo(Boolean.TRUE);
          tareaLocalizacionPresupuestoVenta.setCclIdSeccion(AppConstants.SECCION_4.toString());

          dtoList.add(tareaLocalizacionPresupuestoVenta);
        });
      });
    }
    return dtoList;
  }

  @Override
  public List<TareaLocalizacionPresupuestoVenta> ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionPresupuestoVenta(
      final List<PtrVentaOnlineEntregaTiendaResultItemDto> src, final IdLocalizacionLocalPresupuestoDto iter,
      final TareaDto tarea) {
    final List<TareaLocalizacionPresupuestoVenta> dtoList = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.stream().forEach(item -> {
        final AtomicDouble importeSinIva = new AtomicDouble(0);
        final AtomicDouble importeConIva = new AtomicDouble(0);
        item.getListaSeccion().stream().forEach(venta -> {
          final List<String> ordinal = this.tareaLocalizacionPresupuestoService
              .findLocalizacionOrdinalTarea(tarea.getId(), item.getTienda(), venta.getSeccion(),
                  iter.getFechaInicio(), iter.getFechaFin(), iter.getIdTipoPresupuesto());
          ordinal.stream().forEach(a -> {
            final TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = this.delegate
                .responseItemDtoToTareaLocalizacionPresupuestoVenta(item, iter, tarea);
            tareaLocalizacionPresupuestoVenta.setCclIdSeccion(String.valueOf(venta.getSeccion()));
            tareaLocalizacionPresupuestoVenta
                .setImporteSinImpuestos(venta.getImporteSinIVA().doubleValue());
            tareaLocalizacionPresupuestoVenta
                .setImporteConImpuestos(venta.getImporteConIVA().doubleValue());
            tareaLocalizacionPresupuestoVenta
                .setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder()
                    .id(TipoVentaConceptoChallengeEnum.ENTREGA_TIENDA.getId())
                    .build());
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId())
                .build());
            tareaLocalizacionPresupuestoVenta
                .setTipoPresupuesto(TipoPresupuesto.builder().id(iter.getIdTipoPresupuesto()).build());
            tareaLocalizacionPresupuestoVenta.setActivo(Boolean.TRUE);
            tareaLocalizacionPresupuestoVenta.setOrdinal(Integer.valueOf(a));

            dtoList.add(tareaLocalizacionPresupuestoVenta);
          });
          importeSinIva.getAndAdd(venta.getImporteSinIVA().doubleValue());
          importeConIva.getAndAdd(venta.getImporteConIVA().doubleValue());
        });
        final List<String> ordinalSeccion4 = this.tareaLocalizacionPresupuestoService
            .findLocalizacionOrdinalTarea(tarea.getId(), item.getTienda(), AppConstants.SECCION_4,
                iter.getFechaInicio(), iter.getFechaFin(), iter.getIdTipoPresupuesto());
        ordinalSeccion4.stream().forEach(a -> {
          final TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = this.delegate
              .responseItemDtoToTareaLocalizacionPresupuestoVenta(item, iter, tarea);
          tareaLocalizacionPresupuestoVenta.setOrdinal(Integer.valueOf(a));
          tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(importeConIva.doubleValue());
          tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(importeSinIva.doubleValue());
          tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder()
              .id(TipoVentaConceptoChallengeEnum.ENTREGA_TIENDA.getId())
              .build());
          tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
              .id(TipoDatoEnum.VENTA_RANGO_ONLINE_ENTREGATIENDA_LOCALIZACION.getId())
              .build());
          tareaLocalizacionPresupuestoVenta
              .setTipoPresupuesto(TipoPresupuesto.builder().id(iter.getIdTipoPresupuesto()).build());
          tareaLocalizacionPresupuestoVenta.setActivo(Boolean.TRUE);
          tareaLocalizacionPresupuestoVenta.setCclIdSeccion(AppConstants.SECCION_4.toString());

          dtoList.add(tareaLocalizacionPresupuestoVenta);
        });
      });
    }
    return dtoList;
  }

  @Override
  public List<TareaLocalizacionPresupuestoVenta> ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionPresupuestoVenta(
      final List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, final IdLocalizacionLocalPresupuestoDto iter,
      final TareaDto tarea) {
    final List<TareaLocalizacionPresupuestoVenta> dtoList = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.stream().forEach(item -> {
        final AtomicDouble importeSinIva = new AtomicDouble(0);
        final AtomicDouble importeConIva = new AtomicDouble(0);
        item.getListaSeccion().stream().forEach(venta -> {
          final List<String> ordinal = this.tareaLocalizacionPresupuestoService
              .findLocalizacionOrdinalTarea(tarea.getId(), item.getTienda(), venta.getSeccion(),
                  iter.getFechaInicio(), iter.getFechaFin(), iter.getIdTipoPresupuesto());
          ordinal.stream().forEach(a -> {
            final TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = this.delegate
                .responseItemDtoToTareaLocalizacionPresupuestoVenta(item, iter, tarea);
            tareaLocalizacionPresupuestoVenta.setCclIdSeccion(String.valueOf(venta.getSeccion()));
            tareaLocalizacionPresupuestoVenta
                .setImporteSinImpuestos(venta.getImporteSinIVA().doubleValue());
            tareaLocalizacionPresupuestoVenta
                .setImporteConImpuestos(venta.getImporteConIVA().doubleValue());
            tareaLocalizacionPresupuestoVenta
                .setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder()
                    .id(TipoVentaConceptoChallengeEnum.ENTREGA_DOMICILIO.getId())
                    .build());
            tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
                .id(TipoDatoEnum.VENTA_RANGO_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId())
                .build());
            tareaLocalizacionPresupuestoVenta
                .setTipoPresupuesto(TipoPresupuesto.builder().id(iter.getIdTipoPresupuesto()).build());
            tareaLocalizacionPresupuestoVenta.setActivo(Boolean.TRUE);
            tareaLocalizacionPresupuestoVenta.setOrdinal(Integer.valueOf(a));

            dtoList.add(tareaLocalizacionPresupuestoVenta);
          });
          importeSinIva.getAndAdd(venta.getImporteSinIVA().doubleValue());
          importeConIva.getAndAdd(venta.getImporteConIVA().doubleValue());
        });
        final List<String> ordinalSeccion4 = this.tareaLocalizacionPresupuestoService
            .findLocalizacionOrdinalTarea(tarea.getId(), item.getTienda(), AppConstants.SECCION_4,
                iter.getFechaInicio(), iter.getFechaFin(), iter.getIdTipoPresupuesto());
        ordinalSeccion4.stream().forEach(a -> {
          final TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = this.delegate
              .responseItemDtoToTareaLocalizacionPresupuestoVenta(item, iter, tarea);
          tareaLocalizacionPresupuestoVenta.setOrdinal(Integer.valueOf(a));
          tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(importeConIva.doubleValue());
          tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(importeSinIva.doubleValue());
          tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder()
              .id(TipoVentaConceptoChallengeEnum.ENTREGA_DOMICILIO.getId())
              .build());
          tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder()
              .id(TipoDatoEnum.VENTA_RANGO_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId())
              .build());
          tareaLocalizacionPresupuestoVenta
              .setTipoPresupuesto(TipoPresupuesto.builder().id(iter.getIdTipoPresupuesto()).build());
          tareaLocalizacionPresupuestoVenta.setActivo(Boolean.TRUE);
          tareaLocalizacionPresupuestoVenta.setCclIdSeccion(AppConstants.SECCION_4.toString());

          dtoList.add(tareaLocalizacionPresupuestoVenta);
        });
      });
    }
    return dtoList;
  }

}
