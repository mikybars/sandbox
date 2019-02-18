package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTienda;

@Mapper
@DecoratedWith(TareaTiendaDecorator.class)
public abstract class TareaTiendaMapper {

	@Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaTiendaDto tareaTiendaToTareaTiendaDto(TareaTienda src);

    @InheritInverseConfiguration
    public abstract TareaTienda tareaTiendaDtoToTareaTienda(TareaTiendaDto src);

    public abstract List<TareaTiendaDto> tareaTiendaToTareaTiendaDto(List<TareaTienda> src);

    public abstract List<TareaTienda> tareaTiendaDtoToTareaTienda(List<TareaTiendaDto> src);

    @Mapping(target = "id", source = "srcTareaTiendaDto.id")
    @Mapping(target = "idTienda", source = "srcTareaTiendaDto.idTienda")
    @Mapping(target = "tarea.id", source = "srcTareaDto.id")
    public abstract TareaTienda mergeTareaTiendaDtoAndTareaDtoToTareaTienda(
            TareaTiendaDto srcTareaTiendaDto, TareaDto srcTareaDto);

    public List<TareaTienda> mergeTareaTiendaDtoAndTareaDtoToTareaTienda(
            List<TareaTiendaDto> srcTareaTiendaDto, TareaDto srcTareaDto) {
        throw new UnsupportedOperationException("Not implemented");
    }

}