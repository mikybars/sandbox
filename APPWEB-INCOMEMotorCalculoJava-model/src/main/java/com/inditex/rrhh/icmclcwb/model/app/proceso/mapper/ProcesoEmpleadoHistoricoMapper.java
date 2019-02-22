package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator.ProcesoEmpleadoHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleadoHistorico;

@Mapper
@DecoratedWith(value = ProcesoEmpleadoHistoricoDecorator.class)
public abstract class ProcesoEmpleadoHistoricoMapper {

    @Mapping(target = "idProceso", source = "proceso.id")
    public abstract ProcesoEmpleadoHistoricoDto procesoEmpleadoHistoricoToProcesoEmpleadoHistoricoDto(
            ProcesoEmpleadoHistorico src);

    @InheritInverseConfiguration
    public abstract ProcesoEmpleadoHistorico procesoEmpleadoHistoricoDtoToProcesoEmpleadoHistorico(
            ProcesoEmpleadoHistoricoDto src);

    public abstract List<ProcesoEmpleadoHistoricoDto> procesoEmpleadoHistoricoToProcesoEmpleadoHistoricoDto(
            List<ProcesoEmpleadoHistorico> src);

    public abstract List<ProcesoEmpleadoHistorico> procesoEmpleadoHistoricoDtoToProcesoEmpleadoHistorico(
            List<ProcesoEmpleadoHistoricoDto> src);

    @Mapping(target = "proceso.id", source = "srcProceso.id")
    @Mapping(target = "id", ignore = true)
    public abstract ProcesoEmpleadoHistorico mergeProcesoEmpleadoHistoricoDtoAndProcesoDtoToProcesoEmpleadoHistorico(
            ProcesoEmpleadoHistoricoDto srcProcesoEmpleadoHistorico, ProcesoDto srcProceso);

    public List<ProcesoEmpleadoHistorico> mergeProcesoEmpleadoHistoricoDtoAndProcesoDtoToProcesoEmpleadoHistorico(
            List<ProcesoEmpleadoHistoricoDto> srcProcesoEmpleadoHistorico, ProcesoDto srcProcesoDto) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Mapping(target = "idEmpleado", source = "idEmpleado")
    @Mapping(target = "orEmpleado", source = "orEmpleado")
    @Mapping(target = "idEmpleadoLocal", source = "idEmpleadoLocal")
    @Mapping(target = "idTienda", source = "idTiendaMtu")
    @Mapping(target = "idTiendaMeta4", source = "idLugarTrabajo")
    @Mapping(target = "fechaInicio", source = "fechaInicio")
    @Mapping(target = "fechaFin", source = "fechaFin")
    public abstract ProcesoEmpleadoHistoricoDto genericEmpleadoResultItemDtoToProcesoEmpleadoHistoricoDto(
            GenericEmpleadoResultItemDto src);

    public abstract List<ProcesoEmpleadoHistoricoDto> genericEmpleadoResultItemDtoToProcesoEmpleadoHistoricoDto(
            List<GenericEmpleadoResultItemDto> src);
}
