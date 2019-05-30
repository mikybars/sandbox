package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import com.inditex.aqsw.framework.service.aaa.classic.serviciossso.UserSSO;
import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

@Service
@Validated
public class ProgramacionServiceImpl implements ProgramacionService {

    @Autowired
    private ProgramacionRepository programacionRepository;

    @Autowired
    private ProgramacionMapper programacionMapper;

    @Autowired
    private ProgramacionAmbitoService programacionAmbitoService;

    @Override
    public ProgramacionDto create(@Valid final ProgramacionDto programacion) {
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
        result.setAmbito(programacionAmbitoService.create(programacion.getAmbito(), result));
        return result;
    }

    @Override
    public ProgramacionDto modify(final ProgramacionDto programacion) {
        ProgramacionDto result = programacionMapper.programacionToProgramacionDto(
                programacionRepository.save(programacionMapper.programacionDtoToProgramacion(programacion)));
        result.setAmbito(programacionAmbitoService.findByProgramacion(programacion));
        return result;
    }

    @Override
    public LocalDateTime fechaSiguienteEjecucion(@Valid final ProgramacionDto programacion) {
        return ZonedDateTime
                .of(LocalDate.now(ZoneId.of(programacion.getHuso())), programacion.getHora(),
                        ZoneId.of(programacion.getHuso()))
                .isAfter(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(programacion.getHuso())))
                        ? ZonedDateTime
                                .of(LocalDate.now(ZoneId.of(programacion.getHuso())), programacion.getHora(),
                                        ZoneId.of(programacion.getHuso()))
                                .withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime()
                        : ZonedDateTime
                                .of(LocalDate.now(ZoneId.of(programacion.getHuso())).plusDays(1),
                                        programacion.getHora(), ZoneId.of(programacion.getHuso()))
                                .withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Override
    public List<ProgramacionDto> findPendiente() {
        List<ProgramacionDto> result = programacionMapper.programacionToProgramacionDto(
                programacionRepository.findByFechaSiguienteEjecucionBeforeAndActivaTrue(new Date()));
        result.forEach(item -> item.setAmbito(programacionAmbitoService.findByProgramacion(item)));
        return result;
    }

    @Override
    public ProgramacionDto updateEjecucion(@Valid ProgramacionDto programacion) {
        programacion.setFechaUltimaEjecucion(LocalDateTime.now());
        // TODO No marcamos la siguiente ejecucion para que siempre se ejecute
        // programacion.setFechaSiguienteEjecucion(programacionService.fechaSiguienteEjecucion(programacion));
        return modify(programacion);
    }

}