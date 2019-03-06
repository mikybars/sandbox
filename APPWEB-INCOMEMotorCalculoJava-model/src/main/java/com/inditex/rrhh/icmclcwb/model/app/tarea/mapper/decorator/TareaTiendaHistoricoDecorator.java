package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaHistorico;

public abstract class TareaTiendaHistoricoDecorator extends TareaTiendaHistoricoMapper {

	@Autowired
	private TareaTiendaHistoricoMapper delegate;

	@Override
	public List<TareaTiendaHistorico> mergeTareaTiendaHistoricoDtoAndTareaDtoToTareaTiendaHistorico(
			List<TareaTiendaHistoricoDto> srcTareaTiendaHistorico, TareaDto srcTarea) {
		List<TareaTiendaHistorico> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcTareaTiendaHistorico)) {
			srcTareaTiendaHistorico.forEach(item -> 
				result.add(
						delegate.mergeTareaTiendaHistoricoDtoAndTareaDtoToTareaTiendaHistorico(item, srcTarea))
			);
		}
		return result;
	}

}
