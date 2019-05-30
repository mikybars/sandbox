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
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionVentaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVentaSeccion;

public abstract class TareaLocalizacionVentaSeccionDecorator extends TareaLocalizacionVentaSeccionMapper {

    @Autowired
    private TareaLocalizacionVentaSeccionMapper delegate;
    
    @Override
    public List<TareaLocalizacionVentaSeccion> getVentaTotalizadoResponseItemDtoToTareaLocalizacionVentaSeccion(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionVentaSeccion> dtoList = new ArrayList<>();
        for (PtrVentaTotalizadoResultItemDto childDto : src) {
            TareaLocalizacionVentaSeccion dto = delegate.getVentaTotalizadoResponseItemDtoToTareaLocalizacionVentaSeccion(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
    
    @Override
    public List<TareaLocalizacionVentaSeccion> getVentaOnlineIpodResponseItemDtoToTareaLocalizacionVentaSeccion(
            List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionVentaSeccion> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodResultItemDto childDto : src) {
            TareaLocalizacionVentaSeccion dto = delegate.getVentaOnlineIpodResponseItemDtoToTareaLocalizacionVentaSeccion(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
    
    @Override
    public List<TareaLocalizacionVentaSeccion> getVentaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionVentaSeccion(
            List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionVentaSeccion> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodIndividualDetalleResultItemDto childDto : src) {
            TareaLocalizacionVentaSeccion dto = delegate.getVentaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionVentaSeccion(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }

    @Override
    public List<TareaLocalizacionVentaSeccion> getVentaOnlinePickingResponseItemDtoToTareaLocalizacionVentaSeccion(
            List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionVentaSeccion> dtoList = new ArrayList<>();
        for (PtrVentaOnlinePickingResultItemDto childDto : src) {
            TareaLocalizacionVentaSeccion dto = delegate.getVentaOnlinePickingResponseItemDtoToTareaLocalizacionVentaSeccion(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
    
    @Override
    public List<TareaLocalizacionVentaSeccion> getVentaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionVentaSeccion(
            List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionVentaSeccion> dtoList = new ArrayList<>();
        for (PtrVentaOnlineEntregaTiendaResultItemDto childDto : src) {
            TareaLocalizacionVentaSeccion dto = delegate.getVentaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionVentaSeccion(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
    
    @Override
    public List<TareaLocalizacionVentaSeccion> getVentaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionVentaSeccion(
            List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionVentaSeccion> dtoList = new ArrayList<>();
        for (PtrVentaOnlineEntregaDomicilioResultItemDto childDto : src) {
            TareaLocalizacionVentaSeccion dto = delegate.getVentaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionVentaSeccion(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
    
}
