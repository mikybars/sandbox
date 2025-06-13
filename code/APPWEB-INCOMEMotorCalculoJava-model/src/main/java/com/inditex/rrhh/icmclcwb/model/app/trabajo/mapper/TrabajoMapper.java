package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoEjecucionCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.dto.PeriodoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator.TrabajoMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.Trabajo;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.Programacion.class,
    com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity.Simulacion.class,
    TipoEjecucionCalculoEnum.class})
@DecoratedWith(value = TrabajoMapperDecorator.class)
public abstract class TrabajoMapper {

  @Mapping(target = "idProgramacion",
      expression = "java(src != null && src.getProgramacion() != null && src.getProgramacion().getId() != null ?"
          + " src.getProgramacion().getId() : null)")
  @Mapping(target = "idSimulacion",
      expression = "java(src != null && src.getSimulacion() != null && src.getSimulacion().getId() != null ?"
          + " src.getSimulacion().getId() : null)")
  @Mapping(target = "origen", ignore = true)
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "persona", ignore = true)
  @Mapping(target = "localizacion", ignore = true)
  public abstract TrabajoDTO trabajoToTrabajoDto(Trabajo src);

  public abstract List<TrabajoDTO> trabajoToTrabajoDto(List<Trabajo> src);

  @Mapping(target = "programacion",
      expression = "java(src != null && src.getIdProgramacion() != null ?"
          + " Programacion.builder().id(src.getIdProgramacion()).build() : null)")
  @Mapping(target = "estado.id", source = "estadoTrabajo.id")
  @Mapping(target = "estado.nombre", ignore = true)
  @Mapping(target = "estado.peso", ignore = true)
  @Mapping(target = "estado.estadoTarea", ignore = true)
  @Mapping(target = "tipoAmbito.nombre", ignore = true)
  @Mapping(target = "simulacion",
      expression = "java(src != null && src.getIdSimulacion() != null ?"
          + " Simulacion.builder().id(src.getIdSimulacion()).build() : null)")
  public abstract Trabajo trabajoDtoToTrabajo(TrabajoDTO src);

  public abstract List<Trabajo> trabajoDtoToTrabajo(List<TrabajoDTO> src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "fechaHoraCreacion", ignore = true)
  @Mapping(target = "fechaHoraInicioTrabajo", ignore = true)
  @Mapping(target = "fechaHoraFinTrabajo", ignore = true)
  @Mapping(target = "estadoTrabajo", ignore = true)
  @Mapping(target = "idProgramacion", source = "srcProgramacion.id")
  @Mapping(target = "tipoAmbito", source = "srcProgramacion.tipoAmbito")
  @Mapping(target = "nombreUsuario", source = "srcProgramacion.nombreUsuario")
  @Mapping(target = "icmIdPeriodo", source = "srcPeriodo.id")
  @Mapping(target = "fechaInicioPeriodo", source = "srcPeriodo.fechaInicioPeriodo")
  @Mapping(target = "fechaFinPeriodo", source = "srcPeriodo.fechaFinPeriodo")
  @Mapping(target = "idOrganization", source = "srcProgramacionAmbito.idOrganization")
  public abstract TrabajoDTO mergeProgramacionAmbitoDtoAndProgramacionDtoAndPeriodoDtoToTrabajoDto(
      ProgramacionAmbitoDTO srcProgramacionAmbito, ProgramacionDTO srcProgramacion, PeriodoDTO srcPeriodo);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idTrabajo", ignore = true)
  public abstract TrabajoAmbitoOrigenDto programacionAmbitoOrigenDtoToTrabajoAmbitoOrigenDto(
      ProgramacionAmbitoOrigenDto src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idTrabajo", ignore = true)
  public abstract TrabajoAmbitoEmpresaDto programacionAmbitoEmpresaDtoToTrabajoAmbitoEmpresaDto(
      ProgramacionAmbitoEmpresaDto src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idTrabajo", ignore = true)
  public abstract TrabajoAmbitoLocalizacionDto programacionAmbitoLocalizacionDtoToTrabajoAmbitoLocalizacionDto(
      ProgramacionAmbitoLocalizacionDto src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idTrabajo", ignore = true)
  public abstract TrabajoAmbitoPersonaDto programacionAmbitoPersonaDtoToTrabajoAmbitoPersonaDto(
      ProgramacionAmbitoPersonaDto src);

  @Mapping(target = "idAmbito", ignore = true)
  @Mapping(target = "idTipoEjecucionCalculo",
      expression = "java(trabajo.getIdProgramacion() != null ? "
          + "TipoEjecucionCalculoEnum.PROGRAMADO.getId() : "
          + "TipoEjecucionCalculoEnum.MANUAL.getId())")
  @Mapping(target = "idTipoEjecucion",
      expression = "java(trabajo.getIdSimulacion() != null ? "
          + "TipoEjecucionCalculoEnum.SIMULACION.getId() : "
          + "TipoEjecucionCalculoEnum.MANUAL.getId())")
  @Mapping(target = "idTrabajo", source = "id")
  @Mapping(target = "nombreUsuario", source = "nombreUsuario")
  @Mapping(target = "idOrganization", ignore = true)
  @Mapping(target = "idPeriodo", source = "icmIdPeriodo")
  @Mapping(target = "idOrigen",
      expression = "java(trabajo.getOrigen() != null && !trabajo.getOrigen().isEmpty() ?"
          + " trabajo.getOrigen().get(0).getCclIdOrigen() : null)")
  @Mapping(target = "item", ignore = true)
  public abstract SaveProcesoDto trabajoDtoToSaveProcesoDto(TrabajoDTO trabajo);

  OffsetDateTime map(final LocalDateTime value) {
    return value.atOffset(ZoneOffset.UTC);
  }

  LocalDateTime map(final OffsetDateTime value) {
    return value.toLocalDateTime();
  }

  OffsetDateTime map(final LocalDate value) {
    return value != null ? value.atTime(LocalTime.MIDNIGHT).atOffset(ZoneOffset.UTC) : null;
  }

  LocalDate mapLocalDate(final OffsetDateTime value) {
    return value != null ? value.toLocalDate() : null;
  }

  OffsetDateTime mapLocalTime(final LocalTime value) {
    return OffsetDateTime.of(LocalDate.now(), value, ZoneOffset.UTC);
  }

  LocalTime mapLocalTime(final OffsetDateTime value) {
    return value.toLocalTime();
  }

}
