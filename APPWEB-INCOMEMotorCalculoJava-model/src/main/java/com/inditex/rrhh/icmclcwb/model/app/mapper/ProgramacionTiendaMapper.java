package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTiendaDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.ProgramacionTiendaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionTienda;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(ProgramacionTiendaMapperDecorator.class)
public interface ProgramacionTiendaMapper {

	ProgramacionTiendaDto programacionTiendaToProgramacionTiendaDto(ProgramacionTienda src);

	ProgramacionTienda programacionTiendaDtoToProgramacionTienda(ProgramacionTiendaDto src);
	
	List<ProgramacionTiendaDto> programacionTiendaToprogramacionTiendaDto(List<ProgramacionTienda> src);
	
	List<ProgramacionTienda> programacionTiendaDtoToprogramacionTienda(List<ProgramacionTiendaDto> src);

}