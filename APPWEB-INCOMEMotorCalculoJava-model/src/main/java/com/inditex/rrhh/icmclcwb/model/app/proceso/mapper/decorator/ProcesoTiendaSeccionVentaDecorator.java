package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaSeccionVenta;

public abstract class ProcesoTiendaSeccionVentaDecorator extends ProcesoTiendaSeccionVentaMapper {

	@Autowired
	private ProcesoTiendaSeccionVentaMapper delegate;
	
	@Override
	public List<ProcesoTiendaSeccionVenta> getVentaTotalizadoReponseItemsDtoToProcesoTiendaSeccionVentas(List<PtrVentaTotalizadoResultItemDto> src, ProcesoDto proceso){
		List<ProcesoTiendaSeccionVenta> dtoList = new ArrayList<>();
		for (PtrVentaTotalizadoResultItemDto childDto : src) {
			ProcesoTiendaSeccionVenta dto = delegate.getVentaTotalizadoResponseItemDtoToProcesoTiendaSeccionVenta(childDto, proceso);
    		dtoList.add(dto);
        }
		
		return dtoList;
	}
}
