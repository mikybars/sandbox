package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalLocalizacionPersonaPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoGlobalLocalizacionPersonaPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaPresencia;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaAmbitoGlobalLocalizacionPersonaPresenciaDecorator.class)
public abstract class TareaAmbitoGlobalLocalizacionPersonaPresenciaMapper {

  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaAmbitoGlobalLocalizacionPersonaPresenciaDto tareaLocalizacionPersonaPresenciaToTareaLocalizacionPersonaPresenciaDto(
      TareaAmbitoGlobalLocalizacionPersonaPresencia src);

  public abstract List<TareaAmbitoGlobalLocalizacionPersonaPresenciaDto> tareaLocalizacionPersonaPresenciaToTareaLocalizacionPersonaPresenciaDto(
      List<TareaAmbitoGlobalLocalizacionPersonaPresencia> src);

  @InheritInverseConfiguration
  public abstract TareaAmbitoGlobalLocalizacionPersonaPresencia tareaLocalizacionPersonaPresenciaDtoToTareaLocalizacionPersonaPresencia(
      TareaAmbitoGlobalLocalizacionPersonaPresenciaDto src);

  public abstract List<TareaAmbitoGlobalLocalizacionPersonaPresencia> tareaLocalizacionPersonaPresenciaDtoToTareaLocalizacionPersonaPresencia(
      List<TareaAmbitoGlobalLocalizacionPersonaPresenciaDto> src);

  @Mapping(source = "src.origen", target = "cclIdOrigen")
  @Mapping(source = "src.tienda", target = "cclIdCodOrigen")
  @Mapping(source = "src.empresa", target = "stdIdLegEnt")
  @Mapping(source = "tareaDto.id", target = "tarea.id")
  @Mapping(source = "personas", target = "cclIdPerson")
  @Mapping(target = "id", ignore = true)
  public abstract TareaAmbitoGlobalLocalizacionPersonaPresencia presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersonaPresencia(
      Integer personas, PtrPresenciaEmpleadosTiendaResultItemDto src, TareaDto tareaDto);

  public List<TareaAmbitoGlobalLocalizacionPersonaPresencia> presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersonaPresencia(
      List<PtrPresenciaEmpleadosTiendaResultItemDto> src, TareaDto tareaDto) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
