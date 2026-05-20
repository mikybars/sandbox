package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.function.Supplier;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.util.MigrationDispatcher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Meta4IcmWsCalcIncomeSessionFacadeServiceTest {

  Meta4IcmWsCalcIncomeSessionFacadeService service;

  @Mock
  SoapMeta4IcmWsCalcIncomeSessionService soapService;

  @Mock
  PeopleAclService peopleAclService;

  @Mock
  MigrationDispatcher migrationDispatcher;

  @BeforeEach
  void beforeEach() {
    service = new Meta4IcmWsCalcIncomeSessionFacadeService(soapService, peopleAclService, migrationDispatcher);
  }

  @Nested
  class SearchTiendas {

    @Mock
    SearchTiendasRequestDto request;

    @Mock
    GenericTiendaResultItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<GenericTiendaResultItemDto> expected = List.of(resultItem);
      when(soapService.searchTiendas(request)).thenReturn(expected);

      List<GenericTiendaResultItemDto> result = service.searchTiendas(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).searchTiendas(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetTiendas {

    @Mock
    TiendasRequestDto request;

    @Mock
    GenericTiendaResultItemDto resultItem;

    @Mock
    TiendasResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<GenericTiendaResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<GenericTiendaResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<GenericTiendaResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getTiendas"), any(), any(), any())).thenReturn(expected);

      List<GenericTiendaResultItemDto> result = service.getTiendas(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getTiendas"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      List<GenericTiendaResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.getTiendas(request)).thenReturn(restResponse);

      service.getTiendas(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getTiendas"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(), any());
      List<GenericTiendaResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).getTiendas(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<GenericTiendaResultItemDto> soapData = List.of(resultItem);
      when(soapService.getTiendas(request)).thenReturn(soapData);

      service.getTiendas(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getTiendas"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(), any());
      List<GenericTiendaResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getTiendas(request);
    }
  }

  @Nested
  class SearchEmpleados {

    @Mock
    SearchEmpleadosRequestDto request;

    @Mock
    GenericEmpleadoResultItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<GenericEmpleadoResultItemDto> expected = List.of(resultItem);
      when(soapService.searchEmpleados(request)).thenReturn(expected);

      List<GenericEmpleadoResultItemDto> result = service.searchEmpleados(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).searchEmpleados(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetEmpleados {

    @Mock
    EmpleadosRequestDto request;

    @Mock
    GenericEmpleadoResultItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<GenericEmpleadoResultItemDto> expected = List.of(resultItem);
      when(soapService.getEmpleados(request)).thenReturn(expected);

      List<GenericEmpleadoResultItemDto> result = service.getEmpleados(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).getEmpleados(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class TiendaOnline {

    @Mock
    TiendaOnlineRequestDto request;

    @Mock
    TiendaOnlineResultItemDto resultItem;

    @Mock
    TiendaOnlineResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<TiendaOnlineResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<TiendaOnlineResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<TiendaOnlineResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("tiendaOnline"), any(), any(), any())).thenReturn(expected);

      List<TiendaOnlineResultItemDto> result = service.tiendaOnline(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("tiendaOnline"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      List<TiendaOnlineResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.searchTiendasOnline(request)).thenReturn(restResponse);

      service.tiendaOnline(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("tiendaOnline"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(), any());
      List<TiendaOnlineResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).searchTiendasOnline(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<TiendaOnlineResultItemDto> soapData = List.of(resultItem);
      when(soapService.tiendaOnline(request)).thenReturn(soapData);

      service.tiendaOnline(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("tiendaOnline"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(), any());
      List<TiendaOnlineResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).tiendaOnline(request);
    }
  }

  @Nested
  class GetPeriodos {

    @Mock
    PeriodosRequestDto request;

    @Mock
    PeriodosResultItemDto resultItem;

    @Mock
    PeriodosResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<PeriodosResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<PeriodosResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<PeriodosResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getPeriodos"), any(), any(), any())).thenReturn(expected);

      List<PeriodosResultItemDto> result = service.getPeriodos(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getPeriodos"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      List<PeriodosResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.searchPeriodos(request)).thenReturn(restResponse);

      service.getPeriodos(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPeriodos"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(), any());
      List<PeriodosResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).searchPeriodos(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<PeriodosResultItemDto> soapData = List.of(resultItem);
      when(soapService.getPeriodos(request)).thenReturn(soapData);

      service.getPeriodos(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPeriodos"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(), any());
      List<PeriodosResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getPeriodos(request);
    }
  }

  @Nested
  class GetEmpleadosPresencia {

    @Mock
    EmpleadosPresenciaRequestDto request;

    @Mock
    GenericEmpleadoResultItemDto resultItem;

    @Mock
    EmpleadosPresenciaResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<GenericEmpleadoResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<GenericEmpleadoResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<GenericEmpleadoResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getEmpleadosPresencia"), any(), any(), any())).thenReturn(expected);

      List<GenericEmpleadoResultItemDto> result = service.getEmpleadosPresencia(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpleadosPresencia"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclServiceAndUnwrapsData() {
      List<GenericEmpleadoResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.getEmpleadosPresencia(request)).thenReturn(restResponse);

      service.getEmpleadosPresencia(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpleadosPresencia"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(),
          eq(request));
      List<GenericEmpleadoResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).getEmpleadosPresencia(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<GenericEmpleadoResultItemDto> soapData = List.of(resultItem);
      when(soapService.getEmpleadosPresencia(request)).thenReturn(soapData);

      service.getEmpleadosPresencia(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpleadosPresencia"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(),
          eq(request));
      List<GenericEmpleadoResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getEmpleadosPresencia(request);
    }
  }

  @Nested
  class GetPresenciaManual {

    @Mock
    PresenciaManualRequestDto request;

    @Mock
    GenericEmpleadoResultItemDto resultItem;

    @Mock
    PresenciaManualResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<GenericEmpleadoResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<GenericEmpleadoResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<GenericEmpleadoResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getPresenciaManual"), any(), any(), any())).thenReturn(expected);

      List<GenericEmpleadoResultItemDto> result = service.getPresenciaManual(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getPresenciaManual"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclServiceAndUnwrapsData() {
      List<GenericEmpleadoResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.getPresenciaManual(request)).thenReturn(restResponse);

      service.getPresenciaManual(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPresenciaManual"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      List<GenericEmpleadoResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).getPresenciaManual(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<GenericEmpleadoResultItemDto> soapData = List.of(resultItem);
      when(soapService.getPresenciaManual(request)).thenReturn(soapData);

      service.getPresenciaManual(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPresenciaManual"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      List<GenericEmpleadoResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getPresenciaManual(request);
    }
  }

  @Nested
  class GetCoefJornada {

    @Mock
    CoefJornadaRequestDto request;

    @Mock
    GenericEmpleadoResultItemDto resultItem;

    @Mock
    CoefJornadaResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<GenericEmpleadoResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<GenericEmpleadoResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<GenericEmpleadoResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getCoefJornada"), any(), any(), any())).thenReturn(expected);

      List<GenericEmpleadoResultItemDto> result = service.getCoefJornada(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getCoefJornada"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclServiceAndUnwrapsData() {
      List<GenericEmpleadoResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.getCoefJornada(request)).thenReturn(restResponse);

      service.getCoefJornada(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getCoefJornada"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          any());
      List<GenericEmpleadoResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).getCoefJornada(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<GenericEmpleadoResultItemDto> soapData = List.of(resultItem);
      when(soapService.getCoefJornada(request)).thenReturn(soapData);

      service.getCoefJornada(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getCoefJornada"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          any());
      List<GenericEmpleadoResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getCoefJornada(request);
    }
  }

  @Nested
  class GetFestivos {

    @Mock
    FestivosRequestDto request;

    @Mock
    GenericTiendaResultItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<GenericTiendaResultItemDto> expected = List.of(resultItem);
      when(soapService.getFestivos(request)).thenReturn(expected);

      List<GenericTiendaResultItemDto> result = service.getFestivos(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).getFestivos(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetFlagCalcula {

    @Mock
    FlagCalculaRequestDto request;

    @Mock
    GenericTiendaResultItemDto resultItem;

    @Mock
    FlagCalculaResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<GenericTiendaResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<GenericTiendaResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<GenericTiendaResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getFlagCalcula"), any(), any(), any())).thenReturn(expected);

      List<GenericTiendaResultItemDto> result = service.getFlagCalcula(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getFlagCalcula"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      List<GenericTiendaResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.getFlagCalcula(request)).thenReturn(restResponse);

      service.getFlagCalcula(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getFlagCalcula"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          any());
      List<GenericTiendaResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).getFlagCalcula(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<GenericTiendaResultItemDto> soapData = List.of(resultItem);
      when(soapService.getFlagCalcula(request)).thenReturn(soapData);

      service.getFlagCalcula(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getFlagCalcula"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          any());
      List<GenericTiendaResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getFlagCalcula(request);
    }
  }

  @Nested
  class GetConfiguracionVentaOnline {

    @Mock
    ConfiguracionVentaOnlineRequestDto request;

    @Mock
    ConfiguracionVentaOnlineResultItemDto resultItem;

    @Mock
    ConfiguracionVentaOnlineResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<ConfiguracionVentaOnlineResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<ConfiguracionVentaOnlineResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<ConfiguracionVentaOnlineResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getConfiguracionVentaOnline"), any(), any(), any())).thenReturn(expected);

      List<ConfiguracionVentaOnlineResultItemDto> result = service.getConfiguracionVentaOnline(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getConfiguracionVentaOnline"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      List<ConfiguracionVentaOnlineResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.getConfVentaOnline(request)).thenReturn(restResponse);

      service.getConfiguracionVentaOnline(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getConfiguracionVentaOnline"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), any());
      List<ConfiguracionVentaOnlineResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).getConfVentaOnline(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<ConfiguracionVentaOnlineResultItemDto> soapData = List.of(resultItem);
      when(soapService.getConfiguracionVentaOnline(request)).thenReturn(soapData);

      service.getConfiguracionVentaOnline(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getConfiguracionVentaOnline"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), any());
      List<ConfiguracionVentaOnlineResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getConfiguracionVentaOnline(request);
    }
  }

  @Nested
  class GetAgrupacionesOnline {

    @Mock
    AgrupOnlineRequestDto request;

    @Mock
    AgrupOnlineResultItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<AgrupOnlineResultItemDto> expected = List.of(resultItem);
      when(soapService.getAgrupacionesOnline(request)).thenReturn(expected);

      List<AgrupOnlineResultItemDto> result = service.getAgrupacionesOnline(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).getAgrupacionesOnline(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetEmpresa {

    @Mock
    EmpresaRequestDto request;

    @Mock
    EmpresaResultItemDto resultItem;

    @Mock
    com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<EmpresaResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<EmpresaResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<EmpresaResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getEmpresa"), any(), any(), any())).thenReturn(expected);

      List<EmpresaResultItemDto> result = service.getEmpresa(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpresa"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclServiceAndUnwrapsData() {
      List<EmpresaResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.searchEmpresas(request)).thenReturn(restResponse);

      service.getEmpresa(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpresa"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(), any());
      List<EmpresaResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).searchEmpresas(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<EmpresaResultItemDto> soapData = List.of(resultItem);
      when(soapService.getEmpresa(request)).thenReturn(soapData);

      service.getEmpresa(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpresa"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(), any());
      List<EmpresaResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getEmpresa(request);
    }
  }

  @Nested
  class GetOrigen {

    @Mock
    OrigenRequestDto request;

    @Mock
    OrigenResultItemDto resultItem;

    @Mock
    OrigenResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<OrigenResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<OrigenResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<OrigenResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getOrigen"), any(), any(), any())).thenReturn(expected);

      List<OrigenResultItemDto> result = service.getOrigen(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getOrigen"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclServiceAndUnwrapsData() {
      List<OrigenResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.searchOrigenes(request)).thenReturn(restResponse);

      service.getOrigen(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getOrigen"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(), any());
      List<OrigenResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).searchOrigenes(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<OrigenResultItemDto> soapData = List.of(resultItem);
      when(soapService.getOrigen(request)).thenReturn(soapData);

      service.getOrigen(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getOrigen"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(), any());
      List<OrigenResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getOrigen(request);
    }
  }

  @Nested
  class GetConfiguracionProductoVenta {

    @Mock
    ConfiguracionProductoVentaRequestDto request;

    @Mock
    ConfiguracionProductoVentaResultItemDto resultItem;

    @Mock
    ConfiguracionProductoVentaResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<ConfiguracionProductoVentaResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<ConfiguracionProductoVentaResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedWithRequestDtoExpectDispatcherResultReturned() {
      List<ConfiguracionProductoVentaResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getConfiguracionProductoVenta"), any(), any(), any())).thenReturn(expected);

      List<ConfiguracionProductoVentaResultItemDto> result = service.getConfiguracionProductoVenta(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getConfiguracionProductoVenta"), any(), any(), any());
    }

    @Test
    void whenInvokedWithRequestDtoExpectRestSupplierCallsPeopleAclService() {
      List<ConfiguracionProductoVentaResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.getConfiguracionProductoVenta(request)).thenReturn(restResponse);

      service.getConfiguracionProductoVenta(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getConfiguracionProductoVenta"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), any());
      List<ConfiguracionProductoVentaResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).getConfiguracionProductoVenta(request);
    }

    @Test
    void whenInvokedWithRequestDtoExpectSoapSupplierCallsSoapService() {
      List<ConfiguracionProductoVentaResultItemDto> soapData = List.of(resultItem);
      when(soapService.getConfiguracionProductoVenta(request)).thenReturn(soapData);

      service.getConfiguracionProductoVenta(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getConfiguracionProductoVenta"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), any());
      List<ConfiguracionProductoVentaResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getConfiguracionProductoVenta(request);
    }

    @Test
    void whenInvokedWithIdTareaAndOrigenExpectDispatcherResultReturned() {
      Long idTarea = 42L;
      String cclIdOrigen = "ORIG-1";
      List<ConfiguracionProductoVentaResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getConfiguracionProductoVenta"), any(), any(), any())).thenReturn(expected);

      List<ConfiguracionProductoVentaResultItemDto> result = service.getConfiguracionProductoVenta(idTarea, cclIdOrigen);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getConfiguracionProductoVenta"), any(), any(), any());
    }

    @Test
    void whenInvokedWithIdTareaAndOrigenExpectRestSupplierCallsPeopleAclService() {
      Long idTarea = 42L;
      String cclIdOrigen = "ORIG-1";
      List<ConfiguracionProductoVentaResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.getConfiguracionProductoVenta(any(ConfiguracionProductoVentaRequestDto.class))).thenReturn(restResponse);

      service.getConfiguracionProductoVenta(idTarea, cclIdOrigen);

      verify(migrationDispatcher, times(1)).dispatch(eq("getConfiguracionProductoVenta"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), any());
      List<ConfiguracionProductoVentaResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).getConfiguracionProductoVenta(any(ConfiguracionProductoVentaRequestDto.class));
    }

    @Test
    void whenInvokedWithIdTareaAndOrigenExpectSoapSupplierCallsSoapService() {
      Long idTarea = 42L;
      String cclIdOrigen = "ORIG-1";
      List<ConfiguracionProductoVentaResultItemDto> soapData = List.of(resultItem);
      when(soapService.getConfiguracionProductoVenta(idTarea, cclIdOrigen)).thenReturn(soapData);

      service.getConfiguracionProductoVenta(idTarea, cclIdOrigen);

      verify(migrationDispatcher, times(1)).dispatch(eq("getConfiguracionProductoVenta"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), any());
      List<ConfiguracionProductoVentaResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getConfiguracionProductoVenta(idTarea, cclIdOrigen);
    }
  }

  @Nested
  class GetEmpleadosDesplazamiento {

    @Mock
    EmpleadosDesplazamientoRequestDto request;

    @Mock
    GenericEmpleadoResultItemDto resultItem;

    @Mock
    EmpleadosDesplazamientoResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<GenericEmpleadoResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<GenericEmpleadoResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<GenericEmpleadoResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getEmpleadosDesplazamiento"), any(), any(), any())).thenReturn(expected);

      List<GenericEmpleadoResultItemDto> result = service.getEmpleadosDesplazamiento(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpleadosDesplazamiento"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      List<GenericEmpleadoResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.getEmpleadosDesplazamiento(request)).thenReturn(restResponse);

      service.getEmpleadosDesplazamiento(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpleadosDesplazamiento"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), any());
      List<GenericEmpleadoResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).getEmpleadosDesplazamiento(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<GenericEmpleadoResultItemDto> soapData = List.of(resultItem);
      when(soapService.getEmpleadosDesplazamiento(request)).thenReturn(soapData);

      service.getEmpleadosDesplazamiento(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpleadosDesplazamiento"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), any());
      List<GenericEmpleadoResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getEmpleadosDesplazamiento(request);
    }
  }

  @Nested
  class GetEstructurasCom {

    @Mock
    EstructurasComRequestDto request;

    @Mock
    EstructurasComResultItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<EstructurasComResultItemDto> expected = List.of(resultItem);
      when(soapService.getEstructurasCom(request)).thenReturn(expected);

      List<EstructurasComResultItemDto> result = service.getEstructurasCom(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).getEstructurasCom(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetEstructurasPol {

    @Mock
    EstructurasPolRequestDto request;

    @Mock
    EstructurasPolResultItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<EstructurasPolResultItemDto> expected = List.of(resultItem);
      when(soapService.getEstructurasPol(request)).thenReturn(expected);

      List<EstructurasPolResultItemDto> result = service.getEstructurasPol(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).getEstructurasPol(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetAusencias {

    @Mock
    AusenciasRequestDto request;

    @Mock
    AusenciasResultItemDto resultItem;

    @Mock
    AusenciasResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<AusenciasResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<AusenciasResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<AusenciasResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getAusencias"), any(), any(), any())).thenReturn(expected);

      List<AusenciasResultItemDto> result = service.getAusencias(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getAusencias"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclServiceAndUnwrapsData() {
      List<AusenciasResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.getAusencias(request)).thenReturn(restResponse);

      service.getAusencias(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getAusencias"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(), any());
      List<AusenciasResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).getAusencias(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<AusenciasResultItemDto> soapData = List.of(resultItem);
      when(soapService.getAusencias(request)).thenReturn(soapData);

      service.getAusencias(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getAusencias"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(), any());
      List<AusenciasResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getAusencias(request);
    }
  }

  @Nested
  class GetConfChallengeDiasMinimos {

    @Mock
    ConfChDiasMinimosRequestDto request;

    @Mock
    ConfChDiasMinimosResultItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<ConfChDiasMinimosResultItemDto> expected = List.of(resultItem);
      when(soapService.getConfChallengeDiasMinimos(request)).thenReturn(expected);

      List<ConfChDiasMinimosResultItemDto> result = service.getConfChallengeDiasMinimos(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).getConfChallengeDiasMinimos(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetPresupuestosWloc {

    @Mock
    PresupuestosWlocRequestDto request;

    @Mock
    PresupuestosWlocResultItemDto resultItem;

    @Mock
    com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<PresupuestosWlocResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<PresupuestosWlocResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<PresupuestosWlocResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getPresupuestosWloc"), any(), any(), any())).thenReturn(expected);

      List<PresupuestosWlocResultItemDto> result = service.getPresupuestosWloc(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getPresupuestosWloc"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclServiceAndReturnsData() {
      List<PresupuestosWlocResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.getPresupuestosWloc(request)).thenReturn(restResponse);

      service.getPresupuestosWloc(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPresupuestosWloc"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          any());
      List<PresupuestosWlocResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).getPresupuestosWloc(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<PresupuestosWlocResultItemDto> soapData = List.of(resultItem);
      when(soapService.getPresupuestosWloc(request)).thenReturn(soapData);

      service.getPresupuestosWloc(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPresupuestosWloc"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          any());
      List<PresupuestosWlocResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getPresupuestosWloc(request);
    }
  }

  @Nested
  class GetConfPrecioHora {

    @Mock
    ConfPrecioHoraRequestDto request;

    @Mock
    ConfPrecioHoraResultItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<ConfPrecioHoraResultItemDto> expected = List.of(resultItem);
      when(soapService.getConfPrecioHora(request)).thenReturn(expected);

      List<ConfPrecioHoraResultItemDto> result = service.getConfPrecioHora(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).getConfPrecioHora(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetConfChallengeTpVenta {

    @Mock
    ConfChTpVentaRequestDto request;

    @Mock
    ConfChTpVentaResultItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<ConfChTpVentaResultItemDto> expected = List.of(resultItem);
      when(soapService.getConfChallengeTpVenta(request)).thenReturn(expected);

      List<ConfChTpVentaResultItemDto> result = service.getConfChallengeTpVenta(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).getConfChallengeTpVenta(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetPresupuestosRango {

    @Mock
    PresupuestosRangoRequestDto request;

    @Mock
    PresupuestosRangoResultItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<PresupuestosRangoResultItemDto> expected = List.of(resultItem);
      when(soapService.getPresupuestosRango(request)).thenReturn(expected);

      List<PresupuestosRangoResultItemDto> result = service.getPresupuestosRango(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).getPresupuestosRango(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetVentaCongelada {

    @Mock
    VentaCongeladaRequestDto request;

    @Mock
    VentaCongeladaResultItemDto resultItem;

    @Mock
    VentaCongeladaResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<VentaCongeladaResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<VentaCongeladaResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<VentaCongeladaResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getVentaCongelada"), any(), any(), any())).thenReturn(expected);

      List<VentaCongeladaResultItemDto> result = service.getVentaCongelada(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getVentaCongelada"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      List<VentaCongeladaResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.getVentaCongelada(request)).thenReturn(restResponse);

      service.getVentaCongelada(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getVentaCongelada"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), any());
      List<VentaCongeladaResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).getVentaCongelada(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<VentaCongeladaResultItemDto> soapData = List.of(resultItem);
      when(soapService.getVentaCongelada(request)).thenReturn(soapData);

      service.getVentaCongelada(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getVentaCongelada"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), any());
      List<VentaCongeladaResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getVentaCongelada(request);
    }
  }

  @Nested
  class GetDesplazReal {

    @Mock
    DesplazamientoRealRequestDto request;

    @Mock
    DesplazamientoRealResultItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<DesplazamientoRealResultItemDto> expected = List.of(resultItem);
      when(soapService.getDesplazReal(request)).thenReturn(expected);

      List<DesplazamientoRealResultItemDto> result = service.getDesplazReal(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).getDesplazReal(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetDesplazamientoMultiempresa {

    @Mock
    DesplazamientosMultiempresaRequestDto request;

    @Mock
    DesplazamientosMultiempresaItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<DesplazamientosMultiempresaItemDto> expected = List.of(resultItem);
      when(soapService.getDesplazamientoMultiempresa(request)).thenReturn(expected);

      List<DesplazamientosMultiempresaItemDto> result = service.getDesplazamientoMultiempresa(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).getDesplazamientoMultiempresa(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetPresenciaManualWloc {

    @Mock
    PresenciaManualWlocRequestDto request;

    @Mock
    PresenciaManualWlocResultItemDto resultItem;

    @Mock
    com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResponseDto restResponse;

    @Captor
    ArgumentCaptor<Supplier<List<PresenciaManualWlocResultItemDto>>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<List<PresenciaManualWlocResultItemDto>>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      List<PresenciaManualWlocResultItemDto> expected = List.of(resultItem);
      when(migrationDispatcher.dispatch(eq("getPresenciaManualWloc"), any(), any(), any())).thenReturn(expected);

      List<PresenciaManualWlocResultItemDto> result = service.getPresenciaManualWloc(request);

      assertThat(result).isSameAs(expected);
      verify(migrationDispatcher, times(1)).dispatch(eq("getPresenciaManualWloc"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclServiceAndUnwrapsData() {
      List<PresenciaManualWlocResultItemDto> restData = List.of(resultItem);
      when(restResponse.getData()).thenReturn(restData);
      when(peopleAclService.getPresenciaManualWloc(request)).thenReturn(restResponse);

      service.getPresenciaManualWloc(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPresenciaManualWloc"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), any());
      List<PresenciaManualWlocResultItemDto> restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restData);
      verify(peopleAclService, times(1)).getPresenciaManualWloc(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      List<PresenciaManualWlocResultItemDto> soapData = List.of(resultItem);
      when(soapService.getPresenciaManualWloc(request)).thenReturn(soapData);

      service.getPresenciaManualWloc(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPresenciaManualWloc"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), any());
      List<PresenciaManualWlocResultItemDto> soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapData);
      verify(soapService, times(1)).getPresenciaManualWloc(request);
    }
  }

  @Nested
  class GetVentaManualWloc {

    @Mock
    VentaManualWlocRequestDto request;

    @Mock
    VentaManualWlocResultItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<VentaManualWlocResultItemDto> expected = List.of(resultItem);
      when(soapService.getVentaManualWloc(request)).thenReturn(expected);

      List<VentaManualWlocResultItemDto> result = service.getVentaManualWloc(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).getVentaManualWloc(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetEstadoWloc {

    @Mock
    EstadoWlocRequestDto request;

    @Mock
    EstadoWlocResultItemDto resultItem;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      List<EstadoWlocResultItemDto> expected = List.of(resultItem);
      when(soapService.getEstadoWloc(request)).thenReturn(expected);

      List<EstadoWlocResultItemDto> result = service.getEstadoWloc(request);

      assertThat(result).isSameAs(expected);
      verify(soapService, times(1)).getEstadoWloc(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

}
