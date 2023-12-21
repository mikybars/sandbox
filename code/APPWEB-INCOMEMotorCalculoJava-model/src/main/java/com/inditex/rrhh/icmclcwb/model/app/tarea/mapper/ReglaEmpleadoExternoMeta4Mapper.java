package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4Dto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.ReglaEmpleadoExternoMeta4MapperDecorator;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(ReglaEmpleadoExternoMeta4MapperDecorator.class)
public class ReglaEmpleadoExternoMeta4Mapper {

  public ReglaEmpleadoExternoMeta4RequestDto reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDto(
      final List<ReglaEmpleadoExternoMeta4Dto> reglas) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
