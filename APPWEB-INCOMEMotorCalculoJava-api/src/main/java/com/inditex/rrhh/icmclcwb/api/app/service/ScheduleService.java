package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ScheduleJobDto;

public interface ScheduleService {

	List<ScheduleJobDto> run();

}