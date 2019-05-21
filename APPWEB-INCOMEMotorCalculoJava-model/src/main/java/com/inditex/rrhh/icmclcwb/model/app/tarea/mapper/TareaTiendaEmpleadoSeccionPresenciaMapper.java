package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEmpleadoSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaEmpleadoSeccionPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaEmpleadoSeccionPresencia;

@Mapper
@DecoratedWith(TareaTiendaEmpleadoSeccionPresenciaDecorator.class)
public abstract class TareaTiendaEmpleadoSeccionPresenciaMapper {

    public abstract TareaTiendaEmpleadoSeccionPresencia tareaTiendaEmpleadoSeccionPresenciaDtoToTareaTiendaEmpleadoSeccionPresencia(
            TareaTiendaEmpleadoSeccionPresenciaDto src);

    public abstract List<TareaTiendaEmpleadoSeccionPresencia> tareaTiendaEmpleadoSeccionPresenciaDtoToTareaTiendaEmpleadoSeccionPresencia(
            List<TareaTiendaEmpleadoSeccionPresenciaDto> src);

    public abstract TareaTiendaEmpleadoSeccionPresenciaDto tareaTiendaEmpleadoSeccionPresenciaToTareaTiendaEmpleadoSeccionPresenciaDto(
            TareaTiendaEmpleadoSeccionPresencia src);

    public abstract List<TareaTiendaEmpleadoSeccionPresenciaDto> tareaTiendaEmpleadoSeccionPresenciaToTareaTiendaEmpleadoSeccionPresenciaDto(
            List<TareaTiendaEmpleadoSeccionPresencia> src);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.tipo", target = "idTipoHora")
    @Mapping(source = "src.persona", target = "idEmpleado")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(source = "idSeccion", target = "idSeccion")
    @Mapping(defaultValue = "0L", target = "minutos")
    public abstract TareaTiendaEmpleadoSeccionPresencia presenciasDetalleResponseDtoToTareaTiendaEmpleadoSeccionPresencia(
            PtrPresenciaDetalleResultItemDto src, TareaDto tareaDto, Integer idSeccion);

    public List<TareaTiendaEmpleadoSeccionPresencia> presenciasDetalleResponseDtoToTareaTiendaEmpleadoSeccionPresencia(
            List<PtrPresenciaDetalleResultItemDto> src, TareaDto tareaDto, Integer idSeccion) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void presenciasDetalleResponseDtoToTareaTiendaEmpleadoSeccionPresencia(
            @MappingTarget TareaTiendaEmpleadoSeccionPresencia dest, PtrPresenciaDetalleResultItemDto src, TareaDto tareaDto, Integer idSeccion) {
        dest.setTipoDato(new TipoDato());
        dest.setActivo(Boolean.TRUE);
        dest.getTipoDato().setId(TipoDatoEnum.MINUTOS_INDIVIDUAL.getId());
        List<PtrSeccionPresenciasGenericType> listaSeccion = src.getListaSeccion();
        if (listaSeccion != null) {
            Optional<PtrSeccionPresenciasGenericType> optional = listaSeccion.stream().filter(x -> x.getSeccion() == idSeccion).findFirst();
            if (optional.isPresent()) {
                PtrSeccionPresenciasGenericType seccion = optional.get();
                dest.setMinutos(seccion.getMinutos());
            }
        }
    }
    
}
