package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaSeccionEmpleadoPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionEmpleadoPresencia;

public abstract class TrabajoTiendaSeccionEmpleadoPresenciaDecorator
		extends TrabajoTiendaSeccionEmpleadoPresenciaMapper {

	@Autowired
	TrabajoTiendaSeccionEmpleadoPresenciaMapper delegate; 
	
	@Override
	public List<TrabajoTiendaSeccionEmpleadoPresencia> presenciasDetalleResponsesDtoToTrabajoTiendaSeccionVentas(List<PtrPresenciasMockDetalleResponseDto> src, TrabajoDto trabajoDto){
		List<TrabajoTiendaSeccionEmpleadoPresencia> dtoList = new ArrayList<>();
		for (PtrPresenciasMockDetalleResponseDto childDto : src) {
			TrabajoTiendaSeccionEmpleadoPresencia dto = delegate.presenciasDetalleResponseDtoToTrabajoTiendaSeccionVenta(childDto, trabajoDto);
    		dtoList.add(dto);
        }
		
		return dtoList;
	}
	
	
}
