package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.util.HorarioComercialPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaMapperDecorator extends TareaMapper {

  @Autowired
  private TareaMapper delegate;

  @Override
  public TareaDto mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
      final TrabajoAmbitoEmpresaDTO srcTrabajoAmbitoEmpresa, final TrabajoDTO srcTrabajo) {
    final TareaDto tarea = this.delegate.mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
        srcTrabajoAmbitoEmpresa,
        srcTrabajo);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    srcTrabajo.getOrigen()
        .forEach(item -> ambito.add(TareaAmbitoDto.builder()
            .cclIdOrigen(item.getCclIdOrigen())
            .build()));
    tarea.setAmbito(ambito);

    final List<TareaAmbitoLocalizacionDto> localizacion = new ArrayList<>();
    srcTrabajo.getLocalizacion()
        .stream()
        .filter(item -> item.getStdIdLegEnt().equals(srcTrabajoAmbitoEmpresa.getStdIdLegEnt()))
        .collect(Collectors.toList())
        .forEach(item -> localizacion.add(TareaAmbitoLocalizacionDto.builder()
            .stdIdWorkLocat(item.getStdIdWorkLocat())
            .cclIdOrigen(item.getCclIdOrigen())
            .build()));
    tarea.setLocalizacion(localizacion);

    final List<TareaAmbitoPersonaDto> persona = new ArrayList<>();
    srcTrabajo.getPersona()
        .stream()
        .filter(item -> item.getStdIdLegEnt().equals(srcTrabajoAmbitoEmpresa.getStdIdLegEnt()))
        .collect(Collectors.toList())
        .forEach(item -> persona.add(TareaAmbitoPersonaDto.builder()
            .cclIdPerson(item.getCclIdPerson())
            .stdOrHrPeriod(item.getStdOrHrPeriod())
            .cclIdOrigen(item.getCclIdOrigen())
            .build()));
    tarea.setPersona(persona);
    return tarea;
  }

  @Override
  public List<TareaDto> mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
      final List<TrabajoAmbitoEmpresaDTO> srcTrabajoAmbitoEmpresa, final TrabajoDTO srcTrabajo) {
    final List<TareaDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(srcTrabajoAmbitoEmpresa)) {
      srcTrabajoAmbitoEmpresa.forEach(
          item -> result.add(this.mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(item, srcTrabajo)));
    }
    return result;
  }

  @Override
  public PtrVentaOnlineEntregaDomicilioRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
      final TrabajoDto srcTrabajo, final TareaDto srcTarea, final TareaAmbitoDto srcTareaAmbito,
      final RecolectarPropertiesDto srcRecolectarProperties, final List<IdCadenaDto> cadenas) {
    final PtrVentaOnlineEntregaDomicilioRequestDto ptrVentaOnlineEntregaDomicilioRequestDto = this.delegate
        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
            srcTrabajo, srcTarea, srcTareaAmbito, srcRecolectarProperties, cadenas);
    ptrVentaOnlineEntregaDomicilioRequestDto.setCadena(cadenas.stream()
        .map(IdCadenaDto::getId)
        .map(Integer::valueOf)
        .collect(Collectors.toList()));
    return ptrVentaOnlineEntregaDomicilioRequestDto;
  }

  @Override
  public PtrVentaTotalizadoRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdCadenaDtoToPtrVentaTotalizadoRequestDto(
      final TrabajoDto srcTrabajo, final TareaDto srcTarea, final TareaAmbitoDto srcTareaAmbito,
      final RecolectarPropertiesDto srcRecolectarProperties, final List<IdCadenaDto> cadenas) {
    final PtrVentaTotalizadoRequestDto ptrVentaTotalizadoRequestDto = this.delegate
        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdCadenaDtoToPtrVentaTotalizadoRequestDto(
            srcTrabajo, srcTarea, srcTareaAmbito, srcRecolectarProperties, cadenas);
    ptrVentaTotalizadoRequestDto.setCadena(cadenas.stream()
        .map(IdCadenaDto::getId)
        .map(Integer::valueOf)
        .collect(Collectors.toList()));
    return ptrVentaTotalizadoRequestDto;
  }

  @Override
  public PtrVentaTotalizadoRequestDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoIdCadenaDtoToPtrVentaTotalizadoRequestDto(
      final TareaDto srcTarea, final TareaAmbitoDto srcTareaAmbito, final PeriodoDto periodo,
      final RecolectarPropertiesDto srcRecolectarProperties, final List<IdCadenaDto> cadenas) {
    final PtrVentaTotalizadoRequestDto ptrVentaTotalizadoRequestDto = this.delegate
        .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoIdCadenaDtoToPtrVentaTotalizadoRequestDto(
            srcTarea, srcTareaAmbito, periodo, srcRecolectarProperties, cadenas);
    ptrVentaTotalizadoRequestDto.setCadena(cadenas.stream()
        .map(IdCadenaDto::getId)
        .map(Integer::valueOf)
        .collect(Collectors.toList()));
    return ptrVentaTotalizadoRequestDto;
  }

  @Override
  public PtrPresenciaEmpleadosTiendaRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaEmpleadosTiendaRequestDto(
      final TrabajoDto srcTrabajo, final TareaDto srcTarea, final TareaAmbitoDto srcTareaAmbito,
      final List<IdLocalizacionLocalDto> srcLocalizaciones) {
    final PtrPresenciaEmpleadosTiendaRequestDto result = this.delegate
        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaEmpleadosTiendaRequestDto(srcTrabajo, srcTarea,
            srcTareaAmbito, srcLocalizaciones);
    if ((result != null) && (srcLocalizaciones != null)) {
      final List<Integer> localizaciones = srcLocalizaciones.stream()
          .map(IdLocalizacionLocalDto::getId)
          .map(Integer::valueOf)
          .collect(Collectors.toList());
      result.setTienda(localizaciones);
    }
    return result;
  }

  @Override
  public List<TareaAmbitoGlobalEmpresaDto> mergeTareaDtoAndDesplazamientosMultiempresaItemDtoToAmbitoGlobalEmpresaDto(
      final TareaDto srcTarea, final List<DesplazamientosMultiempresaItemDto> srcDesplazamiento) {
    final List<TareaAmbitoGlobalEmpresaDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(srcDesplazamiento)) {
      srcDesplazamiento.forEach(emp -> result.add(this.delegate
          .mergeTareaDtoAndDesplazamientosMultiempresaItemDtoToAmbitoGlobalEmpresaDto(srcTarea, emp)));
    }
    return result;
  }

  @Override
  public String horarioComercialFestivosRequestDtoToQuery(
      final HorarioComercialFestivosRequestDto request) {
    final StringBuilder sbResult = new StringBuilder();
    final String storesIdsParam = this.horarioComercialFestivosRequestDtoToStoreIdsParam(request);
    final String datesParams = this.horarioComercialFestivosRequestDtoToStartDateParam(request);

    return sbResult.append(storesIdsParam)
        .append(datesParams != null ? datesParams : "")
        .toString();
  }

  private String horarioComercialFestivosRequestDtoToStoreIdsParam(final HorarioComercialFestivosRequestDto request) {
    String result = HorarioComercialPropertiesConstants.STORE_IDS_FIELD
        + HorarioComercialPropertiesConstants.EQUALS_SYMBOL;
    if ((request != null) && CollectionUtils.isNotEmpty(request.getIdTienda())) {
      result += request.getIdTienda()
          .stream()
          .map(String::valueOf)
          .collect(Collectors.joining(HorarioComercialPropertiesConstants.VALUES_SEPARATOR));
    }
    return result;
  }

  private String horarioComercialFestivosRequestDtoToStartDateParam(final HorarioComercialFestivosRequestDto request) {
    String result = null;
    if ((request != null) && ((request.getFechaDesde() != null) && (request.getFechaHasta() != null))) {
      final SimpleDateFormat sdf = new SimpleDateFormat(
          HorarioComercialPropertiesConstants.SIMPLE_DATE_FORMAT);
      result = HorarioComercialPropertiesConstants.PARAMS_SEPARATOR
          + HorarioComercialPropertiesConstants.START_DATE_FIELD
          + HorarioComercialPropertiesConstants.EQUALS_SYMBOL
          + sdf.format(TimeUtils
              .toDate(request.getFechaDesde()))
          + HorarioComercialPropertiesConstants.PARAMS_SEPARATOR
          + HorarioComercialPropertiesConstants.END_DATE_FIELD + HorarioComercialPropertiesConstants.EQUALS_SYMBOL
          + sdf.format(TimeUtils.toDate(request.getFechaHasta().plusDays(1)));
    }
    return result;
  }

}
