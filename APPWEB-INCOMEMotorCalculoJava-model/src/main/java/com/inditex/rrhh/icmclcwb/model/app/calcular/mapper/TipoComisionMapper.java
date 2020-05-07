package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoComisionDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoComision;

@Mapper
public abstract class TipoComisionMapper {

    public abstract TipoComisionDto tipoComisionToTipoComisionDto(TipoComision src);

    @InheritInverseConfiguration
    public abstract TipoComision tipoComisionDtoToTipoComision(TipoComisionDto src);

}
