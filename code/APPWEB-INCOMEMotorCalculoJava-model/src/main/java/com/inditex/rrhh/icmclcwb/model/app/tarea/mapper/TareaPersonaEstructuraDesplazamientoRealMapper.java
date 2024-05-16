package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDesplazamientoRealDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaEstructuraDesplazamientoRealDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamientoReal;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = TareaPersonaEstructuraDesplazamientoRealDecorator.class)
public abstract class TareaPersonaEstructuraDesplazamientoRealMapper {

  @Mapping(target = "id", source = "pk.id")
  @Mapping(target = "fechaInicioPeriodo", source = "pk.fechaInicioPeriodo")
  @Mapping(target = "idTarea", source = "tarea.id")
  @Mapping(target = "fechaFin", source = "fechaFin")
  @Mapping(target = "fechaInicio", source = "fechaInicio")
  @Mapping(target = "cclIdOrigen", source = "cclIdOrigen")
  @Mapping(target = "stdIdHr", source = "stdIdHr")
  @Mapping(target = "stdOrHrPeriod", source = "stdOrHrPeriod")
  @Mapping(target = "icmIdEstrComision", source = "icmIdEstrComision")
  @Mapping(target = "icmIdEstructuraAmbito", source = "icmIdEstructuraAmbito")
  @Mapping(target = "icmIdEstrComisionPadre", source = "icmIdEstrComisionPadre")
  @Mapping(target = "icmIdEstrComisionBase", source = "icmIdEstrComisionBase")
  public abstract TareaPersonaEstructuraDesplazamientoRealDto tareaPersonaEstructuraDesplazamientoRealToTareaPersonaEstructuraDesplazamientoRealDto(
      TareaPersonaEstructuraDesplazamientoReal src);

  public abstract List<
      TareaPersonaEstructuraDesplazamientoRealDto> tareaPersonaEstructuraDesplazamientoRealToTareaPersonaEstructuraDesplazamientoRealDto(
          List<TareaPersonaEstructuraDesplazamientoReal> src);

  @InheritInverseConfiguration
  public abstract TareaPersonaEstructuraDesplazamientoReal tareaPersonaEstructuraDesplazamientoRealDtoToTareaPersonaEstructuraDesplazamientoReal(
      TareaPersonaEstructuraDesplazamientoRealDto src);

  public abstract List<
      TareaPersonaEstructuraDesplazamientoReal> tareaPersonaEstructuraDesplazamientoRealDtoToTareaPersonaEstructuraDesplazamientoReal(
          List<TareaPersonaEstructuraDesplazamientoRealDto> src);

  @Mapping(target = "pk.id", ignore = true)
  @Mapping(target = "pk.fechaInicioPeriodo", source = "tarea.fechaInicioPeriodo")
  @Mapping(target = "tarea.id", source = "tarea.id")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
  @Mapping(target = "stdIdHr", source = "src.idEmpleado")
  @Mapping(target = "stdOrHrPeriod", source = "src.orEmpleado")
  @Mapping(target = "icmIdEstrComision", source = "src.idEstructura")
  @Mapping(target = "icmIdEstrComisionBase", source = "src.idEstructuraBase")
  @Mapping(target = "icmIdEstrComisionPadre", source = "src.idEstructuraPadre")
  @Mapping(target = "icmIdEstructuraAmbito", source = "src.idEstructuraAmbito")
  public abstract TareaPersonaEstructuraDesplazamientoReal desplazamientoRealResultItemDtoToTareaPersonaEstructuraDesplazamientoReal(
      DesplazamientoRealResultItemDto src, TareaDto tarea);

  public List<TareaPersonaEstructuraDesplazamientoReal> desplazamientoRealResultItemDtoToTareaPersonaEstructuraDesplazamientoReal(
      final List<DesplazamientoRealResultItemDto> src, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
