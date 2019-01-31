package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator.TrabajoTiendaSeccionPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionPresencia;

@Mapper
@DecoratedWith(value= TrabajoTiendaSeccionPresenciaDecorator.class)
public abstract class TrabajoTiendaSeccionPresenciaMapper {

    public abstract TrabajoTiendaSeccionPresencia trabajoTiendaSeccionPresenciaDtoToTrabajoTiendaSeccionPresencia(
            TrabajoTiendaSeccionPresenciaDto src);

    public abstract List<TrabajoTiendaSeccionPresencia> trabajoTiendaSeccionPresenciasDtoToTrabajoTiendaSeccionPresencias(
            List<TrabajoTiendaSeccionPresenciaDto> src);

    public abstract TrabajoTiendaSeccionPresenciaDto trabajoTiendaSeccionPresenciaToTrabajoTiendaSeccionPresenciaDto(
            TrabajoTiendaSeccionPresencia src);

    public abstract List<TrabajoTiendaSeccionPresenciaDto> trabajoTiendaSeccionPresenciasToTrabajoTiendaSeccionPresenciasDto(
            List<TrabajoTiendaSeccionPresencia> src);

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(source = "trabajoDto.id", target = "trabajo.id")
    public abstract TrabajoTiendaSeccionPresencia presenciasTotalTiendaSeccionResponseDtoToTrabajoTiendaSeccionPresencia(
            PtrPresenciaTotalTiendaSeccionResultItemDto src, TrabajoDto trabajoDto);

    public List<TrabajoTiendaSeccionPresencia> presenciasTotalTiendaSeccionResponseDtosDtoToTrabajoTiendaSeccionPresencias(
            List<PtrPresenciaTotalTiendaSeccionResultItemDto> src, TrabajoDto trabajoDto){
        throw new UnsupportedOperationException("Not implemented");
    }

}
