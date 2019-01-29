package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.TrabajoTiendaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTienda;

@Mapper
@DecoratedWith(TrabajoTiendaDecorator.class)
public abstract class TrabajoTiendaMapper {

	@Mapping(target = "idTrabajo", source = "trabajo.id")
    public abstract TrabajoTiendaDto trabajoTiendaToTrabajoTiendaDto(TrabajoTienda src);

    @InheritInverseConfiguration
    public abstract TrabajoTienda trabajoTiendaDtoToTrabajoTienda(TrabajoTiendaDto src);

    public abstract List<TrabajoTiendaDto> trabajoTiendaToTrabajoTiendaDto(List<TrabajoTienda> src);

    public abstract List<TrabajoTienda> trabajoTiendaDtoToTrabajoTienda(List<TrabajoTiendaDto> src);

    @Mapping(target = "id", source = "srcTrabajoTiendaDto.id")
    @Mapping(target = "idTienda", source = "srcTrabajoTiendaDto.idTienda")
    @Mapping(target = "trabajo.id", source = "srcTrabajoDto.id")
    public abstract TrabajoTienda mergeTrabajoTiendaDtoAndTrabajoDtoToTrabajoTienda(
            TrabajoTiendaDto srcTrabajoTiendaDto, TrabajoDto srcTrabajoDto);

    public List<TrabajoTienda> mergeTrabajoTiendaDtoAndTrabajoDtoToTrabajoTienda(
            List<TrabajoTiendaDto> srcTrabajoTiendaDto, TrabajoDto srcTrabajoDto) {
        throw new UnsupportedOperationException("Not implemented");
    }

}