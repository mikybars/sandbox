package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.Constants;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTienda;

import java.time.LocalDateTime;

import org.apache.commons.collections.CollectionUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper
public abstract class TrabajoMapper {

	public abstract TrabajoDto trabajoToTrabajoDto(Trabajo src);

	public abstract Trabajo trabajoDtoToTrabajo(TrabajoDto src);

	@Mappings({ @Mapping(target = "id", ignore = true), @Mapping(target = "fechaCreacion", ignore = true) })
	public abstract TrabajoDto programacionDtoToTrabajoDto(ProgramacionDto src);
	
	@AfterMapping
	protected void afterProgramacionDtoToTrabajoDto(ProgramacionDto src, @MappingTarget TrabajoDto trabajoDto) {
		if (src != null) {
			ProgramacionDto programacion = new ProgramacionDto();
			programacion.setId(src.getId());
			trabajoDto.setProgramacion(programacion);
			
			trabajoDto.setFechaCreacion(LocalDateTime.now());
			
			EstadoTrabajoDto estadoTrabajo = new EstadoTrabajoDto();
			estadoTrabajo.setId(Constants.EstadoTrabajoEnum.PENDIENTE_DATOS.getId());
			trabajoDto.setEstado(estadoTrabajo);
		}
	}
	
	@BeforeMapping
	protected void beforeTrabajoDto(TrabajoDto src) {
		if (src != null && src.getId() != null) {
			Long id = src.getId();
			if (CollectionUtils.isNotEmpty(src.getTiendas())) {
				src.getTiendas().stream().forEach(item -> {
					TrabajoDto trabajo = new TrabajoDto();
					trabajo.setId(id);
					item.setTrabajo(trabajo);
				});
			}
			if (CollectionUtils.isNotEmpty(src.getEmpleados())) {
				src.getEmpleados().stream().forEach(item -> {
					TrabajoDto trabajo = new TrabajoDto();
					trabajo.setId(id);
					item.setTrabajo(trabajo);
				});
			}
		}
	}
	
	@BeforeMapping
	protected void beforeTrabajoTienda(TrabajoTienda src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			Trabajo programacion = new Trabajo();
			programacion.setId(src.getTrabajo().getId());
			src.setTrabajo(programacion);
		}
	}
	
	@BeforeMapping
	protected void beforeTrabajoEmpleado(TrabajoEmpleado src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			Trabajo programacion = new Trabajo();
			programacion.setId(src.getTrabajo().getId());
			src.setTrabajo(programacion);
		}
	}
	
	@BeforeMapping
	protected void beforeTrabajoTiendaDto(TrabajoTiendaDto src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			TrabajoDto programacion = new TrabajoDto();
			programacion.setId(src.getTrabajo().getId());
			src.setTrabajo(programacion);
		}
	}
	
	@BeforeMapping
	protected void beforeTrabajoEmpleadoDto(TrabajoEmpleadoDto src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			TrabajoDto programacion = new TrabajoDto();
			programacion.setId(src.getTrabajo().getId());
			src.setTrabajo(programacion);
		}
	}

}