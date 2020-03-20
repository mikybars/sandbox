package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaFilterDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
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
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;

@Mapper(imports = { PtrConstants.class, RunUtils.class, TimeUtils.class })
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
    @Mapping(target = "fechaHoraCreacion", ignore = true)
    @Mapping(target = "fechaHoraInicioTarea", ignore = true)
    @Mapping(target = "fechaHoraFinTarea", ignore = true)
    @Mapping(target = "ambito", ignore = true)
    @Mapping(target = "persona", ignore = true)
    @Mapping(target = "localizacion", ignore = true)
    @Mapping(target = "idOrganization", source = "srcTrabajo.idOrganization")
    @Mapping(target = "stdIdLegEnt", source = "srcTrabajoAmbitoEmpresa.stdIdLegEnt")
    @Mapping(target = "idTrabajo", source = "srcTrabajo.id")
    @Mapping(target = "fechaInicioPeriodo", source = "srcTrabajo.fechaInicioPeriodo")
    @Mapping(target = "fechaFinPeriodo", source = "srcTrabajo.fechaFinPeriodo")
    public abstract TareaDto mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
            TrabajoAmbitoEmpresaDto srcTrabajoAmbitoEmpresa, TrabajoDto srcTrabajo);

    public List<TareaDto> mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
            List<TrabajoAmbitoEmpresaDto> srcTrabajoAmbitoEmpresa, TrabajoDto srcTrabajo) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "item", ignore = true)
    @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaInicioPeriodo()))")
    @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaFinPeriodo()))")
    @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
    @Mapping(target = "idEmpresa", source = "srcTarea.stdIdLegEnt")
    public abstract GenericFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);
    
    @Mapping(target = "item", ignore = true)
    @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaInicioPeriodo()))")
    @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaFinPeriodo()))")
    @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
    public abstract ConfChDiasMinimosFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToConfChDiasMinimosFilterDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);
    
    @Mapping(target = "item", ignore = true)
    @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaInicioPeriodo()))")
    @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaFinPeriodo()))")
    @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
    @Mapping(target = "idEmpresa", source = "srcTarea.stdIdLegEnt")
    public abstract PresupuestosWlocFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPresupuestosWlocFilterDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);
    
    @Mapping(target = "item", ignore = true)
    @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaInicioPeriodo()))")
    @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaFinPeriodo()))")
    @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
    public abstract ConfPrecioHoraFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToConfPrecioHoraFilterDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);
    
    @Mapping(target = "item", ignore = true)
    @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaInicioPeriodo()))")
    @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaFinPeriodo()))")
    @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
    @Mapping(target = "idEmpresa", source = "srcTarea.stdIdLegEnt")
    public abstract ConfChTpVentaFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToConfChTpVentaFilterDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);
    
    @Mapping(target = "item", ignore = true)
    @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaInicioPeriodo()))")
    @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaFinPeriodo()))")
    @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
    @Mapping(target = "idEmpresa", source = "srcTarea.stdIdLegEnt")
    public abstract PresupuestosRangoFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPresupuestosRangoFilterDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);
    
    @Mapping(target = "item", ignore = true)
    @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaInicioPeriodo()))")
    @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaFinPeriodo()))")
    public abstract VentaCongeladaFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToVentaCongeladaFilterDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);
    
    @Mapping(target = "item", ignore = true)
    @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcPeriodo.getFechaInicioPeriodo()))")
    @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcPeriodo.getFechaFinPeriodo()))")
    @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
    @Mapping(target = "idEmpresa", source = "srcTarea.stdIdLegEnt")
    public abstract GenericFilterDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(
            TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto srcPeriodo);

    @Mapping(target = "item", ignore = true)
    @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaInicioPeriodo()))")
    @Mapping(target = "fechaFin", expression = "java(RunUtils.addDays(TimeUtils.toLocalDateTime(srcTrabajo.getFechaFinPeriodo()), srcRecolectarProperties.getDaysNumber()))")
    @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
    @Mapping(target = "idEmpresa", source = "srcTarea.stdIdLegEnt")
    public abstract GenericFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDtoWithDates(
        TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, RecolectarPropertiesDto srcRecolectarProperties);
    
    @Mapping(target = "item", ignore = true)
    @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaInicioPeriodo()))")
    @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaFinPeriodo()))")
    @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
    public abstract EstructurasComFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToEstructurasComFilterDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);

    @Mapping(target = "tienda", ignore = true)
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
    @Mapping(target = "empresa", source = "srcTarea.stdIdLegEnt")
    public abstract PtrVentaTotalizadoRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaTotalizadoRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties);
    
    @Mapping(target = "tienda", ignore = true)
    @Mapping(target = "fechaDesde", source = "srcPresupuesto.fechaInicio", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcPresupuesto.getFechaFin(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
    @Mapping(target = "empresa", source = "srcTarea.stdIdLegEnt")
    public abstract PtrVentaTotalizadoRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaTotalizadoRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, IdLocalizacionLocalPresupuestoDto srcPresupuesto,
            RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "tienda", ignore = true)
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
    @Mapping(target = "empresa", ignore = true)
    public abstract PtrVentaTotalizadoRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdCadenaDtoToPtrVentaTotalizadoRequestDto(
        TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
        RecolectarPropertiesDto srcRecolectarProperties, List<IdCadenaDto> cadenas);

    @Mapping(target = "empresa", source = "srcTarea.stdIdLegEnt")
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
    public abstract PtrVentaIndividualDetalleRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaIndividualDetalleRequestDto(
        TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
        RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "tienda", ignore = true)
    @Mapping(target = "persona", ignore = true)
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "origen", source = "srcTareaAmbito.cclIdOrigen")
    @Mapping(target = "empresa", source = "srcTarea.stdIdLegEnt")
    @Mapping(target = "agruparSeccion", defaultValue = PtrConstants.AGRUPAR_SECCION_TRUE)
    public abstract PtrPresenciaDetalleRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasDetalleRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "empresa", ignore = true)
    @Mapping(target = "tienda", ignore = true)
    @Mapping(target = "origen", source = "srcTareaAmbito.cclIdOrigen")
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", source = "srcTrabajo.fechaFinPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    public abstract PtrPresenciaEmpleadosTiendaRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaEmpleadosTiendaRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, List<IdLocalizacionLocalDto> srcLocalizaciones);
    
    @Mapping(target = "empresa", source = "srcTarea.stdIdLegEnt")
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
    public abstract PtrVentaOnlineIpodRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "empresa", source = "srcTarea.stdIdLegEnt")
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
    public abstract PtrVentaOnlineIpodIndividualDetalleRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodIndividualDetalleRequestDto(
        TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
        RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "empresa", source = "srcTarea.stdIdLegEnt")
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
    public abstract PtrVentaOnlinePickingRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlinePickingRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "empresa", source = "srcTarea.stdIdLegEnt")
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
    public abstract PtrVentaOnlineEntregaTiendaRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaTiendaRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties);
    
    @Mapping(target = "empresa", source = "srcTarea.stdIdLegEnt")
    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
    public abstract PtrVentaOnlineEntregaDomicilioRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties);

    @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "fechaHasta", expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(), PtrConstants.DATE_FORMAT))")
    @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
    @Mapping(target = "empresa", ignore = true)
    public abstract PtrVentaOnlineEntregaDomicilioRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
        TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
        RecolectarPropertiesDto srcRecolectarProperties, List<IdCadenaDto> cadenas);

}
