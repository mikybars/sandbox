package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.AusenciasApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.ConfiguracionVentaApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.EmpresasApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.FlagCalculaApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.OrigenesApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.PresenciasManualApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.TiendasIncomeApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.TiendasOnlineApi;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResponseDto;
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

  @Qualifier("presenciasManualCalculoIncomeApiClient")
  private final PresenciasManualApi presenciasManualApi;

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

  public PresenciaManualResponseDto getPresenciaManual(PresenciaManualRequestDto request) {
    log.debug("🌐 calling People ACL REST endpoint searchPresenciasManual");

    var restRequest = peopleAclMapper.toSearchPresenciaManualRequestDto(request);
    var response = presenciasManualApi.searchPresenciasManual(restRequest);
    return peopleAclMapper.toPresenciaManualResponseDto(response);
  }

}
