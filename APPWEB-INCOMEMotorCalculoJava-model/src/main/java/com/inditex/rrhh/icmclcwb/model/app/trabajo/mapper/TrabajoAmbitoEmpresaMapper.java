package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoParametersDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator.TrabajoAmbitoEmpresaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoEmpresa;

@Mapper
@DecoratedWith(value = TrabajoAmbitoEmpresaMapperDecorator.class)
public abstract class TrabajoAmbitoEmpresaMapper {

    @Mapping(target = "idTrabajo", source = "trabajo.id")
    public abstract TrabajoAmbitoEmpresaDto trabajoAmbitoEmpresaToTrabajoAmbitoEmpresaDto(TrabajoAmbitoEmpresa src);

    @InheritInverseConfiguration
    public abstract TrabajoAmbitoEmpresa trabajoAmbitoEmpresaDtoToTrabajoAmbitoEmpresa(TrabajoAmbitoEmpresaDto src);

    public abstract List<TrabajoAmbitoEmpresaDto> trabajoAmbitoEmpresaToTrabajoAmbitoEmpresaDto(
            List<TrabajoAmbitoEmpresa> src);

    public abstract List<TrabajoAmbitoEmpresa> trabajoAmbitoEmpresaDtoToTrabajoAmbitoEmpresa(
            List<TrabajoAmbitoEmpresaDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "trabajo.id", source = "srcTrabajo.id")
    public abstract TrabajoAmbitoEmpresa mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTrabajoAmbitoEmpresa(
            TrabajoAmbitoEmpresaDto srcTrabajoAmbitoEmpresa, TrabajoDto srcTrabajo);

    public List<TrabajoAmbitoEmpresa> mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTrabajoAmbitoEmpresa(
            List<TrabajoAmbitoEmpresaDto> srcTrabajoAmbitoEmpresa, TrabajoDto srcTrabajo) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "idEmpresa", source = "stdIdLegEnt")
    public abstract SaveProcesoParametersDto trabajoAmbitoEmpresaDtoToSaveProcesoParametersDto(
            TrabajoAmbitoEmpresaDto src);

    public abstract List<SaveProcesoParametersDto> trabajoAmbitoEmpresaDtoToSaveProcesoParametersDto(
            List<TrabajoAmbitoEmpresaDto> src);

}
