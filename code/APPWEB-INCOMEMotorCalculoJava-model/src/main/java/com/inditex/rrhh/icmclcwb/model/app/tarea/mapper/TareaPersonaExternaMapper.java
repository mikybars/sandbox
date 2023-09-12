package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaExternaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaExterna;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = TareaPersonaExternaDecorator.class)
public abstract class TareaPersonaExternaMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "tarea.id", source = "tarea.id")
  @Mapping(target = "cclIdPerson", source = "src.idPersonaLocal")
  @Mapping(target = "fechaInicio", source = "src.fechaDesde")
  @Mapping(target = "fechaFin", source = "src.fechaHasta")
  public abstract TareaPersonaExterna idPersonaLocalExternaToTareaPersonaExterna(IdPersonaLocalExternaDto src,
      TareaDto tarea);

  public List<TareaPersonaExterna> idPersonaLocalExternaToTareaPersonaExterna(
      final List<IdPersonaLocalExternaDto> src,
      final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
