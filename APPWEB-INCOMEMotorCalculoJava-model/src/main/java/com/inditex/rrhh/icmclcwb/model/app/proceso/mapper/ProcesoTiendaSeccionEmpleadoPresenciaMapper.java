package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator.ProcesoTiendaSeccionEmpleadoPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaSeccionEmpleadoPresencia;

@Mapper
@DecoratedWith(ProcesoTiendaSeccionEmpleadoPresenciaDecorator.class)
public abstract class ProcesoTiendaSeccionEmpleadoPresenciaMapper {

    public abstract ProcesoTiendaSeccionEmpleadoPresencia procesoTiendaSeccionEmpleadoPresenciaDtoToProcesoTiendaSeccionEmpleadoPresencia(
            ProcesoTiendaSeccionEmpleadoPresenciaDto src);

    public abstract List<ProcesoTiendaSeccionEmpleadoPresencia> procesoTiendaSeccionEmpleadoPresenciasDtoToProcesoTiendaSeccionEmpleadoPresencias(
            List<ProcesoTiendaSeccionEmpleadoPresenciaDto> src);

    public abstract ProcesoTiendaSeccionEmpleadoPresenciaDto procesoTiendaSeccionEmpleadoPresenciaToProcesoTiendaSeccionEmpleadoPresenciaDto(
            ProcesoTiendaSeccionEmpleadoPresencia src);

    public abstract List<ProcesoTiendaSeccionEmpleadoPresenciaDto> procesoTiendaSeccionEmpleadoPresenciasToProcesoTiendaSeccionEmpleadoPresenciasDto(
            List<ProcesoTiendaSeccionEmpleadoPresencia> src);

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.tipo", target = "idTipoHora")
    @Mapping(source = "src.persona", target = "idEmpleado")
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(source = "procesoDto.id", target = "proceso.id")
    @Mapping(target = "id", ignore = true)
    public abstract ProcesoTiendaSeccionEmpleadoPresencia presenciasDetalleResponseDtoToProcesoTiendaSeccionVenta(
            PtrPresenciaDetalleResultItemDto src, ProcesoDto procesoDto);

    public List<ProcesoTiendaSeccionEmpleadoPresencia> presenciasDetalleResponsesDtoToProcesoTiendaSeccionVentas(
            List<PtrPresenciaDetalleResultItemDto> src, ProcesoDto procesoDto) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.tipo", target = "idTipoHora")
    @Mapping(source = "src.persona", target = "idEmpleado")
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(source = "procesoDto.id", target = "proceso.id")
    @Mapping(target = "id", ignore = true)
    public abstract ProcesoTiendaSeccionEmpleadoPresencia presenciasDetalleComisionableResponseDtoToProcesoTiendaSeccionVenta(
            PtrPresenciaDetalleComisionableResultItemDto src, ProcesoDto procesoDto);

    public List<ProcesoTiendaSeccionEmpleadoPresencia> presenciasDetalleComisionableResponsesDtoToProcesoTiendaSeccionVentas(
            List<PtrPresenciaDetalleComisionableResultItemDto> src, ProcesoDto procesoDto) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
