package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaPresenciaManual;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaAmbitoGlobalLocalizacionPersonaPresenciaManualDecorator.class)
public abstract class TareaAmbitoGlobalLocalizacionPersonaPresenciaManualMapper {

  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaAmbitoGlobalLocalizacionPersonaPresenciaManualDto tareaAmbitoGlobalLocalizacionPersonaPresenciaManualToTareaAmbitoGlobalLocalizacionPersonaPresenciaManualDto(
      TareaAmbitoGlobalLocalizacionPersonaPresenciaManual src);

  public abstract List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManualDto> tareaAmbitoGlobalLocalizacionPersonaPresenciaManualToTareaAmbitoGlobalLocalizacionPersonaPresenciaManualDto(
      List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual> src);

  @InheritInverseConfiguration
  public abstract TareaAmbitoGlobalLocalizacionPersonaPresenciaManual tareaAmbitoGlobalLocalizacionPersonaPresenciaManualDtoToTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(
      TareaAmbitoGlobalLocalizacionPersonaPresenciaManualDto src);

  public abstract List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual> tareaAmbitoGlobalLocalizacionPersonaPresenciaManualDtoToTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(
      List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManualDto> src);

  @Mapping(source = "src.idOrigen", target = "cclIdOrigen")
  @Mapping(source = "src.idLugarTrabajo", target = "stdIdWorkLocat")
  @Mapping(source = "src.idEmpresa", target = "stdIdLegEnt")
  @Mapping(source = "tareaDto.id", target = "tarea.id")
  @Mapping(source = "src.idEmpleadoLocal", target = "cclIdPerson")
  @Mapping(target = "id", ignore = true)
  public abstract TareaAmbitoGlobalLocalizacionPersonaPresenciaManual genericEmpleadoResultItemDtoToTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(
      GenericEmpleadoResultItemDto src, TareaDto tareaDto);

  public List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual> genericEmpleadoResultItemDtoToTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(
      List<GenericEmpleadoResultItemDto> src, TareaDto tareaDto) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
