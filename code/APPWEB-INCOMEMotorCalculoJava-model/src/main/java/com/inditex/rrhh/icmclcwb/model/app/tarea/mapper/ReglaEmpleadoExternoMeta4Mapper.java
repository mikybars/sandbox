package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4Dto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.ReglaEmpleadoExternoMeta4MapperDecorator;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ExternosRequestDTO;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(ReglaEmpleadoExternoMeta4MapperDecorator.class)
public abstract class ReglaEmpleadoExternoMeta4Mapper {

  public List<ReglaEmpleadoExternoMeta4RequestDto> reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDtoList(
      final List<ReglaEmpleadoExternoMeta4Dto> reglas) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Mapping(source = "idOrganization", target = "idOrganization")
  @Mapping(source = "stdIdHrType", target = "stdIdHrType")
  @Mapping(source = "puestos", target = "puestos")
  public abstract ExternosRequestDTO reglaEmpleadoExternoMeta4RequestDtotoExternosRequestDto(
      ReglaEmpleadoExternoMeta4RequestDto src);

}
