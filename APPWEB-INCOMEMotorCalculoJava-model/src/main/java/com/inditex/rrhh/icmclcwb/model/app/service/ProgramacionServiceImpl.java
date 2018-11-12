package com.inditex.rrhh.icmclcwb.model.app.service;

import com.inditex.aqsw.framework.service.aaa.classic.serviciossso.UserSSO;
import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionEmpleadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.ProgramacionEmpleadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.ProgramacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.ProgramacionTiendaRepository;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
	private ProgramacionTiendaMapper programacionTiendaMapper;

	@Autowired
	private ProgramacionEmpleadoRepository programacionEmpleadoRepository;

	@Autowired
	private ProgramacionEmpleadoMapper programacionEmpleadoMapper;

	@Override
	public ProgramacionDto createProgramacion(@Valid ProgramacionDto programacion) {
		LOG.info("Inicio :: ProgramacionService.createProgramacion(): {}", programacion);
		programacion.setFechaCreacion(LocalDateTime.now());
		if (StringUtils.isBlank(programacion.getHuso())) {
			programacion.setHuso(ZoneId.systemDefault().getId());
		}
		if (StringUtils.isBlank(programacion.getIdUsuario())) {
			UserSSO userSSO = SsoUtils.getUserSSO();
			if (StringUtils.isNotBlank(userSSO.getUsername())) {
				programacion.setIdUsuario(userSSO.getUsername());
			}
		}
		programacion.setFechaSiguienteEjecucion(fechaSiguienteEjecucion(programacion));
		ProgramacionDto result = programacionMapper.programacionToProgramacionDto(
				programacionRepository.save(programacionMapper.programacionDtoToProgramacion(programacion)));
		if (CollectionUtils.isNotEmpty(programacion.getTiendas())) {
			result.setTiendas(programacionTiendaMapper.programacionTiendaToProgramacionTiendaDto(programacionTiendaRepository
					.save(programacionTiendaMapper.mergeProgramacionTiendaDtoAndProgramacionDtoToProgramacionTienda(
							programacion.getTiendas(), result))));
		} else if (CollectionUtils.isNotEmpty(programacion.getEmpleados())) {
			result.setEmpleados(programacionEmpleadoMapper.programacionEmpleadoToProgramacionEmpleadoDto(programacionEmpleadoRepository
					.save(programacionEmpleadoMapper.mergeProgramacionEmpleadoDtoAndProgramacionDtoToProgramacionEmpleado(
							programacion.getEmpleados(), result))));
		}
		LOG.info("Fin :: ProgramacionService.createProgramacion(): {}", result);
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

	@Override
	public LocalDateTime fechaSiguienteEjecucion(@Valid ProgramacionDto programacion) {
		return ZonedDateTime
				.of(LocalDate.now(ZoneId.of(programacion.getHuso())).plusDays(1), programacion.getHora(),
						ZoneId.of(programacion.getHuso()))
				.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
	}

}