package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoCalculoDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoCalculo;

@Mapper
public abstract class TipoCalculoMapper {

    public abstract TipoCalculoDto tipoCalculoToTipoCalculoDto(TipoCalculo src);

    @InheritInverseConfiguration
    public abstract TipoCalculo tipoCalculoDtoToTipoCalculo(TipoCalculoDto src);

}
