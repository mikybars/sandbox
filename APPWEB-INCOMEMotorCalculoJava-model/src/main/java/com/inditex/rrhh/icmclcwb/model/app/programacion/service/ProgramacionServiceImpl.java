package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import com.inditex.aqsw.framework.service.aaa.classic.serviciossso.UserSSO;
import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionRepositoryCustom;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Service
@Validated
public class ProgramacionServiceImpl implements ProgramacionService {

    @Autowired
    private ProgramacionRepositoryCustom programacionRepositoryCustom;

    @Autowired
    private ProgramacionRepository programacionRepository;

    @Autowired
    private ProgramacionMapper programacionMapper;

    @Autowired
    private ProgramacionAmbitoService programacionAmbitoService;

    @Override
    public ProgramacionDto create(@Valid final ProgramacionDto programacion) {
        programacion.setFechaHoraCreacion(TimeUtils.nowLocalDateTime());
        if (StringUtils.isBlank(programacion.getProgramacionHuso())) {
            programacion.setProgramacionHuso(TimeUtils.ofZoneId());
        }
        if (StringUtils.isBlank(programacion.getNombreUsuario())) {
            UserSSO userSSO = SsoUtils.getUserSSO();
            if (StringUtils.isNotBlank(userSSO.getUser())) {
                programacion.setNombreUsuario(userSSO.getUser());
            }
        }
        programacion.setFechaHoraSiguienteEjecucion(fechaSiguienteEjecucion(programacion));
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
        ZoneId zoneDefaultHuso = TimeUtils.ofZone();
        ZoneId zoneProgramacionHuso = TimeUtils.ofZone(programacion.getProgramacionHuso());
        ZonedDateTime zonedDateTimeProgramacionHuso = TimeUtils.ofZonedDateTime(programacion.getHoraProgramacion(),
                zoneProgramacionHuso);
        ZonedDateTime nowZonedDateTimeProgramacionHuso = TimeUtils.nowZonedDateTime(zoneProgramacionHuso);
        if (nowZonedDateTimeProgramacionHuso.isAfter(zonedDateTimeProgramacionHuso)) {
            zonedDateTimeProgramacionHuso = zonedDateTimeProgramacionHuso.plusDays(1);
        }
        return zonedDateTimeProgramacionHuso.withZoneSameInstant(zoneDefaultHuso).toLocalDateTime();
    }

    @Override
    public List<ProgramacionDto> findPendiente() {
        List<ProgramacionDto> result = programacionMapper.programacionToProgramacionDto(programacionRepository
            .findByFechaHoraSiguienteEjecucionBeforeAndActivoTrue(TimeUtils.nowLocalDateTime()));
        result.forEach(item -> item.setAmbito(programacionAmbitoService.findByProgramacion(item)));
        return result;
    }

    @Override
    public ProgramacionDto updateEjecucion(@Valid ProgramacionDto programacion) {
        programacion.setFechaHoraUltimaEjecucion(TimeUtils.nowLocalDateTime());
        programacion.setFechaHoraSiguienteEjecucion(fechaSiguienteEjecucion(programacion));
        return modify(programacion);
    }

    @Override
    public void reset() {
        programacionRepositoryCustom.reset();
    }

    @Override
    public void activa() {
        programacionRepositoryCustom.activa();
    }

    @Override
    public void activa(@Positive @NotNull Long id) {
        programacionRepositoryCustom.activa(id);
    }

    @Override
    public void desactiva() {
        programacionRepositoryCustom.desactiva();
    }

    @Override
    public void desactiva(@Positive @NotNull Long id) {
        programacionRepositoryCustom.desactiva(id);
    }

    @Override
    public ProgramacionDto findById(@Positive @NotNull final Long id) {
        ProgramacionDto programacionDto = programacionMapper
            .programacionToProgramacionDto(programacionRepository.findById(id).get());
        programacionDto.setAmbito(programacionAmbitoService.findByProgramacion(programacionDto));
        return programacionDto;
    }

    @Override
    public ProgramacionDto findPendienteById(@Positive @NotNull final Long id) {
        ProgramacionDto programacionDto = programacionMapper.programacionToProgramacionDto(programacionRepository
            .findByIdAndFechaHoraSiguienteEjecucionBeforeAndActivoTrue(id, TimeUtils.nowLocalDateTime()));
        programacionDto.setAmbito(programacionAmbitoService.findByProgramacion(programacionDto));
        return programacionDto;
    }

}
