package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator.TrabajoTiendaComisionHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoTiendaComisionHistorico;

@Mapper
@DecoratedWith(value = TrabajoTiendaComisionHistoricoDecorator.class)
public abstract class TrabajoTiendaComisionHistoricoMapper {
    
    @Mapping(target = "idTrabajo", source = "trabajo.id")
    public abstract TrabajoTiendaComisionHistoricoDto trabajoTiendaComisionHistoricoToTrabajoTiendaComisionHistoricoDto(TrabajoTiendaComisionHistorico src);

    @InheritInverseConfiguration
    public abstract TrabajoTiendaComisionHistorico trabajoTiendaComisionHistoricoDtoToTrabajoTiendaComisionHistorico(TrabajoTiendaComisionHistoricoDto src);

    public abstract List<TrabajoTiendaComisionHistoricoDto> trabajoTiendaComisionHistoricoToTrabajoTiendaComisionHistoricoDto(
            List<TrabajoTiendaComisionHistorico> src);

    @InheritInverseConfiguration
    public abstract List<TrabajoTiendaComisionHistorico> trabajoTiendaComisionHistoricoDtoToTrabajoTiendaComisionHistorico(
            List<TrabajoTiendaComisionHistoricoDto> src);
    
    @Mapping(target = "idTrabajo", source = "trabajo.id")
    @Mapping(target = "idTienda", source = "src.idTiendaMtu")
    @Mapping(target = "idTiendaMeta4", source = "src.idLugarTrabajo")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "comisionable", source = "src.esComisionable")
    public abstract TrabajoTiendaComisionHistoricoDto genericTiendaResultItemDtoToTrabajoTiendaComisionHistoricoDto(
            GenericTiendaResultItemDto src, TrabajoDto trabajo);

    public List<TrabajoTiendaComisionHistoricoDto> genericTiendaResultItemDtoToTrabajoTiendaComisionHistoricoDto(
            List<GenericTiendaResultItemDto> src, TrabajoDto trabajo){
        throw new UnsupportedOperationException("Not implemented");
    }
}
