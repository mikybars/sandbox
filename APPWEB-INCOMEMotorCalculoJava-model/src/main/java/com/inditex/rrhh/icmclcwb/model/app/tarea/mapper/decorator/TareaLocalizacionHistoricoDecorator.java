package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;

public abstract class TareaLocalizacionHistoricoDecorator extends TareaLocalizacionHistoricoMapper {

	@Autowired
	private TareaLocalizacionHistoricoMapper delegate;

	@Override
	public List<TareaLocalizacionHistorico> mergeTareaLocalizacionHistoricoDtoAndTareaDtoToTareaLocalizacionHistorico(
			List<TareaLocalizacionHistoricoDto> srcTareaTiendaHistorico, TareaDto srcTarea) {
		List<TareaLocalizacionHistorico> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcTareaTiendaHistorico)) {
			srcTareaTiendaHistorico.forEach(item -> 
				result.add(
						delegate.mergeTareaLocalizacionHistoricoDtoAndTareaDtoToTareaLocalizacionHistorico(item, srcTarea))
			);
		}
		return result;
	}

}
