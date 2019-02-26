package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator.ProcesoEmpleadoEstructuraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleadoEstructura;

@Mapper
@DecoratedWith(value = ProcesoEmpleadoEstructuraDecorator.class)
public abstract class ProcesoEmpleadoEstructuraMapper {
    
    @Mapping(target = "idProceso", source = "proceso.id")
    public abstract ProcesoEmpleadoEstructuraDto procesoEmpleadoEstructuraToProcesoEmpleadoEstructuraDto(ProcesoEmpleadoEstructura src);

    @InheritInverseConfiguration
    public abstract ProcesoEmpleadoEstructura procesoEmpleadoEstructuraDtoToProcesoEmpleadoEstructura(ProcesoEmpleadoEstructuraDto src);

    public abstract List<ProcesoEmpleadoEstructuraDto> procesoEmpleadoEstructuraToProcesoEmpleadoEstructuraDto(
            List<ProcesoEmpleadoEstructura> src);

    public abstract List<ProcesoEmpleadoEstructura> procesoEmpleadoEstructuraDtoToProcesoEmpleadoEstructura(
            List<ProcesoEmpleadoEstructuraDto> src);
    
    @Mapping(target = "proceso.id", source = "srcProceso.id")
    @Mapping(target = "id", ignore = true)
    public abstract ProcesoEmpleadoEstructura mergeProcesoEmpleadoEstructuraDtoAndProcesoDtoToProcesoEmpleadoEstructura(
            ProcesoEmpleadoEstructuraDto srcProcesoEmpleadoEstructura, ProcesoDto srcProceso);

    public List<ProcesoEmpleadoEstructura> mergeProcesoEmpleadoEstructuraDtoAndProcesoDtoToProcesoEmpleadoEstructura(
            List<ProcesoEmpleadoEstructuraDto> srcProcesoEmpleadoEstructura, ProcesoDto srcProcesoDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @Mapping(target = "idEmpleado", source = "src.idEmpleado")
    public abstract ProcesoEmpleadoEstructuraDto genericEmpleadoResultItemDtoToProcesoEmpleadoEstructuraDto(
            GenericEmpleadoResultItemDto src, ProcesoDto proceso);

    public List<ProcesoEmpleadoEstructuraDto> genericEmpleadoResultItemDtoToProcesoEmpleadoEstructuraDto(
            List<GenericEmpleadoResultItemDto> src, ProcesoDto proceso) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }       
}
