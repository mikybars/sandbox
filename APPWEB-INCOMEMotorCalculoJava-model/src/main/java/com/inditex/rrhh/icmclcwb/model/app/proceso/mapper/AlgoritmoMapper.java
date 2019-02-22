package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.Algoritmo;

@Mapper
public abstract class AlgoritmoMapper {
    
    public abstract AlgoritmoDto algoritmoToAlgoritmoDto(Algoritmo src);

    @InheritInverseConfiguration
    public abstract Algoritmo algoritmoDtoToAlgoritmo(AlgoritmoDto src);
}
