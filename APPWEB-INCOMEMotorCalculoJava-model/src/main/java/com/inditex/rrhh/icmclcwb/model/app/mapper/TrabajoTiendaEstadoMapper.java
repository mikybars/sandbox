package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.BeforeMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.TrabajoTiendaEstadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;

@Mapper
@DecoratedWith(TrabajoTiendaEstadoDecorator.class)
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
		}
	}

	@BeforeMapping
	protected void beforeTrabajoTiendaEstadoDto(TrabajoTiendaEstadoDto src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			TrabajoDto trabajoId = new TrabajoDto();
			trabajoId.setId(src.getTrabajo().getId());
			src.setTrabajo(trabajoId);
		}
	}

	@Mappings({ @Mapping(target = "trabajo.id", source = "srcTrabajoDto.id"), @Mapping(target = "id", ignore = true),
			@Mapping(target = "estado", ignore = true), @Mapping(target = "idPais", source = "srcTrabajoTiendaEstadoDto.idPais"), @Mapping(target = "idEmpresa", source = "srcTrabajoTiendaEstadoDto.idEmpresa")})
	public abstract TrabajoTiendaEstado mergeTrabajoTiendaEstadoDtoAndTrabajoDtoToTrabajoTiendaEstado(
			TrabajoTiendaEstadoDto srcTrabajoTiendaEstadoDto, TrabajoDto srcTrabajoDto);

	public List<TrabajoTiendaEstado> mergeTrabajoTiendaEstadoDtoAndTrabajoDtoToTrabajoTiendaEstado(
			List<TrabajoTiendaEstadoDto> srcTrabajoTiendaEstadoDto, TrabajoDto srcTrabajoDto) {
		throw new UnsupportedOperationException("Not implemented");
	}

}