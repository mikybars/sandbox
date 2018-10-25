package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.Constants;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;

public abstract class TrabajoMapperDecorator implements TrabajoMapper {

	@Autowired
    @Qualifier("delegate")
    private TrabajoMapper delegate;
	
	@Override
	public TrabajoDto programacionDtoToTrabajoDto(ProgramacionDto src) {
		TrabajoDto result = delegate.programacionDtoToTrabajoDto(src);
		result.setFechaCreacion(LocalDateTime.now());
		EstadoTrabajoDto estadoTrabajo = new EstadoTrabajoDto();
		estadoTrabajo.setId(Constants.EstadoTrabajoEnum.PENDIENTE_DATOS.getId());
		result.setEstado(estadoTrabajo);
		result.setProgramacion(src);
		return result;
	}

}