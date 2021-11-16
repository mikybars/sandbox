package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaAusenciaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaAusenciaHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaAusenciaHistorico;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaPersonaAusenciaHistoricoDecorator.class)
public abstract class TareaPersonaAusenciaHistoricoMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "fechaInicioPeriodo", ignore = true)
  @Mapping(target = "idTarea", source = "src.tarea.id")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  @Mapping(target = "stdOrHrPeriod", source = "src.stdOrHrPeriod")
  @Mapping(target = "cclIdPerson", source = "src.cclIdPerson")
  @Mapping(target = "cclIdOrigen", source = "src.cclIdOrigen")
  @Mapping(target = "idTipoAusencia", source = "src.tipoAusencia.id")
  public abstract TareaPersonaAusenciaHistoricoDto tareaPersonaAusenciaHistoricoToTareaPersonaAusenciaHistoricoDto(
      TareaPersonaAusenciaHistorico src);

  public abstract List<TareaPersonaAusenciaHistoricoDto> tareaPersonaAusenciaHistoricoToTareaPersonaAusenciaHistoricoDto(
      List<TareaPersonaAusenciaHistorico> src);

  @InheritInverseConfiguration
  public abstract TareaPersonaAusenciaHistorico tareaPersonaAusenciaHistoricoDtoToTareaPersonaAusenciaHistorico(
      TareaPersonaAusenciaHistoricoDto src);

  public abstract List<TareaPersonaAusenciaHistorico> tareaPersonaAusenciaHistoricoDtoToTareaPersonaAusenciaHistorico(
      List<TareaPersonaAusenciaHistoricoDto> src);

  @Mapping(target = "idTarea", source = "tarea.id")
  @Mapping(target = "cclIdPerson", source = "src.idEmpleado")
  @Mapping(target = "stdOrHrPeriod", source = "src.orEmpleado")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  @Mapping(target = "cclIdOrigen", source = "src.idorigen")
  @Mapping(target = "idTipoAusencia", source = "src.tipo")
  public abstract TareaPersonaAusenciaHistoricoDto ausenciasResultItemDtoToTareaPersonaAusenciaHistoricoDto(
      AusenciasResultItemDto src, TareaDto tarea);

  public List<TareaPersonaAusenciaHistoricoDto> ausenciasResultItemDtoToTareaPersonaAusenciaHistoricoDto(
      final List<AusenciasResultItemDto> src, final TareaDto tareaDto) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
