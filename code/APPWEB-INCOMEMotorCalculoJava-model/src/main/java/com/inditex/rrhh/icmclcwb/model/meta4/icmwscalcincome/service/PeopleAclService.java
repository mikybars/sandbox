package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.OrigenesApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.TiendasOnlineApi;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResponseDto;
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

}
