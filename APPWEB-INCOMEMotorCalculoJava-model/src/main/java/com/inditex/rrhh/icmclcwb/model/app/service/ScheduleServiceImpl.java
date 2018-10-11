package com.inditex.rrhh.icmclcwb.model.app.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.ScheduleDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ScheduleJobDto;
import com.inditex.rrhh.icmclcwb.api.app.service.JobService;
import com.inditex.rrhh.icmclcwb.api.app.service.ScheduleService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.JobMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ScheduleMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.ScheduleRepository;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@Service
@Validated
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private Logger LOG;

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private JobMapper jobMapper;

	@Override
	public List<ScheduleJobDto> run() {
		List<ScheduleJobDto> result = new ArrayList<>();
		LOG.info("Inicio :: ScheduleService.run()");
		scheduleMapper.scheduleToScheduleDto(scheduleRepository.findAll()).stream().forEach(e -> {
			ScheduleJobDto scheduleJobDto = new ScheduleJobDto();
			scheduleJobDto.setSchedule(e);
			scheduleJobDto.setJob(jobService.createJob(jobMapper.scheduleDtoToJobDto(e)));
			result.add(scheduleJobDto);
		});
		LOG.info("Fin :: ScheduleService.run(): " + result.toString());
		return result;
	}

	@Override
	public ScheduleDto createSchedule(@Valid ScheduleDto schedule) {
		ScheduleDto result = new ScheduleDto();
		LOG.info("Inicio :: ScheduleService.createSchedule(): " + schedule.toString());
		result = scheduleMapper.scheduleToScheduleDto(scheduleRepository.save(scheduleMapper.scheduleDtoToSchedule(schedule)));
		LOG.info("Fin :: ScheduleService.createSchedule(): " + result.toString());
		return result;
	}

}