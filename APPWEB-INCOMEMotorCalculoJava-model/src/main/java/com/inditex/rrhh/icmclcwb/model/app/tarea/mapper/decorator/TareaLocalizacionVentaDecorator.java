package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.util.concurrent.AtomicDouble;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

public abstract class TareaLocalizacionVentaDecorator extends TareaLocalizacionVentaMapper {
    
    @Autowired
    private TareaLocalizacionVentaMapper delegate;

    @Override
    public List<TareaLocalizacionVenta> ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea, Long tipoDatoLocalizacionSeccion, Long tipoDatoLocalizacion) {
            return src.stream().flatMap(e -> genericMapper(tarea, tipoDatoLocalizacionSeccion, tipoDatoLocalizacion, e.getTienda(), e.getCadena(), e.getFecha(), e.getListaSeccion()).stream()).collect(Collectors.toList());
    }


    @Override
    public List<TareaLocalizacionVenta> ventaOnlineIpodResponseItemDtoToTareaLocalizacionVenta(
            List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tarea, Long tipoDatoLocalizacionSeccion, Long tipoDatoLocalizacion) {
            return src.stream().flatMap(e -> genericMapper(tarea, tipoDatoLocalizacionSeccion, tipoDatoLocalizacion, e.getTienda(), e.getCadena(), e.getFecha(), e.getListaSeccion()).stream()).collect(Collectors.toList());
    }

    @Override
    public List<TareaLocalizacionVenta> ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionVenta(
            List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea, Long tipoDatoLocalizacionSeccion, Long tipoDatoLocalizacion) {
            return src.stream().flatMap(e -> genericMapper(tarea, tipoDatoLocalizacionSeccion, tipoDatoLocalizacion, e.getTienda(), e.getCadena(), e.getFecha(), e.getListaSeccion()).stream()).collect(Collectors.toList());
    }

    @Override
    public List<TareaLocalizacionVenta> ventaOnlinePickingResponseItemDtoToTareaLocalizacionVenta(
            List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tarea, Long tipoDatoLocalizacionSeccion, Long tipoDatoLocalizacion) {
            return src.stream().flatMap(e -> genericMapper(tarea, tipoDatoLocalizacionSeccion, tipoDatoLocalizacion, e.getTienda(), e.getCadena(), e.getFecha(), e.getListaSeccion()).stream()).collect(Collectors.toList());
    }

    @Override
    public List<TareaLocalizacionVenta> ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionVenta(
            List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tarea, Long tipoDatoLocalizacionSeccion, Long tipoDatoLocalizacion) {
            return src.stream().flatMap(e -> genericMapper(tarea, tipoDatoLocalizacionSeccion, tipoDatoLocalizacion, e.getTienda(), e.getCadena(), e.getFecha(), e.getListaSeccion()).stream()).collect(Collectors.toList());
    }

    @Override
    public List<TareaLocalizacionVenta> ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionVenta(
            List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea, Long tipoDatoLocalizacionSeccion, Long tipoDatoLocalizacion) {
            return src.stream().flatMap(e -> genericMapper(tarea, tipoDatoLocalizacionSeccion, tipoDatoLocalizacion, e.getTienda(), e.getCadena(), e.getFecha(), e.getListaSeccion()).stream()).collect(Collectors.toList());
    }

    @Override
    public List<TareaLocalizacionVenta> ventaIndividualDetalleReponseItemsDtoToTareaLocalizacionVenta(List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tarea, Long tipoDatoLocalizacionSeccion, Long tipoDatoLocalizacion){
            return src.stream().flatMap(e -> genericMapper(tarea, tipoDatoLocalizacionSeccion, tipoDatoLocalizacion, e.getTienda(), e.getCadena(), e.getFecha(), e.getListaSeccion()).stream()).collect(Collectors.toList());

    }
    private List<TareaLocalizacionVenta> genericMapper(TareaDto tarea, Long tipoDatoLocalizacionSeccion, Long tipoDatoLocalizacion,
             Integer tienda, Integer cadena, String fecha, List<PtrSeccionVentaOnlineGenericType> listaSeccion) {
        List<TareaLocalizacionVenta> dtoList = new ArrayList<>();
        AtomicDouble importeSinIva = new AtomicDouble(0);
        AtomicDouble importeConIva = new AtomicDouble(0);
        if (CollectionUtils.isNotEmpty(listaSeccion)) {
            listaSeccion.stream().forEach(item -> {
                TareaLocalizacionVenta venta = delegate.responseItemDtoToTareaLocalizacionVenta(tienda, cadena,
                        fecha, tarea, item.getImporteSinIVA().doubleValue(), item.getImporteConIVA().doubleValue(),
                        item.getSeccion(), tipoDatoLocalizacionSeccion);
                dtoList.add(venta);
                importeSinIva.getAndAdd(venta.getImporte());
                importeConIva.getAndAdd(venta.getImporteConImpuestos());
            });
            dtoList.add(delegate.responseItemDtoToTareaLocalizacionVenta(tienda, cadena, fecha, tarea, importeSinIva.doubleValue(), importeConIva.doubleValue(), AppConstants.SECCION_4, tipoDatoLocalizacion));
        }
        return dtoList;
    }
}
