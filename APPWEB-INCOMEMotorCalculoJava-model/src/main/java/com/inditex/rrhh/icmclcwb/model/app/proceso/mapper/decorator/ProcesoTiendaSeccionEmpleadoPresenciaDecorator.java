package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaSeccionEmpleadoPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaSeccionEmpleadoPresencia;

public abstract class ProcesoTiendaSeccionEmpleadoPresenciaDecorator
		extends ProcesoTiendaSeccionEmpleadoPresenciaMapper {

	@Autowired
	private ProcesoTiendaSeccionEmpleadoPresenciaMapper delegate; 
	
	@Override
	public List<ProcesoTiendaSeccionEmpleadoPresencia> presenciasDetalleResponsesDtoToProcesoTiendaSeccionVentas(List<PtrPresenciaDetalleResultItemDto> src, ProcesoDto procesoDto){
		List<ProcesoTiendaSeccionEmpleadoPresencia> dtoList = new ArrayList<>();
		for (PtrPresenciaDetalleResultItemDto childDto : src) {
			ProcesoTiendaSeccionEmpleadoPresencia dto = delegate.presenciasDetalleResponseDtoToProcesoTiendaSeccionVenta(childDto, procesoDto);
    		dtoList.add(dto);
        }
		
		return dtoList;
	}
	
	@Override
    public List<ProcesoTiendaSeccionEmpleadoPresencia> presenciasDetalleComisionableResponsesDtoToProcesoTiendaSeccionVentas(
            List<PtrPresenciaDetalleComisionableResultItemDto> src, ProcesoDto procesoDto) {
        List<ProcesoTiendaSeccionEmpleadoPresencia> dtoList = new ArrayList<>();
        for (PtrPresenciaDetalleComisionableResultItemDto childDto : src) {
            ProcesoTiendaSeccionEmpleadoPresencia dto = delegate.presenciasDetalleComisionableResponseDtoToProcesoTiendaSeccionVenta(childDto, procesoDto);
            dtoList.add(dto);
        }

        return dtoList;
	}
	
}
