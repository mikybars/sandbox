package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTiendaDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionTienda;

public abstract class ProgramacionTiendaMapperDecorator implements ProgramacionTiendaMapper {

	@Autowired
    @Qualifier("delegate")
    private ProgramacionTiendaMapper delegate;
	
	@Autowired
	private ProgramacionMapper programacionMapper;
	
	@Override
	public ProgramacionTiendaDto programacionTiendaToProgramacionTiendaDto(ProgramacionTienda src) {
		ProgramacionTiendaDto result = delegate.programacionTiendaToProgramacionTiendaDto(src);
		result.setProgramacion(programacionMapper.programacionDtoToProgracionDtoId(result.getProgramacion()));
		return result;
	}

	@Override
	public ProgramacionTienda programacionTiendaDtoToProgramacionTienda(ProgramacionTiendaDto src) {
		ProgramacionTienda result = delegate.programacionTiendaDtoToProgramacionTienda(src);
		result.setProgramacion(programacionMapper.programacionToProgracionId(result.getProgramacion()));
		return result;
	}

}