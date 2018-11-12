package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTiendaDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Programacion;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionEmpleado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionTienda;

import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public abstract class ProgramacionMapper {

	public abstract ProgramacionDto programacionToProgramacionDto(Programacion src);

	public abstract Programacion programacionDtoToProgramacion(ProgramacionDto src);

	public abstract List<ProgramacionDto> programacionToProgramacionDto(List<Programacion> src);

	public abstract List<Programacion> programacionDtoToProgramacion(List<ProgramacionDto> src);

//	@Mappings({ @Mapping(source = "programacion.id", target = "programacion.id") })
//	public abstract ProgramacionTiendaDto programacionTiendaToProgramacionTiendaDto(ProgramacionTienda src);
//	
//	@Mappings({ @Mapping(source = "programacion.id", target = "programacion.id") })
//	public abstract ProgramacionTienda programacionTiendaDtoToProgramacionTienda(ProgramacionTiendaDto src);
//	
//	public abstract List<ProgramacionTiendaDto> programacionTiendaToProgramacionTiendaDto(List<ProgramacionTienda> src);
//
//	public abstract List<ProgramacionTienda> programacionTiendaDtoToProgramacionTienda(List<ProgramacionTiendaDto> src);
//
//	@Mappings({ @Mapping(source = "programacion.id", target = "programacion.id") })
//	public abstract ProgramacionEmpleadoDto programacionEmpleadoToProgramacionEmpleadoDto(ProgramacionEmpleado src);
//	
//	@Mappings({ @Mapping(source = "programacion.id", target = "programacion.id") })
//	public abstract ProgramacionEmpleado programacionEmpleadoDtoToProgramacionEmpleado(ProgramacionEmpleadoDto src);
//	
//	public abstract List<ProgramacionEmpleadoDto> programacionEmpleadoToProgramacionEmpleadoDto(List<ProgramacionEmpleado> src);
//
//	public abstract List<ProgramacionEmpleado> programacionEmpleadoDtoToProgramacionEmpleado(List<ProgramacionEmpleadoDto> src);
	
//	@BeforeMapping
//	protected void beforeProgramacionDto(ProgramacionDto src) {
//		if (src != null && src.getId() != null) {
//			ProgramacionDto programacionId = new ProgramacionDto();
//			programacionId.setId(src.getId());
//			if (CollectionUtils.isNotEmpty(src.getTiendas())) {
//				src.getTiendas().stream().forEach(item -> {
//					item.setProgramacion(programacionId);
//				});
//			}
//			if (CollectionUtils.isNotEmpty(src.getEmpleados())) {
//				src.getEmpleados().stream().forEach(item -> {
//					item.setProgramacion(programacionId);
//				});
//			}
//		}
//	}
//
	@BeforeMapping
	protected void beforeProgramacionTienda(ProgramacionTienda src) {
		if (src != null && src.getProgramacion() != null && src.getProgramacion().getId() != null) {
			Programacion programacionId = new Programacion();
			programacionId.setId(src.getProgramacion().getId());
			src.setProgramacion(programacionId);
		}
	}

	@BeforeMapping
	protected void beforeProgramacionEmpleado(ProgramacionEmpleado src) {
		if (src != null && src.getProgramacion() != null && src.getProgramacion().getId() != null) {
			Programacion programacionId = new Programacion();
			programacionId.setId(src.getProgramacion().getId());
			src.setProgramacion(programacionId);
		}
	}

	@BeforeMapping
	protected void beforeProgramacionTiendaDto(ProgramacionTiendaDto src) {
		if (src != null && src.getProgramacion() != null && src.getProgramacion().getId() != null) {
			ProgramacionDto programacionId = new ProgramacionDto();
			programacionId.setId(src.getProgramacion().getId());
			src.setProgramacion(programacionId);
		}
	}

	@BeforeMapping
	protected void beforeProgramacionEmpleadoDto(ProgramacionEmpleadoDto src) {
		if (src != null && src.getProgramacion() != null && src.getProgramacion().getId() != null) {
			ProgramacionDto programacionId = new ProgramacionDto();
			programacionId.setId(src.getProgramacion().getId());
			src.setProgramacion(programacionId);
		}
	}

}