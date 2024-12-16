package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

import com.google.common.util.concurrent.AtomicDouble;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaLocalizacionVentaDecorator extends TareaLocalizacionVentaMapper {

  @Autowired
  private TareaLocalizacionVentaMapper delegate;

  @Override
  public List<TareaLocalizacionVenta> ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(
      final List<PtrVentaTotalizadoResultItemDto> src, final TareaDto tarea,
      final Integer tipoDatoLocalizacionSeccion,
      final Integer tipoDatoLocalizacion) {
    return src.stream()
        .flatMap(e -> this.genericMapper(tarea, tipoDatoLocalizacionSeccion, tipoDatoLocalizacion, e.getTienda(),
            e.getCadena(), e.getFecha(), e.getListaSeccion())
            .stream())
        .collect(Collectors.toList());
  }

  @Override
  public List<TareaLocalizacionVenta> ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(
      final List<PtrVentaTotalizadoResultItemDto> src, final TareaDto tarea, final Integer tipoDatoLocalizacion) {
    return src.stream()
        .map(e -> this.delegate.responseItemDtoToTareaLocalizacionVenta(e, tarea, tipoDatoLocalizacion))
        .collect(Collectors.toList());
  }

  @Override
  public List<TareaLocalizacionVenta> ventaOnlineIpodResponseItemDtoToTareaLocalizacionVenta(
      final List<PtrVentaOnlineIpodResultItemDto> src, final TareaDto tarea,
      final Integer tipoDatoLocalizacionSeccion,
      final Integer tipoDatoLocalizacion) {
    return src.stream()
        .flatMap(e -> this.genericMapper(tarea, tipoDatoLocalizacionSeccion, tipoDatoLocalizacion, e.getTienda(),
            e.getCadena(), e.getFecha(), e.getListaSeccion())
            .stream())
        .collect(Collectors.toList());
  }

  @Override
  public List<TareaLocalizacionVenta> ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionVenta(
      final List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, final TareaDto tarea,
      final Integer tipoDatoLocalizacionSeccion, final Integer tipoDatoLocalizacion) {
    return src.stream()
        .flatMap(e -> this.genericMapper(tarea, tipoDatoLocalizacionSeccion, tipoDatoLocalizacion, e.getTienda(),
            e.getCadena(), e.getFecha(), e.getListaSeccion())
            .stream())
        .collect(Collectors.toList());
  }

  @Override
  public List<TareaLocalizacionVenta> ventaOnlinePickingResponseItemDtoToTareaLocalizacionVenta(
      final List<PtrVentaOnlinePickingResultItemDto> src, final TareaDto tarea,
      final Integer tipoDatoLocalizacionSeccion,
      final Integer tipoDatoLocalizacion) {
    return src.stream()
        .flatMap(e -> this.genericMapper(tarea, tipoDatoLocalizacionSeccion, tipoDatoLocalizacion, e.getTienda(),
            e.getCadena(), e.getFecha(), e.getListaSeccion())
            .stream())
        .collect(Collectors.toList());
  }

  @Override
  public List<TareaLocalizacionVenta> ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionVenta(
      final List<PtrVentaOnlineEntregaTiendaResultItemDto> src, final TareaDto tarea,
      final Integer tipoDatoLocalizacionSeccion,
      final Integer tipoDatoLocalizacion) {
    return src.stream()
        .flatMap(e -> this.genericMapper(tarea, tipoDatoLocalizacionSeccion, tipoDatoLocalizacion, e.getTienda(),
            e.getCadena(), e.getFecha(), e.getListaSeccion())
            .stream())
        .collect(Collectors.toList());
  }

  @Override
  public List<TareaLocalizacionVenta> ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionVenta(
      final List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, final TareaDto tarea,
      final Integer tipoDatoLocalizacionSeccion,
      final Integer tipoDatoLocalizacion) {
    return src.stream()
        .flatMap(e -> this.genericMapper(tarea, tipoDatoLocalizacionSeccion, tipoDatoLocalizacion, e.getTienda(),
            e.getCadena(), e.getFecha(), e.getListaSeccion())
            .stream())
        .collect(Collectors.toList());
  }

  @Override
  public List<TareaLocalizacionVenta> ventaIndividualDetalleReponseItemsDtoToTareaLocalizacionVenta(
      final List<PtrVentaIndividualDetalleResultItemDto> src, final TareaDto tarea,
      final Integer tipoDatoLocalizacionSeccion,
      final Integer tipoDatoLocalizacion) {
    return src.stream()
        .flatMap(e -> this.genericMapper(tarea, tipoDatoLocalizacionSeccion, tipoDatoLocalizacion, e.getTienda(),
            e.getCadena(), e.getFecha(), e.getListaSeccion())
            .stream())
        .collect(Collectors.toList());

  }

  private List<TareaLocalizacionVenta> genericMapper(final TareaDto tarea, final Integer tipoDatoLocalizacionSeccion,
      final Integer tipoDatoLocalizacion,
      final Integer tienda, final Integer cadena, final String fecha,
      final List<PtrSeccionVentaOnlineGenericType> listaSeccion) {
    final List<TareaLocalizacionVenta> dtoList = new ArrayList<>();
    final AtomicDouble importeSinIva = new AtomicDouble(0);
    final AtomicDouble importeConIva = new AtomicDouble(0);
    if (CollectionUtils.isNotEmpty(listaSeccion)) {
      listaSeccion.stream().forEach(item -> {
        final TareaLocalizacionVenta venta = this.delegate.responseItemDtoToTareaLocalizacionVenta(tienda,
            cadena,
            fecha, tarea, item, tipoDatoLocalizacionSeccion);
        dtoList.add(venta);
        importeSinIva.getAndAdd(venta.getImporteSinImpuestos());
        importeConIva.getAndAdd(venta.getImporteConImpuestos());
      });
      final PtrSeccionVentaOnlineGenericType seccion4 = PtrSeccionVentaOnlineGenericType.builder()
          .seccion(AppConstants.SECCION_4)
          .importeConIVA(importeConIva.doubleValue())
          .importeSinIVA(importeSinIva.doubleValue())
          .build();
      dtoList.add(this.delegate.responseItemDtoToTareaLocalizacionVenta(tienda, cadena, fecha, tarea, seccion4,
          tipoDatoLocalizacion));
    }
    return dtoList;
  }

  @Override
  public List<TareaLocalizacionVenta> genericTiendaResultItemDtoToTareaLocalizacionVenta(
      final List<VentaManualWlocResultItemDto> src, final TareaDto tareaDto) {
    final List<TareaLocalizacionVenta> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(item -> result.add(
          this.delegate.genericTiendaResultItemDtoToTareaLocalizacionVenta(item,
              tareaDto))

      );
    }
    return result;
  }

}
