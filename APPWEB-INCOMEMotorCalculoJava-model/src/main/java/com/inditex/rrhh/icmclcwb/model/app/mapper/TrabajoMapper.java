package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.time.LocalDateTime;

import org.apache.commons.collections.CollectionUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.Constants;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaFilterDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.EstadoTrabajoEmpleado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.EstadoTrabajoTienda;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Programacion;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionEmpleado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionTienda;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TipoTrabajoTienda;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTienda;

@Mapper
public abstract class TrabajoMapper {

	public abstract TrabajoDto trabajoToTrabajoDto(Trabajo src);

	public abstract Trabajo trabajoDtoToTrabajo(TrabajoDto src);

	@Mappings({ @Mapping(target = "id", ignore = true), @Mapping(target = "fechaCreacion", ignore = true) })
	public abstract TrabajoDto programacionDtoToTrabajoDto(ProgramacionDto src);
	
	
	@Mappings({ @Mapping(source = "fechaInicioPeriodo", target = "fechaInicio"), 
		@Mapping(source = "fechaFinPeriodo", target = "fechaFin")})
	public abstract EmpleadosTiendaFilterDto trabajoDtotoEmpleadosTiendaFilterDto(TrabajoDto src);

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
			if (src.getEstado() == null) {
				EstadoTrabajoTienda estado = new EstadoTrabajoTienda();
				estado.setId(Constants.EstadoTrabajoTiendaEnum.PENDIENTE.getId());
				src.setEstado(estado);
			}
			if (src.getTipo() == null) {
				TipoTrabajoTienda estado = new TipoTrabajoTienda();
				estado.setId(Constants.TipoTrabajoTiendaEnum.PARAMETRO.getId());
				src.setTipo(estado);
			}
		}
	}

	@BeforeMapping
	protected void beforeTrabajoEmpleado(TrabajoEmpleado src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			Trabajo programacion = new Trabajo();
			programacion.setId(src.getTrabajo().getId());
			src.setTrabajo(programacion);
			if (src.getEstado() == null) {
				EstadoTrabajoEmpleado estado = new EstadoTrabajoEmpleado();
				estado.setId(Constants.EstadoTrabajoTiendaEnum.PENDIENTE.getId());
				src.setEstado(estado);
			}
		}
	}

	@BeforeMapping
	protected void beforeTrabajoTiendaDto(TrabajoTiendaDto src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			TrabajoDto programacion = new TrabajoDto();
			programacion.setId(src.getTrabajo().getId());
			src.setTrabajo(programacion);
			if (src.getEstado() == null) {
				EstadoTrabajoTiendaDto estado = new EstadoTrabajoTiendaDto();
				estado.setId(Constants.EstadoTrabajoTiendaEnum.PENDIENTE.getId());
				src.setEstado(estado);
			}
			if (src.getTipo() == null) {
				TipoTrabajoTiendaDto estado = new TipoTrabajoTiendaDto();
				estado.setId(Constants.TipoTrabajoTiendaEnum.PARAMETRO.getId());
				src.setTipo(estado);
			}
		}
	}

	@BeforeMapping
	protected void beforeTrabajoEmpleadoDto(TrabajoEmpleadoDto src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			TrabajoDto programacion = new TrabajoDto();
			programacion.setId(src.getTrabajo().getId());
			src.setTrabajo(programacion);
			if (src.getEstado() == null) {
				EstadoTrabajoEmpleadoDto estado = new EstadoTrabajoEmpleadoDto();
				estado.setId(Constants.EstadoTrabajoTiendaEnum.PENDIENTE.getId());
				src.setEstado(estado);
			}
		}
	}
	
	@BeforeMapping
	protected void beforeProgramacionDto(ProgramacionDto src) {
		if (src != null && src.getId() != null) {
			Long id = src.getId();
			if (CollectionUtils.isNotEmpty(src.getTiendas())) {
				src.getTiendas().stream().forEach(item -> {
					ProgramacionDto programacion = new ProgramacionDto();
					programacion.setId(id);
					item.setProgramacion(programacion);
				});
			}
			if (CollectionUtils.isNotEmpty(src.getEmpleados())) {
				src.getEmpleados().stream().forEach(item -> {
					ProgramacionDto programacion = new ProgramacionDto();
					programacion.setId(id);
					item.setProgramacion(programacion);
				});
			}
		}
	}
	
	@BeforeMapping
	protected void beforeProgramacionTienda(ProgramacionTienda src) {
		if (src != null && src.getProgramacion() != null && src.getProgramacion().getId() != null) {
			Programacion programacion = new Programacion();
			programacion.setId(src.getProgramacion().getId());
			src.setProgramacion(programacion);
		}
	}
	
	@BeforeMapping
	protected void beforeProgramacionEmpleado(ProgramacionEmpleado src) {
		if (src != null && src.getProgramacion() != null && src.getProgramacion().getId() != null) {
			Programacion programacion = new Programacion();
			programacion.setId(src.getProgramacion().getId());
			src.setProgramacion(programacion);
		}
	}
	
	@BeforeMapping
	protected void beforeProgramacionTiendaDto(ProgramacionTiendaDto src) {
		if (src != null && src.getProgramacion() != null && src.getProgramacion().getId() != null) {
			ProgramacionDto programacion = new ProgramacionDto();
			programacion.setId(src.getProgramacion().getId());
			src.setProgramacion(programacion);
		}
	}
	
	@BeforeMapping
	protected void beforeProgramacionEmpleadoDto(ProgramacionEmpleadoDto src) {
		if (src != null && src.getProgramacion() != null && src.getProgramacion().getId() != null) {
			ProgramacionDto programacion = new ProgramacionDto();
			programacion.setId(src.getProgramacion().getId());
			src.setProgramacion(programacion);
		}
	}

}