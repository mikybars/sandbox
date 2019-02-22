package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.proceso.EstadoProcesoEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.EstadoProcesoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.EstadoProcesoEmpleado;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleadoEstado;

public abstract class ProcesoEmpleadoEstadoDecorator extends ProcesoEmpleadoEstadoMapper {

	@Autowired
	private Logger log;

	@Autowired
	private ProcesoEmpleadoEstadoMapper delegate;

	@Override
	public List<ProcesoEmpleadoEstadoDto> genericEmpleadoResultItemDtoToProcesoEmpleadoEstadoDto(
			List<GenericEmpleadoResultItemDto> src, ProcesoDto proceso) {
		List<ProcesoEmpleadoEstadoDto> dtoList = new ArrayList<>();
		EstadoProcesoEmpleadoDto estado = new EstadoProcesoEmpleadoDto();
		estado.setId(EstadoProcesoEmpleadoEnum.PENDIENTE.getId());
		for (GenericEmpleadoResultItemDto childDto : src) {
			ProcesoEmpleadoEstadoDto dto = delegate.genericEmpleadoResultItemDtoToProcesoEmpleadoEstadoDto(childDto,
					proceso);
			// TODO CONSTRAINTS
			if (StringUtils.isNotBlank(dto.getIdEmpleado()) && StringUtils.isNotBlank(dto.getIdEmpleadoLocal())
					&& StringUtils.isNotBlank(dto.getOrEmpleado())) {
				dto.setEstado(estado);
				dtoList.add(dto);
			} else {
				log.error(
						"ProcesoEmpleadoEstadoDecorator.genericEmpleadoResultItemDtoToProcesoEmpleadoEstadoDto() :: GenericEmpleadoResultItemDto :: get() :: null :: {}",
						dto);
			}
		}
		return dtoList;
	}

	@Override
	public List<ProcesoEmpleadoEstado> mergeProcesoEmpleadoEstadoDtoAndProcesoDtoToProcesoEmpleadoEstado(
			List<ProcesoEmpleadoEstadoDto> srcProcesoEmpleadoEstadoDto, ProcesoDto srcProcesoDto) {
		List<ProcesoEmpleadoEstado> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcProcesoEmpleadoEstadoDto)) {
			EstadoProcesoEmpleado estado = new EstadoProcesoEmpleado();
			estado.setId(EstadoProcesoEmpleadoEnum.PENDIENTE.getId());
			srcProcesoEmpleadoEstadoDto.stream().forEach(item -> {
				ProcesoEmpleadoEstado procesoEmpleadoEstado = delegate
						.mergeProcesoEmpleadoEstadoDtoAndProcesoDtoToProcesoEmpleadoEstado(item, srcProcesoDto);
				procesoEmpleadoEstado.setEstado(estado);
				result.add(procesoEmpleadoEstado);
			});
		}
		return result;
	}

}
