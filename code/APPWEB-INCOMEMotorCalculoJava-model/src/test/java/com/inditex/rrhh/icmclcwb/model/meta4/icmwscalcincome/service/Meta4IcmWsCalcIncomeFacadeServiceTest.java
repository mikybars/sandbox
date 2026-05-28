package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.function.Supplier;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResponseDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.util.MigrationDispatcher;
import com.inditex.rrhh.icmclcwb.model.primary.calculocomisiones.service.CalculoComisionesService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Meta4IcmWsCalcIncomeFacadeServiceTest {

  Meta4IcmWsCalcIncomeFacadeService service;

  @Mock
  SoapMeta4IcmWsCalcIncomeService soapService;

  @Mock
  PeopleAclService peopleAclService;

  @Mock
  MigrationDispatcher migrationDispatcher;

  @Mock
  CalculoComisionesService calculoComisionesService;

  @BeforeEach
  void beforeEach() {
    service = new Meta4IcmWsCalcIncomeFacadeService(soapService, peopleAclService, migrationDispatcher, calculoComisionesService);
  }

  @Nested
  class SearchTiendas {

    @Mock
    SearchTiendasRequestDto request;

    @Mock
    SearchTiendasResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.searchTiendas(request)).thenReturn(response);

      SearchTiendasResponseDto result = service.searchTiendas(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).searchTiendas(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetTiendas {

    @Mock
    TiendasRequestDto request;

    @Mock
    TiendasResponseDto response;

    @Mock
    TiendasResponseDto restResponse;

    @Mock
    TiendasResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<TiendasResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<TiendasResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getTiendas"), any(), any(), eq(request))).thenReturn(response);

      TiendasResponseDto result = service.getTiendas(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getTiendas"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.getTiendas(request)).thenReturn(restResponse);

      service.getTiendas(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getTiendas"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      TiendasResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).getTiendas(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getTiendas(request)).thenReturn(soapResponse);

      service.getTiendas(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getTiendas"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      TiendasResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getTiendas(request);
    }
  }

  @Nested
  class SearchEmpleados {

    @Mock
    SearchEmpleadosRequestDto request;

    @Mock
    SearchEmpleadosResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.searchEmpleados(request)).thenReturn(response);

      SearchEmpleadosResponseDto result = service.searchEmpleados(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).searchEmpleados(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetEmpleados {

    @Mock
    EmpleadosRequestDto request;

    @Mock
    EmpleadosResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getEmpleados(request)).thenReturn(response);

      EmpleadosResponseDto result = service.getEmpleados(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getEmpleados(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetPresenciaManual {

    @Mock
    PresenciaManualRequestDto request;

    @Mock
    PresenciaManualResponseDto response;

    @Mock
    PresenciaManualResponseDto restResponse;

    @Mock
    PresenciaManualResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<PresenciaManualResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<PresenciaManualResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getPresenciaManual"), any(), any(), any())).thenReturn(response);

      PresenciaManualResponseDto result = service.getPresenciaManual(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getPresenciaManual"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.getPresenciaManual(request)).thenReturn(restResponse);

      service.getPresenciaManual(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPresenciaManual"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      PresenciaManualResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).getPresenciaManual(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getPresenciaManual(request)).thenReturn(soapResponse);

      service.getPresenciaManual(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPresenciaManual"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      PresenciaManualResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getPresenciaManual(request);
    }
  }

  @Nested
  class GetEmpleadosPresencia {

    @Mock
    EmpleadosPresenciaRequestDto request;

    @Mock
    EmpleadosPresenciaResponseDto response;

    @Mock
    EmpleadosPresenciaResponseDto restResponse;

    @Mock
    EmpleadosPresenciaResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<EmpleadosPresenciaResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<EmpleadosPresenciaResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getEmpleadosPresencia"), any(), any(), any())).thenReturn(response);

      EmpleadosPresenciaResponseDto result = service.getEmpleadosPresencia(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpleadosPresencia"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.getEmpleadosPresencia(request)).thenReturn(restResponse);

      service.getEmpleadosPresencia(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpleadosPresencia"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(),
          eq(request));
      EmpleadosPresenciaResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).getEmpleadosPresencia(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getEmpleadosPresencia(request)).thenReturn(soapResponse);

      service.getEmpleadosPresencia(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpleadosPresencia"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(),
          eq(request));
      EmpleadosPresenciaResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getEmpleadosPresencia(request);
    }
  }

  @Nested
  class GetPeriodos {

    @Mock
    PeriodosRequestDto request;

    @Mock
    PeriodosResponseDto response;

    @Mock
    PeriodosResponseDto restResponse;

    @Mock
    PeriodosResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<PeriodosResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<PeriodosResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getPeriodos"), any(), any(), eq(request))).thenReturn(response);

      PeriodosResponseDto result = service.getPeriodos(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getPeriodos"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.searchPeriodos(request)).thenReturn(restResponse);

      service.getPeriodos(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPeriodos"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      PeriodosResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).searchPeriodos(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getPeriodos(request)).thenReturn(soapResponse);

      service.getPeriodos(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPeriodos"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      PeriodosResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getPeriodos(request);
    }
  }

  @Nested
  class GetFestivos {

    @Mock
    FestivosRequestDto request;

    @Mock
    FestivosResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getFestivos(request)).thenReturn(response);

      FestivosResponseDto result = service.getFestivos(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getFestivos(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetCoefJornada {

    @Mock
    CoefJornadaRequestDto request;

    @Mock
    CoefJornadaResponseDto response;

    @Mock
    CoefJornadaResponseDto restResponse;

    @Mock
    CoefJornadaResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<CoefJornadaResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<CoefJornadaResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getCoefJornada"), any(), any(), eq(request))).thenReturn(response);

      CoefJornadaResponseDto result = service.getCoefJornada(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getCoefJornada"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.getCoefJornada(request)).thenReturn(restResponse);

      service.getCoefJornada(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getCoefJornada"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      CoefJornadaResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).getCoefJornada(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getCoefJornada(request)).thenReturn(soapResponse);

      service.getCoefJornada(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getCoefJornada"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      CoefJornadaResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getCoefJornada(request);
    }
  }

  @Nested
  class GetFlagCalcula {

    @Mock
    FlagCalculaRequestDto request;

    @Mock
    FlagCalculaResponseDto response;

    @Mock
    FlagCalculaResponseDto restResponse;

    @Mock
    FlagCalculaResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<FlagCalculaResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<FlagCalculaResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getFlagCalcula"), any(), any(), eq(request))).thenReturn(response);

      FlagCalculaResponseDto result = service.getFlagCalcula(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getFlagCalcula"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.getFlagCalcula(request)).thenReturn(restResponse);

      service.getFlagCalcula(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getFlagCalcula"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      FlagCalculaResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).getFlagCalcula(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getFlagCalcula(request)).thenReturn(soapResponse);

      service.getFlagCalcula(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getFlagCalcula"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      FlagCalculaResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getFlagCalcula(request);
    }
  }

  @Nested
  class GetAgrupOnline {

    @Mock
    AgrupOnlineRequestDto request;

    @Mock
    AgrupOnlineResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getAgrupOnline(request)).thenReturn(response);

      AgrupOnlineResponseDto result = service.getAgrupOnline(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getAgrupOnline(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetConfVentaOnline {

    @Mock
    ConfiguracionVentaOnlineRequestDto request;

    @Mock
    ConfiguracionVentaOnlineResponseDto response;

    @Mock
    ConfiguracionVentaOnlineResponseDto restResponse;

    @Mock
    ConfiguracionVentaOnlineResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<ConfiguracionVentaOnlineResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<ConfiguracionVentaOnlineResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getConfVentaOnline"), any(), any(), eq(request))).thenReturn(response);

      ConfiguracionVentaOnlineResponseDto result = service.getConfVentaOnline(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getConfVentaOnline"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.getConfVentaOnline(request)).thenReturn(restResponse);

      service.getConfVentaOnline(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getConfVentaOnline"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      ConfiguracionVentaOnlineResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).getConfVentaOnline(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getConfVentaOnline(request)).thenReturn(soapResponse);

      service.getConfVentaOnline(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getConfVentaOnline"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      ConfiguracionVentaOnlineResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getConfVentaOnline(request);
    }
  }

  @Nested
  class GetTiendasOnline {

    @Mock
    TiendaOnlineRequestDto request;

    @Mock
    TiendaOnlineResponseDto response;

    @Mock
    TiendaOnlineResponseDto restResponse;

    @Mock
    TiendaOnlineResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<TiendaOnlineResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<TiendaOnlineResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getTiendasOnline"), any(), any(), eq(request))).thenReturn(response);

      TiendaOnlineResponseDto result = service.getTiendasOnline(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getTiendasOnline"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.searchTiendasOnline(request)).thenReturn(restResponse);

      service.getTiendasOnline(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getTiendasOnline"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      TiendaOnlineResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).searchTiendasOnline(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getTiendasOnline(request)).thenReturn(soapResponse);

      service.getTiendasOnline(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getTiendasOnline"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      TiendaOnlineResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getTiendasOnline(request);
    }
  }

  @Nested
  class GetConfiguracionProductoVenta {

    @Mock
    ConfiguracionProductoVentaRequestDto request;

    @Mock
    ConfiguracionProductoVentaResponseDto response;

    @Mock
    ConfiguracionProductoVentaResponseDto restResponse;

    @Mock
    ConfiguracionProductoVentaResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<ConfiguracionProductoVentaResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<ConfiguracionProductoVentaResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getConfiguracionProductoVenta"), any(), any(), eq(request))).thenReturn(response);

      ConfiguracionProductoVentaResponseDto result = service.getConfiguracionProductoVenta(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getConfiguracionProductoVenta"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.getConfiguracionProductoVenta(request)).thenReturn(restResponse);

      service.getConfiguracionProductoVenta(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getConfiguracionProductoVenta"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), eq(request));
      ConfiguracionProductoVentaResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).getConfiguracionProductoVenta(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getConfiguracionProductoVenta(request)).thenReturn(soapResponse);

      service.getConfiguracionProductoVenta(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getConfiguracionProductoVenta"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), eq(request));
      ConfiguracionProductoVentaResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getConfiguracionProductoVenta(request);
    }
  }

  @Nested
  class GetCadena {

    @Mock
    CadenaRequestDto request;

    @Mock
    CadenaResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getCadena(request)).thenReturn(response);

      CadenaResponseDto result = service.getCadena(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getCadena(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetEmpresa {

    @Mock
    EmpresaRequestDto request;

    @Mock
    EmpresaResponseDto response;

    @Mock
    EmpresaResponseDto restResponse;

    @Mock
    EmpresaResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<EmpresaResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<EmpresaResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getEmpresa"), any(), any(), eq(request))).thenReturn(response);

      EmpresaResponseDto result = service.getEmpresa(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpresa"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.searchEmpresas(request)).thenReturn(restResponse);

      service.getEmpresa(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpresa"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      EmpresaResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).searchEmpresas(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getEmpresa(request)).thenReturn(soapResponse);

      service.getEmpresa(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpresa"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      EmpresaResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getEmpresa(request);
    }
  }

  @Nested
  class GetOrigen {

    @Mock
    OrigenRequestDto request;

    @Mock
    OrigenResponseDto response;

    @Mock
    OrigenResponseDto restResponse;

    @Mock
    OrigenResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<OrigenResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<OrigenResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getOrigen"), any(), any(), eq(request))).thenReturn(response);

      OrigenResponseDto result = service.getOrigen(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getOrigen"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.searchOrigenes(request)).thenReturn(restResponse);

      service.getOrigen(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getOrigen"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      OrigenResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).searchOrigenes(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getOrigen(request)).thenReturn(soapResponse);

      service.getOrigen(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getOrigen"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      OrigenResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getOrigen(request);
    }
  }

  @Nested
  class GetEmpleadosDesplazamiento {

    @Mock
    EmpleadosDesplazamientoRequestDto request;

    @Mock
    EmpleadosDesplazamientoResponseDto response;

    @Mock
    EmpleadosDesplazamientoResponseDto restResponse;

    @Mock
    EmpleadosDesplazamientoResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<EmpleadosDesplazamientoResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<EmpleadosDesplazamientoResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getEmpleadosDesplazamiento"), any(), any(), eq(request))).thenReturn(response);

      EmpleadosDesplazamientoResponseDto result = service.getEmpleadosDesplazamiento(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpleadosDesplazamiento"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.getEmpleadosDesplazamiento(request)).thenReturn(restResponse);

      service.getEmpleadosDesplazamiento(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpleadosDesplazamiento"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), eq(request));
      EmpleadosDesplazamientoResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).getEmpleadosDesplazamiento(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getEmpleadosDesplazamiento(request)).thenReturn(soapResponse);

      service.getEmpleadosDesplazamiento(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getEmpleadosDesplazamiento"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), eq(request));
      EmpleadosDesplazamientoResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getEmpleadosDesplazamiento(request);
    }
  }

  @Nested
  class SaveProceso {

    @Mock
    SaveProcesoDto request;

    @Mock
    SaveResultDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.saveProceso(request)).thenReturn(response);

      SaveResultDto result = service.saveProceso(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).saveProceso(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetEstructurasCom {

    @Mock
    EstructurasComRequestDto request;

    @Mock
    EstructurasComResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getEstructurasCom(request)).thenReturn(response);

      EstructurasComResponseDto result = service.getEstructurasCom(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getEstructurasCom(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetEstructurasPol {

    @Mock
    EstructurasPolRequestDto request;

    @Mock
    EstructurasPolResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getEstructurasPol(request)).thenReturn(response);

      EstructurasPolResponseDto result = service.getEstructurasPol(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getEstructurasPol(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetAusencias {

    @Mock
    AusenciasRequestDto request;

    @Mock
    AusenciasResponseDto response;

    @Mock
    AusenciasResponseDto restResponse;

    @Mock
    AusenciasResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<AusenciasResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<AusenciasResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getAusencias"), any(), any(), eq(request))).thenReturn(response);

      AusenciasResponseDto result = service.getAusencias(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getAusencias"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.getAusencias(request)).thenReturn(restResponse);

      service.getAusencias(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getAusencias"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      AusenciasResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).getAusencias(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getAusencias(request)).thenReturn(soapResponse);

      service.getAusencias(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getAusencias"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      AusenciasResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getAusencias(request);
    }
  }

  @Nested
  class GetConfiguracion {

    @Mock
    ConfiguracionesRequestDto request;

    @Mock
    ConfiguracionesResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getConfiguracion(request)).thenReturn(response);

      ConfiguracionesResponseDto result = service.getConfiguracion(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getConfiguracion(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetConfChallengeDiasMinimos {

    @Mock
    ConfChDiasMinimosRequestDto request;

    @Mock
    ConfChDiasMinimosResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getConfChallengeDiasMinimos(request)).thenReturn(response);

      ConfChDiasMinimosResponseDto result = service.getConfChallengeDiasMinimos(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getConfChallengeDiasMinimos(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetPresupuestosWloc {

    @Mock
    PresupuestosWlocRequestDto request;

    @Mock
    PresupuestosWlocResponseDto response;

    @Mock
    PresupuestosWlocResponseDto restResponse;

    @Mock
    PresupuestosWlocResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<PresupuestosWlocResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<PresupuestosWlocResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getPresupuestosWloc"), any(), any(), eq(request))).thenReturn(response);

      PresupuestosWlocResponseDto result = service.getPresupuestosWloc(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getPresupuestosWloc"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.getPresupuestosWloc(request)).thenReturn(restResponse);

      service.getPresupuestosWloc(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPresupuestosWloc"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      PresupuestosWlocResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).getPresupuestosWloc(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getPresupuestosWloc(request)).thenReturn(soapResponse);

      service.getPresupuestosWloc(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPresupuestosWloc"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      PresupuestosWlocResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getPresupuestosWloc(request);
    }
  }

  @Nested
  class GetConfPrecioHora {

    @Mock
    ConfPrecioHoraRequestDto request;

    @Mock
    ConfPrecioHoraResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getConfPrecioHora(request)).thenReturn(response);

      ConfPrecioHoraResponseDto result = service.getConfPrecioHora(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getConfPrecioHora(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetConfChallengeTpVenta {

    @Mock
    ConfChTpVentaRequestDto request;

    @Mock
    ConfChTpVentaResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getConfChallengeTpVenta(request)).thenReturn(response);

      ConfChTpVentaResponseDto result = service.getConfChallengeTpVenta(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getConfChallengeTpVenta(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetPresupuestosRango {

    @Mock
    PresupuestosRangoRequestDto request;

    @Mock
    PresupuestosRangoResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getPresupuestosRango(request)).thenReturn(response);

      PresupuestosRangoResponseDto result = service.getPresupuestosRango(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getPresupuestosRango(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetVentaCongelada {

    @Mock
    VentaCongeladaRequestDto request;

    @Mock
    VentaCongeladaResponseDto response;

    @Mock
    VentaCongeladaResponseDto restResponse;

    @Mock
    VentaCongeladaResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<VentaCongeladaResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<VentaCongeladaResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getVentaCongelada"), any(), any(), eq(request))).thenReturn(response);

      VentaCongeladaResponseDto result = service.getVentaCongelada(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getVentaCongelada"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.getVentaCongelada(request)).thenReturn(restResponse);

      service.getVentaCongelada(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getVentaCongelada"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), eq(request));
      VentaCongeladaResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).getVentaCongelada(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getVentaCongelada(request)).thenReturn(soapResponse);

      service.getVentaCongelada(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getVentaCongelada"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), eq(request));
      VentaCongeladaResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getVentaCongelada(request);
    }
  }

  @Nested
  class GetDesplazReal {

    @Mock
    DesplazamientoRealRequestDto request;

    @Mock
    DesplazamientoRealResponseDto response;

    @Mock
    DesplazamientoRealResponseDto restResponse;

    @Mock
    DesplazamientoRealResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<DesplazamientoRealResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<DesplazamientoRealResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getDesplazReal"), any(), any(), eq(request))).thenReturn(response);

      DesplazamientoRealResponseDto result = service.getDesplazReal(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getDesplazReal"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.getDesplazReal(request)).thenReturn(restResponse);

      service.getDesplazReal(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getDesplazReal"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), eq(request));
      DesplazamientoRealResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).getDesplazReal(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getDesplazReal(request)).thenReturn(soapResponse);

      service.getDesplazReal(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getDesplazReal"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), eq(request));
      DesplazamientoRealResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getDesplazReal(request);
    }
  }

  @Nested
  class GetPresenciaManualWloc {

    @Mock
    PresenciaManualWlocRequestDto request;

    @Mock
    PresenciaManualWlocResponseDto response;

    @Mock
    PresenciaManualWlocResponseDto restResponse;

    @Mock
    PresenciaManualWlocResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<PresenciaManualWlocResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<PresenciaManualWlocResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getPresenciaManualWloc"), any(), any(), eq(request))).thenReturn(response);

      PresenciaManualWlocResponseDto result = service.getPresenciaManualWloc(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getPresenciaManualWloc"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.getPresenciaManualWloc(request)).thenReturn(restResponse);

      service.getPresenciaManualWloc(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPresenciaManualWloc"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), eq(request));
      PresenciaManualWlocResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).getPresenciaManualWloc(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getPresenciaManualWloc(request)).thenReturn(soapResponse);

      service.getPresenciaManualWloc(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getPresenciaManualWloc"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), eq(request));
      PresenciaManualWlocResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getPresenciaManualWloc(request);
    }
  }

  @Nested
  class GetVentaManualWloc {

    @Mock
    VentaManualWlocRequestDto request;

    @Mock
    VentaManualWlocResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getVentaManualWloc(request)).thenReturn(response);

      VentaManualWlocResponseDto result = service.getVentaManualWloc(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getVentaManualWloc(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class Sincronizacion {

    @Mock
    SincronizacionRequestDto request;

    @Mock
    SincronizacionResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.sincronizacion(request)).thenReturn(response);

      SincronizacionResponseDto result = service.sincronizacion(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).sincronizacion(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetMotivosDesplazamiento {

    @Mock
    MotivosDesplazamientoRequestDto request;

    @Mock
    MotivosDesplazamientoResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getMotivosDesplazamiento(request)).thenReturn(response);

      MotivosDesplazamientoResponseDto result = service.getMotivosDesplazamiento(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getMotivosDesplazamiento(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetSistemaDestino {

    @Mock
    SistemaDestinoRequestDto request;

    @Mock
    SistemaDestinoResponseDto response;

    @Mock
    SistemaDestinoResponseDto restResponse;

    @Mock
    SistemaDestinoResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<SistemaDestinoResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<SistemaDestinoResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getSistemaDestino"), any(), any(), eq(request))).thenReturn(response);

      SistemaDestinoResponseDto result = service.getSistemaDestino(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getSistemaDestino"), any(), any(), eq(request));
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.searchSistemasDestino(request)).thenReturn(restResponse);

      service.getSistemaDestino(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getSistemaDestino"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      SistemaDestinoResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).searchSistemasDestino(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getSistemaDestino(request)).thenReturn(soapResponse);

      service.getSistemaDestino(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getSistemaDestino"), restSupplierCaptor.capture(), soapSupplierCaptor.capture(),
          eq(request));
      SistemaDestinoResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getSistemaDestino(request);
    }
  }

  @Nested
  class GetCatalogo {

    @Mock
    CatalogoRequestDto request;

    @Mock
    CatalogoResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getCatalogo(request)).thenReturn(response);

      CatalogoResponseDto result = service.getCatalogo(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getCatalogo(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetTiposHora {

    @Mock
    TiposHoraRequestDto request;

    @Mock
    TiposHoraResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getTiposHora(request)).thenReturn(response);

      TiposHoraResponseDto result = service.getTiposHora(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getTiposHora(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetMail {

    @Mock
    UsuarioRequestDto request;

    @Mock
    UsuarioResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getMail(request)).thenReturn(response);

      UsuarioResponseDto result = service.getMail(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getMail(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetClases {

    @Mock
    ClaseRequestDto request;

    @Mock
    ClaseResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getClases(request)).thenReturn(response);

      ClaseResponseDto result = service.getClases(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getClases(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class Liquidacion {

    @Mock
    LiquidacionRequestDto request;

    @Mock
    LiquidacionResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.liquidacion(request)).thenReturn(response);

      LiquidacionResponseDto result = service.liquidacion(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).liquidacion(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class Planificacion {

    @Mock
    PlanificacionRequestDto request;

    @Mock
    PlanificacionResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.planificacion(request)).thenReturn(response);

      PlanificacionResponseDto result = service.planificacion(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).planificacion(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetEstadoWloc {

    @Mock
    EstadoWlocRequestDto request;

    @Mock
    EstadoWlocResponseDto response;

    @Test
    void whenInvokedExpectDelegateToSoapResult() {
      when(soapService.getEstadoWloc(request)).thenReturn(response);

      EstadoWlocResponseDto result = service.getEstadoWloc(request);

      assertThat(result).isSameAs(response);
      verify(soapService, times(1)).getEstadoWloc(request);
      verifyNoInteractions(peopleAclService, migrationDispatcher);
    }
  }

  @Nested
  class GetDesplazamientosMultiempresa {

    @Mock
    DesplazamientosMultiempresaRequestDto request;

    @Mock
    DesplazamientosMultiempresaResponseDto response;

    @Mock
    DesplazamientosMultiempresaResponseDto restResponse;

    @Mock
    DesplazamientosMultiempresaResponseDto soapResponse;

    @Captor
    ArgumentCaptor<Supplier<DesplazamientosMultiempresaResponseDto>> restSupplierCaptor;

    @Captor
    ArgumentCaptor<Supplier<DesplazamientosMultiempresaResponseDto>> soapSupplierCaptor;

    @Test
    void whenInvokedExpectDispatcherResultReturned() {
      when(migrationDispatcher.dispatch(eq("getDesplazamientosMultiempresa"), any(), any(), any())).thenReturn(response);

      DesplazamientosMultiempresaResponseDto result = service.getDesplazamientosMultiempresa(request);

      assertThat(result).isSameAs(response);
      verify(migrationDispatcher, times(1)).dispatch(eq("getDesplazamientosMultiempresa"), any(), any(), any());
    }

    @Test
    void whenInvokedExpectRestSupplierCallsPeopleAclService() {
      when(peopleAclService.searchDesplazamientosMultiempresa(request)).thenReturn(restResponse);

      service.getDesplazamientosMultiempresa(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getDesplazamientosMultiempresa"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), any());
      DesplazamientosMultiempresaResponseDto restResult = restSupplierCaptor.getValue().get();
      assertThat(restResult).isSameAs(restResponse);
      verify(peopleAclService, times(1)).searchDesplazamientosMultiempresa(request);
    }

    @Test
    void whenInvokedExpectSoapSupplierCallsSoapService() {
      when(soapService.getDesplazamientosMultiempresa(request)).thenReturn(soapResponse);

      service.getDesplazamientosMultiempresa(request);

      verify(migrationDispatcher, times(1)).dispatch(eq("getDesplazamientosMultiempresa"), restSupplierCaptor.capture(),
          soapSupplierCaptor.capture(), any());
      DesplazamientosMultiempresaResponseDto soapResult = soapSupplierCaptor.getValue().get();
      assertThat(soapResult).isSameAs(soapResponse);
      verify(soapService, times(1)).getDesplazamientosMultiempresa(request);
    }
  }

  @Nested
  class BuscarCalculoComisiones {

    @Mock
    CalculoComisionesFilterDto request;

    @Mock
    CalculoComisionesResponseDto response;

    @Test
    void whenInvokedExpectDelegateToCalculoComisionesService() {
      when(calculoComisionesService.buscarCalculoComisiones(request)).thenReturn(response);

      CalculoComisionesResponseDto result = service.buscarCalculoComisiones(request);

      assertThat(result).isSameAs(response);
      verify(calculoComisionesService, times(1)).buscarCalculoComisiones(request);
      verifyNoInteractions(soapService, peopleAclService, migrationDispatcher);
    }
  }

}
