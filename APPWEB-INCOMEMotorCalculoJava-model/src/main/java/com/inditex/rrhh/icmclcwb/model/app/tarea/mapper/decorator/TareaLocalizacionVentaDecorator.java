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
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;


public abstract class TareaLocalizacionVentaDecorator extends TareaLocalizacionVentaMapper {

    @Autowired
    private TareaLocalizacionVentaMapper delegate;
    
    @Override
    public List<TareaLocalizacionVenta> getVentaTotalizadoReponseItemsDtoToTareaLocalizacionVentas(List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionVenta> dtoList = new ArrayList<>();
        for (PtrVentaTotalizadoResultItemDto childDto : src) {
            TareaLocalizacionVenta dto = delegate.getVentaTotalizadoResponseItemDtoToTareaLocalizacionVenta(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
    @Override
    public List<TareaLocalizacionVenta> getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaLocalizacionVentas(List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineEntregaDomicilioResultItemDto childDto : src) {
            TareaLocalizacionVenta dto = delegate.getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaLocalizacionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
    @Override
    public List<TareaLocalizacionVenta> getVentaOnlineEntregaTiendaReponseItemsDtoToTareaLocalizacionVentas(List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineEntregaTiendaResultItemDto childDto : src) {
            TareaLocalizacionVenta dto = delegate.getVentaOnlineEntregaTiendaReponseItemsDtoToTareaLocalizacionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
    @Override
    public List<TareaLocalizacionVenta> getVentaOnlinePickingReponseItemsDtoToTareaLocalizacionVentas(List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlinePickingResultItemDto childDto : src) {
            TareaLocalizacionVenta dto = delegate.getVentaOnlinePickingReponseItemsDtoToTareaLocalizacionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
    @Override
    public List<TareaLocalizacionVenta> getVentaOnlineIpodReponseItemsDtoToTareaLocalizacionVentas(List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodResultItemDto childDto : src) {
            TareaLocalizacionVenta dto = delegate.getVentaOnlineIpodReponseItemsDtoToTareaLocalizacionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TareaLocalizacionVenta> getVentaIndividualDetalleReponseItemsDtoToTareaLocalizacionVentas(List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionVenta> dtoList = new ArrayList<>();
        for (PtrVentaIndividualDetalleResultItemDto childDto : src) {
            TareaLocalizacionVenta dto = delegate.getVentaIndividualDetalleReponseItemsDtoToTareaLocalizacionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
