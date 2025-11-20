package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ReglaValidacionExcedidoDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ReglaValidacionExcedido;

import org.mapstruct.Mapper;

@Mapper
public abstract class ReglaValidacionExcedidoMapper {

  public abstract ReglaValidacionExcedidoDto toDto(ReglaValidacionExcedido entity);

  public abstract List<ReglaValidacionExcedidoDto> toDto(List<ReglaValidacionExcedido> entities);

}
