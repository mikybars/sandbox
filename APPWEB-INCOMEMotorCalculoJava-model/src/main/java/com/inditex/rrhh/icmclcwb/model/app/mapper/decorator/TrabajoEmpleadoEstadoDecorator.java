package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstadoMapper;

public abstract class TrabajoEmpleadoEstadoDecorator extends TrabajoEmpleadoEstadoMapper {

	@Autowired
	private TrabajoEmpleadoEstadoMapper delegate;

	@Override
	public List<TrabajoEmpleadoEstadoDto> empleadosTiendaResultItemDtoToTrabajoEmpleadoEstadoDto(
			List<EmpleadosTiendaResultItemDto> src, TrabajoDto trabajo) {
		List<TrabajoEmpleadoEstadoDto> dtoList = new ArrayList<>();
		EstadoTrabajoEmpleadoDto estado = new EstadoTrabajoEmpleadoDto();
		estado.setId(AppConstants.EstadoTrabajoEmpleadoEnum.PENDIENTE.getId());
		for (EmpleadosTiendaResultItemDto childDto : src) {
			TrabajoEmpleadoEstadoDto dto = delegate.empleadosTiendaResultItemDtoToTrabajoEmpleadoEstadoDto(childDto,
					trabajo);
			dto.setEstado(estado);
			dtoList.add(dto);
		}
		return dtoList;
	}

}