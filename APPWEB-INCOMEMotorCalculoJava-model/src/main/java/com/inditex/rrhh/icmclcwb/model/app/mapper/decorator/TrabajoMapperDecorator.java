package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
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
		estadoTrabajo.setId(Constants.EstadoTrabajoEnum.ESTADO_TRABAJO_PENDIENTE_CALCULO.getId());
		result.setEstado(estadoTrabajo);
		LocalDate periodo = LocalDate.now().plusMonths(-src.getPeriodo());
		result.setFechaInicioPeriodo(periodo.with(TemporalAdjusters.firstDayOfMonth()).atTime(LocalTime.MIN));
		result.setFechaFinPeriodo(periodo.with(TemporalAdjusters.firstDayOfNextMonth()).atTime(LocalTime.MAX));
		result.setProgramacion(src);
		return result;
	}

}