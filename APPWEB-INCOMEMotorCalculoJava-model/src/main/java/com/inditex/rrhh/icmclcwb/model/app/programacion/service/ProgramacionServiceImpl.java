package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.aqsw.framework.service.aaa.userdetails.sso.model.UserSSO;
import com.inditex.aqsw.framework.service.aaa.userdetails.sso.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionRepositoryCustom;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
  public ProgramacionDTO create(@Valid final ProgramacionDTO programacion) {
    programacion.setFechaHoraCreacion(TimeUtils.nowLocalDateTime().atOffset(ZoneOffset.UTC));
    if (StringUtils.isBlank(programacion.getProgramacionHuso())) {
      programacion.setProgramacionHuso(TimeUtils.ofZoneId());
    }
    if (StringUtils.isBlank(programacion.getNombreUsuario())) {
      final UserSSO userSSO = SsoUtils.getUserSSO();
      if (StringUtils.isNotBlank(userSSO.getUser())) {
        programacion.setNombreUsuario(userSSO.getUser());
      }
    }
    programacion
        .setFechaHoraSiguienteEjecucion(this.fechaSiguienteEjecucion(programacion).atOffset(ZoneOffset.UTC));
    final ProgramacionDTO result = this.programacionMapper.programacionToProgramacionDto(
        this.programacionRepository.save(this.programacionMapper.programacionDtoToProgramacion(programacion)));
    result.setAmbito(this.programacionAmbitoService.create(programacion.getAmbito(), result));
    return result;
  }

  @Override
  public ProgramacionDTO modify(final ProgramacionDTO programacion) {
    final ProgramacionDTO result = this.programacionMapper.programacionToProgramacionDto(
        this.programacionRepository.save(this.programacionMapper.programacionDtoToProgramacion(programacion)));
    result.setAmbito(this.programacionAmbitoService.findByProgramacion(programacion));
    return result;
  }

  @Override
  public LocalDateTime fechaSiguienteEjecucion(@Valid final ProgramacionDTO programacion) {
    final ZoneId zoneDefaultHuso = TimeUtils.ofZone();
    final ZoneId zoneProgramacionHuso = TimeUtils.ofZone(programacion.getProgramacionHuso());
    ZonedDateTime zonedDateTimeProgramacionHuso = TimeUtils.ofZonedDateTime(
        programacion.getHoraProgramacion().toLocalTime(),
        zoneProgramacionHuso);
    final ZonedDateTime nowZonedDateTimeProgramacionHuso = TimeUtils.nowZonedDateTime(zoneProgramacionHuso);
    if (nowZonedDateTimeProgramacionHuso.isAfter(zonedDateTimeProgramacionHuso)) {
      zonedDateTimeProgramacionHuso = zonedDateTimeProgramacionHuso.plusDays(1);
    }
    return zonedDateTimeProgramacionHuso.withZoneSameInstant(zoneDefaultHuso).toLocalDateTime();
  }

  @Override
  public List<ProgramacionDTO> findPendiente() {
    final List<ProgramacionDTO> result = this.programacionMapper
        .programacionToProgramacionDto(this.programacionRepository
            .findByFechaHoraSiguienteEjecucionBeforeAndActivoTrue(TimeUtils.nowLocalDateTime()));
    result.forEach(item -> item.setAmbito(this.programacionAmbitoService.findByProgramacion(item)));
    return result;
  }

  @Override
  public ProgramacionDTO updateEjecucion(@Valid final ProgramacionDTO programacion) {
    programacion.setFechaHoraUltimaEjecucion(TimeUtils.nowLocalDateTime().atOffset(ZoneOffset.UTC));
    return this.modify(programacion);
  }

  @Override
  public void reset() {
    this.programacionRepositoryCustom.reset();
  }

  @Override
  public void activa() {
    this.programacionRepositoryCustom.activa();
  }

  @Override
  public void activa(@Positive @NotNull final Long id) {
    this.programacionRepositoryCustom.activa(id);
  }

  @Override
  public void desactiva() {
    this.programacionRepositoryCustom.desactiva();
  }

  @Override
  public void desactiva(@Positive @NotNull final Long id) {
    this.programacionRepositoryCustom.desactiva(id);
  }

  @Override
  public ProgramacionDTO findById(@Positive @NotNull final Long id) {
    final ProgramacionDTO programacionDto = this.programacionMapper
        .programacionToProgramacionDto(this.programacionRepository.findById(id).get());
    programacionDto.setAmbito(this.programacionAmbitoService.findByProgramacion(programacionDto));
    return programacionDto;
  }

  @Override
  public ProgramacionDTO findActivoById(
      @Positive @NotNull final Long id) {
    final ProgramacionDTO programacionDto = this.programacionMapper
        .programacionToProgramacionDto(this.programacionRepository.findByIdAndActivoTrue(id));
    programacionDto.setAmbito(this.programacionAmbitoService.findByProgramacion(programacionDto));
    return programacionDto;
  }

  @Override
  public ProgramacionDTO findPendienteById(@Positive @NotNull final Long id) {
    final ProgramacionDTO programacionDto = this.programacionMapper
        .programacionToProgramacionDto(this.programacionRepository
            .findByIdAndFechaHoraSiguienteEjecucionBeforeAndActivoTrue(id, TimeUtils.nowLocalDateTime()));
    programacionDto.setAmbito(this.programacionAmbitoService.findByProgramacion(programacionDto));
    return programacionDto;
  }

  @Override
  public void updateFechaSiguienteEjecucion(
      @NotNull @NotEmpty final List<ProgramacionDTO> programaciones) {
    // Se obtienen todas las fechas por programacion
    final Map<LocalDateTime, List<ProgramacionDTO>> map = new HashMap<>();
    programaciones.stream().forEach(programacion -> {
      final LocalDateTime fechaSiguienteEjecucion = this.fechaSiguienteEjecucion(programacion);
      if (!map.containsKey(fechaSiguienteEjecucion)) {
        map.put(fechaSiguienteEjecucion, new ArrayList<>());
      }
      map.get(fechaSiguienteEjecucion).add(programacion);
    });

    map.forEach((fechaSiguienteEjecucion, program) -> {
      final List<IdProgramacionDto> ids = program.stream()
          .map(programacion -> IdProgramacionDto.builder().id(programacion.getId()).build())
          .collect(Collectors.toList());
      this.programacionRepositoryCustom.updateFechaSiguienteEjecucion(ids, fechaSiguienteEjecucion);
    });
  }

}
