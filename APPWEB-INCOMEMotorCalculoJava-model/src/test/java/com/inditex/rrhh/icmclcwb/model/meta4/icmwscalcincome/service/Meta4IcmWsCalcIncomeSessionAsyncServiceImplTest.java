package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class Meta4IcmWsCalcIncomeSessionAsyncServiceImplTest {

  @Mock
  private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  @InjectMocks
  private Meta4IcmWsCalcIncomeSessionAsyncServiceImpl meta4IcmWsCalcIncomeSessionAsyncServiceImpl;

  @Test
  public void getFlagCalcula() {
    when(this.meta4IcmWsCalcIncomeSessionService.getFlagCalcula(any(FlagCalculaRequestDto.class)))
        .thenReturn(new ArrayList<GenericTiendaResultItemDto>());

    final FlagCalculaRequestDto request = new FlagCalculaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getFlagCalcula(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getFlagCalcula(ArgumentMatchers.any(FlagCalculaRequestDto.class));

  }

  @Test
  public void getCoefJornada() {
    when(this.meta4IcmWsCalcIncomeSessionService.getCoefJornada(any(CoefJornadaRequestDto.class)))
        .thenReturn(new ArrayList<GenericEmpleadoResultItemDto>());

    final CoefJornadaRequestDto request = new CoefJornadaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getCoefJornada(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getCoefJornada(ArgumentMatchers.any(CoefJornadaRequestDto.class));

  }

  @Test
  public void getFestivos() {
    when(this.meta4IcmWsCalcIncomeSessionService.getFestivos(any(FestivosRequestDto.class)))
        .thenReturn(new ArrayList<GenericTiendaResultItemDto>());

    final FestivosRequestDto request = new FestivosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getFestivos(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getFestivos(ArgumentMatchers.any(FestivosRequestDto.class));

  }

  @Test
  public void getPresenciaManual() {
    when(this.meta4IcmWsCalcIncomeSessionService.getPresenciaManual(any(PresenciaManualRequestDto.class)))
        .thenReturn(new ArrayList<GenericEmpleadoResultItemDto>());

    final PresenciaManualRequestDto request = new PresenciaManualRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getPresenciaManual(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getPresenciaManual(ArgumentMatchers.any(PresenciaManualRequestDto.class));

  }

  @Test
  public void getEmpleadosPresencia() {
    when(this.meta4IcmWsCalcIncomeSessionService.getEmpleadosPresencia(any(EmpleadosPresenciaRequestDto.class)))
        .thenReturn(new ArrayList<GenericEmpleadoResultItemDto>());

    final EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getEmpleadosPresencia(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getEmpleadosPresencia(ArgumentMatchers.any(EmpleadosPresenciaRequestDto.class));

  }

  @Test
  public void getPeriodos() {
    when(this.meta4IcmWsCalcIncomeSessionService.getPeriodos(any(PeriodosRequestDto.class)))
        .thenReturn(new ArrayList<PeriodosResultItemDto>());

    final PeriodosRequestDto request = new PeriodosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getPeriodos(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getPeriodos(ArgumentMatchers.any(PeriodosRequestDto.class));

  }

  @Test
  public void searchTiendas() {
    when(this.meta4IcmWsCalcIncomeSessionService.searchTiendas(any(SearchTiendasRequestDto.class)))
        .thenReturn(new ArrayList<GenericTiendaResultItemDto>());

    final SearchTiendasRequestDto request = new SearchTiendasRequestDto();
    request.setData(new SearchTiendasFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.searchTiendas(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .searchTiendas(ArgumentMatchers.any(SearchTiendasRequestDto.class));

  }

  @Test
  public void getTiendas() {
    when(this.meta4IcmWsCalcIncomeSessionService.getTiendas(any(TiendasRequestDto.class)))
        .thenReturn(new ArrayList<GenericTiendaResultItemDto>());

    final TiendasRequestDto request = new TiendasRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getTiendas(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getTiendas(ArgumentMatchers.any(TiendasRequestDto.class));

  }

  @Test
  public void searchEmpleados() {
    when(this.meta4IcmWsCalcIncomeSessionService.searchEmpleados(any(SearchEmpleadosRequestDto.class)))
        .thenReturn(new ArrayList<GenericEmpleadoResultItemDto>());

    final SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
    request.setData(new SearchEmpleadosFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.searchEmpleados(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .searchEmpleados(ArgumentMatchers.any(SearchEmpleadosRequestDto.class));

  }

  @Test
  public void getEstructurasCom() {
    when(this.meta4IcmWsCalcIncomeSessionService.getEstructurasCom(any(EstructurasComRequestDto.class)))
        .thenReturn(new ArrayList<EstructurasComResultItemDto>());

    final EstructurasComRequestDto request = new EstructurasComRequestDto();
    request.setData(new EstructurasComFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getEstructurasCom(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getEstructurasCom(ArgumentMatchers.any(EstructurasComRequestDto.class));

  }

  @Test
  public void getEstructurasPol() {
    when(this.meta4IcmWsCalcIncomeSessionService.getEstructurasPol(any(EstructurasPolRequestDto.class)))
        .thenReturn(new ArrayList<EstructurasPolResultItemDto>());

    final EstructurasPolRequestDto request = new EstructurasPolRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getEstructurasPol(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getEstructurasPol(ArgumentMatchers.any(EstructurasPolRequestDto.class));

  }

  @Test
  public void getEmpleados() {
    when(this.meta4IcmWsCalcIncomeSessionService.getEmpleados(any(EmpleadosRequestDto.class)))
        .thenReturn(new ArrayList<GenericEmpleadoResultItemDto>());

    final EmpleadosRequestDto request = new EmpleadosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getEmpleados(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getEmpleados(ArgumentMatchers.any(EmpleadosRequestDto.class));

  }

  @Test
  public void getConfiguracionVentaOnline() {
    when(this.meta4IcmWsCalcIncomeSessionService
        .getConfiguracionVentaOnline(any(ConfiguracionVentaOnlineRequestDto.class)))
        .thenReturn(new ArrayList<ConfiguracionVentaOnlineResultItemDto>());

    final ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getConfiguracionVentaOnline(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getConfiguracionVentaOnline(ArgumentMatchers.any(ConfiguracionVentaOnlineRequestDto.class));

  }

  @Test
  public void getAgrupacionesOnline() {
    when(this.meta4IcmWsCalcIncomeSessionService.getAgrupacionesOnline(any(AgrupOnlineRequestDto.class)))
        .thenReturn(new ArrayList<AgrupOnlineResultItemDto>());

    final AgrupOnlineRequestDto request = new AgrupOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getAgrupacionesOnline(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getAgrupacionesOnline(ArgumentMatchers.any(AgrupOnlineRequestDto.class));

  }

  @Test
  public void getTiendasOnline() {
    when(this.meta4IcmWsCalcIncomeSessionService.tiendaOnline(any(TiendaOnlineRequestDto.class)))
        .thenReturn(new ArrayList<TiendaOnlineResultItemDto>());

    final TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getTiendasOnline(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .tiendaOnline(ArgumentMatchers.any(TiendaOnlineRequestDto.class));

  }

  @Test
  public void getEmpresa() {
    when(this.meta4IcmWsCalcIncomeSessionService.getEmpresa(any(EmpresaRequestDto.class)))
        .thenReturn(new ArrayList<EmpresaResultItemDto>());

    final EmpresaRequestDto request = new EmpresaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getEmpresa(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getEmpresa(ArgumentMatchers.any(EmpresaRequestDto.class));

  }

  @Test
  public void getOrigen() {
    when(this.meta4IcmWsCalcIncomeSessionService.getOrigen(any(OrigenRequestDto.class)))
        .thenReturn(new ArrayList<OrigenResultItemDto>());

    final OrigenRequestDto request = new OrigenRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getOrigen(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getOrigen(ArgumentMatchers.any(OrigenRequestDto.class));

  }

  @Test
  public void getConfiguracionProductoVenta() {
    when(this.meta4IcmWsCalcIncomeSessionService
        .getConfiguracionProductoVenta(any(ConfiguracionProductoVentaRequestDto.class)))
        .thenReturn(new ArrayList<ConfiguracionProductoVentaResultItemDto>());

    final ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getConfiguracionProductoVenta(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getConfiguracionProductoVenta(ArgumentMatchers.any(ConfiguracionProductoVentaRequestDto.class));

  }

  @Test
  public void getEmpleadosDesplazamiento() {
    when(this.meta4IcmWsCalcIncomeSessionService
        .getEmpleadosDesplazamiento(any(EmpleadosDesplazamientoRequestDto.class)))
        .thenReturn(new ArrayList<GenericEmpleadoResultItemDto>());

    final EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getEmpleadosDesplazamiento(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getEmpleadosDesplazamiento(ArgumentMatchers.any(EmpleadosDesplazamientoRequestDto.class));

  }

  @Test
  public void getConfChallengeDiasMinimos() {
    when(this.meta4IcmWsCalcIncomeSessionService
        .getConfChallengeDiasMinimos(any(ConfChDiasMinimosRequestDto.class)))
        .thenReturn(new ArrayList<ConfChDiasMinimosResultItemDto>());

    final ConfChDiasMinimosRequestDto request = new ConfChDiasMinimosRequestDto();
    request.setData(new ConfChDiasMinimosFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getConfChallengeDiasMinimos(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getConfChallengeDiasMinimos(ArgumentMatchers.any(ConfChDiasMinimosRequestDto.class));
  }

  @Test
  public void getPresupuestosWloc() {
    when(this.meta4IcmWsCalcIncomeSessionService.getPresupuestosWloc(any(PresupuestosWlocRequestDto.class)))
        .thenReturn(new ArrayList<PresupuestosWlocResultItemDto>());

    final PresupuestosWlocRequestDto request = new PresupuestosWlocRequestDto();
    request.setData(new PresupuestosWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getPresupuestosWloc(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getPresupuestosWloc(ArgumentMatchers.any(PresupuestosWlocRequestDto.class));
  }

  @Test
  public void getConfPrecioHora() {
    when(this.meta4IcmWsCalcIncomeSessionService.getConfPrecioHora(any(ConfPrecioHoraRequestDto.class)))
        .thenReturn(new ArrayList<ConfPrecioHoraResultItemDto>());

    final ConfPrecioHoraRequestDto request = new ConfPrecioHoraRequestDto();
    request.setData(new ConfPrecioHoraFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getConfPrecioHora(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getConfPrecioHora(ArgumentMatchers.any(ConfPrecioHoraRequestDto.class));
  }

  @Test
  public void getConfChallengeTpVenta() {
    when(this.meta4IcmWsCalcIncomeSessionService.getConfChallengeTpVenta(any(ConfChTpVentaRequestDto.class)))
        .thenReturn(new ArrayList<ConfChTpVentaResultItemDto>());

    final ConfChTpVentaRequestDto request = new ConfChTpVentaRequestDto();
    request.setData(new ConfChTpVentaFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getConfChallengeTpVenta(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getConfChallengeTpVenta(ArgumentMatchers.any(ConfChTpVentaRequestDto.class));
  }

  @Test
  public void getPresupuestosRango() {
    when(this.meta4IcmWsCalcIncomeSessionService.getPresupuestosRango(any(PresupuestosRangoRequestDto.class)))
        .thenReturn(new ArrayList<PresupuestosRangoResultItemDto>());

    final PresupuestosRangoRequestDto request = new PresupuestosRangoRequestDto();
    request.setData(new PresupuestosRangoFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getPresupuestosRango(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getPresupuestosRango(ArgumentMatchers.any(PresupuestosRangoRequestDto.class));
  }

  @Test
  public void getDesplazReal() {
    when(this.meta4IcmWsCalcIncomeSessionService.getDesplazReal(any(DesplazamientoRealRequestDto.class)))
        .thenReturn(new ArrayList<DesplazamientoRealResultItemDto>());

    final DesplazamientoRealRequestDto request = new DesplazamientoRealRequestDto();
    request.setData(new DesplazamientoRealFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getDesplazReal(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getDesplazReal(ArgumentMatchers.any(DesplazamientoRealRequestDto.class));
  }

  @Test
  public void getPresenciaManualWloc() {
    when(this.meta4IcmWsCalcIncomeSessionService
        .getPresenciaManualWloc(any(PresenciaManualWlocRequestDto.class)))
        .thenReturn(new ArrayList<PresenciaManualWlocResultItemDto>());

    final PresenciaManualWlocRequestDto request = new PresenciaManualWlocRequestDto();
    request.setData(new PresenciaManualWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getPresenciaManualWloc(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getPresenciaManualWloc(ArgumentMatchers.any(PresenciaManualWlocRequestDto.class));
  }

  @Test
  public void getVentaManualWloc() {
    when(this.meta4IcmWsCalcIncomeSessionService
        .getVentaManualWloc(any(VentaManualWlocRequestDto.class)))
        .thenReturn(new ArrayList<VentaManualWlocResultItemDto>());

    final VentaManualWlocRequestDto request = new VentaManualWlocRequestDto();
    request.setData(new VentaManualWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getVentaManualWloc(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getVentaManualWloc(ArgumentMatchers.any(VentaManualWlocRequestDto.class));
  }

  @Test
  public void estadoWloc() {
    when(this.meta4IcmWsCalcIncomeSessionService
        .getEstadoWloc(any(EstadoWlocRequestDto.class)))
        .thenReturn(new ArrayList<EstadoWlocResultItemDto>());

    final EstadoWlocRequestDto request = new EstadoWlocRequestDto();
    request.setData(new EstadoWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    CompletableFuture
        .completedFuture(this.meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getEstadoWloc(request));

    verify(this.meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1))
        .getEstadoWloc(ArgumentMatchers.any(EstadoWlocRequestDto.class));
  }
}
