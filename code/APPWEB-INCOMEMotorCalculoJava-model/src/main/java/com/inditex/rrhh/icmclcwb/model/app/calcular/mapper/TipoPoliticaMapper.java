package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoPoliticaDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPolitica;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TipoPoliticaMapper {

  @Mapping(target = "id", source = "src.id")
  @Mapping(target = "icmIdTpPolitica", source = "src.icmIdTpPolitica")
  @Mapping(target = "nombre", source = "src.nombre")
  public abstract TipoPoliticaDto tipoPoliticaToTipoPoliticaDto(TipoPolitica src);

}
