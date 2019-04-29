package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;

public abstract class TareaPersonaHistoricoDecorator extends TareaPersonaHistoricoMapper {

	@Autowired
	private TareaPersonaHistoricoMapper delegate;

	@Override
	public List<TareaPersonaHistorico> mergeTareaPersonaHistoricoDtoAndTareaDtoToTareaPersonaHistorico(
			List<TareaPersonaHistoricoDto> srcTareaPersonaHistorico, TareaDto srcTarea) {
		List<TareaPersonaHistorico> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcTareaPersonaHistorico)) {
		    srcTareaPersonaHistorico.forEach(item -> 
				result.add(
						delegate.mergeTareaPersonaHistoricoDtoAndTareaDtoToTareaPersonaHistorico(item, srcTarea))
			);
		}
		return result;
	}

}
