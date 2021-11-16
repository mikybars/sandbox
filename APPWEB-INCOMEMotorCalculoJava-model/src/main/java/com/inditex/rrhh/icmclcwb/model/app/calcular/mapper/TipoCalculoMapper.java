package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoCalculoDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoCalculo;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TipoCalculoMapper {

  public abstract TipoCalculoDto tipoCalculoToTipoCalculoDto(TipoCalculo src);

  @InheritInverseConfiguration
  @Mapping(target = "nombre", ignore = true)
  @Mapping(target = "algoritmo", ignore = true)
  public abstract TipoCalculo tipoCalculoDtoToTipoCalculo(TipoCalculoDto src);

}
