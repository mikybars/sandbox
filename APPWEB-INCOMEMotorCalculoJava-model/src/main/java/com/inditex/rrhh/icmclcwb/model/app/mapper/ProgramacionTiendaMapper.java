package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTiendaDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionTienda;
import org.mapstruct.Mapper;

@Mapper
public interface ProgramacionTiendaMapper {

	ProgramacionTiendaDto programacionTiendaToProgramacionTiendaDto(ProgramacionTienda src);

	ProgramacionTienda programacionTiendaDtoToProgramacionTienda(ProgramacionTiendaDto src);

}