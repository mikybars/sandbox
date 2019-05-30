package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionComisionHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionComisionHistorico;

@Mapper
@DecoratedWith(value = TareaLocalizacionComisionHistoricoDecorator.class)
public abstract class TareaLocalizacionComisionHistoricoMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaLocalizacionComisionHistoricoDto tareaLocalizacionComisionHistoricoToTareaLocalizacionComisionHistoricoDto(
            TareaLocalizacionComisionHistorico src);

    @InheritInverseConfiguration
    public abstract TareaLocalizacionComisionHistorico tareaLocalizacionComisionHistoricoDtoToTareaLocalizacionComisionHistorico(
            TareaLocalizacionComisionHistoricoDto src);

    public abstract List<TareaLocalizacionComisionHistoricoDto> tareaLocalizacionComisionHistoricoToTareaLocalizacionComisionHistoricoDto(
            List<TareaLocalizacionComisionHistorico> src);

    @InheritInverseConfiguration
    public abstract List<TareaLocalizacionComisionHistorico> tareaLocalizacionComisionHistoricoDtoToTareaLocalizacionComisionHistorico(
            List<TareaLocalizacionComisionHistoricoDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tarea.id", source = "srcTarea.id")
    public abstract TareaLocalizacionComisionHistorico mergeTareaLocalizacionComisionHistoricoDtoAndTareaDtoToTareaLocalizacionComisionHistorico(
            TareaLocalizacionComisionHistoricoDto srcTareaLocalizacionComisionHistorico, TareaDto srcTarea);

    public List<TareaLocalizacionComisionHistorico> mergeTareaLocalizacionComisionHistoricoDtoAndTareaDtoToTareaLocalizacionComisionHistorico(
            List<TareaLocalizacionComisionHistoricoDto> srcTareaLocalizacionComisionHistorico, TareaDto srcTareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "idLocalizacion", source = "src.idLugarTrabajoMtu")
    @Mapping(target = "idLocalizacionMeta4", source = "src.idLugarTrabajo")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "comisionable", source = "src.esComisionable")
    public abstract TareaLocalizacionComisionHistoricoDto genericLocalizacionResultItemDtoToTareaLocalizacionComisionHistoricoDto(
            GenericTiendaResultItemDto src);

    public abstract List<TareaLocalizacionComisionHistoricoDto> genericLocalizacionResultItemDtoToTareaLocalizacionComisionHistoricoDto(
            List<GenericTiendaResultItemDto> src);
}
