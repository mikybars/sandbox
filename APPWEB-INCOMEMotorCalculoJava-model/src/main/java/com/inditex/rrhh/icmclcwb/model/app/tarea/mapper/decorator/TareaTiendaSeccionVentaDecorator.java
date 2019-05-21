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
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionVenta;

public abstract class TareaTiendaSeccionVentaDecorator extends TareaTiendaSeccionVentaMapper {
    
    @Autowired
    private TareaTiendaSeccionVentaMapper delegate;

    @Override
    public List<TareaTiendaSeccionVenta> ventaTotalizadoResponseItemDtoToTareaTiendaSeccionVenta(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea, Integer idSeccion) {
        List<TareaTiendaSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaTotalizadoResultItemDto childDto : src) {
            TareaTiendaSeccionVenta dto = delegate.ventaTotalizadoResponseItemDtoToTareaTiendaSeccionVenta(childDto, tarea, idSeccion);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TareaTiendaSeccionVenta> ventaOnlineIpodResponseItemDtoToTareaTiendaSeccionVenta(
            List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tarea, Integer idSeccion) {
        List<TareaTiendaSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodResultItemDto childDto : src) {
            TareaTiendaSeccionVenta dto = delegate.ventaOnlineIpodResponseItemDtoToTareaTiendaSeccionVenta(childDto, tarea, idSeccion);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TareaTiendaSeccionVenta> ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaTiendaSeccionVenta(
            List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea, Integer idSeccion) {
        List<TareaTiendaSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodIndividualDetalleResultItemDto childDto : src) {
            TareaTiendaSeccionVenta dto = delegate.ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaTiendaSeccionVenta(childDto, tarea, idSeccion);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TareaTiendaSeccionVenta> ventaOnlinePickingResponseItemDtoToTareaTiendaSeccionVenta(
            List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tarea, Integer idSeccion) {
        List<TareaTiendaSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlinePickingResultItemDto childDto : src) {
            TareaTiendaSeccionVenta dto = delegate.ventaOnlinePickingResponseItemDtoToTareaTiendaSeccionVenta(childDto, tarea, idSeccion);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TareaTiendaSeccionVenta> ventaOnlineEntregaTiendaResponseItemDtoToTareaTiendaSeccionVenta(
            List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tarea, Integer idSeccion) {
        List<TareaTiendaSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineEntregaTiendaResultItemDto childDto : src) {
            TareaTiendaSeccionVenta dto = delegate.ventaOnlineEntregaTiendaResponseItemDtoToTareaTiendaSeccionVenta(childDto, tarea, idSeccion);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TareaTiendaSeccionVenta> ventaOnlineEntregaDomicilioResponseItemDtoToTareaTiendaSeccionVenta(
            List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea, Integer idSeccion) {
        List<TareaTiendaSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineEntregaDomicilioResultItemDto childDto : src) {
            TareaTiendaSeccionVenta dto = delegate.ventaOnlineEntregaDomicilioResponseItemDtoToTareaTiendaSeccionVenta(childDto, tarea, idSeccion);
            dtoList.add(dto);
        }
        return dtoList;
    }

}
