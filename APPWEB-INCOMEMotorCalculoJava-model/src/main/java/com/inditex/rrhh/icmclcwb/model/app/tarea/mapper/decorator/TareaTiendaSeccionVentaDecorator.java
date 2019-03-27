package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionVenta;

public abstract class TareaTiendaSeccionVentaDecorator extends TareaTiendaSeccionVentaMapper {

	@Autowired
	private TareaTiendaSeccionVentaMapper delegate;
	
	@Override
	public List<TareaTiendaSeccionVenta> getVentaTotalizadoReponseItemsDtoToTareaTiendaSeccionVentas(List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea){
		List<TareaTiendaSeccionVenta> dtoList = new ArrayList<>();
		for (PtrVentaTotalizadoResultItemDto childDto : src) {
			TareaTiendaSeccionVenta dto = delegate.getVentaTotalizadoResponseItemDtoToTareaTiendaSeccionVenta(childDto, tarea);
    		dtoList.add(dto);
        }
		
		return dtoList;
	}
	
    @Override
    public List<TareaTiendaSeccionVenta> getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaTiendaSeccionVentas(List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea){
        List<TareaTiendaSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineEntregaDomicilioResultItemDto childDto : src) {
            TareaTiendaSeccionVenta dto = delegate.getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaTiendaSeccionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
    
    @Override
    public List<TareaTiendaSeccionVenta> getVentaOnlineEntregaTiendaReponseItemsDtoToTareaTiendaSeccionVentas(List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tarea){
        List<TareaTiendaSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineEntregaTiendaResultItemDto childDto : src) {
            TareaTiendaSeccionVenta dto = delegate.getVentaOnlineEntregaTiendaReponseItemsDtoToTareaTiendaSeccionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
    
    @Override
    public List<TareaTiendaSeccionVenta> getVentaOnlinePickingReponseItemsDtoToTareaTiendaSeccionVentas(List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tarea){
        List<TareaTiendaSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlinePickingResultItemDto childDto : src) {
            TareaTiendaSeccionVenta dto = delegate.getVentaOnlinePickingReponseItemsDtoToTareaTiendaSeccionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
    
    @Override
    public List<TareaTiendaSeccionVenta> getVentaOnlineIpodReponseItemsDtoToTareaTiendaSeccionVentas(List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tarea){
        List<TareaTiendaSeccionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodResultItemDto childDto : src) {
            TareaTiendaSeccionVenta dto = delegate.getVentaOnlineIpodReponseItemsDtoToTareaTiendaSeccionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
}
