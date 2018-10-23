package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.JobStatusDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ScheduleDto;
import com.inditex.rrhh.icmclcwb.api.app.util.Constants;
import com.inditex.rrhh.icmclcwb.model.app.mapper.JobMapper;

public abstract class JobMapperDecorator implements JobMapper {

	@Autowired
    @Qualifier("delegate")
    private JobMapper delegate;

	@Override
	public JobDto scheduleDtoToJobDto(ScheduleDto src) {
		JobDto result = delegate.scheduleDtoToJobDto(src);
		result.setFechaCreacion(LocalDateTime.now());
		JobStatusDto jobStatus = new JobStatusDto();
		jobStatus.setId(Constants.JobStatusEnum.ESTADO_JOB_PENDIENTE_CALCULO.getId());
		result.setEstado(jobStatus);
		LocalDate periodo = LocalDate.now().plusMonths(-src.getPeriodo());
		result.setFechaInicioPeriodo(periodo.with(TemporalAdjusters.firstDayOfMonth()).atTime(LocalTime.MIN));
		result.setFechaFinPeriodo(periodo.with(TemporalAdjusters.firstDayOfNextMonth()).atTime(LocalTime.MAX));
		result.setSchedule(src);
		return result;
	}

}