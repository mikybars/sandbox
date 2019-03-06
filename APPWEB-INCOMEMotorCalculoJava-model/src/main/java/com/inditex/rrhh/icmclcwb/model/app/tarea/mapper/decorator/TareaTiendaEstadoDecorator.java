package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TipoTareaTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaEstado;

public abstract class TareaTiendaEstadoDecorator extends TareaTiendaEstadoMapper {

	@Autowired
	private TareaTiendaEstadoMapper delegate;

	@Override
	public List<TareaTiendaEstado> mergeTareaTiendaEstadoDtoAndTareaDtoToTareaTiendaEstado(
			List<TareaTiendaEstadoDto> tareaTiendaEstado, TareaDto tarea) {
		List<TareaTiendaEstado> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(tareaTiendaEstado)) {
			tareaTiendaEstado.forEach(item -> result
					.add(delegate.mergeTareaTiendaEstadoDtoAndTareaDtoToTareaTiendaEstado(item, tarea)));
		}
		return result;
	}

	@Override
	public List<TareaTiendaEstadoDto> genericTiendaResultItemDtoToTareaTiendaEstadoDto(
			List<GenericTiendaResultItemDto> srcGenericTiendaResultItem, TipoTareaTiendaDto srcTipoTareaTienda) {
		List<TareaTiendaEstadoDto> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcGenericTiendaResultItem)) {
			srcGenericTiendaResultItem.forEach(item -> {
				TareaTiendaEstadoDto src = delegate.genericTiendaResultItemDtoToTareaTiendaEstadoDto(item,
						srcTipoTareaTienda);
				src.setTipo(srcTipoTareaTienda);
				result.add(src);
			});
		}
		return result;
	}

}
