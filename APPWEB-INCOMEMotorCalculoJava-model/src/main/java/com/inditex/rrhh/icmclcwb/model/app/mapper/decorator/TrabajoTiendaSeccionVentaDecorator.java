package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseItemDTO;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionVenta;

public abstract class TrabajoTiendaSeccionVentaDecorator extends TrabajoTiendaSeccionVentaMapper {

	@Autowired
	TrabajoTiendaSeccionVentaMapper delegate;
	
	@Override
	public List<TrabajoTiendaSeccionVenta> getVentaTotalizadoReponseItemsDtoToTrabajoTiendaSeccionVentas(List<GetVentaTotalizadoResponseItemDTO> src, TrabajoDto trabajo){
		List<TrabajoTiendaSeccionVenta> dtoList = new ArrayList<>();
		for (GetVentaTotalizadoResponseItemDTO childDto : src) {
			TrabajoTiendaSeccionVenta dto = delegate.getVentaTotalizadoResponseItemDTOToTrabajoTiendaSeccionVenta(childDto, trabajo);
    		dtoList.add(dto);
        }
		
		return dtoList;
	}
}
