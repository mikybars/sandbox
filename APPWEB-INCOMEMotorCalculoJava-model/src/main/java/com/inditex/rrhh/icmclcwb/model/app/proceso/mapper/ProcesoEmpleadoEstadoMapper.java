package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator.ProcesoEmpleadoEstadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleadoEstado;

@Mapper
@DecoratedWith(ProcesoEmpleadoEstadoDecorator.class)
public abstract class ProcesoEmpleadoEstadoMapper {

	@Mapping(target = "idProceso", source = "proceso.id")
    public abstract ProcesoEmpleadoEstadoDto procesoEmpleadoEstadoToProcesoEmpleadoEstadoDto(ProcesoEmpleadoEstado src);

    @InheritInverseConfiguration
    public abstract ProcesoEmpleadoEstado procesoEmpleadoEstadoDtoToProcesoEmpleadoEstado(ProcesoEmpleadoEstadoDto src);

    public abstract List<ProcesoEmpleadoEstadoDto> procesoEmpleadoEstadoToProcesoEmpleadoEstadoDto(
            List<ProcesoEmpleadoEstado> src);

    public abstract List<ProcesoEmpleadoEstado> procesoEmpleadoEstadoDtoToProcesoEmpleadoEstado(
            List<ProcesoEmpleadoEstadoDto> src);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "proceso.id", source = "srcProcesoDto.id")
	@Mapping(target = "idEmpleado", source = "srcProcesoEmpleadoEstadoDto.idEmpleado")
	@Mapping(target = "orEmpleado", source = "srcProcesoEmpleadoEstadoDto.orEmpleado")
	public abstract ProcesoEmpleadoEstado mergeProcesoEmpleadoEstadoDtoAndProcesoDtoToProcesoEmpleadoEstado(
			ProcesoEmpleadoEstadoDto srcProcesoEmpleadoEstadoDto, ProcesoDto srcProcesoDto);
   
	public List<ProcesoEmpleadoEstado> mergeProcesoEmpleadoEstadoDtoAndProcesoDtoToProcesoEmpleadoEstado(
            List<ProcesoEmpleadoEstadoDto> srcProcesoEmpleadoEstadoDto, ProcesoDto srcProcesoDto) {
	    throw new UnsupportedOperationException("Not implemented");
    }

    @Mapping(target = "idEmpleado", source = "src.idEmpleado")
    @Mapping(target = "orEmpleado", source = "src.orEmpleado")
    @Mapping(target = "idProceso", source = "proceso.id")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    public abstract ProcesoEmpleadoEstadoDto genericEmpleadoResultItemDtoToProcesoEmpleadoEstadoDto(
            GenericEmpleadoResultItemDto src, ProcesoDto proceso);

    public List<ProcesoEmpleadoEstadoDto> genericEmpleadoResultItemDtoToProcesoEmpleadoEstadoDto(
            List<GenericEmpleadoResultItemDto> src, ProcesoDto proceso) {
        throw new UnsupportedOperationException("Not implemented");
    }

}