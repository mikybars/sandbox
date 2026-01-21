package com.inditex.rrhh.icmclcwb.model.app.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

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

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class IncomeMetaServiceImplTest {

  @Mock
  private Logger log;

  @Mock
  @Qualifier("empleadoIncomeMetaApiClient")
  private EmpleadoApi empleadoApi;

  @Mock
  @Qualifier("tiendaIncomeMetaApiClient")
  private TiendaApi tiendaApi;

  @Mock
  @Qualifier("configuracionIncomeMetaApiClient")
  private ConfiguracionApi configuracionApi;

  @InjectMocks
  private IncomeMetaServiceImpl incomeMetaService;

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void getEmpleadosExternosExcluidosDenominadorTest(final String idOrganization, final LocalDate fechaInicio, final LocalDate fechaFin,
      final List<Long> puestos, final String stdIdHrType, final List<EmpleadoExternoDTO> response) {
    doReturn(response).when(this.empleadoApi).findExternos(idOrganization, fechaInicio, fechaFin, puestos, stdIdHrType);

    final List<EmpleadoExternoDTO> result =
        this.incomeMetaService.getEmpleadosExternosExcluidosDenominador(idOrganization, fechaInicio, fechaFin, puestos, stdIdHrType);
    Assertions.assertEquals(response, result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void searchEmpleadosTest(final SearchEmpleadosRequestDto request, final List<EmpleadoDTO> response) {
    final SearchEmpleadosFilterDto dto = request.getData();

    final List<String> idsEmpresa = dto.getIdsEmpresa();
    final List<String> idsCadena = dto.getIdsCadena();
    final Boolean esEmpresa = CollectionUtils.isNotEmpty((idsEmpresa));

    doReturn(response).when(this.empleadoApi).listEmpleados(dto.getIdOrigen(), esEmpresa ? idsEmpresa : idsCadena,
        dto.getFechaInicio().toLocalDate(),
        dto.getFechaFin().toLocalDate(), esEmpresa);

    final List<EmpleadoDTO> result = this.incomeMetaService.searchEmpleados(request);
    Assertions.assertEquals(response, result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void getTiposVentaChallengeTest() {
    final List<TiposVentaChallengeResponseDTO> mockResponse = Collections.singletonList(new TiposVentaChallengeResponseDTO());
    when(
        this.configuracionApi.findTiposVentaChallenge(anyString(), anyInt(), any(LocalDate.class), any(LocalDate.class), anyString()))
            .thenReturn(mockResponse);

    final List<TiposVentaChallengeResponseDTO> result =
        this.incomeMetaService.getTiposVentaChallenge("01", 1, LocalDate.now(), LocalDate.now(), "PL");

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void getTiendasTest() {
    final List<TiendaResponseDTO> mockResponse = Collections.singletonList(new TiendaResponseDTO());
    when(
        this.tiendaApi.listTiendas("01", List.of("1"), true, LocalDate.now(), LocalDate.now(), "PL"))
            .thenReturn(mockResponse);

    final List<TiendaResponseDTO> result =
        this.incomeMetaService.getTiendas("01", List.of("1"), true, LocalDate.now(), LocalDate.now(), "PL");

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void getPeriodosTest() {
    final PeriodoResponseDTO mockResponse = new PeriodoResponseDTO();
    when(
        this.tiendaApi.periodos("01", 1, true, true))
            .thenReturn(mockResponse);

    final PeriodoResponseDTO result =
        this.incomeMetaService.getPeriodos("01", 1, true, true);

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void getPresupuestosTest() {
    final List<PresupuestoResponseDTO> mockResponse = Collections.singletonList(new PresupuestoResponseDTO());
    when(
        this.tiendaApi.getPresupuesto(List.of(1), LocalDate.now(), LocalDate.now(), "PL"))
            .thenReturn(mockResponse);

    final List<PresupuestoResponseDTO> result =
        this.incomeMetaService.getPresupuestos(List.of(1), LocalDate.now(), LocalDate.now(), "PL");

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void getAgrupOnline() {
    final List<AgrupacionesOnlineResponseDTO> mockResponse = Collections.singletonList(new AgrupacionesOnlineResponseDTO());
    when(
        this.configuracionApi.findAgrupacionesOnline("PL"))
            .thenReturn(mockResponse);

    final List<AgrupacionesOnlineResponseDTO> result =
        this.incomeMetaService.getAgrupOnline("PL");

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void getConfPrecioHoraTest() {
    final List<ConfiguracionPrecioHoraResponseDTO> mockResponse = Collections.singletonList(new ConfiguracionPrecioHoraResponseDTO());
    when(
        this.configuracionApi.getConfPrecioHora("PL", LocalDate.now(), LocalDate.now().plusDays(30)))
            .thenReturn(mockResponse);

    final List<ConfiguracionPrecioHoraResponseDTO> result =
        this.incomeMetaService.getConfPrecioHora("PL", LocalDate.now(), LocalDate.now().plusDays(30));

    assertNotNull(result);
  }
}
