package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoComisionDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoComision;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TipoComisionMapper {

  public abstract TipoComisionDto tipoComisionToTipoComisionDto(TipoComision src);

  @InheritInverseConfiguration
  @Mapping(target = "algoritmo", ignore = true)
  @Mapping(target = "nombre", ignore = true)
  public abstract TipoComision tipoComisionDtoToTipoComision(TipoComisionDto src);

}
