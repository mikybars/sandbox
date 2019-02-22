package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.TipoComisionDto;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.TipoComision;

@Mapper
public abstract class TipoComisionMapper {

    public abstract TipoComisionDto tipoComisionToTipoComisionDto(TipoComision src);

    @InheritInverseConfiguration
    public abstract TipoComision tipoComisionDtoToTipoComision(TipoComisionDto src);
}
