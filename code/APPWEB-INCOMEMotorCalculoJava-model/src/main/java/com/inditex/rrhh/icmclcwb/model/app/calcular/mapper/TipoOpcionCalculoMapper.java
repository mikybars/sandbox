package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoOpcionCalculoDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoOpcionCalculo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TipoOpcionCalculoMapper {

  @Mapping(target = "id", source = "src.id")
  @Mapping(target = "idMeta4", source = "src.idMeta4")
  @Mapping(target = "nombre", source = "src.nombre")
  public abstract TipoOpcionCalculoDto tipoOpcionCalculoToTipoOpcionCalculoDto(TipoOpcionCalculo src);

  public abstract List<TipoOpcionCalculoDto> tipoOpcionCalculoToTipoOpcionCalculoDto(List<TipoOpcionCalculo> src);

}
