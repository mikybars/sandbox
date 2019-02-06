package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoTiendaEstado;

public abstract class TrabajoTiendaEstadoDecorator extends TrabajoTiendaEstadoMapper {

	@Autowired
	private TrabajoTiendaEstadoMapper delegate;

	@Override
	public List<TrabajoTiendaEstado> mergeTrabajoTiendaEstadoDtoAndTrabajoDtoToTrabajoTiendaEstado(
			List<TrabajoTiendaEstadoDto> trabajoTiendaEstado, TrabajoDto trabajo) {
		List<TrabajoTiendaEstado> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(trabajoTiendaEstado)) {
			trabajoTiendaEstado.forEach(item -> result
					.add(delegate.mergeTrabajoTiendaEstadoDtoAndTrabajoDtoToTrabajoTiendaEstado(item, trabajo)));
		}
		return result;
	}

	@Override
	public List<TrabajoTiendaEstadoDto> genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(
			List<GenericTiendaResultItemDto> srcGenericTiendaResultItem, TipoTrabajoTiendaDto srcTipoTrabajoTienda) {
		List<TrabajoTiendaEstadoDto> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcGenericTiendaResultItem)) {
			srcGenericTiendaResultItem.forEach(item -> {
				TrabajoTiendaEstadoDto src = delegate.genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(item,
						srcTipoTrabajoTienda);
				src.setTipo(srcTipoTrabajoTienda);
				result.add(src);
			});
		}
		return result;
	}

}
