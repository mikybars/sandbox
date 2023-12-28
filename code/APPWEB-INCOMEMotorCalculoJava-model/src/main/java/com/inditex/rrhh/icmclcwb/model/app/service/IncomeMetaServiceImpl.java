package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.service.IncomeMetaService;
import com.inditex.rrhh.icmclcwb.dto.EmpleadoExternoDTO;
import com.inditex.rrhh.icmclcwb.dto.ExternosRequestDTO;
import com.inditex.rrhh.icmclcwb.service.ExternosApi;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class IncomeMetaServiceImpl implements IncomeMetaService {

  private static final String LOG_MESSAGE = "Enviando petición a INCOMEMETA para {}...";

  @Autowired
  private Logger log;

  @Autowired
  private ExternosApi externosApi;

  @Override
  public List<EmpleadoExternoDTO> getEmpleadosExternosExcluidosDenominador(final ExternosRequestDTO request) {
    this.log.info(LOG_MESSAGE, "llamada al método de servicio FINDEXTERNOS");
    return this.externosApi.findExternos(request).getBody();
  }
}
