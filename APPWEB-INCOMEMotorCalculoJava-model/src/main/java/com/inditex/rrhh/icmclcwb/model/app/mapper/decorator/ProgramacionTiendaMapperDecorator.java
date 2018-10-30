//package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
//import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTiendaDto;
//import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionMapper;
//import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionTiendaMapper;
//import com.inditex.rrhh.icmclcwb.model.primary.entity.Programacion;
//import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionTienda;
//
//public abstract class ProgramacionTiendaMapperDecorator implements ProgramacionTiendaMapper {
//
//	@Autowired
//	@Qualifier("delegate")
//	private ProgramacionTiendaMapper delegate;
//
//	@Autowired
//	private ProgramacionMapper programacionMapper;
//
////	@Autowired
////	private ProgramacionTiendaMapper programacionTiendaMapper;
//
//	@Override
//	public ProgramacionTiendaDto programacionTiendaToProgramacionTiendaDto(ProgramacionTienda src) {
//		if (src == null) {
//			return null;
//		}
//		ProgramacionTiendaDto result = delegate.programacionTiendaToProgramacionTiendaDto(src);
//		Programacion programacionId = programacionMapper.programacionToProgramacionId(src.getProgramacion());
//		result.setProgramacion(programacionMapper.programacionToProgramacionDto(programacionId));
//		return result;
//	}
//
//	@Override
//	public ProgramacionTienda programacionTiendaDtoToProgramacionTienda(ProgramacionTiendaDto src) {
//		if (src == null) {
//			return null;
//		}
//		ProgramacionTienda result = delegate.programacionTiendaDtoToProgramacionTienda(src);
//		ProgramacionDto programacionId = programacionMapper.programacionDtoToProgramacionDtoId(src.getProgramacion());
//		result.setProgramacion(programacionMapper.programacionDtoToProgramacion(programacionId));
//		return result;
//	}
//
//	@Override
//	public List<ProgramacionTiendaDto> programacionTiendaToProgramacionTiendaDto(List<ProgramacionTienda> src) {
//		if (src == null) {
//			return null;
//		}
//		List<ProgramacionTiendaDto> result = new ArrayList<>();
//		src.stream().forEach(item -> {
//			ProgramacionTiendaDto programacionTienda = new ProgramacionTiendaDto();
//			programacionTienda = delegate.programacionTiendaToProgramacionTiendaDto(item);
//			Programacion programacionId = programacionMapper.programacionToProgramacionId(item.getProgramacion());
//			programacionTienda.setProgramacion(programacionMapper.programacionToProgramacionDto(programacionId));
//			result.add(programacionTienda);
//		});
//		return result;
//	}
//
//	@Override
//	public List<ProgramacionTienda> programacionTiendaDtoToProgramacionTienda(List<ProgramacionTiendaDto> src) {
//		if (src == null) {
//			return null;
//		}
//		List<ProgramacionTienda> result = new ArrayList<>();
//		src.stream().forEach(item -> {
//			ProgramacionTienda programacionTienda = new ProgramacionTienda();
//			programacionTienda = delegate.programacionTiendaDtoToProgramacionTienda(item);
//			ProgramacionDto programacionId = programacionMapper
//					.programacionDtoToProgramacionDtoId(item.getProgramacion());
//			programacionTienda.setProgramacion(programacionMapper.programacionDtoToProgramacion(programacionId));
//			result.add(programacionTienda);
//		});
//		return result;
//	}
//
//}