package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;

@Mapper
@DecoratedWith(value = TareaPersonaHistoricoDecorator.class)
public abstract class TareaPersonaHistoricoMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaPersonaHistoricoDto tareaPersonaHistoricoToTareaPersonaHistoricoDto(
            TareaPersonaHistorico src);

    @InheritInverseConfiguration
    public abstract TareaPersonaHistorico tareaPersonaHistoricoDtoToTareaPersonaHistorico(
            TareaPersonaHistoricoDto src);

    public abstract List<TareaPersonaHistoricoDto> tareaPersonaHistoricoToTareaPersonaHistoricoDto(
            List<TareaPersonaHistorico> src);

    public abstract List<TareaPersonaHistorico> tareaPersonaHistoricoDtoToTareaPersonaHistorico(
            List<TareaPersonaHistoricoDto> src);

    @Mapping(target = "stdIdHr", source = "src.idEmpleado")
    @Mapping(target = "stdOrHrPeriod", source = "src.orEmpleado")
    @Mapping(target = "cclIdPerson", source = "src.idEmpleadoLocal")
    @Mapping(target = "cclIdCodOrigen", source = "src.idLugarTrabajoMtu")
    @Mapping(target = "stdIdWorkLocat", source = "src.idLugarTrabajo")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "fechaInicioSeccion", source = "src.fechaInicioSec")
    @Mapping(target = "fechaFinSeccion", source = "src.fechaFinSec")
    @Mapping(target = "stdIdLegEnt", source = "src.idEmpresa")
    @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
    @Mapping(target = "cclIdSeccion", source = "src.idSeccion")
    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaPersonaHistoricoDto genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(
            GenericEmpleadoResultItemDto src, TareaDto tarea);

    public List<TareaPersonaHistoricoDto> genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(
            List<GenericEmpleadoResultItemDto> src, TareaDto tarea){
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
