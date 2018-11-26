package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionVenta;

public abstract class TrabajoTiendaSeccionVentaDecorator extends TrabajoTiendaSeccionVentaMapper {

	@Autowired
	TrabajoTiendaSeccionVentaMapper delegate;
	
	@Override
	public List<TrabajoTiendaSeccionVenta> getVentaTotalizadoReponseItemsDtoToTrabajoTiendaSeccionVentas(List<GetVentaTotalizadoResponseItemDto> src, TrabajoDto trabajo){
		List<TrabajoTiendaSeccionVenta> dtoList = new ArrayList<>();
		for (GetVentaTotalizadoResponseItemDto childDto : src) {
			TrabajoTiendaSeccionVenta dto = delegate.getVentaTotalizadoResponseItemDtoToTrabajoTiendaSeccionVenta(childDto, trabajo);
    		dtoList.add(dto);
        }
		
		return dtoList;
	}
}
