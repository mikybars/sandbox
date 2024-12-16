package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.CadenaVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionVenta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaAgrupacionVentaDecorator extends TareaAgrupacionVentaMapper {

  private static final Logger LOG = LoggerFactory.getLogger(TareaAgrupacionVentaDecorator.class);

  @Autowired
  private TareaAgrupacionVentaMapper delegate;

  @Override
  public List<TareaAgrupacionVenta> ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(
      List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea, List<TareaAgrupacionCadenasDto> agrupaciones) {
    return this.crearAgrupaciones(src, tarea, agrupaciones, x -> this.delegate
        .ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta((PtrVentaTotalizadoResultItemDto) x, tarea));
  }

  @Override
  public List<TareaAgrupacionVenta> ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(
      List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea,
      List<TareaAgrupacionCadenasDto> agrupaciones) {
    return this.crearAgrupaciones(src, tarea, agrupaciones,
        x -> this.delegate.ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(
            (PtrVentaOnlineEntregaDomicilioResultItemDto) x, tarea));
  }

  private List<TareaAgrupacionVenta> crearAgrupaciones(List<? extends CadenaVentaResultItemDto> src, TareaDto tarea,
      List<TareaAgrupacionCadenasDto> agrupaciones, Transform transform) {
    final List<TareaAgrupacionVenta> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      final Map<TareaAgrupacion, TareaAgrupacionVenta> ventas = new HashMap<>();
      final Map<Integer, Long> idAgrupaciones = new HashMap<>();
      for (final CadenaVentaResultItemDto item : src) {
        if (!idAgrupaciones.containsKey(item.getCadena())) {
          final Optional<TareaAgrupacionCadenasDto> optionalAgrupacion = agrupaciones.stream()
              .filter(x -> x.getCadenas().stream().anyMatch(y -> y.equals(item.getCadena().toString())))
              .findFirst();
          if (!optionalAgrupacion.isPresent()) {
            LOG.warn("No hay agrupacion para la cadena: {}, id de tarea: {}", item.getCadena(),
                tarea.getId());
          } else {
            idAgrupaciones.put(item.getCadena(), optionalAgrupacion.get().getId());
          }
        }
        if (idAgrupaciones.containsKey(item.getCadena())) {
          final Long idAgrupacion = idAgrupaciones.get(item.getCadena());
          final TareaAgrupacion agrupacion = TareaAgrupacion.builder()
              .fecha(item.getFecha())
              .idAgrupacion(idAgrupacion)
              .idSeccion(item.getSeccion())
              .idTarea(tarea.getId())
              .idPais(item.getPais())
              .build();
          if (!ventas.containsKey(agrupacion)) {
            final TareaAgrupacionVenta tareaAgrupacionVenta = transform.transform(item);
            tareaAgrupacionVenta.setIcmIdAgrupacionOnline(idAgrupacion);
            tareaAgrupacionVenta.setImporteSinImpuestos(new BigDecimal(0));
            tareaAgrupacionVenta.setImporteConImpuestos(new BigDecimal(0));
            ventas.put(agrupacion, tareaAgrupacionVenta);
          }
          final TareaAgrupacionVenta tareaAgrupacionVenta = ventas.get(agrupacion);
          tareaAgrupacionVenta.setImporteSinImpuestos(
              tareaAgrupacionVenta.getImporteSinImpuestos().add(item.getImporteSinIVA()));
          tareaAgrupacionVenta.setImporteConImpuestos(
              tareaAgrupacionVenta.getImporteConImpuestos().add(item.getImporteConIVA()));
        }
      }
      result.addAll(ventas.values());
    }
    return result;
  }

  private interface Transform {

    TareaAgrupacionVenta transform(CadenaVentaResultItemDto origen);

  }

}
