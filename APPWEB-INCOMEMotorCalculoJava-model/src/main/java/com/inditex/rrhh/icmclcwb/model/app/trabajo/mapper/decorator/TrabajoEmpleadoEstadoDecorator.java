package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.EstadoTrabajoEmpleado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;

public abstract class TrabajoEmpleadoEstadoDecorator extends TrabajoEmpleadoEstadoMapper {

	@Autowired
	private Logger log;

	@Autowired
	private TrabajoEmpleadoEstadoMapper delegate;

	@Override
	public List<TrabajoEmpleadoEstadoDto> genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(
			List<GenericEmpleadoResultItemDto> src, TrabajoDto trabajo) {
		List<TrabajoEmpleadoEstadoDto> dtoList = new ArrayList<>();
		EstadoTrabajoEmpleadoDto estado = new EstadoTrabajoEmpleadoDto();
		estado.setId(AppConstants.EstadoTrabajoEmpleadoEnum.PENDIENTE.getId());
		for (GenericEmpleadoResultItemDto childDto : src) {
			TrabajoEmpleadoEstadoDto dto = delegate.genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(childDto,
					trabajo);
			// TODO CONSTRAINTS
			if (StringUtils.isNotBlank(dto.getIdEmpleado()) && StringUtils.isNotBlank(dto.getIdEmpleadoLocal())
					&& StringUtils.isNotBlank(dto.getOrEmpleado())) {
				dto.setEstado(estado);
				dtoList.add(dto);
			} else {
				log.error(
						"TrabajoEmpleadoEstadoDecorator.genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto() :: GenericEmpleadoResultItemDto :: get() :: null :: {}",
						dto);
			}
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
				result.add(trabajoEmpleadoEstado);
			});
		}
		return result;
	}

}
