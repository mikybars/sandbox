package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.service.IncomeMetaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.rest.client.api.EmpleadosApi;
import com.inditex.rrhh.icmclcwb.rest.client.api.ExternosApi;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoExternoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ExternosRequestDTO;

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
  @Qualifier("empleadosIncomeMetaApiClient")
  private EmpleadosApi empleadosApi;

  @Override
  public List<EmpleadoExternoDTO> getEmpleadosExternosExcluidosDenominador(final ExternosRequestDTO request) {
    IncomeMetaServiceImpl.LOG.info(LOG_MESSAGE, "llamada al método de servicio FINDEXTERNOS");
    IncomeMetaServiceImpl.LOG.info("INFO REQUEST: " + request);
    return this.externosApi.findExternos(request);
  }

  @Override
  public List<EmpleadoDTO> searchEmpleados(final SearchEmpleadosRequestDto request) {
    IncomeMetaServiceImpl.LOG.info(LOG_MESSAGE, "llamada al método de servicio SEARCHEMPLEADOS");
    IncomeMetaServiceImpl.LOG.info("INFO REQUEST: " + request);

    final SearchEmpleadosFilterDto dto = request.getData();

    final List<String> idsEmpresa = dto.getIdsEmpresa();
    final List<String> idsCadena = dto.getIdsCadena();
    final Boolean esEmpresa = CollectionUtils.isNotEmpty((idsEmpresa));

    return this.empleadosApi.listEmpleados(dto.getIdOrigen(), esEmpresa ? idsEmpresa : idsCadena, dto.getFechaInicio().toLocalDate(),
        dto.getFechaFin().toLocalDate(), esEmpresa);
  }

}
