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

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.app.util.RunUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;

@Mapper(imports = { PtrConstants.class, RunUtils.class })
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

    @Mapping(target = "item", ignore = true)
    @Mapping(target = "fechaInicio", source = "srcTrabajo.fechaInicioPeriodo")
    @Mapping(target = "fechaFin", source = "srcTrabajo.fechaFinPeriodo")
    @Mapping(target = "idOrigen", source = "srcTareaAmbito.idCatalogo")
    @Mapping(target = "idEmpresa", source = "srcTarea.idEmpresa")
    public abstract GenericFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndTareaAmbitoLocalizacionDtoAndTareaAmbitoPersonaDtoToGenericFilterDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            List<TareaAmbitoLocalizacionDto> srcTareaAmbitoLocalizacion,
            List<TareaAmbitoPersonaDto> srcTareaAmbitoPersona);

    @Mapping(target = "item", ignore = true)
    @Mapping(target = "fechaInicio", source = "srcTrabajo.fechaInicioPeriodo")
    @Mapping(target = "fechaFin", source = "srcTrabajo.fechaFinPeriodo")
    @Mapping(target = "idOrigen", source = "srcTareaAmbito.idCatalogo")
    @Mapping(target = "idEmpresa", source = "srcTarea.idEmpresa")
    public abstract GenericFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdPersonaDtoToGenericFilterDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, List<IdPersonaDto> srcIdsPersona);

    @AfterMapping
    public void mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdPersonaDtoToGenericFilterDto(TrabajoDto srcTrabajo,
            TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, List<IdPersonaDto> srcIdsPersona,
            @MappingTarget GenericFilterDto genericFilter) {
        if (genericFilter != null && srcIdsPersona != null) {
            genericFilter.getItem()
                    .addAll(srcIdsPersona.stream()
                            .map(x -> GenericFilterParametersDto.builder().idEmpleado(x.getIdPersona()).build())
                            .collect(Collectors.toList()));
        }
    }

    @Mapping(target = "item", ignore = true)
    @Mapping(target = "fechaInicio", source = "srcTrabajo.fechaInicioPeriodo")
    @Mapping(target = "fechaFin", source = "srcTrabajo.fechaFinPeriodo")
    @Mapping(target = "idOrigen", source = "srcTareaAmbito.idCatalogo")
    @Mapping(target = "idEmpresa", source = "srcTarea.idEmpresa")
    public abstract GenericFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);

    @Mapping(target = "tienda", ignore = true)
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.idCatalogo")
    @Mapping(target = "empresa", source = "srcTarea.idEmpresa")
    public abstract PtrVentaTotalizadoRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaTotalizadoRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "tienda", ignore = true)
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", source = "srcTrabajo.fechaFinPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "pais", source = "srcTareaAmbito.idCatalogo")
    @Mapping(target = "empresa", source = "srcTarea.idEmpresa")
    public abstract PtrVentaIndividualDetalleRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaIndividualDetalleRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);

    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "origen", source = "srcTareaAmbito.idCatalogo")
    @Mapping(target = "empresa", source = "srcTarea.idEmpresa")
    public abstract PtrPresenciaTotalTiendaSeccionRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasTotalTiendaSecceionRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "origen", source = "srcTareaAmbito.idCatalogo")
    @Mapping(target = "empresa", source = "srcTarea.idEmpresa")
    public abstract PtrPresenciaTotalTiendaRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasTotalTiendaRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "origen", source = "srcTareaAmbito.idCatalogo")
    @Mapping(target = "empresa", source = "srcTarea.idEmpresa")
    public abstract PtrPresenciaTotalizadoRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaTotalizadoRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "tienda", ignore = true)
    @Mapping(target = "persona", ignore = true)
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", source = "srcTrabajo.fechaFinPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "origen", source = "srcTareaAmbito.idCatalogo")
    @Mapping(target = "empresa", source = "srcTarea.idEmpresa")
    @Mapping(target = "agruparSeccion", defaultValue = PtrConstants.AGRUPAR_SECCION_TRUE)
    public abstract PtrPresenciaDetalleRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasDetalleRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);

    @Mapping(target = "tienda", ignore = true)
    @Mapping(target = "persona", ignore = true)
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", source = "srcTrabajo.fechaFinPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "origen", source = "srcTareaAmbito.idCatalogo")
    @Mapping(target = "empresa", source = "srcTarea.idEmpresa")
    @Mapping(target = "agruparSeccion", defaultValue = PtrConstants.AGRUPAR_SECCION_TRUE)
    public abstract PtrPresenciaDetalleComisionableRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasDetalleComisionableRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);

    @Mapping(target = "empresa", source = "srcTarea.idEmpresa")
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.idCatalogo")
    public abstract PtrVentaOnlineIpodIndividualDetalleRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodIndividualDetalleRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "empresa", ignore = true)
    @Mapping(target = "persona", ignore = true)
    @Mapping(target = "origen", source = "srtTareaAmbito.idCatalogo")
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", source = "srcTrabajo.fechaFinPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    public abstract PtrPresenciaTiendasEmpleadoRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaTiendasEmpleadoRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srtTareaAmbito);

    @Mapping(target = "empresa", ignore = true)
    @Mapping(target = "tienda", ignore = true)
    @Mapping(target = "origen", source = "srtTareaAmbito.idCatalogo")
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", source = "srcTrabajo.fechaFinPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    public abstract PtrPresenciaEmpleadosTiendaRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaEmpleadosTiendaRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srtTareaAmbito, List<IdLocalizacionLocalDto> srcLocalizaciones);
    
    @AfterMapping
    public void mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaEmpleadosTiendaRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            List<IdLocalizacionLocalDto> srcLocalizaciones, @MappingTarget PtrPresenciaEmpleadosTiendaRequestDto result) {
        if (result != null && srcLocalizaciones != null) {
            List<Integer> localizaciones = srcLocalizaciones.stream().map(IdLocalizacionLocalDto::getId).map(Integer::valueOf).collect(Collectors.toList());
            result.setTienda(localizaciones);
        }
    }

    @Mapping(target = "empresa", source = "srcTarea.idEmpresa")
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.idCatalogo")
    public abstract PtrVentaOnlineIpodRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "empresa", source = "srcTarea.idEmpresa")
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.idCatalogo")
    public abstract PtrVentaOnlinePickingRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlinePickingRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "empresa", source = "srcTarea.idEmpresa")
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.idCatalogo")
    public abstract PtrVentaOnlineEntregaTiendaRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaTiendaRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "empresa", source = "srcTarea.idEmpresa")
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.idCatalogo")
    public abstract PtrVentaOnlineEntregaDomicilioRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties);

}
