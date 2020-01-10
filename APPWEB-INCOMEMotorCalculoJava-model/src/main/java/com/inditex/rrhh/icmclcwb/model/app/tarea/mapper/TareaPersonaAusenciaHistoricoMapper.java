package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaAusenciaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaAusenciaHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaAusenciaHistorico;

@Mapper
@DecoratedWith(TareaPersonaAusenciaHistoricoDecorator.class)
public abstract class TareaPersonaAusenciaHistoricoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idTarea", source = "src.tarea.id")
    @Mapping(target = "fechaInicioPeriodo", source = "pk.fechaInicioPeriodo")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "stdOrHrPeriod", source = "src.stdOrHrPeriod")
    @Mapping(target = "cclIdPerson", source = "src.cclIdPerson")
    @Mapping(target = "idTipoAusencia", source = "src.tipoAusencia.id")
    public abstract TareaPersonaAusenciaHistoricoDto tareaPersonaAusenciaHistoricoToTareaPersonaAusenciaHistoricoDto(TareaPersonaAusenciaHistorico src);

    @InheritInverseConfiguration
    public abstract TareaPersonaAusenciaHistorico tareaPersonaAusenciaHistoricoDtoToTareaPersonaAusenciaHistorico(TareaPersonaAusenciaHistoricoDto src);

    public abstract List<TareaPersonaAusenciaHistoricoDto> tareaPersonaAusenciaHistoricoToTareaPersonaAusenciaHistoricoDto(
            List<TareaPersonaAusenciaHistorico> src);
    
    public abstract List<TareaPersonaAusenciaHistorico> tareaPersonaAusenciaHistoricoDtoToTareaPersonaAusenciaHistorico(
            List<TareaPersonaAusenciaHistoricoDto> src);
    
    @Mapping(target = "idTarea", source = "tarea.id")
    @Mapping(target = "cclIdPerson", source = "src.idEmpleado")
    @Mapping(target = "stdOrHrPeriod", source = "src.orEmpleado")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "fechaInicioPeriodo", source = "tarea.fechaInicioPeriodo")
    public abstract TareaPersonaAusenciaHistoricoDto ausenciasResultItemDtoToTareaPersonaAusenciaHistoricoDto(
            AusenciasResultItemDto src, TareaDto tarea);
    
    public List<TareaPersonaAusenciaHistoricoDto> ausenciasResultItemDtoToTareaPersonaAusenciaHistoricoDto(
            List<AusenciasResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
}
