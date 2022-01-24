package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoUnidadTiempoDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoUnidadTiempo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TipoUnidadTiempoMapper {

  @Mapping(target = "id", source = "src.id")
  @Mapping(target = "icmIdUnidadTiempo", source = "src.icmIdUnidadTiempo")
  @Mapping(target = "nombre", source = "src.nombre")
  public abstract TipoUnidadTiempoDto tipoUnidadTiempoToTipoUnidadTiempoDto(TipoUnidadTiempo src);

}
