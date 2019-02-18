package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaComisionHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaComisionHistorico;

@Mapper
@DecoratedWith(value = TareaTiendaComisionHistoricoDecorator.class)
public abstract class TareaTiendaComisionHistoricoMapper {
    
    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaTiendaComisionHistoricoDto tareaTiendaComisionHistoricoToTareaTiendaComisionHistoricoDto(TareaTiendaComisionHistorico src);

    @InheritInverseConfiguration
    public abstract TareaTiendaComisionHistorico tareaTiendaComisionHistoricoDtoToTareaTiendaComisionHistorico(TareaTiendaComisionHistoricoDto src);

    public abstract List<TareaTiendaComisionHistoricoDto> tareaTiendaComisionHistoricoToTareaTiendaComisionHistoricoDto(
            List<TareaTiendaComisionHistorico> src);

    @InheritInverseConfiguration
    public abstract List<TareaTiendaComisionHistorico> tareaTiendaComisionHistoricoDtoToTareaTiendaComisionHistorico(
            List<TareaTiendaComisionHistoricoDto> src);
    
    @Mapping(target = "idTarea", source = "tarea.id")
    @Mapping(target = "idTienda", source = "src.idTiendaMtu")
    @Mapping(target = "idTiendaMeta4", source = "src.idLugarTrabajo")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "comisionable", source = "src.esComisionable")
    public abstract TareaTiendaComisionHistoricoDto genericTiendaResultItemDtoToTareaTiendaComisionHistoricoDto(
            GenericTiendaResultItemDto src, TareaDto tarea);

    public List<TareaTiendaComisionHistoricoDto> genericTiendaResultItemDtoToTareaTiendaComisionHistoricoDto(
            List<GenericTiendaResultItemDto> src, TareaDto tarea){
        throw new UnsupportedOperationException("Not implemented");
    }
}
