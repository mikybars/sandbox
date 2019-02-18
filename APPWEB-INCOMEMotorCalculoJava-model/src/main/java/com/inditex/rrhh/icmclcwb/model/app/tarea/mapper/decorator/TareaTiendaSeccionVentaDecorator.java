package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
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
}
