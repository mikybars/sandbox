package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;

@Mapper
@DecoratedWith(TareaLocalizacionHistoricoDecorator.class)
public abstract class TareaLocalizacionHistoricoMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaLocalizacionHistoricoDto tareaLocalizacionHistoricoToTareaLocalizacionHistoricoDto(TareaLocalizacionHistorico src);

    @InheritInverseConfiguration
    public abstract TareaLocalizacionHistorico tareaLocalizacionHistoricoDtoToTareaLocalizacionHistorico(TareaLocalizacionHistoricoDto src);

    public abstract List<TareaLocalizacionHistoricoDto> tareaLocalizacionHistoricoToTareaLocalizacionHistoricoDto(
            List<TareaLocalizacionHistorico> src);

    public abstract List<TareaLocalizacionHistorico> tareaLocalizacionHistoricoDtoToTareaLocalizacionHistorico(
            List<TareaLocalizacionHistoricoDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tarea.id", source = "srcTarea.id")
    @Mapping(target = "idPaisOrigen", source = "srcTareaLocalizacionHistorico.idPaisOrigen")
    @Mapping(target = "idEmpresa", source = "srcTareaLocalizacionHistorico.idEmpresa")
    public abstract TareaLocalizacionHistorico mergeTareaLocalizacionHistoricoDtoAndTareaDtoToTareaLocalizacionHistorico(
            TareaLocalizacionHistoricoDto srcTareaLocalizacionHistorico, TareaDto srcTarea);

    public List<TareaLocalizacionHistorico> mergeTareaLocalizacionHistoricoDtoAndTareaDtoToTareaLocalizacionHistorico(
            List<TareaLocalizacionHistoricoDto> srcTareaLocalizacionHistorico, TareaDto srcTareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idPais", source = "idPais")
    @Mapping(target = "idPaisOrigen", source = "idOrigen")
    @Mapping(target = "idEmpresa", source = "idEmpresa")
    @Mapping(target = "idCadena", source = "idCadena")
    @Mapping(target = "idLocalizacion", source = "idLugarTrabajoMtu")
    @Mapping(target = "idLocalizacionMeta4", source = "idLugarTrabajo")
    @Mapping(target = "fechaInicio", source = "fechaInicio")
    @Mapping(target = "fechaFin", source = "fechaFin")
    public abstract TareaLocalizacionHistoricoDto genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(
            GenericTiendaResultItemDto src);

    public abstract List<TareaLocalizacionHistoricoDto> genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(
            List<GenericTiendaResultItemDto> src);

}