package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.EstadoTareaEmpleado;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoEstado;

public abstract class TareaEmpleadoEstadoDecorator extends TareaEmpleadoEstadoMapper {

	@Autowired
	private Logger log;

	@Autowired
	private TareaEmpleadoEstadoMapper delegate;

	@Override
	public List<TareaEmpleadoEstadoDto> genericEmpleadoResultItemDtoToTareaEmpleadoEstadoDto(
			List<GenericEmpleadoResultItemDto> src, TareaDto tarea) {
		List<TareaEmpleadoEstadoDto> dtoList = new ArrayList<>();
		EstadoTareaEmpleadoDto estado = new EstadoTareaEmpleadoDto();
		estado.setId(EstadoTareaEmpleadoEnum.PENDIENTE.getId());
		for (GenericEmpleadoResultItemDto childDto : src) {
			TareaEmpleadoEstadoDto dto = delegate.genericEmpleadoResultItemDtoToTareaEmpleadoEstadoDto(childDto,
					tarea);
			// TODO CONSTRAINTS
			if (StringUtils.isNotBlank(dto.getIdEmpleado()) && StringUtils.isNotBlank(dto.getIdEmpleadoLocal())
					&& StringUtils.isNotBlank(dto.getOrEmpleado())) {
				dto.setEstado(estado);
				dtoList.add(dto);
			} else {
				log.error(
						"TareaEmpleadoEstadoDecorator.genericEmpleadoResultItemDtoToTareaEmpleadoEstadoDto() :: GenericEmpleadoResultItemDto :: get() :: null :: {}",
						dto);
			}
		}
		return dtoList;
	}

	@Override
	public List<TareaEmpleadoEstado> mergeTareaEmpleadoEstadoDtoAndTareaDtoToTareaEmpleadoEstado(
			List<TareaEmpleadoEstadoDto> srcTareaEmpleadoEstadoDto, TareaDto srcTareaDto) {
		List<TareaEmpleadoEstado> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcTareaEmpleadoEstadoDto)) {
			EstadoTareaEmpleado estado = new EstadoTareaEmpleado();
			estado.setId(EstadoTareaEmpleadoEnum.PENDIENTE.getId());
			srcTareaEmpleadoEstadoDto.stream().forEach(item -> {
				TareaEmpleadoEstado tareaEmpleadoEstado = delegate
						.mergeTareaEmpleadoEstadoDtoAndTareaDtoToTareaEmpleadoEstado(item, srcTareaDto);
				tareaEmpleadoEstado.setEstado(estado);
				result.add(tareaEmpleadoEstado);
			});
		}
		return result;
	}

}
