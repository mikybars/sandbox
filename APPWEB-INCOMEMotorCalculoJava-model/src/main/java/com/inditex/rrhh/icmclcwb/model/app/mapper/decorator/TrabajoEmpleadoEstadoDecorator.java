package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.EstadoTrabajoEmpleado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;

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

	@Override
	public List<TrabajoEmpleadoEstadoDto> genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(
			List<GenericEmpleadoResultItemDto> src, TrabajoDto trabajo) {
		List<TrabajoEmpleadoEstadoDto> dtoList = new ArrayList<>();
		EstadoTrabajoEmpleadoDto estado = new EstadoTrabajoEmpleadoDto();
		estado.setId(AppConstants.EstadoTrabajoEmpleadoEnum.PENDIENTE.getId());
		for (GenericEmpleadoResultItemDto childDto : src) {
			TrabajoEmpleadoEstadoDto dto = delegate.genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(childDto,
					trabajo);
			dto.setEstado(estado);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public List<TrabajoEmpleadoEstado> mergeTrabajoEmpleadoEstadoDtoAndTrabajoDtoToTrabajoEmpleadoEstado(
			List<TrabajoEmpleadoEstadoDto> srcTrabajoEmpleadoEstadoDto, TrabajoDto srcTrabajoDto) {
		List<TrabajoEmpleadoEstado> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcTrabajoEmpleadoEstadoDto)) {
			EstadoTrabajoEmpleado estado = new EstadoTrabajoEmpleado();
			estado.setId(AppConstants.EstadoTrabajoEmpleadoEnum.PENDIENTE.getId());
			srcTrabajoEmpleadoEstadoDto.stream().forEach(item -> {
				TrabajoEmpleadoEstado trabajoEmpleadoEstado = delegate
						.mergeTrabajoEmpleadoEstadoDtoAndTrabajoDtoToTrabajoEmpleadoEstado(item, srcTrabajoDto);
				trabajoEmpleadoEstado.setEstado(estado);
			});
		}
		return result;
	}

}
