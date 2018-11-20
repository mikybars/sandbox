package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.TrabajoTiendaSeccionEmpleadoPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionEmpleadoPresencia;

@Mapper
@DecoratedWith(TrabajoTiendaSeccionEmpleadoPresenciaDecorator.class)
public abstract class TrabajoTiendaSeccionEmpleadoPresenciaMapper {

    public abstract TrabajoTiendaSeccionEmpleadoPresencia trabajoTiendaSeccionEmpleadoPresenciaDtoToTrabajoTiendaSeccionEmpleadoPresencia(
            TrabajoTiendaSeccionEmpleadoPresenciaDto src);

    public abstract List<TrabajoTiendaSeccionEmpleadoPresencia> trabajoTiendaSeccionEmpleadoPresenciasDtoToTrabajoTiendaSeccionEmpleadoPresencias(
            List<TrabajoTiendaSeccionEmpleadoPresenciaDto> src);

    public abstract TrabajoTiendaSeccionEmpleadoPresenciaDto trabajoTiendaSeccionEmpleadoPresenciaToTrabajoTiendaSeccionEmpleadoPresenciaDto(
            TrabajoTiendaSeccionEmpleadoPresencia src);

    public abstract List<TrabajoTiendaSeccionEmpleadoPresenciaDto> trabajoTiendaSeccionEmpleadoPresenciasToTrabajoTiendaSeccionEmpleadoPresenciasDto(
            List<TrabajoTiendaSeccionEmpleadoPresencia> src);

    @Mappings({ @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE),
            @Mapping(source = "src.tienda", target = "idTienda"),
            @Mapping(source = "src.seccion", target = "idSeccion"),
            @Mapping(source = "src.tipo", target = "idTipoHora"),
            @Mapping(source = "src.persona", target = "idEmpleado"),
            @Mapping(source = "src.minutos", target = "minutos"),
            @Mapping(source = "trabajoDto.id", target = "trabajo.id"), @Mapping(target = "id", ignore = true) })
    public abstract TrabajoTiendaSeccionEmpleadoPresencia presenciasDetalleResponseDtoToTrabajoTiendaSeccionVenta(
            PresenciasDetalleResponseDto src, TrabajoDto trabajoDto);

    public List<TrabajoTiendaSeccionEmpleadoPresencia> presenciasDetalleResponsesDtoToTrabajoTiendaSeccionVentas(
            List<PresenciasDetalleResponseDto> src, TrabajoDto trabajoDto) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
