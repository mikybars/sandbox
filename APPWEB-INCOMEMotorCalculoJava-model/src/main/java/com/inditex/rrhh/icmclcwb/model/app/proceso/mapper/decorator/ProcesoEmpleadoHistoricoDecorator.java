package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoEmpleadoHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleadoHistorico;

public abstract class ProcesoEmpleadoHistoricoDecorator extends ProcesoEmpleadoHistoricoMapper {

	@Autowired
	private ProcesoEmpleadoHistoricoMapper delegate;

	@Override
	public List<ProcesoEmpleadoHistorico> mergeProcesoEmpleadoHistoricoDtoAndProcesoDtoToProcesoEmpleadoHistorico(
			List<ProcesoEmpleadoHistoricoDto> srcProcesoEmpleadoHistorico, ProcesoDto srcProceso) {
		List<ProcesoEmpleadoHistorico> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcProcesoEmpleadoHistorico)) {
		    srcProcesoEmpleadoHistorico.forEach(item -> 
				result.add(
						delegate.mergeProcesoEmpleadoHistoricoDtoAndProcesoDtoToProcesoEmpleadoHistorico(item, srcProceso))
			);
		}
		return result;
	}

}
