package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaCoeficienteDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaCoeficienteDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaCoeficiente;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaPersonaCoeficienteDecorator.class)
public abstract class TareaPersonaCoeficienteMapper {

  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaPersonaCoeficienteDto tareaPersonaCoeficienteToTareaPersonaCoeficienteDto(
      TareaPersonaCoeficiente src);

  public abstract List<TareaPersonaCoeficienteDto> tareaPersonaCoeficienteToTareaPersonaCoeficienteDto(
      List<TareaPersonaCoeficiente> src);

  @InheritInverseConfiguration
  public abstract TareaPersonaCoeficiente tareaPersonaCoeficienteDtoToTareaPersonaCoeficiente(
      TareaPersonaCoeficienteDto src);

  public abstract List<TareaPersonaCoeficiente> tareaPersonaCoeficienteDtoToPersonaCoeficiente(
      List<TareaPersonaCoeficienteDto> src);

  @Mapping(source = "src.idEmpleado", target = "stdIdHr")
  @Mapping(source = "src.orEmpleado", target = "stdOrHrPeriod")
  @Mapping(source = "src.idEmpleadoLocal", target = "cclIdPerson")
  @Mapping(source = "src.fechaInicioCom", target = "fechaInicioCom")
  @Mapping(source = "src.fechaFinCom", target = "fechaFinCom")
  @Mapping(source = "src.fechaInicioPar", target = "fechaInicioPar")
  @Mapping(source = "src.fechaFinPar", target = "fechaFinPar")
  @Mapping(source = "src.coefJornada", target = "coeficiente")
  @Mapping(source = "tareaDto.id", target = "tarea.id")
  @Mapping(target = "id", ignore = true)
  public abstract TareaPersonaCoeficiente genericEmpleadoResultItemDtoToTareaPersonaCoeficiente(
      GenericEmpleadoResultItemDto src, TareaDto tareaDto);

  public List<TareaPersonaCoeficiente> genericEmpleadoResultItemDtoToTareaPersonaCoeficiente(
      List<GenericEmpleadoResultItemDto> src, TareaDto tareaDto) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
