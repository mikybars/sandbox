package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConcepto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TipoVentaConceptoMapper {

  @Mapping(target = "id", source = "src.id")
  @Mapping(target = "icmIdConceptoVenta", source = "src.icmIdConceptoVenta")
  @Mapping(target = "nombre", source = "nombre")
  @Mapping(target = "descripcion", source = "descripcion")
  public abstract TipoVentaConceptoDto tipoVentaConceptoToTipoVentaConceptoDto(TipoVentaConcepto src);

}
