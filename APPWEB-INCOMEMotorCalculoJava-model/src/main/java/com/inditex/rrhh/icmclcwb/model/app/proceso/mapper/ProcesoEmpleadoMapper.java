package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator.ProcesoEmpleadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleado;

@Mapper
@DecoratedWith(ProcesoEmpleadoDecorator.class)
public abstract class ProcesoEmpleadoMapper {

	@Mapping(target = "idProceso", source = "proceso.id")
    public abstract ProcesoEmpleadoDto procesoEmpleadoToProcesoEmpleadoDto(ProcesoEmpleado src);

    @InheritInverseConfiguration
    public abstract ProcesoEmpleado procesoEmpleadoDtoToProcesoEmpleado(ProcesoEmpleadoDto src);

    public abstract List<ProcesoEmpleadoDto> procesoEmpleadoToProcesoEmpleadoDto(List<ProcesoEmpleado> src);

    public abstract List<ProcesoEmpleado> procesoEmpleadoDtoToProcesoEmpleado(List<ProcesoEmpleadoDto> src);

    @Mapping(target = "id", source = "srcProcesoEmpleadoDto.id")
    @Mapping(target = "idEmpleado", source = "srcProcesoEmpleadoDto.idEmpleado")
    @Mapping(target = "proceso.id", source = "srcProcesoDto.id")
    public abstract ProcesoEmpleado mergeProcesoEmpleadoDtoAndProcesoDtoToProcesoEmpleado(
            ProcesoEmpleadoDto srcProcesoEmpleadoDto, ProcesoDto srcProcesoDto);

    public List<ProcesoEmpleado> mergeProcesoEmpleadoDtoAndProcesoDtoToProcesoEmpleado(
            List<ProcesoEmpleadoDto> srcProcesoEmpleadoDto, ProcesoDto srcProcesoDto) {
        throw new UnsupportedOperationException("Not implemented");
    }

}