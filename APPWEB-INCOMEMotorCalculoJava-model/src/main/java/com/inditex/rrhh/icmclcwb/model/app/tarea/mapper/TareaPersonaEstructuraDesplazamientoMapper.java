package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {org.apache.commons.lang3.StringUtils.class,
    com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants.class})
public abstract class TareaPersonaEstructuraDesplazamientoMapper {

  @Mapping(target = "id", source = "pk.id")
  @Mapping(target = "idTarea", source = "tarea.id")
  @Mapping(target = "idMotivoDesplazamiento", ignore = true)
  @Mapping(target = "idTipoOpcionCalculoEfectiva", source = "tipoOpcionCalculoEfectiva.id")
  @Mapping(target = "idTipoOpcionCalculoEstructura", source = "tipoOpcionCalculoEstructura.id")
  @Mapping(target = "fechaInicioPeriodo", source = "pk.fechaInicioPeriodo")
  @Mapping(target = "totalCondiciones", source = "esIncluirTotalCondiciones")
  public abstract TareaPersonaEstructuraDesplazamientoDto tareaPersonaEstructuraDesplazamientoToTareaPersonaEstructuraDesplazamientoDto(
      TareaPersonaEstructuraDesplazamiento src);

  @InheritInverseConfiguration
  public abstract TareaPersonaEstructuraDesplazamiento tareaPersonaEstructuraDesplazamientoDtoToTareaPersonaEstructuraDesplazamiento(
      TareaPersonaEstructuraDesplazamientoDto src);

}
