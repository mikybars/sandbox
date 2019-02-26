package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator.ProcesoTiendaComisionHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaComisionHistorico;

@Mapper
@DecoratedWith(value = ProcesoTiendaComisionHistoricoDecorator.class)
public abstract class ProcesoTiendaComisionHistoricoMapper {
    
    @Mapping(target = "idProceso", source = "proceso.id")
    public abstract ProcesoTiendaComisionHistoricoDto procesoTiendaComisionHistoricoToProcesoTiendaComisionHistoricoDto(ProcesoTiendaComisionHistorico src);

    @InheritInverseConfiguration
    public abstract ProcesoTiendaComisionHistorico procesoTiendaComisionHistoricoDtoToProcesoTiendaComisionHistorico(ProcesoTiendaComisionHistoricoDto src);

    public abstract List<ProcesoTiendaComisionHistoricoDto> procesoTiendaComisionHistoricoToProcesoTiendaComisionHistoricoDto(
            List<ProcesoTiendaComisionHistorico> src);

    @InheritInverseConfiguration
    public abstract List<ProcesoTiendaComisionHistorico> procesoTiendaComisionHistoricoDtoToProcesoTiendaComisionHistorico(
            List<ProcesoTiendaComisionHistoricoDto> src);
    
    @Mapping(target = "idProceso", source = "proceso.id")
    @Mapping(target = "idTienda", source = "src.idTiendaMtu")
    @Mapping(target = "idTiendaMeta4", source = "src.idLugarTrabajo")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "comisionable", source = "src.esComisionable")
    public abstract ProcesoTiendaComisionHistoricoDto genericTiendaResultItemDtoToProcesoTiendaComisionHistoricoDto(
            GenericTiendaResultItemDto src, ProcesoDto proceso);

    public List<ProcesoTiendaComisionHistoricoDto> genericTiendaResultItemDtoToProcesoTiendaComisionHistoricoDto(
            List<GenericTiendaResultItemDto> src, ProcesoDto proceso){
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
}
