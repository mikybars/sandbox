package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;

@Mapper
@DecoratedWith(value = TareaMapperDecorator.class)
public abstract class TareaMapper {

    @Mapping(target = "idTrabajo", source = "trabajo.id")
    public abstract TareaDto tareaToTareaDto(Tarea src);

    @InheritInverseConfiguration
    public abstract Tarea tareaDtoToTarea(TareaDto src);

    public abstract List<TareaDto> tareaToTareaDto(List<Tarea> src);

    public abstract List<Tarea> tareaDtoToTarea(List<TareaDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true /* expression = "java(java.time.LocalDateTime.now())" */)
    @Mapping(target = "fechaInicioTarea", ignore = true)
    @Mapping(target = "fechaFinTarea", ignore = true)
    @Mapping(target = "ambito", ignore = true)
    @Mapping(target = "persona", ignore = true)
    @Mapping(target = "localizacion", ignore = true)
    @Mapping(target = "idSociedad", source = "srcTrabajo.idSociedad")
    @Mapping(target = "idEmpresa", source = "srcTrabajoAmbitoEmpresa.idEmpresa")
    @Mapping(target = "idTrabajo", source = "srcTrabajo.id")
    public abstract TareaDto mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
            TrabajoAmbitoEmpresaDto srcTrabajoAmbitoEmpresa, TrabajoDto srcTrabajo);

    @AfterMapping
    protected void mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(TrabajoAmbitoEmpresaDto srcTrabajoAmbitoEmpresa,
            TrabajoDto srcTrabajo, @MappingTarget TareaDto tarea) {

        List<TareaAmbitoDto> ambito = new ArrayList<>();
        srcTrabajo.getOrigen().forEach(item -> ambito.add(TareaAmbitoDto.builder().idOrigen(item.getIdOrigen())
                .idCatalogo(/* TODO Cambiar por valor de Meta4 */item.getIdOrigen()).build()));
        tarea.setAmbito(ambito);

        List<TareaAmbitoLocalizacionDto> localizacion = new ArrayList<>();
        srcTrabajo.getLocalizacion().stream()
                .filter(item -> item.getIdEmpresa().equals(srcTrabajoAmbitoEmpresa.getIdEmpresa()))
                .collect(Collectors.toList()).forEach(item -> localizacion.add(TareaAmbitoLocalizacionDto.builder()
                        .idLocalizacion(item.getIdLocalizacion()).idOrigen(item.getIdOrigen()).build()));
        tarea.setLocalizacion(localizacion);

        List<TareaAmbitoPersonaDto> persona = new ArrayList<>();
        srcTrabajo.getPersona().stream()
                .filter(item -> item.getIdEmpresa().equals(srcTrabajoAmbitoEmpresa.getIdEmpresa()))
                .collect(Collectors.toList())
                .forEach(item -> persona.add(TareaAmbitoPersonaDto.builder().idPersona(item.getIdPersona())
                        .orPersona(item.getOrPersona()).idOrigen(item.getIdOrigen()).build()));
        tarea.setPersona(persona);
    }

    public List<TareaDto> mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
            List<TrabajoAmbitoEmpresaDto> srcTrabajoAmbitoEmpresa, TrabajoDto srcTrabajo) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

//    @Mapping(target = "fechaInicio", source = "fechaInicioPeriodo")
//    @Mapping(target = "fechaFin", source = "fechaFinPeriodo")
//    @Mapping(target = "idOrigen", source = "idPaisOrigen")
    @Mapping(target = "idEmpresa", source = "idEmpresa")
    public abstract GenericFilterDto tareaDtoToGenericFilterDto(TareaDto src);

//    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
//    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
//    @Mapping(target = "pais", source = "idPaisOrigen")
    @Mapping(target = "tienda", ignore = true)
    public abstract PtrVentaTotalizadoRequestDto tareaDtoToPtrVentaTotalizadoRequestDto(TareaDto src);

//    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
//    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
//    @Mapping(target = "pais", source = "idPaisOrigen")
    @Mapping(target = "tienda", ignore = true)
    public abstract PtrVentaIndividualDetalleRequestDto tareaDtoToPtrVentaIndividualDetalleRequestDto(TareaDto src);

//    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
//    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
//    @Mapping(target = "origen", source = "idPaisOrigen")
    public abstract PtrPresenciaTotalTiendaSeccionRequestDto tareaDtoToPtrPresenciasTotalTiendaSeccionRequestDto(
            TareaDto src);

//    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
//    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
//    @Mapping(target = "origen", source = "idPaisOrigen")
    @Mapping(target = "persona", ignore = true)
    public abstract PtrPresenciaDetalleRequestDto tareaDtoToPtrPresenciasDetalleRequestDto(TareaDto src);

//    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
//    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
//    @Mapping(target = "origen", source = "idPaisOrigen")
    @Mapping(target = "persona", ignore = true)
    public abstract PtrPresenciaDetalleComisionableRequestDto tareaDtoToPtrPresenciasDetalleComisionableRequestDto(
            TareaDto src);
    
}
