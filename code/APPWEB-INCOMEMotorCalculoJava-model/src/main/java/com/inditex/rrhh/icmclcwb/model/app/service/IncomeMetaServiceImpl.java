package com.inditex.rrhh.icmclcwb.model.app.service;

import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.service.IncomeMetaService;
import com.inditex.rrhh.icmclcwb.rest.client.api.ExternosApi;
import com.inditex.rrhh.icmclcwb.rest.client.api.TiposventachallengeApi;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoExternoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ExternosRequestDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.TiposVentaChallengeResponseDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class IncomeMetaServiceImpl implements IncomeMetaService {

  private static final String LOG_MESSAGE = "Enviando petición a INCOMEMETA para {}...";

  private static final Logger LOG = LoggerFactory.getLogger(IncomeMetaServiceImpl.class);

  @Autowired
  @Qualifier("externosIncomeMetaApiClient")
  private ExternosApi externosApi;

  @Autowired
  @Qualifier("tiposventachallengeIncomeMetaApiClient")
  private TiposventachallengeApi tiposventachallengeApi;

  @Override
  public List<EmpleadoExternoDTO> getEmpleadosExternosExcluidosDenominador(final ExternosRequestDTO request) {
    IncomeMetaServiceImpl.LOG.info(LOG_MESSAGE, "llamada al método de servicio FINDEXTERNOS");
    IncomeMetaServiceImpl.LOG.info("INFO REQUEST: " + request);
    return this.externosApi.findExternos(request);
  }

  @Override
  public List<TiposVentaChallengeResponseDTO> getTiposVentaChallenge(String origen, Integer empresa, LocalDate fechaInicio,
      LocalDate fechaFin, String organizacion) {

    IncomeMetaServiceImpl.LOG.info(LOG_MESSAGE, "llamada al método TiposVentaChallenge");
    IncomeMetaServiceImpl.LOG.info("INFO REQUEST: " + origen + " " + empresa + " " + fechaInicio + " " + fechaFin + " " + organizacion);
    return this.tiposventachallengeApi.findTiposVentaChallenge(origen, empresa, fechaInicio, fechaFin, organizacion);
  }

}
