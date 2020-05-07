package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.Algoritmo;

@Mapper
public abstract class AlgoritmoMapper {

    public abstract AlgoritmoDto algoritmoToAlgoritmoDto(Algoritmo src);

    @InheritInverseConfiguration
    public abstract Algoritmo algoritmoDtoToAlgoritmo(AlgoritmoDto src);

    public abstract List<AlgoritmoDto> algoritmoToAlgoritmoDto(List<Algoritmo> src);

    @InheritInverseConfiguration
    public abstract List<Algoritmo> algoritmoDtoToAlgoritmo(List<AlgoritmoDto> src);

}
