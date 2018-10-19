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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		LOG.info("Inicio :: ScheduleService.createSchedule(): {}", schedule);
		schedule.setFechaCreacion(LocalDateTime.now());
		schedule.setFechaSiguienteEjecucion(LocalDateTime.of(LocalDate.now(), schedule.getHora()));
		result = scheduleMapper
				.scheduleToScheduleDto(scheduleRepository.save(scheduleMapper.scheduleDtoToSchedule(schedule)));
		LOG.info("Fin :: ScheduleService.createSchedule(): {}", result);
		return result;
	}

	@Override
	public Boolean init() {
		Boolean result = Boolean.TRUE;

		Random random = new Random();
		LocalDateTime nowDateTime = LocalDateTime.now();
		LocalDate nowDate = LocalDate.now();
		for (int i = 1; i <= 500; i++) {
			ScheduleDto schedule = new ScheduleDto();
			LocalTime time = LocalTime.of(random.nextInt(24), random.nextInt(60));

			schedule.setActiva(Boolean.TRUE);
			schedule.setFechaCreacion(nowDateTime);
			schedule.setFechaSiguienteEjecucion(LocalDateTime.of(nowDate, time));
			schedule.setHora(time);
			schedule.setIdTienda("T" + i);
			schedule.setIdUsuario("INIT");
			schedule.setPeriodo(new Long(random.nextInt(2)));

			createSchedule(schedule);
		}

		return result;
	}

}