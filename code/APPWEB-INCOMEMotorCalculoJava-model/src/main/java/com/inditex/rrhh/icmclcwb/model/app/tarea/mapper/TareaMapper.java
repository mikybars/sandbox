package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalFechaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocFilterDto;
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
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.app.util.RunUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {PtrConstants.class, RunUtils.class, TimeUtils.class, Arrays.class})
@DecoratedWith(value = TareaMapperDecorator.class)
public abstract class TareaMapper {

  @Mapping(target = "idTrabajo", source = "trabajo.id")
  @Mapping(target = "ambito", ignore = true)
  @Mapping(target = "persona", ignore = true)
  @Mapping(target = "localizacion", ignore = true)
  public abstract TareaDto tareaToTareaDto(Tarea src);

  public abstract List<TareaDto> tareaToTareaDto(List<Tarea> src);

  @InheritInverseConfiguration
  @Mapping(target = "estado.id", source = "estado.id")
  @Mapping(target = "estado.nombre", ignore = true)
  @Mapping(target = "estado.peso", ignore = true)
  public abstract Tarea tareaDtoToTarea(TareaDto src);

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
      TrabajoAmbitoEmpresaDTO srcTrabajoAmbitoEmpresa, TrabajoDTO srcTrabajo);

  public List<TareaDto> mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
      final List<TrabajoAmbitoEmpresaDTO> srcTrabajoAmbitoEmpresa, final TrabajoDTO srcTrabajo) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(periodo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(periodo.getFechaFinPeriodo()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "idsEmpresa", ignore = true)
  public abstract GenericFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(
      TrabajoDTO srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(periodo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(periodo.getFechaFinPeriodo()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  public abstract ConfChDiasMinimosFilterDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToConfChDiasMinimosFilterDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "idSeccion", ignore = true)
  @Mapping(target = "banda", ignore = true)
  @Mapping(target = "ordinal", ignore = true)
  @Mapping(target = "fechaInicio",
      expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaInicioPeriodo().toLocalDate()))")
  @Mapping(target = "fechaFin",
      expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaFinPeriodo().toLocalDate()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  public abstract PresupuestosWlocFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPresupuestosWlocFilterDto(
      TrabajoDTO srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);

  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "idLugarTrabajo", ignore = true)
  @Mapping(target = "idTpPresupuesto", ignore = true)
  @Mapping(target = "idEmpresa", source = "stdIdLegEnt")
  public abstract PresupuestosWlocFilterParametersDto idEmpresaDtoToPresupuestosWlocFilterParametersDto(
      IdEmpresaDto src);

  public abstract List<PresupuestosWlocFilterParametersDto> idEmpresaDtoToPresupuestosWlocFilterParametersDto(
      List<IdEmpresaDto> src);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(periodo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(periodo.getFechaFinPeriodo()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  public abstract ConfPrecioHoraFilterDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToConfPrecioHoraFilterDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(periodo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(periodo.getFechaFinPeriodo()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "idEmpresa", source = "srcTarea.stdIdLegEnt")
  public abstract ConfChTpVentaFilterDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToConfChTpVentaFilterDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "fechaInicio",
      expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaInicioPeriodo().toLocalDate()))")
  @Mapping(target = "fechaFin",
      expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaFinPeriodo().toLocalDate()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  public abstract PresupuestosRangoFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPresupuestosRangoFilterDto(
      TrabajoDTO srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaFinPeriodo()))")
  public abstract VentaCongeladaFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToVentaCongeladaFilterDto(
      TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(periodo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(periodo.getFechaFinPeriodo()))")
  public abstract VentaCongeladaFilterDto mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToVentaCongeladaFilterDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcPeriodo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcPeriodo.getFechaFinPeriodo()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "idsEmpresa", expression = "java(Arrays.asList(srcTarea.getStdIdLegEnt()))")
  public abstract GenericFilterDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto srcPeriodo);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcPeriodo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcPeriodo.getFechaFinPeriodo()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "idsEmpresa", ignore = true)
  @Mapping(target = "idsCadena", ignore = true)
  public abstract SearchTiendasFilterDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToSearchTiendasFilterDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto srcPeriodo);

  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcPeriodo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcPeriodo.getFechaFinPeriodo()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "idsEmpresa", ignore = true)
  @Mapping(target = "idsCadena", ignore = true)
  public abstract SearchEmpleadosFilterDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtotoSearchEmpleadosFilterDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto srcPeriodo);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcPeriodo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcPeriodo.getFechaFinPeriodo()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "idsEmpresa", expression = "java(Arrays.asList(srcTarea.getStdIdLegEnt()))")
  public abstract VentaManualWlocFilterDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToVentaManualWlocFilterDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto srcPeriodo);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcPeriodo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcPeriodo.getFechaFinPeriodo()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "idsEmpresa", expression = "java(Arrays.asList(srcTarea.getStdIdLegEnt()))")
  public abstract EstadoWlocFilterDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToEstadoWlocFilterDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto srcPeriodo);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcPeriodo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(srcPeriodo.getFechaFinPeriodo()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "idsEmpresa", ignore = true)
  public abstract PresenciaManualWlocFilterDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPresenciaManualWlocFilterDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto srcPeriodo);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin",
      expression = "java(RunUtils.addDays(TimeUtils.toLocalDateTime(srcTrabajo.getFechaFinPeriodo()),"
          + " srcRecolectarProperties.getDaysNumber()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "idsEmpresa", expression = "java(Arrays.asList(srcTarea.getStdIdLegEnt()))")
  public abstract GenericFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDtoWithDates(
      TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      RecolectarPropertiesDto srcRecolectarProperties);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(periodo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin",
      expression = "java(RunUtils.addDays(TimeUtils.toLocalDateTime(periodo.getFechaFinPeriodo()),"
          + " srcRecolectarProperties.getDaysNumber()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "idsEmpresa", expression = "java(Arrays.asList(srcTarea.getStdIdLegEnt()))")
  public abstract GenericFilterDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDtoWithDates(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo,
      RecolectarPropertiesDto srcRecolectarProperties);

  @Mapping(target = "item", ignore = true)
  @Mapping(target = "fechaInicio",
      expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaInicioPeriodo().toLocalDate()))")
  @Mapping(target = "fechaFin",
      expression = "java(TimeUtils.toLocalDateTime(srcTrabajo.getFechaFinPeriodo().toLocalDate()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  public abstract EstructurasComFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToEstructurasComFilterDto(
      TrabajoDTO srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);

  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta",
      expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(),"
          + " PtrConstants.DATE_FORMAT))")
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "temporada", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "operacion", ignore = true)
  public abstract PtrVentaTotalizadoRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaTotalizadoRequestDto(
      TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      RecolectarPropertiesDto srcRecolectarProperties);

  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "fechaDesde", source = "periodo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta",
      expression = "java(RunUtils.addDays( periodo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(),"
          + " PtrConstants.DATE_FORMAT))")
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "temporada", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "operacion", ignore = true)
  public abstract PtrVentaTotalizadoRequestDto mergeTareaDtoAndTareaAmbitoDtoPeriodoDtoToPtrVentaTotalizadoRequestDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo,
      RecolectarPropertiesDto srcRecolectarProperties);

  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "fechaDesde", source = "srcPresupuesto.fechaInicio", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta", source = "srcPresupuesto.fechaFin", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "temporada", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "operacion", ignore = true)
  public abstract PtrVentaTotalizadoRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaTotalizadoRequestDto(
      TrabajoDTO srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      IdLocalizacionLocalPresupuestoDto srcPresupuesto);

  @Mapping(target = "fechaDesde", source = "srcPresupuesto.fechaInicio", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta", source = "srcPresupuesto.fechaFin", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tiendaOnline", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  public abstract PtrVentaOnlineEntregaDomicilioRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
      TrabajoDTO srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      IdLocalizacionLocalPresupuestoDto srcPresupuesto);

  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "fechaDesde", source = "srcPresupuesto.fechaInicio", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta", source = "srcPresupuesto.fechaFin", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tiendaOnline", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  public abstract PtrVentaOnlineEntregaTiendaRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaOnlineEntregaTiendaRequestDto(
      TrabajoDTO srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      IdLocalizacionLocalPresupuestoDto srcPresupuesto);

  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "fechaDesde", source = "srcPresupuesto.fechaInicio", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta", source = "srcPresupuesto.fechaFin", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tiendaOnline", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "ventaPAT", ignore = true)
  public abstract PtrVentaOnlinePickingRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaOnlinePickingRequestDto(
      TrabajoDTO srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      IdLocalizacionLocalPresupuestoDto srcPresupuesto);

  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "fechaDesde", source = "srcPresupuesto.fechaInicio", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta", source = "srcPresupuesto.fechaFin", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tiendaOnline", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  public abstract PtrVentaOnlineIpodRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaOnlineIpodRequestDto(
      TrabajoDTO srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      IdLocalizacionLocalPresupuestoDto srcPresupuesto);

  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta",
      expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(),"
          + " PtrConstants.DATE_FORMAT))")
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "temporada", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "operacion", ignore = true)
  public abstract PtrVentaTotalizadoRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdCadenaDtoToPtrVentaTotalizadoRequestDto(
      TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      RecolectarPropertiesDto srcRecolectarProperties, List<IdCadenaDto> cadenas);

  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "fechaDesde", source = "periodo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta",
      expression = "java(RunUtils.addDays( periodo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(),"
          + " PtrConstants.DATE_FORMAT))")
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "temporada", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "operacion", ignore = true)
  public abstract PtrVentaTotalizadoRequestDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoIdCadenaDtoToPtrVentaTotalizadoRequestDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo,
      RecolectarPropertiesDto srcRecolectarProperties, List<IdCadenaDto> cadenas);

  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "fechaDesde", source = "periodo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta",
      expression = "java(RunUtils.addDays( periodo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(),"
          + " PtrConstants.DATE_FORMAT))")
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "temporada", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "operacion", ignore = true)
  public abstract PtrVentaTotalizadoRequestDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoAndIdCadenaDtoToPtrVentaTotalizadoRequestDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, RecolectarPropertiesDto srcRecolectarProperties,
      PeriodoDto periodo, List<IdCadenaDto> cadenas);

  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta",
      expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo().toLocalDateTime(), srcRecolectarProperties.getDaysNumber(),"
          + " PtrConstants.DATE_FORMAT))")
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "temporada", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "vendedores", ignore = true)
  @Mapping(target = "fechaVentaInicial", ignore = true)
  @Mapping(target = "cajero", ignore = true)
  @Mapping(target = "operacion", ignore = true)
  public abstract PtrVentaIndividualDetalleRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaIndividualDetalleRequestDto(
      TrabajoDTO srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      RecolectarPropertiesDto srcRecolectarProperties);

  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "persona", ignore = true)
  @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta",
      expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(),"
          + " PtrConstants.DATE_FORMAT))")
  @Mapping(target = "origen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true, defaultValue = PtrConstants.AGRUPAR_SECCION_TRUE)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "tipo", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "incluidoVenta", ignore = true)
  @Mapping(target = "incluidoChallenge", ignore = true)
  @Mapping(target = "incluidoEcommerce", ignore = true)
  @Mapping(target = "excluidoDenom", ignore = true)
  @Mapping(target = "excluidoCalculo", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  public abstract PtrPresenciaDetalleRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasDetalleRequestDto(
      TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      RecolectarPropertiesDto srcRecolectarProperties);

  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "persona", ignore = true)
  @Mapping(target = "fechaDesde", source = "periodo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta",
      expression = "java(RunUtils.addDays( periodo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(),"
          + " PtrConstants.DATE_FORMAT))")
  @Mapping(target = "origen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true, defaultValue = PtrConstants.AGRUPAR_SECCION_TRUE)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "tipo", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "incluidoVenta", ignore = true)
  @Mapping(target = "incluidoChallenge", ignore = true)
  @Mapping(target = "incluidoEcommerce", ignore = true)
  @Mapping(target = "excluidoDenom", ignore = true)
  @Mapping(target = "excluidoCalculo", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  public abstract PtrPresenciaDetalleRequestDto mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo,
      RecolectarPropertiesDto srcRecolectarProperties);

  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "persona", ignore = true)
  @Mapping(target = "fechaDesde", source = "periodo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta", source = "periodo.fechaFinPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "origen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "agruparSeccion", ignore = true, defaultValue = PtrConstants.AGRUPAR_SECCION_TRUE)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "tipo", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "incluidoVenta", ignore = true)
  @Mapping(target = "incluidoChallenge", ignore = true)
  @Mapping(target = "incluidoEcommerce", ignore = true)
  @Mapping(target = "excluidoDenom", ignore = true)
  @Mapping(target = "excluidoCalculo", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "empresa", ignore = true)
  public abstract PtrPresenciaDetalleRequestDto mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo);

  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "origen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta", source = "srcTrabajo.fechaFinPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tipo", ignore = true)
  @Mapping(target = "incluidoVenta", ignore = true)
  @Mapping(target = "incluidoChallenge", ignore = true)
  @Mapping(target = "incluidoEcommerce", ignore = true)
  @Mapping(target = "excluidoDenom", ignore = true)
  @Mapping(target = "excluidoCalculo", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  public abstract PtrPresenciaEmpleadosTiendaRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaEmpleadosTiendaRequestDto(
      TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      List<IdLocalizacionLocalDto> srcLocalizaciones);

  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "origen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "fechaDesde", source = "periodo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta", source = "periodo.fechaFinPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tipo", ignore = true)
  @Mapping(target = "incluidoVenta", ignore = true)
  @Mapping(target = "incluidoChallenge", ignore = true)
  @Mapping(target = "incluidoEcommerce", ignore = true)
  @Mapping(target = "excluidoDenom", ignore = true)
  @Mapping(target = "excluidoCalculo", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  public abstract PtrPresenciaEmpleadosTiendaRequestDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciaEmpleadosTiendaRequestDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo,
      List<IdLocalizacionLocalDto> srcLocalizaciones);

  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "fechaDesde", source = "periodo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta", source = "periodo.fechaFinPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tiendaOnline", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  public abstract PtrVentaOnlineIpodRequestDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrVentaOnlineIpodRequestDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo);

  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta",
      expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo().toLocalDateTime(), srcRecolectarProperties.getDaysNumber(),"
          + " PtrConstants.DATE_FORMAT))")
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tiendaOnline", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "vendedores", ignore = true)
  @Mapping(target = "operacion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  public abstract PtrVentaOnlineIpodIndividualDetalleRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodIndividualDetalleRequestDto(
      TrabajoDTO srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      RecolectarPropertiesDto srcRecolectarProperties);

  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta",
      expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(),"
          + " PtrConstants.DATE_FORMAT))")
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tiendaOnline", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  @Mapping(target = "ventaPAT", ignore = true)
  public abstract PtrVentaOnlinePickingRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlinePickingRequestDto(
      TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      RecolectarPropertiesDto srcRecolectarProperties);

  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "fechaDesde", source = "periodo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta", source = "periodo.fechaFinPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tiendaOnline", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  @Mapping(target = "ventaPAT", ignore = true)
  public abstract PtrVentaOnlinePickingRequestDto mergeTareaDtoAndTareaAmbitoDtoPeriodoDtoToPtrVentaOnlinePickingRequestDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo);

  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta",
      expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(),"
          + " PtrConstants.DATE_FORMAT))")
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tiendaOnline", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  public abstract PtrVentaOnlineEntregaTiendaRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaTiendaRequestDto(
      TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      RecolectarPropertiesDto srcRecolectarProperties);

  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "fechaDesde", source = "periodo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta", source = "periodo.fechaFinPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tiendaOnline", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "tienda", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  public abstract PtrVentaOnlineEntregaTiendaRequestDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrVentaOnlineEntregaTiendaRequestDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo);

  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta",
      expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(),"
          + " PtrConstants.DATE_FORMAT))")
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tiendaOnline", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  public abstract PtrVentaOnlineEntregaDomicilioRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
      TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      RecolectarPropertiesDto srcRecolectarProperties);

  @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta",
      expression = "java(RunUtils.addDays( srcTrabajo.getFechaFinPeriodo(), srcRecolectarProperties.getDaysNumber(),"
          + " PtrConstants.DATE_FORMAT))")
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tiendaOnline", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  public abstract PtrVentaOnlineEntregaDomicilioRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
      TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
      RecolectarPropertiesDto srcRecolectarProperties, List<IdCadenaDto> cadenas);

  @Mapping(target = "fechaDesde", source = "periodo.fechaInicioPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "fechaHasta", source = "periodo.fechaFinPeriodo", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "pais", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "empresa", ignore = true)
  @Mapping(target = "cadena", ignore = true)
  @Mapping(target = "tiendaOnline", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "seccion", ignore = true)
  @Mapping(target = "agrupacion", ignore = true)
  @Mapping(target = "agruparSeccion", ignore = true)
  public abstract PtrVentaOnlineEntregaDomicilioRequestDto mergeTareaDtoAndTareaAmbitoAndPeriodoDtoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo, List<IdCadenaDto> cadenas);

  @Mapping(target = "items", ignore = true)
  @Mapping(target = "ambito", ignore = true)
  @Mapping(target = "fechaInicio", expression = "java(TimeUtils.toLocalDateTime(periodo.getFechaInicioPeriodo()))")
  @Mapping(target = "fechaFin", expression = "java(TimeUtils.toLocalDateTime(periodo.getFechaFinPeriodo()))")
  @Mapping(target = "idOrigen", source = "srcTareaAmbito.cclIdOrigen")
  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "idEmpleado", ignore = true)
  @Mapping(target = "orEmpleado", ignore = true)
  @Mapping(target = "idLugarTrabajo", ignore = true)
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "idPais", ignore = true)
  @Mapping(target = "abierto", ignore = true)
  @Mapping(target = "vigente", ignore = true)
  @Mapping(target = "idTipoHora", ignore = true)
  @Mapping(target = "idEmpleadoLocal", ignore = true)
  @Mapping(target = "idLugarTrabajoMtu", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "idOrigenReg", ignore = true)
  @Mapping(target = "idSociedadReg", ignore = true)
  @Mapping(target = "idEstado", ignore = true)
  @Mapping(target = "idRegion", ignore = true)
  @Mapping(target = "idPeriodo", ignore = true)
  @Mapping(target = "idUsuario", ignore = true)
  @Mapping(target = "resultado", ignore = true)
  @Mapping(target = "fechaDesde", ignore = true)
  @Mapping(target = "fechaHasta", ignore = true)
  @Mapping(target = "idCadenaReg", ignore = true)
  @Mapping(target = "idPoblacion", ignore = true)
  @Mapping(target = "idTipoProceso", ignore = true)
  @Mapping(target = "nombreEmpleado", ignore = true)
  @Mapping(target = "fechaFinCalculo", ignore = true)
  @Mapping(target = "apellidoEmpleado", ignore = true)
  @Mapping(target = "fechaInicioCalculo", ignore = true)
  @Mapping(target = "idManualProgramado", ignore = true)
  @Mapping(target = "fechaFinExportacion", ignore = true)
  @Mapping(target = "fechaInicioExportacion", ignore = true)
  public abstract ConfiguracionesRequestDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToConfiguracionesRequestDto(
      TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, PeriodoDto periodo);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idTarea", source = "srcTarea.id")
  @Mapping(target = "cclIdOrigen", source = "srcDesplazamiento.idOrigen")
  @Mapping(target = "stdIdLegEnt", source = "srcDesplazamiento.idEmpresa")
  public abstract TareaAmbitoGlobalEmpresaDto mergeTareaDtoAndDesplazamientosMultiempresaItemDtoToAmbitoGlobalEmpresaDto(
      TareaDto srcTarea, DesplazamientosMultiempresaItemDto srcDesplazamiento);

  public List<TareaAmbitoGlobalEmpresaDto> mergeTareaDtoAndDesplazamientosMultiempresaItemDtoToAmbitoGlobalEmpresaDto(
      final TareaDto srcTarea, final List<DesplazamientosMultiempresaItemDto> srcDesplazamiento) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idTarea", source = "srcTarea.id")
  @Mapping(target = "fechaInicio", source = "srcDesplazamiento.fechaInicio")
  @Mapping(target = "fechaFin", source = "srcDesplazamiento.fechaFin")
  public abstract TareaAmbitoGlobalFechaDto mergeTareaDtoAndDesplazamientosMultiempresaItemDtoToTareaAmbitoGlobalFechaDto(
      TareaDto srcTarea, DesplazamientosMultiempresaItemDto srcDesplazamiento);

  @Mapping(target = "item", ignore = true)
  public abstract DesplazamientoRealFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToDesplazamientoRealFilterDto(
      TrabajoDTO srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);

  @Mapping(target = "idTienda", ignore = true)
  @Mapping(target = "fechaDesde", source = "srcTrabajo.fechaInicioPeriodo")
  @Mapping(target = "fechaHasta", source = "srcTrabajo.fechaFinPeriodo")
  public abstract HorarioComercialFestivosRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoDtoToHorarioComercialFestivosRequestDto(
      TrabajoDTO srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito);

  public String horarioComercialFestivosRequestDtoToQuery(
      final HorarioComercialFestivosRequestDto request) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  OffsetDateTime map(final LocalDate value) {
    return value.atTime(LocalTime.MIDNIGHT).atOffset(ZoneOffset.UTC);
  }

  LocalDate mapLocalDate(final OffsetDateTime value) {
    return value.toLocalDate();
  }

}
