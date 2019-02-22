package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.TipoProcesoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaEstado;

public abstract class ProcesoTiendaEstadoDecorator extends ProcesoTiendaEstadoMapper {

	@Autowired
	private ProcesoTiendaEstadoMapper delegate;

	@Override
	public List<ProcesoTiendaEstado> mergeProcesoTiendaEstadoDtoAndProcesoDtoToProcesoTiendaEstado(
			List<ProcesoTiendaEstadoDto> procesoTiendaEstado, ProcesoDto proceso) {
		List<ProcesoTiendaEstado> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(procesoTiendaEstado)) {
			procesoTiendaEstado.forEach(item -> result
					.add(delegate.mergeProcesoTiendaEstadoDtoAndProcesoDtoToProcesoTiendaEstado(item, proceso)));
		}
		return result;
	}

	@Override
	public List<ProcesoTiendaEstadoDto> genericTiendaResultItemDtoToProcesoTiendaEstadoDto(
			List<GenericTiendaResultItemDto> srcGenericTiendaResultItem, TipoProcesoTiendaDto srcTipoProcesoTienda) {
		List<ProcesoTiendaEstadoDto> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcGenericTiendaResultItem)) {
			srcGenericTiendaResultItem.forEach(item -> {
				ProcesoTiendaEstadoDto src = delegate.genericTiendaResultItemDtoToProcesoTiendaEstadoDto(item,
						srcTipoProcesoTienda);
				src.setTipo(srcTipoProcesoTienda);
				result.add(src);
			});
		}
		return result;
	}

}
