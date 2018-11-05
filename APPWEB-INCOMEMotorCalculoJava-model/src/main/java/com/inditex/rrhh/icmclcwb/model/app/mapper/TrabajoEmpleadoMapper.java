package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.Constants;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.EstadoTrabajoEmpleado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleado;

@Mapper
public abstract class TrabajoEmpleadoMapper {
	
	public abstract TrabajoEmpleadoDto trabajoEmpleadoToTrabajoEmpleadoDto(TrabajoEmpleado src);

	public abstract TrabajoEmpleado trabajoEmpleadoDtoToTrabajoEmpleado(TrabajoEmpleadoDto src);
	
	public abstract List<TrabajoEmpleadoDto> trabajoEmpleadoToTrabajoEmpleadoDto(List<TrabajoEmpleado> src);

	public abstract List<TrabajoEmpleado> trabajoEmpleadoDtoToTrabajoEmpleado(List<TrabajoEmpleadoDto> src);

	public abstract TrabajoEmpleadoDto empleadosTiendaResultItemDtoToTrabajoEmpleadoDto(EmpleadosTiendaResultItemDto src);
	
	public abstract List<TrabajoEmpleadoDto> empleadosTiendaResultItemDtoToTrabajoEmpleadoDto(List<EmpleadosTiendaResultItemDto> src);

	@BeforeMapping
	protected void beforeTrabajoEmpleado(TrabajoEmpleado src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			Trabajo trabajoId = new Trabajo();
			trabajoId.setId(src.getTrabajo().getId());
			src.setTrabajo(trabajoId);
			if (src.getEstado() == null) {
				EstadoTrabajoEmpleado estado = new EstadoTrabajoEmpleado();
				estado.setId(Constants.EstadoTrabajoEmpleadoEnum.PENDIENTE.getId());
				src.setEstado(estado);
			}
		}
	}

	@BeforeMapping
	protected void beforeTrabajoEmpleadoDto(TrabajoEmpleadoDto src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			TrabajoDto trabajoId = new TrabajoDto();
			trabajoId.setId(src.getTrabajo().getId());
			src.setTrabajo(trabajoId);
			if (src.getEstado() == null) {
				EstadoTrabajoEmpleadoDto estado = new EstadoTrabajoEmpleadoDto();
				estado.setId(Constants.EstadoTrabajoEmpleadoEnum.PENDIENTE.getId());
				src.setEstado(estado);
			}
		}
	}
	
}
