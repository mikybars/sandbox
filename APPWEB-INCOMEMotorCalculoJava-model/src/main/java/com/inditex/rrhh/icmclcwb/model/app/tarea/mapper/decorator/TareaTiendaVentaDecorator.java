package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaVenta;


public abstract class TareaTiendaVentaDecorator extends TareaTiendaVentaMapper {

    @Autowired
    private TareaTiendaVentaMapper delegate;
    
    @Override
    public List<TareaTiendaVenta> getVentaTotalizadoReponseItemsDtoToTareaTiendaVentas(List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea){
        List<TareaTiendaVenta> dtoList = new ArrayList<>();
        for (PtrVentaTotalizadoResultItemDto childDto : src) {
            TareaTiendaVenta dto = delegate.getVentaTotalizadoResponseItemDtoToTareaTiendaVenta(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
    @Override
    public List<TareaTiendaVenta> getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaTiendaVentas(List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea){
        List<TareaTiendaVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineEntregaDomicilioResultItemDto childDto : src) {
            TareaTiendaVenta dto = delegate.getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaTiendaVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
    @Override
    public List<TareaTiendaVenta> getVentaOnlineEntregaTiendaReponseItemsDtoToTareaTiendaVentas(List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tarea){
        List<TareaTiendaVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineEntregaTiendaResultItemDto childDto : src) {
            TareaTiendaVenta dto = delegate.getVentaOnlineEntregaTiendaReponseItemsDtoToTareaTiendaVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
    @Override
    public List<TareaTiendaVenta> getVentaOnlinePickingReponseItemsDtoToTareaTiendaVentas(List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tarea){
        List<TareaTiendaVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlinePickingResultItemDto childDto : src) {
            TareaTiendaVenta dto = delegate.getVentaOnlinePickingReponseItemsDtoToTareaTiendaVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
    @Override
    public List<TareaTiendaVenta> getVentaOnlineIpodReponseItemsDtoToTareaTiendaVentas(List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tarea){
        List<TareaTiendaVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodResultItemDto childDto : src) {
            TareaTiendaVenta dto = delegate.getVentaOnlineIpodReponseItemsDtoToTareaTiendaVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TareaTiendaVenta> getVentaIndividualDetalleReponseItemsDtoToTareaTiendaVentas(List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tarea){
        List<TareaTiendaVenta> dtoList = new ArrayList<>();
        for (PtrVentaIndividualDetalleResultItemDto childDto : src) {
            TareaTiendaVenta dto = delegate.getVentaIndividualDetalleReponseItemsDtoToTareaTiendaVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
