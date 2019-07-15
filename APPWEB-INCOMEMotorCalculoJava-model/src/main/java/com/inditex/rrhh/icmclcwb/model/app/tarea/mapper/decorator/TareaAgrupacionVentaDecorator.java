package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.CadenaVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionVenta;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class TareaAgrupacionVentaDecorator extends TareaAgrupacionVentaMapper {

    @Autowired
    private TareaAgrupacionVentaMapper delegate;

    @Override
    public List<TareaAgrupacionVenta> ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(
        List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea, List<TareaAgrupacionCadenasDto> agrupaciones) {
        return crearAgrupaciones(src, tarea, agrupaciones,
            x -> delegate.ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta((PtrVentaTotalizadoResultItemDto)x, tarea));
    }

    @Override
    public List<TareaAgrupacionVenta> ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(
        List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea, List<TareaAgrupacionCadenasDto> agrupaciones) {
        return crearAgrupaciones(src, tarea, agrupaciones,
            x -> delegate.ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta((PtrVentaOnlineEntregaDomicilioResultItemDto) x, tarea));
    }

    private List<TareaAgrupacionVenta> crearAgrupaciones(List<? extends CadenaVentaResultItemDto> src, TareaDto tarea,
            List<TareaAgrupacionCadenasDto> agrupaciones, Transform transform) {
        List<TareaAgrupacionVenta> result = new ArrayList<>();
        if (src != null) {
            Map<TareaAgrupacion, TareaAgrupacionVenta> ventas = new HashMap<>();
            Map<Integer, Long> idAgrupaciones = new HashMap<>();
            src.forEach(item -> {
                if (!idAgrupaciones.containsKey(item.getCadena())) {
                    Optional<TareaAgrupacionCadenasDto> optionalAgrupacion = agrupaciones.stream().filter(x -> x.getCadenas().stream().anyMatch(
                        y -> y.equals(item.getCadena().toString()))).findFirst();
                    if (!optionalAgrupacion.isPresent()) {
                        throw new RuntimeException("No hay agrupacion para la cadena " + item.getCadena());
                    }
                    idAgrupaciones.put(item.getCadena(), optionalAgrupacion.get().getId());
                }
                Long idAgrupacion = idAgrupaciones.get(item.getCadena());
                TareaAgrupacion agrupacion = TareaAgrupacion
                    .builder()
                    .fecha(item.getFecha())
                    .idAgrupacion(idAgrupacion)
                    .idSeccion(item.getSeccion())
                    .idTarea(tarea.getId())
                    .idPais(item.getPais())
                    .build();
                if (!ventas.containsKey(agrupacion)) {
                    TareaAgrupacionVenta tareaAgrupacionVenta = transform.transform(item);
                    tareaAgrupacionVenta.setIdAgrupacion(idAgrupacion);
                    tareaAgrupacionVenta.setImporte(0D);
                    tareaAgrupacionVenta.setImporteConImpuestos(0D);
                    ventas.put(agrupacion, tareaAgrupacionVenta);
                }
                TareaAgrupacionVenta tareaAgrupacionVenta = ventas.get(agrupacion);
                tareaAgrupacionVenta.setImporte(
                    BigDecimal.valueOf(tareaAgrupacionVenta.getImporte()).add(item.getImporteSinIVA()).doubleValue());
                tareaAgrupacionVenta.setImporteConImpuestos(
                    BigDecimal.valueOf(tareaAgrupacionVenta.getImporteConImpuestos()).add(item.getImporteConIVA()).doubleValue());
            });
            result.addAll(ventas.values());
        }
        return result;
    }

    private interface Transform {
        TareaAgrupacionVenta transform(CadenaVentaResultItemDto origen);
    }
}
