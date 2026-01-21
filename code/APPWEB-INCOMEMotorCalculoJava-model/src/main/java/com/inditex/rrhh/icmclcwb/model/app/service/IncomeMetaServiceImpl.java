package com.inditex.rrhh.icmclcwb.model.app.service;

import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.service.IncomeMetaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.rest.client.api.ConfiguracionApi;
import com.inditex.rrhh.icmclcwb.rest.client.api.EmpleadoApi;
import com.inditex.rrhh.icmclcwb.rest.client.api.TiendaApi;
import com.inditex.rrhh.icmclcwb.rest.client.dto.AgrupacionesOnlineResponseDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ConfiguracionPrecioHoraResponseDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoExternoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.PeriodoResponseDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.PresupuestoResponseDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.TiendaResponseDTO;
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
  @Qualifier("empleadoIncomeMetaApiClient")
  private EmpleadoApi empleadoApi;

  @Autowired
  @Qualifier("configuracionIncomeMetaApiClient")
  private ConfiguracionApi configuracionApi;

  @Autowired
  @Qualifier("tiendaIncomeMetaApiClient")
  private TiendaApi tiendaApi;

  @Override
  public List<EmpleadoExternoDTO> getEmpleadosExternosExcluidosDenominador(String idOrganization, LocalDate fechaInicio, LocalDate fechaFin,
      List<Long> puestos, String stdIdHrType) {
    IncomeMetaServiceImpl.LOG.info(LOG_MESSAGE, "llamada al método de servicio FINDEXTERNOS");
    IncomeMetaServiceImpl.LOG
        .info("INFO REQUEST: " + idOrganization + " " + fechaInicio + " " + fechaFin + " " + puestos + " " + stdIdHrType);
    return this.empleadoApi.findExternos(idOrganization, fechaInicio, fechaFin, puestos, stdIdHrType);
  }

  @Override
  public List<EmpleadoDTO> searchEmpleados(final SearchEmpleadosRequestDto request) {
    IncomeMetaServiceImpl.LOG.info(LOG_MESSAGE, "llamada al método de servicio SEARCHEMPLEADOS");
    IncomeMetaServiceImpl.LOG.info("INFO REQUEST: " + request);

    final SearchEmpleadosFilterDto dto = request.getData();

    final List<String> idsEmpresa = dto.getIdsEmpresa();
    final List<String> idsCadena = dto.getIdsCadena();
    final Boolean esEmpresa = CollectionUtils.isNotEmpty((idsEmpresa));

    return this.empleadoApi.listEmpleados(dto.getIdOrigen(), esEmpresa ? idsEmpresa : idsCadena, dto.getFechaInicio().toLocalDate(),
        dto.getFechaFin().toLocalDate(), esEmpresa);
  }

  @Override
  public List<TiposVentaChallengeResponseDTO> getTiposVentaChallenge(String origen, Integer empresa, LocalDate fechaInicio,
      LocalDate fechaFin, String organizacion) {

    IncomeMetaServiceImpl.LOG.info(LOG_MESSAGE, "llamada al método TiposVentaChallenge");
    IncomeMetaServiceImpl.LOG.info("INFO REQUEST: " + origen + " " + empresa + " " + fechaInicio + " " + fechaFin + " " + organizacion);
    return this.configuracionApi.findTiposVentaChallenge(origen, empresa, fechaInicio, fechaFin, organizacion);
  }

  @Override
  public List<TiendaResponseDTO> getTiendas(String idOrigen, List<String> idsEmpresaOrCadena, Boolean esEmpresa, LocalDate fechaInicio,
      LocalDate fechaFin, String idOrganizacion) {

    IncomeMetaServiceImpl.LOG.info(LOG_MESSAGE, "llamada al método Tiendas");
    IncomeMetaServiceImpl.LOG.info("INFO REQUEST: "
        + idOrigen + " " + idsEmpresaOrCadena + " " + esEmpresa + " " + fechaInicio + " " + fechaFin + " " + idOrganizacion);

    return this.tiendaApi.listTiendas(idOrigen, idsEmpresaOrCadena, esEmpresa, fechaInicio, fechaFin, idOrganizacion);
  }

  @Override
  public PeriodoResponseDTO getPeriodos(String idOrganization, Integer idPeriodo, Boolean abierto, Boolean vigente) {
    IncomeMetaServiceImpl.LOG.info(LOG_MESSAGE, "llamada al método getPeriodos");
    IncomeMetaServiceImpl.LOG.info("INFO REQUEST: {} {} {} {}", idOrganization, idPeriodo, abierto, vigente);
    return this.tiendaApi.periodos(idOrganization, idPeriodo, abierto, vigente);
  }

  @Override
  public List<PresupuestoResponseDTO> getPresupuestos(List<Integer> idEmpresa, LocalDate fechaInicio, LocalDate fechaFin,
      String idOrganizacion) {
    IncomeMetaServiceImpl.LOG.info(LOG_MESSAGE, "llamada al método Presupuestos");
    IncomeMetaServiceImpl.LOG.info("INFO REQUEST: " + idEmpresa + " " + fechaInicio + " " + fechaFin + " " + idOrganizacion + " ");

    return this.tiendaApi.getPresupuesto(idEmpresa, fechaInicio, fechaFin, idOrganizacion);
  }

  @Override
  public List<AgrupacionesOnlineResponseDTO> getAgrupOnline(String idOrigen) {
    IncomeMetaServiceImpl.LOG.info(LOG_MESSAGE, "llamada al método getAgrupOnline");
    IncomeMetaServiceImpl.LOG.info("INFO REQUEST: {}", idOrigen);
    return this.configuracionApi.findAgrupacionesOnline(idOrigen);
  }

  @Override
  public List<ConfiguracionPrecioHoraResponseDTO> getConfPrecioHora(String idOrganization, LocalDate fechaInicio, LocalDate fechaFin) {
    IncomeMetaServiceImpl.LOG.info(LOG_MESSAGE, "llamada al método getConfPrecioHora");
    IncomeMetaServiceImpl.LOG.info("INFO REQUEST: {} {} {}", idOrganization, fechaInicio, fechaFin);
    return this.configuracionApi.getConfPrecioHora(idOrganization, fechaInicio, fechaFin);
  }

}
