package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4Dto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.ReglaEmpleadoExternoMeta4Mapper;

public abstract class ReglaEmpleadoExternoMeta4MapperDecorator extends ReglaEmpleadoExternoMeta4Mapper {

  @Override
  public List<ReglaEmpleadoExternoMeta4RequestDto> reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDtoList(
      final List<ReglaEmpleadoExternoMeta4Dto> reglas) {

    final List<ReglaEmpleadoExternoMeta4RequestDto> result = new ArrayList<>();

    if (!reglas.isEmpty()) {
      reglas.stream().collect(groupingBy(ReglaEmpleadoExternoMeta4Dto::getStdIdHrType)).entrySet().forEach(obj -> {
        result.add(ReglaEmpleadoExternoMeta4RequestDto.builder()
            .idOrganization(
                reglas.stream().collect(groupingBy(ReglaEmpleadoExternoMeta4Dto::getIdOrganization)).keySet().stream().findFirst().get())
            .stdIdHrType(obj.getKey())
            .puestos(obj.getValue().stream().map(ReglaEmpleadoExternoMeta4Dto::getPuesto).collect(Collectors.toList())).build());
      });

      return result;
    }

    return null;
  }

}
