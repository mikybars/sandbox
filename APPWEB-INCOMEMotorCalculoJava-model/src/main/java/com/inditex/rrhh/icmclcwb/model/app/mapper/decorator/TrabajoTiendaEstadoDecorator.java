package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TipoTrabajoTienda;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;

public abstract class TrabajoTiendaEstadoDecorator extends TrabajoTiendaEstadoMapper {

	@Autowired
	private TrabajoTiendaEstadoMapper delegate;

	@Override
	public List<TrabajoTiendaEstado> mergeTrabajoTiendaEstadoDtoAndTrabajoDtoToTrabajoTiendaEstado(
			List<TrabajoTiendaEstadoDto> trabajoTiendaEstado, TrabajoDto trabajo) {
		List<TrabajoTiendaEstado> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(trabajoTiendaEstado)) {
			TipoTrabajoTienda tipoInicialId = new TipoTrabajoTienda();
			tipoInicialId.setId(AppConstants.TipoTrabajoTiendaEnum.INICIAL.getId());
			trabajoTiendaEstado.forEach(item -> {
				TrabajoTiendaEstado src = delegate.mergeTrabajoTiendaEstadoDtoAndTrabajoDtoToTrabajoTiendaEstado(item, trabajo);
				src.setTipo(tipoInicialId);
				result.add(src);
			});
		}
		return result;
	}
}
