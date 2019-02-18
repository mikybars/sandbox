package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaEmpleadoHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoHistorico;

public abstract class TareaEmpleadoHistoricoDecorator extends TareaEmpleadoHistoricoMapper {

	@Autowired
	private TareaEmpleadoHistoricoMapper delegate;

	@Override
	public List<TareaEmpleadoHistorico> mergeTareaEmpleadoHistoricoDtoAndTareaDtoToTareaEmpleadoHistorico(
			List<TareaEmpleadoHistoricoDto> srcTareaEmpleadoHistorico, TareaDto srcTarea) {
		List<TareaEmpleadoHistorico> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcTareaEmpleadoHistorico)) {
		    srcTareaEmpleadoHistorico.forEach(item -> 
				result.add(
						delegate.mergeTareaEmpleadoHistoricoDtoAndTareaDtoToTareaEmpleadoHistorico(item, srcTarea))
			);
		}
		return result;
	}

}
