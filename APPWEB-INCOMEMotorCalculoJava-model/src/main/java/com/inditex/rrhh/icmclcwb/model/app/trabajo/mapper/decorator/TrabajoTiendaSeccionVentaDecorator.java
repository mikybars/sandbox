package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoTiendaSeccionVenta;

public abstract class TrabajoTiendaSeccionVentaDecorator extends TrabajoTiendaSeccionVentaMapper {

	@Autowired
	private TrabajoTiendaSeccionVentaMapper delegate;
	
	@Override
	public List<TrabajoTiendaSeccionVenta> getVentaTotalizadoReponseItemsDtoToTrabajoTiendaSeccionVentas(List<PtrVentaTotalizadoResultItemDto> src, TrabajoDto trabajo){
		List<TrabajoTiendaSeccionVenta> dtoList = new ArrayList<>();
		for (PtrVentaTotalizadoResultItemDto childDto : src) {
			TrabajoTiendaSeccionVenta dto = delegate.getVentaTotalizadoResponseItemDtoToTrabajoTiendaSeccionVenta(childDto, trabajo);
    		dtoList.add(dto);
        }
		
		return dtoList;
	}
}
