package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.BeforeMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.TrabajoEmpleadoEstadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.EstadoTrabajoEmpleado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;

@Mapper
@DecoratedWith(TrabajoEmpleadoEstadoDecorator.class)
public abstract class TrabajoEmpleadoEstadoMapper {

	public abstract TrabajoEmpleadoEstadoDto trabajoEmpleadoEstadoToTrabajoEmpleadoEstadoDto(TrabajoEmpleadoEstado src);

	public abstract TrabajoEmpleadoEstado trabajoEmpleadoEstadoDtoToTrabajoEmpleadoEstado(TrabajoEmpleadoEstadoDto src);

	public abstract List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstadoToTrabajoEmpleadoEstadoDto(
			List<TrabajoEmpleadoEstado> src);

	public abstract List<TrabajoEmpleadoEstado> trabajoEmpleadoEstadoDtoToTrabajoEmpleadoEstado(
			List<TrabajoEmpleadoEstadoDto> src);

	@BeforeMapping
	protected void beforeTrabajoEmpleadoEstado(TrabajoEmpleadoEstado src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			Trabajo trabajoId = new Trabajo();
			trabajoId.setId(src.getTrabajo().getId());
			src.setTrabajo(trabajoId);
			if (src.getEstado() == null) {
				EstadoTrabajoEmpleado estado = new EstadoTrabajoEmpleado();
				estado.setId(AppConstants.EstadoTrabajoEmpleadoEnum.PENDIENTE.getId());
				src.setEstado(estado);
			}
		}
	}

	@BeforeMapping
	protected void beforeTrabajoEmpleadoEstadoDto(TrabajoEmpleadoEstadoDto src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			TrabajoDto trabajoId = new TrabajoDto();
			trabajoId.setId(src.getTrabajo().getId());
			src.setTrabajo(trabajoId);
			if (src.getEstado() == null) {
				EstadoTrabajoEmpleadoDto estado = new EstadoTrabajoEmpleadoDto();
				estado.setId(AppConstants.EstadoTrabajoEmpleadoEnum.PENDIENTE.getId());
				src.setEstado(estado);
			}
		}
	}

	@Mappings({ @Mapping(target = "idEmpleado", source = "src.idEmpleado"),
			@Mapping(target = "trabajo.id", source = "trabajo.id"),
			@Mapping(target = "id", ignore = true),
			@Mapping(target = "estado", ignore = true) })
	public abstract TrabajoEmpleadoEstadoDto empleadosTiendaResultItemDtoToTrabajoEmpleadoEstadoDto(
			EmpleadosTiendaResultItemDto src, TrabajoDto trabajo);

	public List<TrabajoEmpleadoEstadoDto> empleadosTiendaResultItemDtoToTrabajoEmpleadoEstadoDto(
			List<EmpleadosTiendaResultItemDto> src, TrabajoDto trabajo) {
		throw new UnsupportedOperationException("Not implemented");
	}
	
	@Mappings({ @Mapping(target = "idEmpleado", source = "src.idEmpleado"),
		@Mapping(target = "trabajo.id", source = "trabajo.id"),
		@Mapping(target = "id", ignore = true),
		@Mapping(target = "estado", ignore = true) })
	public abstract TrabajoEmpleadoEstadoDto genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(
			GenericEmpleadoResultItemDto src, TrabajoDto trabajo);
	
	public List<TrabajoEmpleadoEstadoDto> genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(
			List<GenericEmpleadoResultItemDto> src, TrabajoDto trabajo) {
		throw new UnsupportedOperationException("Not implemented");
	}

}