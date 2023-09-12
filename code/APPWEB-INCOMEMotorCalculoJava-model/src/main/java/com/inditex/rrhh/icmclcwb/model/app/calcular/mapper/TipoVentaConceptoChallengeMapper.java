package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoChallengeDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConceptoChallenge;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TipoVentaConceptoChallengeMapper {

  @Mapping(target = "id", source = "src.id")
  @Mapping(target = "icmIdConceptoVenta", source = "src.icmIdConceptoVenta")
  @Mapping(target = "nombre", source = "src.nombre")
  @Mapping(target = "descripcion", source = "src.descripcion")
  public abstract TipoVentaConceptoChallengeDto tipoVentaConceptoChallengeToTipoVentaConceptoChallengeDto(
      TipoVentaConceptoChallenge src);

}
