package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoEmpleadoHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoHistorico;

public abstract class TrabajoEmpleadoHistoricoDecorator extends TrabajoEmpleadoHistoricoMapper {

	@Autowired
	private TrabajoEmpleadoHistoricoMapper delegate;

	@Override
	public List<TrabajoEmpleadoHistorico> mergeTrabajoEmpleadoHistoricoDtoAndTrabajoDtoToTrabajoEmpleadoHistorico(
			List<TrabajoEmpleadoHistoricoDto> srcTrabajoEmpleadoHistorico, TrabajoDto srcTrabajo) {
		List<TrabajoEmpleadoHistorico> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcTrabajoEmpleadoHistorico)) {
		    srcTrabajoEmpleadoHistorico.forEach(item -> 
				result.add(
						delegate.mergeTrabajoEmpleadoHistoricoDtoAndTrabajoDtoToTrabajoEmpleadoHistorico(item, srcTrabajo))
			);
		}
		return result;
	}

}
