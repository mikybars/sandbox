package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaEmpleadoHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoHistorico;

@Mapper
@DecoratedWith(value = TareaEmpleadoHistoricoDecorator.class)
public abstract class TareaEmpleadoHistoricoMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaEmpleadoHistoricoDto tareaEmpleadoHistoricoToTareaEmpleadoHistoricoDto(
            TareaEmpleadoHistorico src);

    @InheritInverseConfiguration
    public abstract TareaEmpleadoHistorico tareaEmpleadoHistoricoDtoToTareaEmpleadoHistorico(
            TareaEmpleadoHistoricoDto src);

    public abstract List<TareaEmpleadoHistoricoDto> tareaEmpleadoHistoricoToTareaEmpleadoHistoricoDto(
            List<TareaEmpleadoHistorico> src);

    public abstract List<TareaEmpleadoHistorico> tareaEmpleadoHistoricoDtoToTareaEmpleadoHistorico(
            List<TareaEmpleadoHistoricoDto> src);

    @Mapping(target = "tarea.id", source = "srcTarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaEmpleadoHistorico mergeTareaEmpleadoHistoricoDtoAndTareaDtoToTareaEmpleadoHistorico(
            TareaEmpleadoHistoricoDto srcTareaEmpleadoHistorico, TareaDto srcTarea);

    public List<TareaEmpleadoHistorico> mergeTareaEmpleadoHistoricoDtoAndTareaDtoToTareaEmpleadoHistorico(
            List<TareaEmpleadoHistoricoDto> srcTareaEmpleadoHistorico, TareaDto srcTareaDto) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Mapping(target = "idEmpleado", source = "idEmpleado")
    @Mapping(target = "orEmpleado", source = "orEmpleado")
    @Mapping(target = "idEmpleadoLocal", source = "idEmpleadoLocal")
    @Mapping(target = "idTienda", source = "idTiendaMtu")
    @Mapping(target = "idTiendaMeta4", source = "idLugarTrabajo")
    @Mapping(target = "fechaInicio", source = "fechaInicio")
    @Mapping(target = "fechaFin", source = "fechaFin")
    public abstract TareaEmpleadoHistoricoDto genericEmpleadoResultItemDtoToTareaEmpleadoHistoricoDto(
            GenericEmpleadoResultItemDto src);

    public abstract List<TareaEmpleadoHistoricoDto> genericEmpleadoResultItemDtoToTareaEmpleadoHistoricoDto(
            List<GenericEmpleadoResultItemDto> src);
}
