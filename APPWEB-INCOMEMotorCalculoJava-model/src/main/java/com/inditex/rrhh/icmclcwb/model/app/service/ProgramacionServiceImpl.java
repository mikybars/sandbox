package com.inditex.rrhh.icmclcwb.model.app.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.ProgramacionRepository;

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
public class ProgramacionServiceImpl implements ProgramacionService {

	@Autowired
	private Logger LOG;

	@Autowired
	private ProgramacionRepository programacionRepository;

	@Autowired
	private ProgramacionMapper programacionMapper;

	@Autowired
	private TrabajoService trabajoService;

	@Autowired
	private TrabajoMapper trabajoMapper;

	@Override
	public List<ProgramacionTrabajoDto> run() {
		List<ProgramacionTrabajoDto> result = new ArrayList<>();
		LOG.info("Inicio :: ProgramacionService.run()");
		programacionMapper.programacionToProgramacionDto(programacionRepository.findAll()).stream().forEach(e -> {
			ProgramacionTrabajoDto programacionTrabajoDto = new ProgramacionTrabajoDto();
			programacionTrabajoDto.setProgramacion(e);
			programacionTrabajoDto.setTrabajo(trabajoService.createTrabajo(trabajoMapper.programacionDtoToTrabajoDto(e)));
			result.add(programacionTrabajoDto);
		});
		LOG.info("Fin :: ProgramacionService.run(): " + result.toString());
		return result;
	}

	@Override
	public ProgramacionDto createProgramacion(@Valid ProgramacionDto programacion) {
		ProgramacionDto result = new ProgramacionDto();
		LOG.info("Inicio :: ProgramacionService.createProgramacion(): {}", programacion);
		programacion.setFechaCreacion(LocalDateTime.now());
		programacion.setFechaSiguienteEjecucion(LocalDateTime.of(LocalDate.now(), programacion.getHora()));
		result = programacionMapper
				.programacionToProgracionDto(programacionRepository.save(programacionMapper.programacionDtoToProgramacion(programacion)));
		LOG.info("Fin :: ProgramacionService.createProgramacion(): {}", result);
		return result;
	}

	@Override
	public Boolean init() {
		Boolean result = Boolean.TRUE;

		Random random = new Random();
		LocalDateTime nowDateTime = LocalDateTime.now();
		LocalDate nowDate = LocalDate.now();
		for (int i = 1; i <= 500; i++) {
			ProgramacionDto programacion = new ProgramacionDto();
			LocalTime time = LocalTime.of(random.nextInt(24), random.nextInt(60));

			programacion.setActiva(Boolean.TRUE);
			programacion.setFechaCreacion(nowDateTime);
			programacion.setFechaSiguienteEjecucion(LocalDateTime.of(nowDate, time));
			programacion.setHora(time);
			programacion.setIdTienda("T" + i);
			programacion.setIdUsuario("INIT");
			programacion.setPeriodo(new Long(random.nextInt(2)));

			createProgramacion(programacion);
		}

		return result;
	}

}