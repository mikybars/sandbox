package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoMinutosPresenciaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEmpleadoPresenciaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaEmpleadoPresenciaSeccionDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoMinutosPresencia;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaEmpleadoPresenciaSeccion;

@Mapper
@DecoratedWith(TareaTiendaEmpleadoPresenciaSeccionDecorator.class)
public abstract class TareaTiendaEmpleadoPresenciaSeccionMapper {

    public abstract TareaTiendaEmpleadoPresenciaSeccion tareaTiendaEmpleadoPresenciaSeccionDtoToTareaTiendaEmpleadoPresenciaSeccion(
            TareaTiendaEmpleadoPresenciaSeccionDto src);

    public abstract List<TareaTiendaEmpleadoPresenciaSeccion> tareaTiendaEmpleadoPresenciaSeccionDtoToTareaTiendaEmpleadoPresenciaSeccion(
            List<TareaTiendaEmpleadoPresenciaSeccionDto> src);

    public abstract TareaTiendaEmpleadoPresenciaSeccionDto tareaTiendaEmpleadoPresenciaSeccionToTareaTiendaEmpleadoPresenciaSeccionDto(
            TareaTiendaEmpleadoPresenciaSeccion src);

    public abstract List<TareaTiendaEmpleadoPresenciaSeccionDto> tareaTiendaEmpleadoPresenciaSeccionToTareaTiendaEmpleadoPresenciaSeccionDto(
            List<TareaTiendaEmpleadoPresenciaSeccion> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.tipo", target = "idTipoHora")
    @Mapping(source = "src.persona", target = "idEmpleado")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    public abstract TareaTiendaEmpleadoPresenciaSeccion presenciasDetalleResponseDtoToTareaTiendaEmpleadoPresenciaSeccion(
            PtrPresenciaDetalleResultItemDto src, TareaDto tareaDto);

    public List<TareaTiendaEmpleadoPresenciaSeccion> presenciasDetalleResponseDtoToTareaTiendaEmpleadoPresenciaSeccion(
            List<PtrPresenciaDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaEmpleadoPresenciaSeccion tareaTienda,
            PtrPresenciaDetalleResultItemDto src) {
        for (PtrSeccionPresenciasGenericType item : src.getListaSeccion()) {
            if (AppConstants.SECCION_1.equals(item.getSeccion())) {
                tareaTienda.setMinutos1(item.getMinutos());
            } else if (AppConstants.SECCION_2.equals(item.getSeccion())) {
                tareaTienda.setMinutos2(item.getMinutos());
            } else if (AppConstants.SECCION_3.equals(item.getSeccion())) {
                tareaTienda.setMinutos3(item.getMinutos());
            }
        }
        tareaTienda.setTipoMinutosPresencia(new TipoMinutosPresencia());
        tareaTienda.getTipoMinutosPresencia().setId(TipoMinutosPresenciaEnum.MINUTOS_DE_VENDEDORES.getId());
        tareaTienda.setActivo(Boolean.TRUE);
    }
}
