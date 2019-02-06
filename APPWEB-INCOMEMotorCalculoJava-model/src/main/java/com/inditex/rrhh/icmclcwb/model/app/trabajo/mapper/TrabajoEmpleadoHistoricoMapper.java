package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator.TrabajoEmpleadoHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoEmpleadoHistorico;

@Mapper
@DecoratedWith(value = TrabajoEmpleadoHistoricoDecorator.class)
public abstract class TrabajoEmpleadoHistoricoMapper {

    
    @Mapping(target = "idTrabajo", source = "trabajo.id")
    public abstract TrabajoEmpleadoHistoricoDto trabajoEmpleadoHistoricoToTrabajoEmpleadoHistoricoDto(TrabajoEmpleadoHistorico src);

    @InheritInverseConfiguration
    public abstract TrabajoEmpleadoHistorico trabajoEmpleadoHistoricoDtoToTrabajoEmpleadoHistorico(TrabajoEmpleadoHistoricoDto src);

    public abstract List<TrabajoEmpleadoHistoricoDto> trabajoEmpleadoHistoricoToTrabajoEmpleadoHistoricoDto(
            List<TrabajoEmpleadoHistorico> src);

    public abstract List<TrabajoEmpleadoHistorico> trabajoEmpleadoHistoricoDtoToTrabajoEmpleadoHistorico(
            List<TrabajoEmpleadoHistoricoDto> src);
    
    @Mapping(target = "trabajo.id", source = "srcTrabajo.id")
    @Mapping(target = "id", ignore = true)
    public abstract TrabajoEmpleadoHistorico mergeTrabajoEmpleadoHistoricoDtoAndTrabajoDtoToTrabajoEmpleadoHistorico(
            TrabajoEmpleadoHistoricoDto srcTrabajoEmpleadoHistorico, TrabajoDto srcTrabajo);

    public List<TrabajoEmpleadoHistorico> mergeTrabajoEmpleadoHistoricoDtoAndTrabajoDtoToTrabajoEmpleadoHistorico(
            List<TrabajoEmpleadoHistoricoDto> srcTrabajoEmpleadoHistorico, TrabajoDto srcTrabajoDto) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    @Mapping(target = "idEmpleado", source = "idEmpleado")
    @Mapping(target = "orEmpleado", source = "orEmpleado")
    @Mapping(target = "idEmpleadoLocal", source = "idEmpleadoLocal")
    @Mapping(target = "idTienda", source = "idTiendaMtu")
    @Mapping(target = "idTiendaMeta4", source = "idLugarTrabajo")
    @Mapping(target = "fechaInicio", source = "fechaInicio")
    @Mapping(target = "fechaFin", source = "fechaFin")
    public abstract TrabajoEmpleadoHistoricoDto genericEmpleadoResultItemDtoToTrabajoEmpleadoHistoricoDto(
            GenericEmpleadoResultItemDto src);

    public abstract List<TrabajoEmpleadoHistoricoDto> genericEmpleadoResultItemDtoToTrabajoEmpleadoHistoricoDto(
            List<GenericEmpleadoResultItemDto> src);
}
