package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoAusenciaDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoAusencia;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TipoAusenciaMapper {

  @Mapping(target = "id", source = "src.id")
  @Mapping(target = "icmTpAbsence", source = "src.icmTpAbsence")
  @Mapping(target = "nombre", source = "src.nombre")
  public abstract TipoAusenciaDto tipoAusenciaToTipoAusenciaDto(TipoAusencia src);

}
