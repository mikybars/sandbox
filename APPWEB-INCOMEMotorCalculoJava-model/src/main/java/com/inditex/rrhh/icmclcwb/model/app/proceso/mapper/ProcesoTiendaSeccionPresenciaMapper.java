package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator.ProcesoTiendaSeccionPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaSeccionPresencia;

@Mapper
@DecoratedWith(value= ProcesoTiendaSeccionPresenciaDecorator.class)
public abstract class ProcesoTiendaSeccionPresenciaMapper {

    public abstract ProcesoTiendaSeccionPresencia procesoTiendaSeccionPresenciaDtoToProcesoTiendaSeccionPresencia(
            ProcesoTiendaSeccionPresenciaDto src);

    public abstract List<ProcesoTiendaSeccionPresencia> procesoTiendaSeccionPresenciasDtoToProcesoTiendaSeccionPresencias(
            List<ProcesoTiendaSeccionPresenciaDto> src);

    public abstract ProcesoTiendaSeccionPresenciaDto procesoTiendaSeccionPresenciaToProcesoTiendaSeccionPresenciaDto(
            ProcesoTiendaSeccionPresencia src);

    public abstract List<ProcesoTiendaSeccionPresenciaDto> procesoTiendaSeccionPresenciasToProcesoTiendaSeccionPresenciasDto(
            List<ProcesoTiendaSeccionPresencia> src);

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(source = "procesoDto.id", target = "proceso.id")
    public abstract ProcesoTiendaSeccionPresencia presenciasTotalTiendaSeccionResponseDtoToProcesoTiendaSeccionPresencia(
            PtrPresenciaTotalTiendaSeccionResultItemDto src, ProcesoDto procesoDto);

    public List<ProcesoTiendaSeccionPresencia> presenciasTotalTiendaSeccionResponseDtosDtoToProcesoTiendaSeccionPresencias(
            List<PtrPresenciaTotalTiendaSeccionResultItemDto> src, ProcesoDto procesoDto){
        throw new UnsupportedOperationException("Not implemented");
    }

}
