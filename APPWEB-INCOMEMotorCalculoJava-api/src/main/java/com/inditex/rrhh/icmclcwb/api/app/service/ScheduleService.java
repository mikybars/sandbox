package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.ScheduleDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ScheduleJobDto;

public interface ScheduleService {

	List<ScheduleJobDto> run();

	ScheduleDto createSchedule(@Valid final ScheduleDto schedule);

	Boolean init();

}