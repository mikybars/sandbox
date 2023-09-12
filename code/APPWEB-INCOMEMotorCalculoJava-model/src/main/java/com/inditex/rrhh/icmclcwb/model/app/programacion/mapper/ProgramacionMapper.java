package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.Programacion;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class ProgramacionMapper {

  @Mapping(target = "ambito", ignore = true)
  public abstract ProgramacionDTO programacionToProgramacionDto(Programacion src);

  public abstract List<ProgramacionDTO> programacionToProgramacionDto(List<Programacion> src);

  @Mapping(target = "tipoAmbito.nombre", ignore = true)
  public abstract Programacion programacionDtoToProgramacion(ProgramacionDTO src);

  public abstract List<Programacion> programacionDtoToProgramacion(List<ProgramacionDTO> src);

  OffsetDateTime map(final LocalDateTime value) {
    return value != null ? value.atOffset(ZoneOffset.UTC) : null;
  }

  LocalDateTime map(final OffsetDateTime value) {
    return value != null ? value.toLocalDateTime() : null;
  }

  OffsetDateTime mapLocalTime(final LocalTime value) {
    return OffsetDateTime.of(LocalDate.now(), value, ZoneOffset.UTC);
  }

  LocalTime mapLocalTime(final OffsetDateTime value) {
    return value.toLocalTime();
  }

}
