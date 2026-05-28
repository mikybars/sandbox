package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchAusenciasRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchAusenciasResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchCoeficienteJornadaRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchCoeficienteJornadaResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfProductoVentaRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfProductoVentaResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfVentaOnlineRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfVentaOnlineResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchDesplazamientosMultiempresaRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchDesplazamientosMultiempresaResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchDesplazamientosRealesRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchDesplazamientosRealesResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpleadosDesplazadosRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpleadosDesplazadosResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpleadosPresenciaResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpresasRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpresasResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchFlagCalculaRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchFlagCalculaResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchOrigenesRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchOrigenesResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPeriodosRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPeriodosResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresenciaManualRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresenciaManualResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresenciasManualWlocRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresenciasManualWlocResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresupuestosWlocResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchSistemasDestinoRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchSistemasDestinoResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasIncomeRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasIncomeResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasOnlineRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasOnlineResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchVentasCongeladasRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchVentasCongeladasResponseDto;
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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PeopleAclServiceTest {

  PeopleAclService service;

  @Mock
  TiendasOnlineApi tiendasOnlineApi;

  @Mock
  OrigenesApi origenesApi;

  @Mock
  EmpresasApi empresasApi;

  @Mock
  AusenciasApi ausenciasApi;

  @Mock
  ConfiguracionVentaApi configuracionVentaApi;

  @Mock
  TiendasIncomeApi tiendasIncomeApi;

  @Mock
  FlagCalculaApi flagCalculaApi;

  @Mock
  CoeficientesJornadaApi coeficientesJornadaApi;

  @Mock
  PresenciasManualApi presenciasManualApi;

  @Mock
  PresenciasManualWlocApi presenciasManualWlocApi;

  @Mock
  EmpleadosDesplazadosApi empleadosDesplazadosApi;

  @Mock
  EmpleadosPresenciaApi empleadosPresenciaApi;

  @Mock
  PresupuestosApi presupuestosApi;

  @Mock
  VentasCongeladasApi ventasCongeladasApi;

  @Mock
  PeriodosApi periodosApi;

  @Mock
  SistemasDestinoApi sistemasDestinoApi;

  @Mock
  DesplazamientosRealesApi desplazamientosRealesApi;

  @Mock
  DesplazamientosMultiempresaApi desplazamientosMultiempresaApi;

  @Mock
  PeopleAclMapper peopleAclMapper;

  @BeforeEach
  void beforeEach() {
    service = new PeopleAclService(tiendasOnlineApi, origenesApi, empresasApi, ausenciasApi, configuracionVentaApi, tiendasIncomeApi,
        flagCalculaApi, coeficientesJornadaApi, presenciasManualApi, presenciasManualWlocApi, empleadosDesplazadosApi,
        empleadosPresenciaApi, presupuestosApi, ventasCongeladasApi, periodosApi, sistemasDestinoApi, desplazamientosRealesApi,
        desplazamientosMultiempresaApi,
        peopleAclMapper);
  }

  @Nested
  class SearchTiendasOnline {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
      SearchTiendasOnlineRequestDto restRequest = new SearchTiendasOnlineRequestDto();
      SearchTiendasOnlineResponseDto restResponse = new SearchTiendasOnlineResponseDto();
      TiendaOnlineResponseDto expected = new TiendaOnlineResponseDto();
      when(peopleAclMapper.toSearchTiendasOnlineRequestDto(request)).thenReturn(restRequest);
      when(tiendasOnlineApi.searchTiendasOnline(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toTiendaOnlineResponseDto(restResponse)).thenReturn(expected);

      TiendaOnlineResponseDto result = service.searchTiendasOnline(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
      SearchTiendasOnlineRequestDto restRequest = new SearchTiendasOnlineRequestDto();
      when(peopleAclMapper.toSearchTiendasOnlineRequestDto(request)).thenReturn(restRequest);
      when(tiendasOnlineApi.searchTiendasOnline(restRequest)).thenReturn(null);
      when(peopleAclMapper.toTiendaOnlineResponseDto(null)).thenReturn(null);

      TiendaOnlineResponseDto result = service.searchTiendasOnline(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toTiendaOnlineResponseDto(null);
    }
  }

  @Nested
  class SearchOrigenes {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      OrigenRequestDto request = new OrigenRequestDto();
      SearchOrigenesRequestDto restRequest = new SearchOrigenesRequestDto();
      SearchOrigenesResponseDto restResponse = new SearchOrigenesResponseDto();
      OrigenResponseDto expected = new OrigenResponseDto();
      when(peopleAclMapper.toSearchOrigenesRequestDto(request)).thenReturn(restRequest);
      when(origenesApi.searchOrigenes(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toOrigenResponseDto(restResponse)).thenReturn(expected);

      OrigenResponseDto result = service.searchOrigenes(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      OrigenRequestDto request = new OrigenRequestDto();
      SearchOrigenesRequestDto restRequest = new SearchOrigenesRequestDto();
      when(peopleAclMapper.toSearchOrigenesRequestDto(request)).thenReturn(restRequest);
      when(origenesApi.searchOrigenes(restRequest)).thenReturn(null);
      when(peopleAclMapper.toOrigenResponseDto(null)).thenReturn(null);

      OrigenResponseDto result = service.searchOrigenes(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toOrigenResponseDto(null);
    }
  }

  @Nested
  class SearchEmpresas {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      EmpresaRequestDto request = new EmpresaRequestDto();
      SearchEmpresasRequestDto restRequest = new SearchEmpresasRequestDto();
      SearchEmpresasResponseDto restResponse = new SearchEmpresasResponseDto();
      EmpresaResponseDto expected = new EmpresaResponseDto();
      when(peopleAclMapper.toSearchEmpresasRequestDto(request)).thenReturn(restRequest);
      when(empresasApi.searchEmpresas(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toEmpresaResponseDto(restResponse)).thenReturn(expected);

      EmpresaResponseDto result = service.searchEmpresas(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      EmpresaRequestDto request = new EmpresaRequestDto();
      SearchEmpresasRequestDto restRequest = new SearchEmpresasRequestDto();
      when(peopleAclMapper.toSearchEmpresasRequestDto(request)).thenReturn(restRequest);
      when(empresasApi.searchEmpresas(restRequest)).thenReturn(null);
      when(peopleAclMapper.toEmpresaResponseDto(null)).thenReturn(null);

      EmpresaResponseDto result = service.searchEmpresas(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toEmpresaResponseDto(null);
    }
  }

  @Nested
  class GetAusencias {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      AusenciasRequestDto request = new AusenciasRequestDto();
      SearchAusenciasRequestDto restRequest = new SearchAusenciasRequestDto();
      SearchAusenciasResponseDto restResponse = new SearchAusenciasResponseDto();
      AusenciasResponseDto expected = new AusenciasResponseDto();
      when(peopleAclMapper.toSearchAusenciasRequestDto(request)).thenReturn(restRequest);
      when(ausenciasApi.searchAusencias(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toAusenciasResponseDto(restResponse)).thenReturn(expected);

      AusenciasResponseDto result = service.getAusencias(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      AusenciasRequestDto request = new AusenciasRequestDto();
      SearchAusenciasRequestDto restRequest = new SearchAusenciasRequestDto();
      when(peopleAclMapper.toSearchAusenciasRequestDto(request)).thenReturn(restRequest);
      when(ausenciasApi.searchAusencias(restRequest)).thenReturn(null);
      when(peopleAclMapper.toAusenciasResponseDto(null)).thenReturn(null);

      AusenciasResponseDto result = service.getAusencias(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toAusenciasResponseDto(null);
    }
  }

  @Nested
  class GetConfVentaOnline {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
      SearchConfVentaOnlineRequestDto restRequest = new SearchConfVentaOnlineRequestDto();
      SearchConfVentaOnlineResponseDto restResponse = new SearchConfVentaOnlineResponseDto();
      ConfiguracionVentaOnlineResponseDto expected = new ConfiguracionVentaOnlineResponseDto();
      when(peopleAclMapper.toSearchConfVentaOnlineRequestDto(request)).thenReturn(restRequest);
      when(configuracionVentaApi.searchConfVentaOnline(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toConfiguracionVentaOnlineResponseDto(restResponse)).thenReturn(expected);

      ConfiguracionVentaOnlineResponseDto result = service.getConfVentaOnline(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
      SearchConfVentaOnlineRequestDto restRequest = new SearchConfVentaOnlineRequestDto();
      when(peopleAclMapper.toSearchConfVentaOnlineRequestDto(request)).thenReturn(restRequest);
      when(configuracionVentaApi.searchConfVentaOnline(restRequest)).thenReturn(null);
      when(peopleAclMapper.toConfiguracionVentaOnlineResponseDto(null)).thenReturn(null);

      ConfiguracionVentaOnlineResponseDto result = service.getConfVentaOnline(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toConfiguracionVentaOnlineResponseDto(null);
    }
  }

  @Nested
  class GetTiendas {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      TiendasRequestDto request = new TiendasRequestDto();
      SearchTiendasIncomeRequestDto restRequest = new SearchTiendasIncomeRequestDto();
      SearchTiendasIncomeResponseDto restResponse = new SearchTiendasIncomeResponseDto();
      TiendasResponseDto expected = new TiendasResponseDto();
      when(peopleAclMapper.toSearchTiendasIncomeRequestDto(request)).thenReturn(restRequest);
      when(tiendasIncomeApi.searchTiendasIncome(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toTiendasResponseDto(restResponse)).thenReturn(expected);

      TiendasResponseDto result = service.getTiendas(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      TiendasRequestDto request = new TiendasRequestDto();
      SearchTiendasIncomeRequestDto restRequest = new SearchTiendasIncomeRequestDto();
      when(peopleAclMapper.toSearchTiendasIncomeRequestDto(request)).thenReturn(restRequest);
      when(tiendasIncomeApi.searchTiendasIncome(restRequest)).thenReturn(null);
      when(peopleAclMapper.toTiendasResponseDto(null)).thenReturn(null);

      TiendasResponseDto result = service.getTiendas(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toTiendasResponseDto(null);
    }
  }

  @Nested
  class GetConfiguracionProductoVenta {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
      SearchConfProductoVentaRequestDto restRequest = new SearchConfProductoVentaRequestDto();
      SearchConfProductoVentaResponseDto restResponse = new SearchConfProductoVentaResponseDto();
      ConfiguracionProductoVentaResponseDto expected = new ConfiguracionProductoVentaResponseDto();
      when(peopleAclMapper.toSearchConfProductoVentaRequestDto(request)).thenReturn(restRequest);
      when(configuracionVentaApi.searchConfProductoVenta(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toConfiguracionProductoVentaResponseDto(restResponse)).thenReturn(expected);

      ConfiguracionProductoVentaResponseDto result = service.getConfiguracionProductoVenta(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
      SearchConfProductoVentaRequestDto restRequest = new SearchConfProductoVentaRequestDto();
      when(peopleAclMapper.toSearchConfProductoVentaRequestDto(request)).thenReturn(restRequest);
      when(configuracionVentaApi.searchConfProductoVenta(restRequest)).thenReturn(null);
      when(peopleAclMapper.toConfiguracionProductoVentaResponseDto(null)).thenReturn(null);

      ConfiguracionProductoVentaResponseDto result = service.getConfiguracionProductoVenta(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toConfiguracionProductoVentaResponseDto(null);
    }
  }

  @Nested
  class GetFlagCalcula {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      FlagCalculaRequestDto request = new FlagCalculaRequestDto();
      SearchFlagCalculaRequestDto restRequest = new SearchFlagCalculaRequestDto();
      SearchFlagCalculaResponseDto restResponse = new SearchFlagCalculaResponseDto();
      FlagCalculaResponseDto expected = new FlagCalculaResponseDto();
      when(peopleAclMapper.toSearchFlagCalculaRequestDto(request)).thenReturn(restRequest);
      when(flagCalculaApi.searchFlagCalcula(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toFlagCalculaResponseDto(restResponse)).thenReturn(expected);

      FlagCalculaResponseDto result = service.getFlagCalcula(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      FlagCalculaRequestDto request = new FlagCalculaRequestDto();
      SearchFlagCalculaRequestDto restRequest = new SearchFlagCalculaRequestDto();
      when(peopleAclMapper.toSearchFlagCalculaRequestDto(request)).thenReturn(restRequest);
      when(flagCalculaApi.searchFlagCalcula(restRequest)).thenReturn(null);
      when(peopleAclMapper.toFlagCalculaResponseDto(null)).thenReturn(null);

      FlagCalculaResponseDto result = service.getFlagCalcula(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toFlagCalculaResponseDto(null);
    }
  }

  @Nested
  class GetCoefJornada {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      CoefJornadaRequestDto request = new CoefJornadaRequestDto();
      SearchCoeficienteJornadaRequestDto restRequest = new SearchCoeficienteJornadaRequestDto();
      SearchCoeficienteJornadaResponseDto restResponse = new SearchCoeficienteJornadaResponseDto();
      CoefJornadaResponseDto expected = new CoefJornadaResponseDto();
      when(peopleAclMapper.toSearchCoeficienteJornadaRequestDto(request)).thenReturn(restRequest);
      when(coeficientesJornadaApi.searchCoeficientesJornada(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toCoefJornadaResponseDto(restResponse)).thenReturn(expected);

      CoefJornadaResponseDto result = service.getCoefJornada(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      CoefJornadaRequestDto request = new CoefJornadaRequestDto();
      SearchCoeficienteJornadaRequestDto restRequest = new SearchCoeficienteJornadaRequestDto();
      when(peopleAclMapper.toSearchCoeficienteJornadaRequestDto(request)).thenReturn(restRequest);
      when(coeficientesJornadaApi.searchCoeficientesJornada(restRequest)).thenReturn(null);
      when(peopleAclMapper.toCoefJornadaResponseDto(null)).thenReturn(null);

      CoefJornadaResponseDto result = service.getCoefJornada(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toCoefJornadaResponseDto(null);
    }
  }

  @Nested
  class GetPresenciaManual {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      PresenciaManualRequestDto request = new PresenciaManualRequestDto();
      SearchPresenciaManualRequestDto restRequest = new SearchPresenciaManualRequestDto();
      SearchPresenciaManualResponseDto restResponse = new SearchPresenciaManualResponseDto();
      PresenciaManualResponseDto expected = new PresenciaManualResponseDto();
      when(peopleAclMapper.toSearchPresenciaManualRequestDto(request)).thenReturn(restRequest);
      when(presenciasManualApi.searchPresenciasManual(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toPresenciaManualResponseDto(restResponse)).thenReturn(expected);

      PresenciaManualResponseDto result = service.getPresenciaManual(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      PresenciaManualRequestDto request = new PresenciaManualRequestDto();
      SearchPresenciaManualRequestDto restRequest = new SearchPresenciaManualRequestDto();
      when(peopleAclMapper.toSearchPresenciaManualRequestDto(request)).thenReturn(restRequest);
      when(presenciasManualApi.searchPresenciasManual(restRequest)).thenReturn(null);
      when(peopleAclMapper.toPresenciaManualResponseDto(null)).thenReturn(null);

      PresenciaManualResponseDto result = service.getPresenciaManual(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toPresenciaManualResponseDto(null);
    }
  }

  @Nested
  class GetEmpleadosDesplazamiento {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
      SearchEmpleadosDesplazadosRequestDto restRequest = new SearchEmpleadosDesplazadosRequestDto();
      SearchEmpleadosDesplazadosResponseDto restResponse = new SearchEmpleadosDesplazadosResponseDto();
      EmpleadosDesplazamientoResponseDto expected = new EmpleadosDesplazamientoResponseDto();
      when(peopleAclMapper.toSearchEmpleadosDesplazadosRequestDto(request)).thenReturn(restRequest);
      when(empleadosDesplazadosApi.searchEmpleadosDesplazados(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toEmpleadosDesplazamientoResponseDto(restResponse)).thenReturn(expected);

      EmpleadosDesplazamientoResponseDto result = service.getEmpleadosDesplazamiento(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
      SearchEmpleadosDesplazadosRequestDto restRequest = new SearchEmpleadosDesplazadosRequestDto();
      when(peopleAclMapper.toSearchEmpleadosDesplazadosRequestDto(request)).thenReturn(restRequest);
      when(empleadosDesplazadosApi.searchEmpleadosDesplazados(restRequest)).thenReturn(null);
      when(peopleAclMapper.toEmpleadosDesplazamientoResponseDto(null)).thenReturn(null);

      EmpleadosDesplazamientoResponseDto result = service.getEmpleadosDesplazamiento(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toEmpleadosDesplazamientoResponseDto(null);
    }
  }

  @Nested
  class GetEmpleadosPresencia {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
      SearchEmpleadosPresenciaRequestDto restRequest = new SearchEmpleadosPresenciaRequestDto();
      SearchEmpleadosPresenciaResponseDto restResponse = new SearchEmpleadosPresenciaResponseDto();
      EmpleadosPresenciaResponseDto expected = new EmpleadosPresenciaResponseDto();
      when(peopleAclMapper.toSearchEmpleadosPresenciaRequestDto(request)).thenReturn(restRequest);
      when(empleadosPresenciaApi.searchEmpleadosPresencia(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toEmpleadosPresenciaResponseDto(restResponse)).thenReturn(expected);

      EmpleadosPresenciaResponseDto result = service.getEmpleadosPresencia(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
      SearchEmpleadosPresenciaRequestDto restRequest = new SearchEmpleadosPresenciaRequestDto();
      when(peopleAclMapper.toSearchEmpleadosPresenciaRequestDto(request)).thenReturn(restRequest);
      when(empleadosPresenciaApi.searchEmpleadosPresencia(restRequest)).thenReturn(null);
      when(peopleAclMapper.toEmpleadosPresenciaResponseDto(null)).thenReturn(null);

      EmpleadosPresenciaResponseDto result = service.getEmpleadosPresencia(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toEmpleadosPresenciaResponseDto(null);
    }
  }

  @Nested
  class GetPresupuestosWloc {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      PresupuestosWlocRequestDto request = new PresupuestosWlocRequestDto();
      SearchPresupuestosWlocRequestDto restRequest = new SearchPresupuestosWlocRequestDto();
      SearchPresupuestosWlocResponseDto restResponse = new SearchPresupuestosWlocResponseDto();
      PresupuestosWlocResponseDto expected = new PresupuestosWlocResponseDto();
      when(peopleAclMapper.toSearchPresupuestosWlocRequestDto(request)).thenReturn(restRequest);
      when(presupuestosApi.searchPresupuestosWloc(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toPresupuestosWlocResponseDto(restResponse)).thenReturn(expected);

      PresupuestosWlocResponseDto result = service.getPresupuestosWloc(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      PresupuestosWlocRequestDto request = new PresupuestosWlocRequestDto();
      SearchPresupuestosWlocRequestDto restRequest = new SearchPresupuestosWlocRequestDto();
      when(peopleAclMapper.toSearchPresupuestosWlocRequestDto(request)).thenReturn(restRequest);
      when(presupuestosApi.searchPresupuestosWloc(restRequest)).thenReturn(null);
      when(peopleAclMapper.toPresupuestosWlocResponseDto(null)).thenReturn(null);

      PresupuestosWlocResponseDto result = service.getPresupuestosWloc(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toPresupuestosWlocResponseDto(null);
    }
  }

  @Nested
  class GetVentaCongelada {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      VentaCongeladaRequestDto request = new VentaCongeladaRequestDto();
      SearchVentasCongeladasRequestDto restRequest = new SearchVentasCongeladasRequestDto();
      SearchVentasCongeladasResponseDto restResponse = new SearchVentasCongeladasResponseDto();
      VentaCongeladaResponseDto expected = new VentaCongeladaResponseDto();
      when(peopleAclMapper.toSearchVentasCongeladasRequestDto(request)).thenReturn(restRequest);
      when(ventasCongeladasApi.searchVentasCongeladas(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toVentaCongeladaResponseDto(restResponse)).thenReturn(expected);

      VentaCongeladaResponseDto result = service.getVentaCongelada(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      VentaCongeladaRequestDto request = new VentaCongeladaRequestDto();
      SearchVentasCongeladasRequestDto restRequest = new SearchVentasCongeladasRequestDto();
      when(peopleAclMapper.toSearchVentasCongeladasRequestDto(request)).thenReturn(restRequest);
      when(ventasCongeladasApi.searchVentasCongeladas(restRequest)).thenReturn(null);
      when(peopleAclMapper.toVentaCongeladaResponseDto(null)).thenReturn(null);

      VentaCongeladaResponseDto result = service.getVentaCongelada(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toVentaCongeladaResponseDto(null);
    }
  }

  @Nested
  class GetPresenciaManualWloc {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      PresenciaManualWlocRequestDto request = new PresenciaManualWlocRequestDto();
      SearchPresenciasManualWlocRequestDto restRequest = new SearchPresenciasManualWlocRequestDto();
      SearchPresenciasManualWlocResponseDto restResponse = new SearchPresenciasManualWlocResponseDto();
      PresenciaManualWlocResponseDto expected = new PresenciaManualWlocResponseDto();
      when(peopleAclMapper.toSearchPresenciasManualWlocRequestDto(request)).thenReturn(restRequest);
      when(presenciasManualWlocApi.searchPresenciasManualWloc(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toPresenciaManualWlocResponseDto(restResponse)).thenReturn(expected);

      PresenciaManualWlocResponseDto result = service.getPresenciaManualWloc(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      PresenciaManualWlocRequestDto request = new PresenciaManualWlocRequestDto();
      SearchPresenciasManualWlocRequestDto restRequest = new SearchPresenciasManualWlocRequestDto();
      when(peopleAclMapper.toSearchPresenciasManualWlocRequestDto(request)).thenReturn(restRequest);
      when(presenciasManualWlocApi.searchPresenciasManualWloc(restRequest)).thenReturn(null);
      when(peopleAclMapper.toPresenciaManualWlocResponseDto(null)).thenReturn(null);

      PresenciaManualWlocResponseDto result = service.getPresenciaManualWloc(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toPresenciaManualWlocResponseDto(null);
    }
  }

  @Nested
  class SearchPeriodos {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      PeriodosRequestDto request = new PeriodosRequestDto();
      SearchPeriodosRequestDto restRequest = new SearchPeriodosRequestDto();
      SearchPeriodosResponseDto restResponse = new SearchPeriodosResponseDto();
      PeriodosResponseDto expected = new PeriodosResponseDto();
      when(peopleAclMapper.toSearchPeriodosRequestDto(request)).thenReturn(restRequest);
      when(periodosApi.searchPeriodos(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toPeriodosResponseDto(restResponse)).thenReturn(expected);

      PeriodosResponseDto result = service.searchPeriodos(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      PeriodosRequestDto request = new PeriodosRequestDto();
      SearchPeriodosRequestDto restRequest = new SearchPeriodosRequestDto();
      when(peopleAclMapper.toSearchPeriodosRequestDto(request)).thenReturn(restRequest);
      when(periodosApi.searchPeriodos(restRequest)).thenReturn(null);
      when(peopleAclMapper.toPeriodosResponseDto(null)).thenReturn(null);

      PeriodosResponseDto result = service.searchPeriodos(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toPeriodosResponseDto(null);
    }
  }

  @Nested
  class SearchSistemasDestino {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      SistemaDestinoRequestDto request = SistemaDestinoRequestDto.builder().cclIdOrigen("OR1").build();
      SearchSistemasDestinoRequestDto restRequest = new SearchSistemasDestinoRequestDto();
      SearchSistemasDestinoResponseDto restResponse = new SearchSistemasDestinoResponseDto();
      SistemaDestinoResponseDto expected = SistemaDestinoResponseDto.builder().build();
      when(peopleAclMapper.toSearchSistemasDestinoRequestDto(request)).thenReturn(restRequest);
      when(sistemasDestinoApi.searchSistemasDestino(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toSistemaDestinoResponseDto(restResponse)).thenReturn(expected);

      SistemaDestinoResponseDto result = service.searchSistemasDestino(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      SistemaDestinoRequestDto request = SistemaDestinoRequestDto.builder().cclIdOrigen("OR1").build();
      SearchSistemasDestinoRequestDto restRequest = new SearchSistemasDestinoRequestDto();
      when(peopleAclMapper.toSearchSistemasDestinoRequestDto(request)).thenReturn(restRequest);
      when(sistemasDestinoApi.searchSistemasDestino(restRequest)).thenReturn(null);
      when(peopleAclMapper.toSistemaDestinoResponseDto(null)).thenReturn(null);

      SistemaDestinoResponseDto result = service.searchSistemasDestino(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toSistemaDestinoResponseDto(null);
    }
  }

  @Nested
  class GetDesplazReal {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      DesplazamientoRealRequestDto request = new DesplazamientoRealRequestDto();
      SearchDesplazamientosRealesRequestDto restRequest = new SearchDesplazamientosRealesRequestDto();
      SearchDesplazamientosRealesResponseDto restResponse = new SearchDesplazamientosRealesResponseDto();
      DesplazamientoRealResponseDto expected = new DesplazamientoRealResponseDto();
      when(peopleAclMapper.toSearchDesplazamientosRealesRequestDto(request)).thenReturn(restRequest);
      when(desplazamientosRealesApi.searchDesplazamientosReales(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toDesplazamientoRealResponseDto(restResponse)).thenReturn(expected);

      DesplazamientoRealResponseDto result = service.getDesplazReal(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      DesplazamientoRealRequestDto request = new DesplazamientoRealRequestDto();
      SearchDesplazamientosRealesRequestDto restRequest = new SearchDesplazamientosRealesRequestDto();
      when(peopleAclMapper.toSearchDesplazamientosRealesRequestDto(request)).thenReturn(restRequest);
      when(desplazamientosRealesApi.searchDesplazamientosReales(restRequest)).thenReturn(null);
      when(peopleAclMapper.toDesplazamientoRealResponseDto(null)).thenReturn(null);

      DesplazamientoRealResponseDto result = service.getDesplazReal(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toDesplazamientoRealResponseDto(null);
    }
  }

  @Nested
  class SearchDesplazamientosMultiempresa {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      DesplazamientosMultiempresaRequestDto request = new DesplazamientosMultiempresaRequestDto();
      SearchDesplazamientosMultiempresaRequestDto restRequest = new SearchDesplazamientosMultiempresaRequestDto();
      SearchDesplazamientosMultiempresaResponseDto restResponse = new SearchDesplazamientosMultiempresaResponseDto();
      DesplazamientosMultiempresaResponseDto expected = new DesplazamientosMultiempresaResponseDto();
      when(peopleAclMapper.toSearchDesplazamientosMultiempresaRequestDto(request)).thenReturn(restRequest);
      when(desplazamientosMultiempresaApi.searchDesplazamientosMultiempresa(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toDesplazamientosMultiempresaResponseDto(restResponse)).thenReturn(expected);

      DesplazamientosMultiempresaResponseDto result = service.searchDesplazamientosMultiempresa(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      DesplazamientosMultiempresaRequestDto request = new DesplazamientosMultiempresaRequestDto();
      SearchDesplazamientosMultiempresaRequestDto restRequest = new SearchDesplazamientosMultiempresaRequestDto();
      when(peopleAclMapper.toSearchDesplazamientosMultiempresaRequestDto(request)).thenReturn(restRequest);

      service.searchDesplazamientosMultiempresa(request);

      verify(peopleAclMapper, times(1)).toSearchDesplazamientosMultiempresaRequestDto(request);
      verify(desplazamientosMultiempresaApi, times(1)).searchDesplazamientosMultiempresa(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      DesplazamientosMultiempresaRequestDto request = new DesplazamientosMultiempresaRequestDto();
      SearchDesplazamientosMultiempresaRequestDto restRequest = new SearchDesplazamientosMultiempresaRequestDto();
      SearchDesplazamientosMultiempresaResponseDto restResponse = new SearchDesplazamientosMultiempresaResponseDto();
      when(peopleAclMapper.toSearchDesplazamientosMultiempresaRequestDto(request)).thenReturn(restRequest);
      when(desplazamientosMultiempresaApi.searchDesplazamientosMultiempresa(restRequest)).thenReturn(restResponse);

      service.searchDesplazamientosMultiempresa(request);

      verify(peopleAclMapper, times(1)).toDesplazamientosMultiempresaResponseDto(restResponse);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      DesplazamientosMultiempresaRequestDto request = new DesplazamientosMultiempresaRequestDto();
      SearchDesplazamientosMultiempresaRequestDto restRequest = new SearchDesplazamientosMultiempresaRequestDto();
      when(peopleAclMapper.toSearchDesplazamientosMultiempresaRequestDto(request)).thenReturn(restRequest);
      when(desplazamientosMultiempresaApi.searchDesplazamientosMultiempresa(restRequest)).thenReturn(null);
      when(peopleAclMapper.toDesplazamientosMultiempresaResponseDto(null)).thenReturn(null);

      DesplazamientosMultiempresaResponseDto result = service.searchDesplazamientosMultiempresa(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toDesplazamientosMultiempresaResponseDto(null);
    }
  }
}
