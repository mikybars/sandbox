package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.AusenciasApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.CoeficientesJornadaApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.ConfiguracionVentaApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.DesplazamientosMultiempresaApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.DesplazamientosRealesApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.EmpleadosDesplazadosApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.EmpleadosPresenciaApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.EmpresasApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.FlagCalculaApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.OrigenesApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.PeriodosApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.PresenciasManualApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.PresenciasManualWlocApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.PresupuestosApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.SistemasDestinoApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.TiendasIncomeApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.TiendasOnlineApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.VentasCongeladasApi;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResponseDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper.PeopleAclMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Anti-Corruption Layer service for People domain operations via the calculo-income REST API.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PeopleAclService {

  @Qualifier("tiendasOnlineCalculoIncomeApiClient")
  private final TiendasOnlineApi tiendasOnlineApi;

  @Qualifier("origenesCalculoIncomeApiClient")
  private final OrigenesApi origenesApi;

  @Qualifier("empresasCalculoIncomeApiClient")
  private final EmpresasApi empresasApi;

  @Qualifier("ausenciasCalculoIncomeApiClient")
  private final AusenciasApi ausenciasApi;

  @Qualifier("configuracionVentaCalculoIncomeApiClient")
  private final ConfiguracionVentaApi configuracionVentaApi;

  @Qualifier("tiendasIncomeCalculoIncomeApiClient")
  private final TiendasIncomeApi tiendasIncomeApi;

  @Qualifier("flagCalculaCalculoIncomeApiClient")
  private final FlagCalculaApi flagCalculaApi;

  @Qualifier("coeficientesJornadaCalculoIncomeApiClient")
  private final CoeficientesJornadaApi coeficientesJornadaApi;

  @Qualifier("presenciasManualCalculoIncomeApiClient")
  private final PresenciasManualApi presenciasManualApi;

  @Qualifier("presenciasManualWlocCalculoIncomeApiClient")
  private final PresenciasManualWlocApi presenciasManualWlocApi;

  @Qualifier("empleadosDesplazadosCalculoIncomeApiClient")
  private final EmpleadosDesplazadosApi empleadosDesplazadosApi;

  @Qualifier("empleadosPresenciaCalculoIncomeApiClient")
  private final EmpleadosPresenciaApi empleadosPresenciaApi;

  @Qualifier("presupuestosCalculoIncomeApiClient")
  private final PresupuestosApi presupuestosApi;

  @Qualifier("ventasCongeladasCalculoIncomeApiClient")
  private final VentasCongeladasApi ventasCongeladasApi;

  @Qualifier("periodosCalculoIncomeApiClient")
  private final PeriodosApi periodosApi;

  @Qualifier("sistemasDestinoCalculoIncomeApiClient")
  private final SistemasDestinoApi sistemasDestinoApi;

  @Qualifier("desplazamientosRealesCalculoIncomeApiClient")
  private final DesplazamientosRealesApi desplazamientosRealesApi;

  @Qualifier("desplazamientosMultiempresaCalculoIncomeApiClient")
  private final DesplazamientosMultiempresaApi desplazamientosMultiempresaApi;

  private final PeopleAclMapper peopleAclMapper;

  public TiendaOnlineResponseDto searchTiendasOnline(TiendaOnlineRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchTiendasOnline");

    var restRequest = peopleAclMapper.toSearchTiendasOnlineRequestDto(request);
    var response = tiendasOnlineApi.searchTiendasOnline(restRequest);
    return peopleAclMapper.toTiendaOnlineResponseDto(response);
  }

  public OrigenResponseDto searchOrigenes(OrigenRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchOrigenes");

    var restRequest = peopleAclMapper.toSearchOrigenesRequestDto(request);
    var response = origenesApi.searchOrigenes(restRequest);
    return peopleAclMapper.toOrigenResponseDto(response);
  }

  public EmpresaResponseDto searchEmpresas(EmpresaRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchEmpresas");

    var restRequest = peopleAclMapper.toSearchEmpresasRequestDto(request);
    var response = empresasApi.searchEmpresas(restRequest);
    return peopleAclMapper.toEmpresaResponseDto(response);
  }

  public AusenciasResponseDto getAusencias(AusenciasRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchAusencias");

    var restRequest = peopleAclMapper.toSearchAusenciasRequestDto(request);
    var response = ausenciasApi.searchAusencias(restRequest);
    return peopleAclMapper.toAusenciasResponseDto(response);
  }

  public ConfiguracionVentaOnlineResponseDto getConfVentaOnline(ConfiguracionVentaOnlineRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchConfVentaOnline");

    var restRequest = peopleAclMapper.toSearchConfVentaOnlineRequestDto(request);
    var response = configuracionVentaApi.searchConfVentaOnline(restRequest);
    return peopleAclMapper.toConfiguracionVentaOnlineResponseDto(response);
  }

  public TiendasResponseDto getTiendas(TiendasRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchTiendasIncome");

    var restRequest = peopleAclMapper.toSearchTiendasIncomeRequestDto(request);
    var response = tiendasIncomeApi.searchTiendasIncome(restRequest);
    return peopleAclMapper.toTiendasResponseDto(response);
  }

  public ConfiguracionProductoVentaResponseDto getConfiguracionProductoVenta(ConfiguracionProductoVentaRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchConfProductoVenta");

    var restRequest = peopleAclMapper.toSearchConfProductoVentaRequestDto(request);
    var response = configuracionVentaApi.searchConfProductoVenta(restRequest);
    return peopleAclMapper.toConfiguracionProductoVentaResponseDto(response);
  }

  public FlagCalculaResponseDto getFlagCalcula(FlagCalculaRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchFlagCalcula");

    var restRequest = peopleAclMapper.toSearchFlagCalculaRequestDto(request);
    var response = flagCalculaApi.searchFlagCalcula(restRequest);
    return peopleAclMapper.toFlagCalculaResponseDto(response);
  }

  public CoefJornadaResponseDto getCoefJornada(CoefJornadaRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchCoeficientesJornada");

    var restRequest = peopleAclMapper.toSearchCoeficienteJornadaRequestDto(request);
    var response = coeficientesJornadaApi.searchCoeficientesJornada(restRequest);
    return peopleAclMapper.toCoefJornadaResponseDto(response);
  }

  public PresenciaManualResponseDto getPresenciaManual(PresenciaManualRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchPresenciasManual");

    var restRequest = peopleAclMapper.toSearchPresenciaManualRequestDto(request);
    var response = presenciasManualApi.searchPresenciasManual(restRequest);
    return peopleAclMapper.toPresenciaManualResponseDto(response);
  }

  public EmpleadosDesplazamientoResponseDto getEmpleadosDesplazamiento(EmpleadosDesplazamientoRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchEmpleadosDesplazados");

    var restRequest = peopleAclMapper.toSearchEmpleadosDesplazadosRequestDto(request);
    var response = empleadosDesplazadosApi.searchEmpleadosDesplazados(restRequest);
    return peopleAclMapper.toEmpleadosDesplazamientoResponseDto(response);
  }

  public EmpleadosPresenciaResponseDto getEmpleadosPresencia(EmpleadosPresenciaRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchEmpleadosPresencia");

    var restRequest = peopleAclMapper.toSearchEmpleadosPresenciaRequestDto(request);
    var response = empleadosPresenciaApi.searchEmpleadosPresencia(restRequest);
    return peopleAclMapper.toEmpleadosPresenciaResponseDto(response);
  }

  public PresupuestosWlocResponseDto getPresupuestosWloc(PresupuestosWlocRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchPresupuestosWloc");

    var restRequest = peopleAclMapper.toSearchPresupuestosWlocRequestDto(request);
    var response = presupuestosApi.searchPresupuestosWloc(restRequest);
    return peopleAclMapper.toPresupuestosWlocResponseDto(response);
  }

  public VentaCongeladaResponseDto getVentaCongelada(VentaCongeladaRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchVentasCongeladas");

    var restRequest = peopleAclMapper.toSearchVentasCongeladasRequestDto(request);
    var response = ventasCongeladasApi.searchVentasCongeladas(restRequest);
    return peopleAclMapper.toVentaCongeladaResponseDto(response);
  }

  public PresenciaManualWlocResponseDto getPresenciaManualWloc(PresenciaManualWlocRequestDto request) {
    log.debug("calling People ACL REST endpoint searchPresenciasManualWloc");

    var restRequest = peopleAclMapper.toSearchPresenciasManualWlocRequestDto(request);
    var response = presenciasManualWlocApi.searchPresenciasManualWloc(restRequest);
    return peopleAclMapper.toPresenciaManualWlocResponseDto(response);
  }

  public PeriodosResponseDto searchPeriodos(PeriodosRequestDto request) {
    log.debug("calling People ACL REST endpoint searchPeriodos");

    var restRequest = peopleAclMapper.toSearchPeriodosRequestDto(request);
    var response = periodosApi.searchPeriodos(restRequest);
    return peopleAclMapper.toPeriodosResponseDto(response);
  }

  public SistemaDestinoResponseDto searchSistemasDestino(SistemaDestinoRequestDto request) {
    log.debug("calling People ACL REST endpoint searchSistemasDestino");

    var restRequest = peopleAclMapper.toSearchSistemasDestinoRequestDto(request);
    var response = sistemasDestinoApi.searchSistemasDestino(restRequest);
    return peopleAclMapper.toSistemaDestinoResponseDto(response);
  }

  public DesplazamientoRealResponseDto getDesplazReal(DesplazamientoRealRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchDesplazamientosReales");

    var restRequest = peopleAclMapper.toSearchDesplazamientosRealesRequestDto(request);
    var response = desplazamientosRealesApi.searchDesplazamientosReales(restRequest);
    return peopleAclMapper.toDesplazamientoRealResponseDto(response);
  }

  public DesplazamientosMultiempresaResponseDto searchDesplazamientosMultiempresa(DesplazamientosMultiempresaRequestDto request) {
    log.debug("calling People ACL REST endpoint searchDesplazamientosMultiempresa");

    var restRequest = peopleAclMapper.toSearchDesplazamientosMultiempresaRequestDto(request);
    var response = desplazamientosMultiempresaApi.searchDesplazamientosMultiempresa(restRequest);
    return peopleAclMapper.toDesplazamientosMultiempresaResponseDto(response);
  }

}
