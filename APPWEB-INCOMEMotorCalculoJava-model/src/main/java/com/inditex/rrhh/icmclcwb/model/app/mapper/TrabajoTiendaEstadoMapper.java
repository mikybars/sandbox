package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.Constants;
import com.inditex.rrhh.icmclcwb.model.primary.entity.EstadoTrabajoTienda;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TipoTrabajoTienda;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;

@Mapper
public abstract class TrabajoTiendaEstadoMapper {

	public abstract TrabajoTiendaEstadoDto trabajoTiendaEstadoToTrabajoTiendaEstadoDto(TrabajoTiendaEstado src);

	public abstract TrabajoTiendaEstado trabajoTiendaEstadoDtoToTrabajoTiendaEstado(TrabajoTiendaEstadoDto src);

	public abstract List<TrabajoTiendaEstadoDto> trabajoTiendaEstadoToTrabajoTiendaEstadoDto(
			List<TrabajoTiendaEstado> src);

	public abstract List<TrabajoTiendaEstado> trabajoTiendaEstadoDtoToTrabajoTiendaEstado(
			List<TrabajoTiendaEstadoDto> src);

	@BeforeMapping
	protected void beforeTrabajoTienda(TrabajoTiendaEstado src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			Trabajo trabajoId = new Trabajo();
			trabajoId.setId(src.getTrabajo().getId());
			src.setTrabajo(trabajoId);
			if (src.getEstado() == null) {
				EstadoTrabajoTienda estado = new EstadoTrabajoTienda();
				estado.setId(Constants.EstadoTrabajoTiendaEnum.PENDIENTE.getId());
				src.setEstado(estado);
			}
			if (src.getTipo() == null) {
				TipoTrabajoTienda estado = new TipoTrabajoTienda();
				estado.setId(Constants.TipoTrabajoTiendaEnum.INICIAL.getId());
				src.setTipo(estado);
			}
		}
	}

	@BeforeMapping
	protected void beforeTrabajoTiendaEstadoDto(TrabajoTiendaEstadoDto src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			TrabajoDto trabajoId = new TrabajoDto();
			trabajoId.setId(src.getTrabajo().getId());
			src.setTrabajo(trabajoId);
			if (src.getEstado() == null) {
				EstadoTrabajoTiendaDto estado = new EstadoTrabajoTiendaDto();
				estado.setId(Constants.EstadoTrabajoTiendaEnum.PENDIENTE.getId());
				src.setEstado(estado);
			}
			if (src.getTipo() == null) {
				TipoTrabajoTiendaDto estado = new TipoTrabajoTiendaDto();
				estado.setId(Constants.TipoTrabajoTiendaEnum.INICIAL.getId());
				src.setTipo(estado);
			}
		}
	}

}