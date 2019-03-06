package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.SeccionPresenciasDetalleComisionableType;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator.ProcesoTiendaSeccionEmpleadoPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaEmpleadoPresenciaSeccion;
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
    public abstract ProcesoTiendaSeccionEmpleadoPresencia presenciasDetalleResponseDtoToProcesoTiendaSeccionEmpleadoPresencia(
            PtrPresenciaDetalleResultItemDto src, ProcesoDto procesoDto);

    public List<ProcesoTiendaSeccionEmpleadoPresencia> presenciasDetalleResponsesDtoToProcesoTiendaSeccionEmpleadoPresencia(
            List<PtrPresenciaDetalleResultItemDto> src, ProcesoDto procesoDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.tipo", target = "idTipoHora")
    @Mapping(source = "src.persona", target = "idEmpleado")
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(source = "procesoDto.id", target = "proceso.id")
    @Mapping(target = "id", ignore = true)
    public abstract ProcesoTiendaSeccionEmpleadoPresencia presenciasDetalleComisionableResponseDtoToProcesoTiendaSeccionEmpleadoPresencia(
            PtrPresenciaDetalleComisionableResultItemDto src, ProcesoDto procesoDto);

    public List<ProcesoTiendaSeccionEmpleadoPresencia> presenciasDetalleComisionableResponsesDtoToProcesoTiendaSeccionEmpleadoPresencia(
            List<PtrPresenciaDetalleComisionableResultItemDto> src, ProcesoDto procesoDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.tipo", target = "idTipoHora")
    @Mapping(source = "src.persona", target = "idEmpleado")
    @Mapping(source = "procesoDto.id", target = "proceso.id")
    @Mapping(target = "id", ignore = true)
    public abstract ProcesoTiendaEmpleadoPresenciaSeccion presenciasDetalleComisionableResponseDtoToProcesoTiendaEmpleadoPresenciaSeccion( 
            PtrPresenciaDetalleComisionableResultItemDto src, ProcesoDto procesoDto);

    public List<ProcesoTiendaEmpleadoPresenciaSeccion> presenciasDetalleComisionableResponseDtoToProcesoTiendaEmpleadoPresenciaSeccion(
            List<PtrPresenciaDetalleComisionableResultItemDto> src, ProcesoDto procesoDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget ProcesoTiendaEmpleadoPresenciaSeccion procesoTienda, PtrPresenciaDetalleComisionableResultItemDto src){
        for(SeccionPresenciasDetalleComisionableType item : src.getListaSeccion()) {
            if(item.getSeccion().equals(1)){
                procesoTienda.setMinutos1(item.getMinutos());
            }else if(item.getSeccion().equals(2)) {
                procesoTienda.setMinutos2(item.getMinutos());
            }else if(item.getSeccion().equals(3)) {
                procesoTienda.setMinutos3(item.getMinutos());
            }
        }
    }
}
