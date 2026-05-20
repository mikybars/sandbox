package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.AusenciasApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.CoeficientesJornadaApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.ConfiguracionVentaApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.EmpleadosDesplazadosApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.EmpleadosPresenciaApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.EmpresasApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.FlagCalculaApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.OrigenesApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.PresenciasManualApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.PresenciasManualWlocApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.PresupuestosApi;
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
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresenciaManualRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresenciaManualResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresenciasManualWlocRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresenciasManualWlocResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresupuestosWlocResponseDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResponseDto;
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
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
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
  PeopleAclMapper peopleAclMapper;

  @Captor
  ArgumentCaptor<SearchTiendasOnlineRequestDto> restRequestCaptor;

  @Captor
  ArgumentCaptor<SearchTiendasIncomeRequestDto> tiendasIncomeRestRequestCaptor;

  @Captor
  ArgumentCaptor<SearchOrigenesRequestDto> origenesRestRequestCaptor;

  @BeforeEach
  void beforeEach() {
    service = new PeopleAclService(tiendasOnlineApi, origenesApi, empresasApi, ausenciasApi, configuracionVentaApi, tiendasIncomeApi,
        flagCalculaApi, coeficientesJornadaApi, presenciasManualApi, presenciasManualWlocApi, empleadosDesplazadosApi,
        empleadosPresenciaApi,
        presupuestosApi, ventasCongeladasApi, peopleAclMapper);
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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
      SearchTiendasOnlineRequestDto restRequest = new SearchTiendasOnlineRequestDto();
      when(peopleAclMapper.toSearchTiendasOnlineRequestDto(request)).thenReturn(restRequest);

      service.searchTiendasOnline(request);

      verify(peopleAclMapper, times(1)).toSearchTiendasOnlineRequestDto(request);
      verify(tiendasOnlineApi, times(1)).searchTiendasOnline(restRequestCaptor.capture());
      assertThat(restRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
      SearchTiendasOnlineRequestDto restRequest = new SearchTiendasOnlineRequestDto();
      SearchTiendasOnlineResponseDto restResponse = new SearchTiendasOnlineResponseDto();
      when(peopleAclMapper.toSearchTiendasOnlineRequestDto(request)).thenReturn(restRequest);
      when(tiendasOnlineApi.searchTiendasOnline(restRequest)).thenReturn(restResponse);

      service.searchTiendasOnline(request);

      verify(peopleAclMapper, times(1)).toTiendaOnlineResponseDto(restResponse);
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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      OrigenRequestDto request = new OrigenRequestDto();
      SearchOrigenesRequestDto restRequest = new SearchOrigenesRequestDto();
      when(peopleAclMapper.toSearchOrigenesRequestDto(request)).thenReturn(restRequest);

      service.searchOrigenes(request);

      verify(peopleAclMapper, times(1)).toSearchOrigenesRequestDto(request);
      verify(origenesApi, times(1)).searchOrigenes(origenesRestRequestCaptor.capture());
      assertThat(origenesRestRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      OrigenRequestDto request = new OrigenRequestDto();
      SearchOrigenesRequestDto restRequest = new SearchOrigenesRequestDto();
      SearchOrigenesResponseDto restResponse = new SearchOrigenesResponseDto();
      when(peopleAclMapper.toSearchOrigenesRequestDto(request)).thenReturn(restRequest);
      when(origenesApi.searchOrigenes(restRequest)).thenReturn(restResponse);

      service.searchOrigenes(request);

      verify(peopleAclMapper, times(1)).toOrigenResponseDto(restResponse);
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

    @Captor
    ArgumentCaptor<SearchEmpresasRequestDto> empresasRestRequestCaptor;

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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      EmpresaRequestDto request = new EmpresaRequestDto();
      SearchEmpresasRequestDto restRequest = new SearchEmpresasRequestDto();
      when(peopleAclMapper.toSearchEmpresasRequestDto(request)).thenReturn(restRequest);

      service.searchEmpresas(request);

      verify(peopleAclMapper, times(1)).toSearchEmpresasRequestDto(request);
      verify(empresasApi, times(1)).searchEmpresas(empresasRestRequestCaptor.capture());
      assertThat(empresasRestRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      EmpresaRequestDto request = new EmpresaRequestDto();
      SearchEmpresasRequestDto restRequest = new SearchEmpresasRequestDto();
      SearchEmpresasResponseDto restResponse = new SearchEmpresasResponseDto();
      when(peopleAclMapper.toSearchEmpresasRequestDto(request)).thenReturn(restRequest);
      when(empresasApi.searchEmpresas(restRequest)).thenReturn(restResponse);

      service.searchEmpresas(request);

      verify(peopleAclMapper, times(1)).toEmpresaResponseDto(restResponse);
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

    @Captor
    ArgumentCaptor<SearchAusenciasRequestDto> ausenciasRestRequestCaptor;

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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      AusenciasRequestDto request = new AusenciasRequestDto();
      SearchAusenciasRequestDto restRequest = new SearchAusenciasRequestDto();
      when(peopleAclMapper.toSearchAusenciasRequestDto(request)).thenReturn(restRequest);

      service.getAusencias(request);

      verify(peopleAclMapper, times(1)).toSearchAusenciasRequestDto(request);
      verify(ausenciasApi, times(1)).searchAusencias(ausenciasRestRequestCaptor.capture());
      assertThat(ausenciasRestRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      AusenciasRequestDto request = new AusenciasRequestDto();
      SearchAusenciasRequestDto restRequest = new SearchAusenciasRequestDto();
      SearchAusenciasResponseDto restResponse = new SearchAusenciasResponseDto();
      when(peopleAclMapper.toSearchAusenciasRequestDto(request)).thenReturn(restRequest);
      when(ausenciasApi.searchAusencias(restRequest)).thenReturn(restResponse);

      service.getAusencias(request);

      verify(peopleAclMapper, times(1)).toAusenciasResponseDto(restResponse);
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

    @Captor
    ArgumentCaptor<SearchConfVentaOnlineRequestDto> confVentaRestRequestCaptor;

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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
      SearchConfVentaOnlineRequestDto restRequest = new SearchConfVentaOnlineRequestDto();
      when(peopleAclMapper.toSearchConfVentaOnlineRequestDto(request)).thenReturn(restRequest);

      service.getConfVentaOnline(request);

      verify(peopleAclMapper, times(1)).toSearchConfVentaOnlineRequestDto(request);
      verify(configuracionVentaApi, times(1)).searchConfVentaOnline(confVentaRestRequestCaptor.capture());
      assertThat(confVentaRestRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
      SearchConfVentaOnlineRequestDto restRequest = new SearchConfVentaOnlineRequestDto();
      SearchConfVentaOnlineResponseDto restResponse = new SearchConfVentaOnlineResponseDto();
      when(peopleAclMapper.toSearchConfVentaOnlineRequestDto(request)).thenReturn(restRequest);
      when(configuracionVentaApi.searchConfVentaOnline(restRequest)).thenReturn(restResponse);

      service.getConfVentaOnline(request);

      verify(peopleAclMapper, times(1)).toConfiguracionVentaOnlineResponseDto(restResponse);
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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      TiendasRequestDto request = new TiendasRequestDto();
      SearchTiendasIncomeRequestDto restRequest = new SearchTiendasIncomeRequestDto();
      when(peopleAclMapper.toSearchTiendasIncomeRequestDto(request)).thenReturn(restRequest);

      service.getTiendas(request);

      verify(peopleAclMapper, times(1)).toSearchTiendasIncomeRequestDto(request);
      verify(tiendasIncomeApi, times(1)).searchTiendasIncome(tiendasIncomeRestRequestCaptor.capture());
      assertThat(tiendasIncomeRestRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      TiendasRequestDto request = new TiendasRequestDto();
      SearchTiendasIncomeRequestDto restRequest = new SearchTiendasIncomeRequestDto();
      SearchTiendasIncomeResponseDto restResponse = new SearchTiendasIncomeResponseDto();
      when(peopleAclMapper.toSearchTiendasIncomeRequestDto(request)).thenReturn(restRequest);
      when(tiendasIncomeApi.searchTiendasIncome(restRequest)).thenReturn(restResponse);

      service.getTiendas(request);

      verify(peopleAclMapper, times(1)).toTiendasResponseDto(restResponse);
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

    @Captor
    ArgumentCaptor<SearchConfProductoVentaRequestDto> confProductoVentaRestRequestCaptor;

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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
      SearchConfProductoVentaRequestDto restRequest = new SearchConfProductoVentaRequestDto();
      when(peopleAclMapper.toSearchConfProductoVentaRequestDto(request)).thenReturn(restRequest);

      service.getConfiguracionProductoVenta(request);

      verify(peopleAclMapper, times(1)).toSearchConfProductoVentaRequestDto(request);
      verify(configuracionVentaApi, times(1)).searchConfProductoVenta(confProductoVentaRestRequestCaptor.capture());
      assertThat(confProductoVentaRestRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
      SearchConfProductoVentaRequestDto restRequest = new SearchConfProductoVentaRequestDto();
      SearchConfProductoVentaResponseDto restResponse = new SearchConfProductoVentaResponseDto();
      when(peopleAclMapper.toSearchConfProductoVentaRequestDto(request)).thenReturn(restRequest);
      when(configuracionVentaApi.searchConfProductoVenta(restRequest)).thenReturn(restResponse);

      service.getConfiguracionProductoVenta(request);

      verify(peopleAclMapper, times(1)).toConfiguracionProductoVentaResponseDto(restResponse);
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

    @Captor
    ArgumentCaptor<SearchFlagCalculaRequestDto> flagCalculaRestRequestCaptor;

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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      FlagCalculaRequestDto request = new FlagCalculaRequestDto();
      SearchFlagCalculaRequestDto restRequest = new SearchFlagCalculaRequestDto();
      when(peopleAclMapper.toSearchFlagCalculaRequestDto(request)).thenReturn(restRequest);

      service.getFlagCalcula(request);

      verify(peopleAclMapper, times(1)).toSearchFlagCalculaRequestDto(request);
      verify(flagCalculaApi, times(1)).searchFlagCalcula(flagCalculaRestRequestCaptor.capture());
      assertThat(flagCalculaRestRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      FlagCalculaRequestDto request = new FlagCalculaRequestDto();
      SearchFlagCalculaRequestDto restRequest = new SearchFlagCalculaRequestDto();
      SearchFlagCalculaResponseDto restResponse = new SearchFlagCalculaResponseDto();
      when(peopleAclMapper.toSearchFlagCalculaRequestDto(request)).thenReturn(restRequest);
      when(flagCalculaApi.searchFlagCalcula(restRequest)).thenReturn(restResponse);

      service.getFlagCalcula(request);

      verify(peopleAclMapper, times(1)).toFlagCalculaResponseDto(restResponse);
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

    @Captor
    ArgumentCaptor<SearchCoeficienteJornadaRequestDto> coefJornadaRestRequestCaptor;

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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      CoefJornadaRequestDto request = new CoefJornadaRequestDto();
      SearchCoeficienteJornadaRequestDto restRequest = new SearchCoeficienteJornadaRequestDto();
      when(peopleAclMapper.toSearchCoeficienteJornadaRequestDto(request)).thenReturn(restRequest);

      service.getCoefJornada(request);

      verify(peopleAclMapper, times(1)).toSearchCoeficienteJornadaRequestDto(request);
      verify(coeficientesJornadaApi, times(1)).searchCoeficientesJornada(coefJornadaRestRequestCaptor.capture());
      assertThat(coefJornadaRestRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      CoefJornadaRequestDto request = new CoefJornadaRequestDto();
      SearchCoeficienteJornadaRequestDto restRequest = new SearchCoeficienteJornadaRequestDto();
      SearchCoeficienteJornadaResponseDto restResponse = new SearchCoeficienteJornadaResponseDto();
      when(peopleAclMapper.toSearchCoeficienteJornadaRequestDto(request)).thenReturn(restRequest);
      when(coeficientesJornadaApi.searchCoeficientesJornada(restRequest)).thenReturn(restResponse);

      service.getCoefJornada(request);

      verify(peopleAclMapper, times(1)).toCoefJornadaResponseDto(restResponse);
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

    @Captor
    ArgumentCaptor<SearchPresenciaManualRequestDto> presenciaManualRestRequestCaptor;

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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      PresenciaManualRequestDto request = new PresenciaManualRequestDto();
      SearchPresenciaManualRequestDto restRequest = new SearchPresenciaManualRequestDto();
      when(peopleAclMapper.toSearchPresenciaManualRequestDto(request)).thenReturn(restRequest);

      service.getPresenciaManual(request);

      verify(peopleAclMapper, times(1)).toSearchPresenciaManualRequestDto(request);
      verify(presenciasManualApi, times(1)).searchPresenciasManual(presenciaManualRestRequestCaptor.capture());
      assertThat(presenciaManualRestRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      PresenciaManualRequestDto request = new PresenciaManualRequestDto();
      SearchPresenciaManualRequestDto restRequest = new SearchPresenciaManualRequestDto();
      SearchPresenciaManualResponseDto restResponse = new SearchPresenciaManualResponseDto();
      when(peopleAclMapper.toSearchPresenciaManualRequestDto(request)).thenReturn(restRequest);
      when(presenciasManualApi.searchPresenciasManual(restRequest)).thenReturn(restResponse);

      service.getPresenciaManual(request);

      verify(peopleAclMapper, times(1)).toPresenciaManualResponseDto(restResponse);
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

    @Captor
    ArgumentCaptor<SearchEmpleadosDesplazadosRequestDto> empleadosDesplazadosRestRequestCaptor;

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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
      SearchEmpleadosDesplazadosRequestDto restRequest = new SearchEmpleadosDesplazadosRequestDto();
      when(peopleAclMapper.toSearchEmpleadosDesplazadosRequestDto(request)).thenReturn(restRequest);

      service.getEmpleadosDesplazamiento(request);

      verify(peopleAclMapper, times(1)).toSearchEmpleadosDesplazadosRequestDto(request);
      verify(empleadosDesplazadosApi, times(1)).searchEmpleadosDesplazados(empleadosDesplazadosRestRequestCaptor.capture());
      assertThat(empleadosDesplazadosRestRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
      SearchEmpleadosDesplazadosRequestDto restRequest = new SearchEmpleadosDesplazadosRequestDto();
      SearchEmpleadosDesplazadosResponseDto restResponse = new SearchEmpleadosDesplazadosResponseDto();
      when(peopleAclMapper.toSearchEmpleadosDesplazadosRequestDto(request)).thenReturn(restRequest);
      when(empleadosDesplazadosApi.searchEmpleadosDesplazados(restRequest)).thenReturn(restResponse);

      service.getEmpleadosDesplazamiento(request);

      verify(peopleAclMapper, times(1)).toEmpleadosDesplazamientoResponseDto(restResponse);
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

    @Captor
    ArgumentCaptor<SearchEmpleadosPresenciaRequestDto> empleadosPresenciaRestRequestCaptor;

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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
      SearchEmpleadosPresenciaRequestDto restRequest = new SearchEmpleadosPresenciaRequestDto();
      when(peopleAclMapper.toSearchEmpleadosPresenciaRequestDto(request)).thenReturn(restRequest);

      service.getEmpleadosPresencia(request);

      verify(peopleAclMapper, times(1)).toSearchEmpleadosPresenciaRequestDto(request);
      verify(empleadosPresenciaApi, times(1)).searchEmpleadosPresencia(empleadosPresenciaRestRequestCaptor.capture());
      assertThat(empleadosPresenciaRestRequestCaptor.getValue()).isSameAs(restRequest);
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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      PresupuestosWlocRequestDto request = new PresupuestosWlocRequestDto();
      SearchPresupuestosWlocRequestDto restRequest = new SearchPresupuestosWlocRequestDto();
      when(peopleAclMapper.toSearchPresupuestosWlocRequestDto(request)).thenReturn(restRequest);

      service.getPresupuestosWloc(request);

      verify(peopleAclMapper, times(1)).toSearchPresupuestosWlocRequestDto(request);
      verify(presupuestosApi, times(1)).searchPresupuestosWloc(restRequest);
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

    @Captor
    ArgumentCaptor<SearchVentasCongeladasRequestDto> ventasCongeladasRestRequestCaptor;

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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      VentaCongeladaRequestDto request = new VentaCongeladaRequestDto();
      SearchVentasCongeladasRequestDto restRequest = new SearchVentasCongeladasRequestDto();
      when(peopleAclMapper.toSearchVentasCongeladasRequestDto(request)).thenReturn(restRequest);

      service.getVentaCongelada(request);

      verify(peopleAclMapper, times(1)).toSearchVentasCongeladasRequestDto(request);
      verify(ventasCongeladasApi, times(1)).searchVentasCongeladas(ventasCongeladasRestRequestCaptor.capture());
      assertThat(ventasCongeladasRestRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      VentaCongeladaRequestDto request = new VentaCongeladaRequestDto();
      SearchVentasCongeladasRequestDto restRequest = new SearchVentasCongeladasRequestDto();
      SearchVentasCongeladasResponseDto restResponse = new SearchVentasCongeladasResponseDto();
      when(peopleAclMapper.toSearchVentasCongeladasRequestDto(request)).thenReturn(restRequest);
      when(ventasCongeladasApi.searchVentasCongeladas(restRequest)).thenReturn(restResponse);

      service.getVentaCongelada(request);

      verify(peopleAclMapper, times(1)).toVentaCongeladaResponseDto(restResponse);
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

    @Captor
    ArgumentCaptor<SearchPresenciasManualWlocRequestDto> presenciasManualWlocRestRequestCaptor;

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
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      PresenciaManualWlocRequestDto request = new PresenciaManualWlocRequestDto();
      SearchPresenciasManualWlocRequestDto restRequest = new SearchPresenciasManualWlocRequestDto();
      when(peopleAclMapper.toSearchPresenciasManualWlocRequestDto(request)).thenReturn(restRequest);

      service.getPresenciaManualWloc(request);

      verify(peopleAclMapper, times(1)).toSearchPresenciasManualWlocRequestDto(request);
      verify(presenciasManualWlocApi, times(1)).searchPresenciasManualWloc(presenciasManualWlocRestRequestCaptor.capture());
      assertThat(presenciasManualWlocRestRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      PresenciaManualWlocRequestDto request = new PresenciaManualWlocRequestDto();
      SearchPresenciasManualWlocRequestDto restRequest = new SearchPresenciasManualWlocRequestDto();
      SearchPresenciasManualWlocResponseDto restResponse = new SearchPresenciasManualWlocResponseDto();
      when(peopleAclMapper.toSearchPresenciasManualWlocRequestDto(request)).thenReturn(restRequest);
      when(presenciasManualWlocApi.searchPresenciasManualWloc(restRequest)).thenReturn(restResponse);

      service.getPresenciaManualWloc(request);

      verify(peopleAclMapper, times(1)).toPresenciaManualWlocResponseDto(restResponse);
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
}
