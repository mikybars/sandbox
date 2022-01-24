package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoPresupuestoDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPresupuesto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TipoPresupuestoMapper {

  @Mapping(target = "id", source = "src.id")
  @Mapping(target = "icmIdTpPresupuesto", source = "src.icmIdTpPresupuesto")
  @Mapping(target = "nombre", source = "src.nombre")
  @Mapping(target = "descripcion", source = "src.descripcion")
  public abstract TipoPresupuestoDto tipoPresupuestoToTipoPreupuestoDto(TipoPresupuesto src);

}
