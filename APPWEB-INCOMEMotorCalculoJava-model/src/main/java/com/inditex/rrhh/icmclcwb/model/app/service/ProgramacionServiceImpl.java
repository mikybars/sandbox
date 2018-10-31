package com.inditex.rrhh.icmclcwb.model.app.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.service.Meta4SessionService;
import com.inditex.rrhh.icmclcwb.api.app.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Programacion;
import com.inditex.rrhh.icmclcwb.model.primary.repository.ProgramacionEmpleadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.ProgramacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.ProgramacionTiendaRepository;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
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
	private ProgramacionTiendaRepository programacionTiendaRepository;

	@Autowired
	private ProgramacionEmpleadoRepository programacionEmpleadoRepository;

	@Autowired
	private TrabajoService trabajoService;

	@Autowired
	private TrabajoMapper trabajoMapper;

	@Autowired
	private Meta4SessionService meta4Service;

	@Override
	public List<TrabajoDto> run() {
		List<TrabajoDto> result = new ArrayList<>();
		LOG.info("Inicio :: ProgramacionService.run()");
		programacionMapper
				.programacionToProgramacionDto(
						programacionRepository.findByFechaSiguienteEjecucionBeforeAndActivaTrue(new Date()))
				.stream().forEach(programacion -> {
					programacion.setFechaUltimaEjecucion(LocalDateTime.now());
					programacion.setFechaSiguienteEjecucion(programacion.getFechaSiguienteEjecucion().plusDays(1));
					ProgramacionDto programacionModify = modifyProgramacion(programacion);
					meta4Service.periodo().stream().forEach(periodo -> {
						TrabajoDto trabajo = trabajoMapper.programacionDtoToTrabajoDto(programacionModify);
						trabajo.setFechaInicioPeriodo(periodo.getFechaInicioPeriodo());
						trabajo.setFechaFinPeriodo(periodo.getFechaFinPeriodo());
						result.add(trabajoService.createTrabajo(trabajo));
					});
				});
		LOG.info("Fin :: ProgramacionService.run(): {}", result);
		return result;
	}

	@Override
	public ProgramacionDto createProgramacion(@Valid ProgramacionDto programacion) {
		LOG.info("Inicio :: ProgramacionService.createProgramacion(): {}", programacion);
		programacion.setFechaCreacion(LocalDateTime.now());
		programacion.setFechaSiguienteEjecucion(LocalDateTime.of(LocalDate.now(), programacion.getHora()));
		ProgramacionDto parent = programacionMapper.programacionToProgramacionDto(
				programacionRepository.save(programacionMapper.programacionDtoToProgramacion(programacion)));
		parent.setTiendas(programacion.getTiendas());
		parent.setEmpleados(programacion.getEmpleados());
		Programacion child = programacionMapper.programacionDtoToProgramacion(parent);
		if (CollectionUtils.isNotEmpty(child.getTiendas())) {
			child.setTiendas(programacionTiendaRepository.save(child.getTiendas()));
		} else if (CollectionUtils.isNotEmpty(child.getEmpleados())) {
			child.setEmpleados(programacionEmpleadoRepository.save(child.getEmpleados()));
		}
		ProgramacionDto result = programacionMapper.programacionToProgramacionDto(child);
		LOG.info("Fin :: ProgramacionService.createProgramacion(): {}", result);
		return result;
	}

	@Override
	public Boolean init() {
		Boolean result = Boolean.TRUE;
		Random random = new Random();
		String idPais = "11";
		String idCadena = "1";
		for (int i = 1; i <= 500; i++) {
			ProgramacionDto programacion = new ProgramacionDto();
			programacion.setActiva(Boolean.TRUE);
			programacion.setHora(LocalTime.of(random.nextInt(24), random.nextInt(60)));
			programacion.setIdPais(idPais);
			programacion.setIdCadena(idCadena);
			ProgramacionTiendaDto tienda = new ProgramacionTiendaDto();
			tienda.setIdTienda(String.valueOf(i));
			programacion.setTiendas(Arrays.asList(tienda));
			programacion.setIdUsuario("INIT");
			createProgramacion(programacion);
		}
		return result;
	}

	@Override
	public ProgramacionDto modifyProgramacion(@Valid final ProgramacionDto programacion) {
		LOG.info("Inicio :: ProgramacionService.modifyProgramacion(): {}", programacion);
		ProgramacionDto result = programacionMapper.programacionToProgramacionDto(
				programacionRepository.save(programacionMapper.programacionDtoToProgramacion(programacion)));
		result.setTiendas(programacion.getTiendas());
		result.setEmpleados(programacion.getEmpleados());
		LOG.info("Fin :: ProgramacionService.modifyProgramacion(): {}", result);
		return result;
	}

}