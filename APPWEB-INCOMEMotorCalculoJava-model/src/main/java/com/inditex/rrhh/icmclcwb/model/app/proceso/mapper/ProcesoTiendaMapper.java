package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator.ProcesoTiendaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTienda;

@Mapper
@DecoratedWith(ProcesoTiendaDecorator.class)
public abstract class ProcesoTiendaMapper {

	@Mapping(target = "idProceso", source = "proceso.id")
    public abstract ProcesoTiendaDto procesoTiendaToProcesoTiendaDto(ProcesoTienda src);

    @InheritInverseConfiguration
    public abstract ProcesoTienda procesoTiendaDtoToProcesoTienda(ProcesoTiendaDto src);

    public abstract List<ProcesoTiendaDto> procesoTiendaToProcesoTiendaDto(List<ProcesoTienda> src);

    public abstract List<ProcesoTienda> procesoTiendaDtoToProcesoTienda(List<ProcesoTiendaDto> src);

    @Mapping(target = "id", source = "srcProcesoTiendaDto.id")
    @Mapping(target = "idTienda", source = "srcProcesoTiendaDto.idTienda")
    @Mapping(target = "proceso.id", source = "srcProcesoDto.id")
    public abstract ProcesoTienda mergeProcesoTiendaDtoAndProcesoDtoToProcesoTienda(
            ProcesoTiendaDto srcProcesoTiendaDto, ProcesoDto srcProcesoDto);

    public List<ProcesoTienda> mergeProcesoTiendaDtoAndProcesoDtoToProcesoTienda(
            List<ProcesoTiendaDto> srcProcesoTiendaDto, ProcesoDto srcProcesoDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}