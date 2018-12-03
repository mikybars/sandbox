package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.BeforeMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.TrabajoTiendaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTienda;

@Mapper
@DecoratedWith(TrabajoTiendaDecorator.class)
public abstract class TrabajoTiendaMapper {

    public abstract TrabajoTiendaDto trabajoTiendaToTrabajoTiendaDto(TrabajoTienda src);

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

    @BeforeMapping
    protected void beforeTrabajoTienda(TrabajoTienda src) {
        if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
            Trabajo trabajoId = new Trabajo();
            trabajoId.setId(src.getTrabajo().getId());
            src.setTrabajo(trabajoId);
        }
    }

    @BeforeMapping
    protected void beforeTrabajoTiendaDto(TrabajoTiendaDto src) {
        if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
            TrabajoDto trabajoId = new TrabajoDto();
            trabajoId.setId(src.getTrabajo().getId());
            src.setTrabajo(trabajoId);
        }
    }

}