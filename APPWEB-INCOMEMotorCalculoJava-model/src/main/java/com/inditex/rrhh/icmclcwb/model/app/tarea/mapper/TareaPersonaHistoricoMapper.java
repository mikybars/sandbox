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

    @Mapping(target = "tarea.id", source = "srcTarea.id")
    @Mapping(target = "idEmpresa", source = "srcTareaPersonaHistorico.idEmpresa")
    @Mapping(target = "id", ignore = true)
    public abstract TareaPersonaHistorico mergeTareaPersonaHistoricoDtoAndTareaDtoToTareaPersonaHistorico(
            TareaPersonaHistoricoDto srcTareaPersonaHistorico, TareaDto srcTarea);

    public List<TareaPersonaHistorico> mergeTareaPersonaHistoricoDtoAndTareaDtoToTareaPersonaHistorico(
            List<TareaPersonaHistoricoDto> srcTareaPersonaHistorico, TareaDto srcTareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "idEmpleado", source = "idEmpleado")
    @Mapping(target = "orEmpleado", source = "orEmpleado")
    @Mapping(target = "idEmpleadoLocal", source = "idEmpleadoLocal")
    @Mapping(target = "idTienda", source = "idLugarTrabajoMtu")
    @Mapping(target = "idTiendaMeta4", source = "idLugarTrabajo")
    @Mapping(target = "fechaInicio", source = "fechaInicio")
    @Mapping(target = "fechaFin", source = "fechaFin")
    @Mapping(target = "idEmpresa", source = "idEmpresa")
    @Mapping(target = "idOrigen", source = "idOrigen")
    @Mapping(target = "idSeccion", source = "idSeccion")
    public abstract TareaPersonaHistoricoDto genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(
            GenericEmpleadoResultItemDto src);

    public abstract List<TareaPersonaHistoricoDto> genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(
            List<GenericEmpleadoResultItemDto> src);
}
