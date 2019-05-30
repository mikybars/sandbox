package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionSeccionVenta;

public abstract class TareaLocalizacionSeccionVentaDecorator extends TareaLocalizacionSeccionVentaMapper {
    
    @Autowired
    private TareaLocalizacionSeccionVentaMapper delegate;

    @Override
    public List<TareaLocalizacionSeccionVenta> ventaTotalizadoResponseItemDtoToTareaLocalizacionSeccionVenta(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea, Integer idSeccion) {
        List<TareaLocalizacionSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaTotalizadoResultItemDto childDto : src) {
            TareaLocalizacionSeccionVenta dto = delegate.ventaTotalizadoResponseItemDtoToTareaLocalizacionSeccionVenta(childDto, tarea, idSeccion);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TareaLocalizacionSeccionVenta> ventaOnlineIpodResponseItemDtoToTareaLocalizacionSeccionVenta(
            List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tarea, Integer idSeccion) {
        List<TareaLocalizacionSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodResultItemDto childDto : src) {
            TareaLocalizacionSeccionVenta dto = delegate.ventaOnlineIpodResponseItemDtoToTareaLocalizacionSeccionVenta(childDto, tarea, idSeccion);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TareaLocalizacionSeccionVenta> ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionSeccionVenta(
            List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea, Integer idSeccion) {
        List<TareaLocalizacionSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodIndividualDetalleResultItemDto childDto : src) {
            TareaLocalizacionSeccionVenta dto = delegate.ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionSeccionVenta(childDto, tarea, idSeccion);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TareaLocalizacionSeccionVenta> ventaOnlinePickingResponseItemDtoToTareaLocalizacionSeccionVenta(
            List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tarea, Integer idSeccion) {
        List<TareaLocalizacionSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlinePickingResultItemDto childDto : src) {
            TareaLocalizacionSeccionVenta dto = delegate.ventaOnlinePickingResponseItemDtoToTareaLocalizacionSeccionVenta(childDto, tarea, idSeccion);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TareaLocalizacionSeccionVenta> ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionSeccionVenta(
            List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tarea, Integer idSeccion) {
        List<TareaLocalizacionSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineEntregaTiendaResultItemDto childDto : src) {
            TareaLocalizacionSeccionVenta dto = delegate.ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionSeccionVenta(childDto, tarea, idSeccion);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TareaLocalizacionSeccionVenta> ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionSeccionVenta(
            List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea, Integer idSeccion) {
        List<TareaLocalizacionSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineEntregaDomicilioResultItemDto childDto : src) {
            TareaLocalizacionSeccionVenta dto = delegate.ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionSeccionVenta(childDto, tarea, idSeccion);
            dtoList.add(dto);
        }
        return dtoList;
    }

}
