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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.util.HorarioComercialPropertiesConstants;
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
    final String query = this.horarioComercialFestivosRequestDtoToSolrRequest(request);

    final String pagination = this.horarioComercialFestivosRequestDtoToPaginationRequest(request);

    return sbResult.append(HorarioComercialPropertiesConstants.Q_FIELD)
        .append(HorarioComercialPropertiesConstants.EQUALS_SYMBOL)
        .append(query)
        .append(pagination)
        .toString();
  }

  private String horarioComercialFestivosRequestDtoToPaginationRequest(
      final HorarioComercialFestivosRequestDto request) {
    String pagination = "";
    if ((request != null) && ((request.getRows() != null) || (request.getStart() != null))) {
      final StringBuilder sbPagination = new StringBuilder();
      sbPagination.append(HorarioComercialPropertiesConstants.AMPERSAND_SYMBOL);
      final List<String> filters = new ArrayList<>();
      if (request.getRows() != null) {
        filters.add(new StringBuilder(HorarioComercialPropertiesConstants.ROWS_FIELD)
            .append(HorarioComercialPropertiesConstants.EQUALS_SYMBOL)
            .append(request.getRows())
            .toString());
      }
      if (request.getStart() != null) {
        filters.add(new StringBuilder(HorarioComercialPropertiesConstants.START_FIELD)
            .append(HorarioComercialPropertiesConstants.EQUALS_SYMBOL)
            .append(request.getStart())
            .toString());
      }
      sbPagination.append(String.join(HorarioComercialPropertiesConstants.AMPERSAND_SYMBOL, filters));
      pagination = sbPagination.toString();
    }
    return pagination;
  }

  private String horarioComercialFestivosRequestDtoToSolrRequest(final HorarioComercialFestivosRequestDto request) {
    String query = HorarioComercialPropertiesConstants.ASTERISK_SYMBOL;
    if ((request != null)
        && ((request.getIdPais() != null)
            || (request.getIdCadena() != null) || (request.getIdTienda() != null)
            || ((request.getFechaDesde() != null) && (request.getFechaHasta() != null)))) {
      final List<String> filters = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(request.getIdTienda())) {
        final List<String> filtrosTienda = request.getIdTienda()
            .stream()
            .map(idTienda -> new StringBuilder().append(HorarioComercialPropertiesConstants.ID_TIENDA_FIELD)
                .append(HorarioComercialPropertiesConstants.SOLR_VALUE_SEPARATOR)
                .append(idTienda)
                .toString())
            .collect(
                Collectors.toList());
        filters.add(new StringBuffer().append(HorarioComercialPropertiesConstants.SOLR_GROUP_BEGIN)
            .append(String.join(HorarioComercialPropertiesConstants.SOLR_FIELD_OR_CONNECTOR, filtrosTienda))
            .append(HorarioComercialPropertiesConstants.SOLR_GROUP_END)
            .toString());
      }
      if (request.getIdCadena() != null) {
        filters
            .add(new StringBuilder().append(HorarioComercialPropertiesConstants.ID_CADENA_FIELD)
                .append(HorarioComercialPropertiesConstants.SOLR_VALUE_SEPARATOR)
                .append(request.getIdCadena())
                .toString());
      }
      if (request.getIdPais() != null) {
        filters.add(new StringBuilder().append(HorarioComercialPropertiesConstants.ID_PAIS_FIELD)
            .append(HorarioComercialPropertiesConstants.SOLR_VALUE_SEPARATOR)
            .append(request.getIdPais())
            .toString());
      }
      if ((request.getFechaDesde() != null) && (request.getFechaHasta() != null)) {
        final SimpleDateFormat sdf = new SimpleDateFormat(
            HorarioComercialPropertiesConstants.DATE_FORMAT);
        filters.add(new StringBuilder().append(HorarioComercialPropertiesConstants.FECHA)
            .append(HorarioComercialPropertiesConstants.SOLR_VALUE_SEPARATOR)
            .append(HorarioComercialPropertiesConstants.SOLR_RANGE_BEGIN)
            .append(sdf.format(TimeUtils
                .toDate(request.getFechaDesde())))
            .append(HorarioComercialPropertiesConstants.SOLR_DATE_CONNECTOR)
            .append(sdf.format(TimeUtils.toDate(request.getFechaHasta())))
            .append(HorarioComercialPropertiesConstants.SOLR_RANGE_END)
            .toString());
      }
      query = String.join(HorarioComercialPropertiesConstants.SOLR_FIELD_AND_CONNECTOR, filters);
    }
    return query;
  }

}
