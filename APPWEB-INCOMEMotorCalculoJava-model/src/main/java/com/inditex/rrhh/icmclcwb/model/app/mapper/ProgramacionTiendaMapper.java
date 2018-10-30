//package com.inditex.rrhh.icmclcwb.model.app.mapper;
//
//import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTiendaDto;
//import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.ProgramacionTiendaMapperDecorator;
//import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionTienda;
//
//import java.util.List;
//
//import org.mapstruct.DecoratedWith;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//
//@Mapper
////@DecoratedWith(ProgramacionTiendaMapperDecorator.class)
//public interface ProgramacionTiendaMapper {
//
////	@Named("programacionTiendaToProgramacionTiendaDto")
//	@Mappings({ @Mapping(target = "programacion", ignore = true) })
//	ProgramacionTiendaDto programacionTiendaToProgramacionTiendaDto(ProgramacionTienda src);
//
////	@Named("programacionTiendaDtoToProgramacionTienda")
//	@Mappings({ @Mapping(target = "programacion", ignore = true) })
//	ProgramacionTienda programacionTiendaDtoToProgramacionTienda(ProgramacionTiendaDto src);
//
////	@IterableMapping(elementTargetType = ProgramacionTiendaDto.class)
////	@IterableMapping(qualifiedByName = "programacionTiendaToProgramacionTiendaDto")
//	List<ProgramacionTiendaDto> programacionTiendaToProgramacionTiendaDto(List<ProgramacionTienda> src);
//
////	@IterableMapping(elementTargetType = ProgramacionTienda.class)
////	@IterableMapping(qualifiedByName = "programacionTiendaDtoToProgramacionTienda")
//	List<ProgramacionTienda> programacionTiendaDtoToProgramacionTienda(List<ProgramacionTiendaDto> src);
//
//}