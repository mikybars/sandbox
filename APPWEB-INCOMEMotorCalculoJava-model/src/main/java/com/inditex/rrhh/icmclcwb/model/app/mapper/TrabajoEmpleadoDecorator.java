package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;

public abstract class TrabajoEmpleadoDecorator extends TrabajoEmpleadoMapper {

	@Autowired
    private TrabajoEmpleadoMapper delegate;
    
    @Override
    public List<TrabajoEmpleadoDto> empleadosTiendaResultItemDtoToTrabajoEmpleadoDto(List<EmpleadosTiendaResultItemDto> src, TrabajoDto trabajo) {
        List<TrabajoEmpleadoDto> dtoList = new ArrayList<>();
    	for (EmpleadosTiendaResultItemDto childDto : src) {
    		dtoList.add(delegate.empleadosTiendaResultItemDtoToTrabajoEmpleadoDto(childDto, trabajo));
        }
        return dtoList;
    }

}
