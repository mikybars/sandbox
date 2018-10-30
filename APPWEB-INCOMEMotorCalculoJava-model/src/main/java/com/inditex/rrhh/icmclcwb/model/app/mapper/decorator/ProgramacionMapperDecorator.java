//package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;
//
//import java.util.List;
//
//import org.apache.commons.collections.CollectionUtils;
//import org.mapstruct.AfterMapping;
//import org.mapstruct.BeforeMapping;
//import org.mapstruct.MappingTarget;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
//import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionEmpleadoMapper;
//import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionMapper;
//import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionTiendaMapper;
//import com.inditex.rrhh.icmclcwb.model.primary.entity.Programacion;
//import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionEmpleado;
//import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionTienda;
//
//public abstract class ProgramacionMapperDecorator implements ProgramacionMapper {
//
//	@Autowired
//	@Qualifier("delegate")
//	private ProgramacionMapper delegate;
//
//	@Autowired
//	private ProgramacionTiendaMapper programacionTiendaMapper;
//
//	@Autowired
//	private ProgramacionEmpleadoMapper programacionEmpleadoMapper;
//
//	@BeforeMapping
//	void programacionToProgramacionDtoBefore(Programacion src) {
//		
//	}
//	
//	@AfterMapping
//	void programacionToProgramacionDtoAfter(Programacion src, @MappingTarget ProgramacionDto result) {
//		
//	}
//	
////	@Override
////	public ProgramacionDto programacionToProgramacionDto(Programacion src) {
////		if (src == null) {
////			return null;
////		}
////		ProgramacionDto result = delegate.programacionToProgramacionDto(src);
////		List<ProgramacionTienda> tiendas = src.getTiendas();
////		if (CollectionUtils.isNotEmpty(tiendas)) {
////			tiendas.stream().forEach(item -> {
////				item.setProgramacion(delegate.programacionToProgramacionId(item.getProgramacion()));
////			});
////			result.setTiendas(programacionTiendaMapper.programacionTiendaToProgramacionTiendaDto(tiendas));
////		}
////		List<ProgramacionEmpleado> empleados = src.getEmpleados();
////		if (CollectionUtils.isNotEmpty(empleados)) {
////			empleados.stream().forEach(item -> {
////				item.setProgramacion(delegate.programacionToProgramacionId(item.getProgramacion()));
////			});
////			result.setEmpleados(programacionEmpleadoMapper.programacionEmpleadoToProgramacionEmpleadoDto(empleados));
////		}
////		return result;
////	}
//
//	@Override
//	public ProgramacionDto programacionDtoToProgramacionDtoId(ProgramacionDto src) {
//		if (src == null) {
//			return null;
//		}
//		ProgramacionDto result = new ProgramacionDto();
//		result.setId(src.getId());
//		return result;
//	}
//
//	@Override
//	public Programacion programacionToProgramacionId(Programacion src) {
//		if (src == null) {
//			return null;
//		}
//		Programacion result = new Programacion();
//		result.setId(src.getId());
//		return result;
//	}
//
//}