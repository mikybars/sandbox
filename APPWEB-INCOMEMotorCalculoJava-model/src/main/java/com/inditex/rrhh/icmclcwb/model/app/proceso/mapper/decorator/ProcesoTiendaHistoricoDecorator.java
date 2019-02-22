package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaHistorico;

public abstract class ProcesoTiendaHistoricoDecorator extends ProcesoTiendaHistoricoMapper {

	@Autowired
	private ProcesoTiendaHistoricoMapper delegate;

	@Override
	public List<ProcesoTiendaHistorico> mergeProcesoTiendaHistoricoDtoAndProcesoDtoToProcesoTiendaHistorico(
			List<ProcesoTiendaHistoricoDto> srcProcesoTiendaHistorico, ProcesoDto srcProceso) {
		List<ProcesoTiendaHistorico> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcProcesoTiendaHistorico)) {
			srcProcesoTiendaHistorico.forEach(item -> 
				result.add(
						delegate.mergeProcesoTiendaHistoricoDtoAndProcesoDtoToProcesoTiendaHistorico(item, srcProceso))
			);
		}
		return result;
	}

}
