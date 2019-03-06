package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaSeccionEmpleadoPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaEmpleadoPresenciaSeccion;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaSeccionEmpleadoPresencia;

public abstract class ProcesoTiendaSeccionEmpleadoPresenciaDecorator
		extends ProcesoTiendaSeccionEmpleadoPresenciaMapper {

	@Autowired
	private ProcesoTiendaSeccionEmpleadoPresenciaMapper delegate; 
	
	@Override
	public List<ProcesoTiendaSeccionEmpleadoPresencia> presenciasDetalleResponsesDtoToProcesoTiendaSeccionEmpleadoPresencia(List<PtrPresenciaDetalleResultItemDto> src, ProcesoDto procesoDto){
		List<ProcesoTiendaSeccionEmpleadoPresencia> dtoList = new ArrayList<>();
		for (PtrPresenciaDetalleResultItemDto childDto : src) {
			ProcesoTiendaSeccionEmpleadoPresencia dto = delegate.presenciasDetalleResponseDtoToProcesoTiendaSeccionEmpleadoPresencia(childDto, procesoDto);
    		dtoList.add(dto);
        }
		
		return dtoList;
	}
	
	@Override
    public List<ProcesoTiendaSeccionEmpleadoPresencia> presenciasDetalleComisionableResponsesDtoToProcesoTiendaSeccionEmpleadoPresencia(
            List<PtrPresenciaDetalleComisionableResultItemDto> src, ProcesoDto procesoDto) {
        List<ProcesoTiendaSeccionEmpleadoPresencia> dtoList = new ArrayList<>();
        for (PtrPresenciaDetalleComisionableResultItemDto childDto : src) {
            ProcesoTiendaSeccionEmpleadoPresencia dto = delegate.presenciasDetalleComisionableResponseDtoToProcesoTiendaSeccionEmpleadoPresencia(childDto, procesoDto);
            dtoList.add(dto);
        }

        return dtoList;
	}
	
    @Override
    public List<ProcesoTiendaEmpleadoPresenciaSeccion> presenciasDetalleComisionableResponseDtoToProcesoTiendaEmpleadoPresenciaSeccion(List<PtrPresenciaDetalleComisionableResultItemDto> src, ProcesoDto procesoDto)  {
        List<ProcesoTiendaEmpleadoPresenciaSeccion> dtoList = new ArrayList<>();
        for (PtrPresenciaDetalleComisionableResultItemDto childDto : src) {
            ProcesoTiendaEmpleadoPresenciaSeccion dto = delegate.presenciasDetalleComisionableResponseDtoToProcesoTiendaEmpleadoPresenciaSeccion(childDto, procesoDto);
            dtoList.add(dto);
        }
        return dtoList;
    }
	
}
