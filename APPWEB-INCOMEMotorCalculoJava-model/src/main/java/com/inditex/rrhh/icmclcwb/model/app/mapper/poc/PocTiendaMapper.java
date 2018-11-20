package com.inditex.rrhh.icmclcwb.model.app.mapper.poc;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocTiendaDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.poc.PocTienda;

@Mapper
public abstract class PocTiendaMapper {

    public abstract PocTiendaDto pocTiendaToPocTiendaDto(PocTienda src);

    public abstract List<PocTiendaDto> pocTiendaToPocTiendaDto(List<PocTienda> src);

    @Mappings({ @Mapping(target = "id", ignore = true), @Mapping(target = "idTienda", source = "id") })
    public abstract TrabajoTiendaEstadoDto pocTiendaDtoToTrabajoTiendaEstadoDto(PocTiendaDto src);

    public abstract List<TrabajoTiendaEstadoDto> pocTiendaDtoToTrabajoTiendaEstadoDto(List<PocTiendaDto> src);

}