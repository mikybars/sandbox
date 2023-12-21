package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4Dto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.ReglaEmpleadoExternoMeta4Mapper;

public abstract class ReglaEmpleadoExternoMeta4MapperDecorator extends ReglaEmpleadoExternoMeta4Mapper {

  @Override
  public ReglaEmpleadoExternoMeta4RequestDto reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDto(
      final List<ReglaEmpleadoExternoMeta4Dto> reglas) {

    if (!reglas.isEmpty()) {
      return ReglaEmpleadoExternoMeta4RequestDto.builder()
          .idOrganization(
              reglas.stream().collect(groupingBy(ReglaEmpleadoExternoMeta4Dto::getCclIdOrigen)).keySet().stream().findFirst().get())
          .puestos(reglas.stream().map(ReglaEmpleadoExternoMeta4Dto::getPuesto).collect(Collectors.toList())).build();
    }

    return null;
  }

}
