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
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaVentaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaVentaSeccion;

public abstract class TareaTiendaVentaSeccionDecorator extends TareaTiendaVentaSeccionMapper {

    @Autowired
    private TareaTiendaVentaSeccionMapper delegate;
    
    @Override
    public List<TareaTiendaVentaSeccion> getVentaTotalizadoResponseItemDtoToTareaTiendaVentaSeccion(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea){
        List<TareaTiendaVentaSeccion> dtoList = new ArrayList<>();
        for (PtrVentaTotalizadoResultItemDto childDto : src) {
            TareaTiendaVentaSeccion dto = delegate.getVentaTotalizadoResponseItemDtoToTareaTiendaVentaSeccion(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
    
    @Override
    public List<TareaTiendaVentaSeccion> getVentaOnlineIpodResponseItemDtoToTareaTiendaVentaSeccion(
            List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tarea){
        List<TareaTiendaVentaSeccion> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodResultItemDto childDto : src) {
            TareaTiendaVentaSeccion dto = delegate.getVentaOnlineIpodResponseItemDtoToTareaTiendaVentaSeccion(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
    
    @Override
    public List<TareaTiendaVentaSeccion> getVentaOnlineIpodIndividualDetalleResponseItemDtoToTareaTiendaVentaSeccion(
            List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea){
        List<TareaTiendaVentaSeccion> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodIndividualDetalleResultItemDto childDto : src) {
            TareaTiendaVentaSeccion dto = delegate.getVentaOnlineIpodIndividualDetalleResponseItemDtoToTareaTiendaVentaSeccion(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }

    @Override
    public List<TareaTiendaVentaSeccion> getVentaOnlinePickingResponseItemDtoToTareaTiendaVentaSeccion(
            List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tarea){
        List<TareaTiendaVentaSeccion> dtoList = new ArrayList<>();
        for (PtrVentaOnlinePickingResultItemDto childDto : src) {
            TareaTiendaVentaSeccion dto = delegate.getVentaOnlinePickingResponseItemDtoToTareaTiendaVentaSeccion(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
    
    @Override
    public List<TareaTiendaVentaSeccion> getVentaOnlineEntregaTiendaResponseItemDtoToTareaTiendaVentaSeccion(
            List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tarea){
        List<TareaTiendaVentaSeccion> dtoList = new ArrayList<>();
        for (PtrVentaOnlineEntregaTiendaResultItemDto childDto : src) {
            TareaTiendaVentaSeccion dto = delegate.getVentaOnlineEntregaTiendaResponseItemDtoToTareaTiendaVentaSeccion(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
    
    @Override
    public List<TareaTiendaVentaSeccion> getVentaOnlineEntregaDomicilioResponseItemDtoToTareaTiendaVentaSeccion(
            List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea){
        List<TareaTiendaVentaSeccion> dtoList = new ArrayList<>();
        for (PtrVentaOnlineEntregaDomicilioResultItemDto childDto : src) {
            TareaTiendaVentaSeccion dto = delegate.getVentaOnlineEntregaDomicilioResponseItemDtoToTareaTiendaVentaSeccion(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
    
}
