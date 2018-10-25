package com.inditex.rrhh.icmclcwb.model.app.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.service.Meta4Service;
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
import java.util.Date;
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

	@Autowired
	private Meta4Service meta4Service;

	@Override
	public List<ProgramacionTrabajoDto> run() {
		List<ProgramacionTrabajoDto> result = new ArrayList<>();
		LOG.info("Inicio :: ProgramacionService.run()");
		programacionMapper
				.programacionToProgramacionDto(
						programacionRepository.findByFechaSiguienteEjecucionBeforeAndActivaTrue(new Date()))
				.stream().forEach(programacion -> {
					meta4Service.periodo().stream().forEach(periodo -> {
						ProgramacionTrabajoDto programacionTrabajoDto = new ProgramacionTrabajoDto();

						TrabajoDto trabajo = trabajoMapper.programacionDtoToTrabajoDto(programacion);
						trabajo.setFechaInicioPeriodo(periodo.getFechaInicioPeriodo());
						trabajo.setFechaFinPeriodo(periodo.getFechaFinPeriodo());
						programacionTrabajoDto.setTrabajo(trabajoService.createTrabajo(trabajo));

						programacion.setFechaUltimaEjecucion(LocalDateTime.now());
						// Programamos la ejecucion para el dia siguiente
						programacion.setFechaSiguienteEjecucion(programacion.getFechaSiguienteEjecucion().plusDays(1));
						programacionTrabajoDto.setProgramacion(modifyProgramacion(programacion));

						result.add(programacionTrabajoDto);
					});
				});
		LOG.info("Fin :: ProgramacionService.run(): {}", result);
		return result;
	}

	@Override
	public ProgramacionDto createProgramacion(@Valid ProgramacionDto programacion) {
		ProgramacionDto result = new ProgramacionDto();
		LOG.info("Inicio :: ProgramacionService.createProgramacion(): {}", programacion);
		programacion.setFechaCreacion(LocalDateTime.now());
		programacion.setFechaSiguienteEjecucion(LocalDateTime.of(LocalDate.now(), programacion.getHora()));
		result = programacionMapper.programacionToProgracionDto(
				programacionRepository.save(programacionMapper.programacionDtoToProgramacion(programacion)));
		LOG.info("Fin :: ProgramacionService.createProgramacion(): {}", result);
		return result;
	}

	@Override
	public Boolean init() {
		Boolean result = Boolean.TRUE;
		Random random = new Random();
		for (int i = 1; i <= 500; i++) {
			ProgramacionDto programacion = new ProgramacionDto();
			programacion.setActiva(Boolean.TRUE);
			programacion.setHora(LocalTime.of(random.nextInt(24), random.nextInt(60)));
			programacion.setIdPais("11");
			programacion.setIdCadena("1");
			programacion.setIdTienda("T" + i);
			programacion.setIdUsuario("INIT");
			createProgramacion(programacion);
		}
		return result;
	}

	@Override
	public ProgramacionDto modifyProgramacion(@Valid ProgramacionDto programacion) {
		LOG.info("Inicio :: ProgramacionService.modifyProgramacion(): {}", programacion);
		ProgramacionDto result = programacionMapper.programacionToProgracionDto(
				programacionRepository.save(programacionMapper.programacionDtoToProgramacion(programacion)));
		LOG.info("Fin :: ProgramacionService.modifyProgramacion(): {}", result);
		return result;
	}

}