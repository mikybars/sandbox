package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoDTO;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = TareaPersonaHistoricoDecorator.class)
public abstract class TareaPersonaHistoricoMapper {

  @Mapping(target = "id", source = "pk.id")
  @Mapping(target = "idTarea", source = "tarea.id")
  @Mapping(target = "fechaInicioPeriodo", source = "pk.fechaInicioPeriodo")
  public abstract TareaPersonaHistoricoDto tareaPersonaHistoricoToTareaPersonaHistoricoDto(
      TareaPersonaHistorico src);

  public abstract List<TareaPersonaHistoricoDto> tareaPersonaHistoricoToTareaPersonaHistoricoDto(
      List<TareaPersonaHistorico> src);

  @InheritInverseConfiguration
  public abstract TareaPersonaHistorico tareaPersonaHistoricoDtoToTareaPersonaHistorico(
      TareaPersonaHistoricoDto src);

  public abstract List<TareaPersonaHistorico> tareaPersonaHistoricoDtoToTareaPersonaHistorico(
      List<TareaPersonaHistoricoDto> src);

  @Mapping(target = "stdIdHr", source = "src.idEmpleado")
  @Mapping(target = "stdOrHrPeriod", source = "src.orEmpleado")
  @Mapping(target = "cclIdPerson", source = "src.idEmpleadoLocal")
  @Mapping(target = "cclIdCodOrigen", source = "src.idLugarTrabajoMtu")
  @Mapping(target = "stdIdWorkLocat", source = "src.idLugarTrabajo")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  @Mapping(target = "fechaInicioSeccion", source = "src.fechaInicioSec")
  @Mapping(target = "fechaFinSeccion", source = "src.fechaFinSec")
  @Mapping(target = "fechaInicioLocalizacion", source = "src.fechaInicioLoc")
  @Mapping(target = "fechaFinLocalizacion", source = "src.fechaFinLoc")
  @Mapping(target = "fechaAntiguedad", source = "src.fechaAntiguedad")
  @Mapping(target = "stdIdLegEnt", source = "src.idEmpresa")
  @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
  @Mapping(target = "cclIdSeccion", source = "src.idSeccion")
  @Mapping(target = "idTarea", source = "tarea.id")
  @Mapping(target = "fechaInicioPeriodo", source = "tarea.fechaInicioPeriodo")
  public abstract TareaPersonaHistoricoDto genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(
      GenericEmpleadoResultItemDto src, TareaDto tarea);

  public List<TareaPersonaHistoricoDto> genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(
      final List<GenericEmpleadoResultItemDto> src, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Mapping(target = "stdIdHr", source = "src.stdIdHr")
  @Mapping(target = "stdOrHrPeriod", source = "src.stdOrHrPeriod")
  @Mapping(target = "cclIdPerson", source = "src.cclIdPerson")
  @Mapping(target = "cclIdCodOrigen", source = "src.cclIdCodOrigen")
  @Mapping(target = "stdIdWorkLocat", source = "src.stdIdWorkLocat")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  @Mapping(target = "fechaInicioSeccion", source = "src.fechaInicioSeccion")
  @Mapping(target = "fechaFinSeccion", source = "src.fechaFinSeccion")
  @Mapping(target = "fechaInicioLocalizacion", source = "src.fechaInicioLocalizacion")
  @Mapping(target = "fechaFinLocalizacion", source = "src.fechaFinLocalizacion")
  @Mapping(target = "fechaAntiguedad", source = "src.fechaAntiguedad")
  @Mapping(target = "stdIdLegEnt", source = "src.stdIdLegEnt")
  @Mapping(target = "cclIdOrigen", source = "src.cclIdOrigen")
  @Mapping(target = "cclIdSeccion", source = "src.cclIdSeccion")
  @Mapping(target = "idTarea", source = "tarea.id")
  @Mapping(target = "fechaInicioPeriodo", source = "tarea.fechaInicioPeriodo")
  public abstract TareaPersonaHistoricoDto empleadoDtoToTareaPersonaHistoricoDto(EmpleadoDTO src, TareaDto tarea);

  public List<TareaPersonaHistoricoDto> empleadoDtoToTareaPersonaHistoricoDto(
      final List<EmpleadoDTO> src, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }
}
