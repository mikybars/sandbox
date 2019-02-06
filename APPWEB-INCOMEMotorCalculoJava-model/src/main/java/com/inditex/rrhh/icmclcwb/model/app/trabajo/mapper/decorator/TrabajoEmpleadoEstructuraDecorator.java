package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoEmpleadoEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoEmpleadoEstructura;

public abstract class TrabajoEmpleadoEstructuraDecorator extends TrabajoEmpleadoEstructuraMapper {

	@Autowired
	private TrabajoEmpleadoEstructuraMapper delegate;

	@Override
	public List<TrabajoEmpleadoEstructura> mergeTrabajoEmpleadoEstructuraDtoAndTrabajoDtoToTrabajoEmpleadoEstructura(
			List<TrabajoEmpleadoEstructuraDto> srcTrabajoEmpleadoEstructura, TrabajoDto srcTrabajo) {
		List<TrabajoEmpleadoEstructura> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcTrabajoEmpleadoEstructura)) {
		    srcTrabajoEmpleadoEstructura.forEach(item -> 
				result.add(
						delegate.mergeTrabajoEmpleadoEstructuraDtoAndTrabajoDtoToTrabajoEmpleadoEstructura(item, srcTrabajo))
			);
		}
		return result;
	}

}
