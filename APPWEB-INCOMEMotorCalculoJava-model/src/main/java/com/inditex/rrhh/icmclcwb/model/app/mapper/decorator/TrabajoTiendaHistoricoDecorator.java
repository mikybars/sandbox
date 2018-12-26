package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaHistorico;

public abstract class TrabajoTiendaHistoricoDecorator extends TrabajoTiendaHistoricoMapper {

	@Autowired
	private TrabajoTiendaHistoricoMapper delegate;

	@Override
	public List<TrabajoTiendaHistorico> mergeTrabajoTiendaHistoricoDtoAndTrabajoDtoToTrabajoTiendaHistorico(
			List<TrabajoTiendaHistoricoDto> srcTrabajoTiendaHistorico, TrabajoDto srcTrabajo) {
		List<TrabajoTiendaHistorico> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcTrabajoTiendaHistorico)) {
			srcTrabajoTiendaHistorico.forEach(item -> 
				result.add(
						delegate.mergeTrabajoTiendaHistoricoDtoAndTrabajoDtoToTrabajoTiendaHistorico(item, srcTrabajo))
			);
		}
		return result;
	}

}
