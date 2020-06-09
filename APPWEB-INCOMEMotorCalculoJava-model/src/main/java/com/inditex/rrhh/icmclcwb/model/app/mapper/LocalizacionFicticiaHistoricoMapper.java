package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.LocalizacionFicticiaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.LocalizacionFicticiaHistorico;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(LocalizacionFicticiaHistoricoDecorator.class)
public abstract class LocalizacionFicticiaHistoricoMapper {

    @Mapping(target = "cclIdOrigen", source = "pk.idOrigen")
    @Mapping(target = "stdIdLegEnt", source = "pk.idEmpresa")
    @Mapping(target = "cclIdCodOrigen", source = "pk.idLugarTrabajoMtu")
    @Mapping(target = "fechaInicio", source = "pk.fechaInicio")
    public abstract LocalizacionFicticiaHistoricoDto localizacionFicticiaHistoricoToLocalizacionFicticiaHistoricoDto(
            LocalizacionFicticiaHistorico src);

    @InheritInverseConfiguration
    public abstract LocalizacionFicticiaHistorico localizacionFicticiaHistoricoDtoToLocalizacionFicticiaHistorico(
            LocalizacionFicticiaHistoricoDto src);

    public abstract List<LocalizacionFicticiaHistoricoDto> localizacionFicticiaHistoricoToLocalizacionFicticiaHistoricoDto(
            List<LocalizacionFicticiaHistorico> src);

    public abstract List<LocalizacionFicticiaHistorico> localizacionFicticiaHistoricoDtoToLocalizacionFicticiaHistorico(
            List<LocalizacionFicticiaHistoricoDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "stdIdCountry", source = "src.idOrigen")
    @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
    @Mapping(target = "stdIdLegEnt", source = "src.idEmpresa")
    @Mapping(target = "cclIdCadena", source = "src.idCadena")
    @Mapping(target = "cclIdCodOrigen", source = "src.idLugarTrabajoMtu")
    @Mapping(target = "stdIdWorkLocat", source = "src.idLugarTrabajo")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "idTarea", source = "srcTarea.id")
    public abstract TareaLocalizacionHistoricoDto genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(
            GenericTiendaResultItemDto src, TareaDto srcTarea);

    public List<TareaLocalizacionHistoricoDto> genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(
            final List<GenericTiendaResultItemDto> src, final TareaDto srcTarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
