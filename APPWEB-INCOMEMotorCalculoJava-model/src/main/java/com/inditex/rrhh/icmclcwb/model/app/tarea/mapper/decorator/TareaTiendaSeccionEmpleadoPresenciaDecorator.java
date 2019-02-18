package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaSeccionEmpleadoPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionEmpleadoPresencia;

public abstract class TareaTiendaSeccionEmpleadoPresenciaDecorator
		extends TareaTiendaSeccionEmpleadoPresenciaMapper {

	@Autowired
	private TareaTiendaSeccionEmpleadoPresenciaMapper delegate; 
	
	@Override
	public List<TareaTiendaSeccionEmpleadoPresencia> presenciasDetalleResponsesDtoToTareaTiendaSeccionVentas(List<PtrPresenciaDetalleResultItemDto> src, TareaDto tareaDto){
		List<TareaTiendaSeccionEmpleadoPresencia> dtoList = new ArrayList<>();
		for (PtrPresenciaDetalleResultItemDto childDto : src) {
			TareaTiendaSeccionEmpleadoPresencia dto = delegate.presenciasDetalleResponseDtoToTareaTiendaSeccionVenta(childDto, tareaDto);
    		dtoList.add(dto);
        }
		
		return dtoList;
	}
	
	@Override
    public List<TareaTiendaSeccionEmpleadoPresencia> presenciasDetalleComisionableResponsesDtoToTareaTiendaSeccionVentas(
            List<PtrPresenciaDetalleComisionableResultItemDto> src, TareaDto tareaDto) {
        List<TareaTiendaSeccionEmpleadoPresencia> dtoList = new ArrayList<>();
        for (PtrPresenciaDetalleComisionableResultItemDto childDto : src) {
            TareaTiendaSeccionEmpleadoPresencia dto = delegate.presenciasDetalleComisionableResponseDtoToTareaTiendaSeccionVenta(childDto, tareaDto);
            dtoList.add(dto);
        }

        return dtoList;
	}
	
}
