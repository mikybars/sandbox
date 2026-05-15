package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4FilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaRequestItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealFilterDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper.IcmWsCalcIncomeMapper;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class SoapMeta4IcmWsCalcIncomeSessionServiceTest {

  @Mock
  private SoapMeta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Mock
  private Meta4ClientPool meta4ClientPool;

  @Mock
  private IcmWsCalcIncomeMapper icmWsCalcIncomeMapper;

  @Mock
  private Map<String, Meta4PropertiesDto> meta4Properties;

  @InjectMocks
  private SoapMeta4IcmWsCalcIncomeSessionService soapMeta4IcmWsCalcIncomeSessionService;

  @Test
  void getFlagCalcula() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getFlagCalcula(any(FlagCalculaRequestDto.class)))
        .thenReturn(new FlagCalculaResponseDto());

    final FlagCalculaRequestDto request = new FlagCalculaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getFlagCalcula(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getFlagCalcula(ArgumentMatchers.any(FlagCalculaRequestDto.class));
  }

  @Test
  void getFestivos() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getFestivos(any(FestivosRequestDto.class)))
        .thenReturn(new FestivosResponseDto());

    final FestivosRequestDto request = new FestivosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getFestivos(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getFestivos(ArgumentMatchers.any(FestivosRequestDto.class));
  }

  @Test
  void getCoefJornada() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getCoefJornada(any(CoefJornadaRequestDto.class)))
        .thenReturn(new CoefJornadaResponseDto());

    final CoefJornadaRequestDto request = new CoefJornadaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getCoefJornada(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getCoefJornada(ArgumentMatchers.any(CoefJornadaRequestDto.class));
  }

  @Test
  void getPresenciaManual() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getPresenciaManual(any(PresenciaManualRequestDto.class)))
        .thenReturn(new PresenciaManualResponseDto());

    final PresenciaManualRequestDto request = new PresenciaManualRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getPresenciaManual(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getPresenciaManual(ArgumentMatchers.any(PresenciaManualRequestDto.class));
  }

  @Test
  void getEmpleadosPresencia() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getEmpleadosPresencia(any(EmpleadosPresenciaRequestDto.class)))
        .thenReturn(new EmpleadosPresenciaResponseDto());

    final EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getEmpleadosPresencia(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getEmpleadosPresencia(ArgumentMatchers.any(EmpleadosPresenciaRequestDto.class));
  }

  @Test
  void getPeriodos() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getPeriodos(any(PeriodosRequestDto.class)))
        .thenReturn(new PeriodosResponseDto());

    final PeriodosRequestDto request = new PeriodosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getPeriodos(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getPeriodos(ArgumentMatchers.any(PeriodosRequestDto.class));
  }

  @Test
  void searchTiendas() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.searchTiendas(any(SearchTiendasRequestDto.class)))
        .thenReturn(new SearchTiendasResponseDto());

    final SearchTiendasRequestDto request = new SearchTiendasRequestDto();
    request.setData(new SearchTiendasFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.searchTiendas(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .searchTiendas(ArgumentMatchers.any(SearchTiendasRequestDto.class));
  }

  @Test
  void getTiendas() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getTiendas(any(TiendasRequestDto.class)))
        .thenReturn(new TiendasResponseDto());

    final TiendasRequestDto request = new TiendasRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getTiendas(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getTiendas(ArgumentMatchers.any(TiendasRequestDto.class));
  }

  @Test
  void searchEmpleados() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.searchEmpleados(any(SearchEmpleadosRequestDto.class)))
        .thenReturn(new SearchEmpleadosResponseDto());

    final SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
    request.setData(new SearchEmpleadosFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.searchEmpleados(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .searchEmpleados(ArgumentMatchers.any(SearchEmpleadosRequestDto.class));
  }

  @Test
  void getEmpleados() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getEmpleados(any(EmpleadosRequestDto.class)))
        .thenReturn(new EmpleadosResponseDto());

    final EmpleadosRequestDto request = new EmpleadosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getEmpleados(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getEmpleados(ArgumentMatchers.any(EmpleadosRequestDto.class));
  }

  @Test
  void getConfiguracionVentaOnline() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getConfVentaOnline(any(ConfiguracionVentaOnlineRequestDto.class)))
        .thenReturn(new ConfiguracionVentaOnlineResponseDto());

    final ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getConfiguracionVentaOnline(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getConfVentaOnline(ArgumentMatchers.any(ConfiguracionVentaOnlineRequestDto.class));
  }

  @Test
  void getAgrupacionesOnline() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getAgrupOnline(any(AgrupOnlineRequestDto.class)))
        .thenReturn(new AgrupOnlineResponseDto());

    final AgrupOnlineRequestDto request = new AgrupOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getAgrupacionesOnline(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getAgrupOnline(ArgumentMatchers.any(AgrupOnlineRequestDto.class));
  }

  @Test
  void tiendaOnline() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getTiendasOnline(any(TiendaOnlineRequestDto.class)))
        .thenReturn(new TiendaOnlineResponseDto());

    final TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.tiendaOnline(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getTiendasOnline(ArgumentMatchers.any(TiendaOnlineRequestDto.class));
  }

  @Test
  void getEmpresa() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getEmpresa(any(EmpresaRequestDto.class)))
        .thenReturn(new EmpresaResponseDto());

    final EmpresaRequestDto request = new EmpresaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getEmpresa(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getEmpresa(ArgumentMatchers.any(EmpresaRequestDto.class));
  }

  @Test
  void getOrigen() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getOrigen(any(OrigenRequestDto.class)))
        .thenReturn(new OrigenResponseDto());

    final OrigenRequestDto request = new OrigenRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getOrigen(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getOrigen(ArgumentMatchers.any(OrigenRequestDto.class));
  }

  @Test
  void getConfiguracionProductoVenta() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService
        .getConfiguracionProductoVenta(any(ConfiguracionProductoVentaRequestDto.class)))
            .thenReturn(new ConfiguracionProductoVentaResponseDto());

    final ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getConfiguracionProductoVenta(ArgumentMatchers.any(ConfiguracionProductoVentaRequestDto.class));
  }

  @Test
  void getConfiguracionProductoVentaIdTareaCclIdOrigen() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService
        .getConfiguracionProductoVenta(any(ConfiguracionProductoVentaRequestDto.class)))
            .thenReturn(new ConfiguracionProductoVentaResponseDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.CONF_PRODUCTO_VENTA)).thenReturn(properties);

    final Long idTarea = 1L;
    final String cclIdOrigen = "38";

    this.soapMeta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(idTarea, cclIdOrigen);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getConfiguracionProductoVenta(ArgumentMatchers.any(ConfiguracionProductoVentaRequestDto.class));
  }

  @Test
  void getEmpleadosDesplazamiento() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getEmpleadosDesplazamiento(any(EmpleadosDesplazamientoRequestDto.class)))
        .thenReturn(new EmpleadosDesplazamientoResponseDto());

    final EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getEmpleadosDesplazamiento(request);
    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getEmpleadosDesplazamiento(ArgumentMatchers.any(EmpleadosDesplazamientoRequestDto.class));
  }

  @Test
  void getDesplazReal() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService.getDesplazReal(any(DesplazamientoRealRequestDto.class)))
        .thenReturn(new DesplazamientoRealResponseDto());

    final DesplazamientoRealRequestDto request = new DesplazamientoRealRequestDto();
    request.setData(new DesplazamientoRealFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getDesplazReal(request);
    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getDesplazReal(ArgumentMatchers.any(DesplazamientoRealRequestDto.class));
  }

  @Test
  void getPresenciaManualWloc() {
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    properties.setFilter(filter);
    when(this.meta4IcmWsCalcIncomeService
        .getPresenciaManualWloc(any(PresenciaManualWlocRequestDto.class)))
            .thenReturn(new PresenciaManualWlocResponseDto());

    final PresenciaManualWlocRequestDto request = new PresenciaManualWlocRequestDto();
    request.setData(new PresenciaManualWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getPresenciaManualWloc(request);
    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getPresenciaManualWloc(ArgumentMatchers.any(PresenciaManualWlocRequestDto.class));
  }

  @Test
  void getEstructurasCom() {
    when(this.meta4IcmWsCalcIncomeService.getEstructurasCom(any(EstructurasComRequestDto.class)))
        .thenReturn(new EstructurasComResponseDto());

    final EstructurasComRequestDto request = new EstructurasComRequestDto();
    request.setData(new EstructurasComFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getEstructurasCom(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getEstructurasCom(ArgumentMatchers.any(EstructurasComRequestDto.class));
  }

  @Test
  void getEstructurasPol() {
    when(this.meta4IcmWsCalcIncomeService.getEstructurasPol(any(EstructurasPolRequestDto.class)))
        .thenReturn(new EstructurasPolResponseDto());

    final EstructurasPolRequestDto request = new EstructurasPolRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getEstructurasPol(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getEstructurasPol(ArgumentMatchers.any(EstructurasPolRequestDto.class));
  }

  @Test
  void getAusencias() {
    when(this.meta4IcmWsCalcIncomeService.getAusencias(any(AusenciasRequestDto.class)))
        .thenReturn(new AusenciasResponseDto());

    final AusenciasRequestDto request = new AusenciasRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getAusencias(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getAusencias(ArgumentMatchers.any(AusenciasRequestDto.class));
  }

  @Test
  void getConfChallengeDiasMinimos() {
    when(this.meta4IcmWsCalcIncomeService.getConfChallengeDiasMinimos(any(ConfChDiasMinimosRequestDto.class)))
        .thenReturn(new ConfChDiasMinimosResponseDto());

    final ConfChDiasMinimosRequestDto request = new ConfChDiasMinimosRequestDto();
    request.setData(new ConfChDiasMinimosFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getConfChallengeDiasMinimos(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getConfChallengeDiasMinimos(ArgumentMatchers.any(ConfChDiasMinimosRequestDto.class));
  }

  @Test
  void getPresupuestosWloc() {
    when(this.meta4IcmWsCalcIncomeService.getPresupuestosWloc(any(PresupuestosWlocRequestDto.class)))
        .thenReturn(new PresupuestosWlocResponseDto());

    final PresupuestosWlocRequestDto request = new PresupuestosWlocRequestDto();
    request.setData(new PresupuestosWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getPresupuestosWloc(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getPresupuestosWloc(ArgumentMatchers.any(PresupuestosWlocRequestDto.class));
  }

  @Test
  void getConfPrecioHora() {
    when(this.meta4IcmWsCalcIncomeService.getConfPrecioHora(any(ConfPrecioHoraRequestDto.class)))
        .thenReturn(new ConfPrecioHoraResponseDto());

    final ConfPrecioHoraRequestDto request = new ConfPrecioHoraRequestDto();
    request.setData(new ConfPrecioHoraFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getConfPrecioHora(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getConfPrecioHora(ArgumentMatchers.any(ConfPrecioHoraRequestDto.class));
  }

  @Test
  void getConfChallengeTpVenta() {
    when(this.meta4IcmWsCalcIncomeService.getConfChallengeTpVenta(any(ConfChTpVentaRequestDto.class)))
        .thenReturn(new ConfChTpVentaResponseDto());

    final ConfChTpVentaRequestDto request = new ConfChTpVentaRequestDto();
    request.setData(new ConfChTpVentaFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getConfChallengeTpVenta(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getConfChallengeTpVenta(ArgumentMatchers.any(ConfChTpVentaRequestDto.class));
  }

  @Test
  void getPresupuestosRango() {
    when(this.meta4IcmWsCalcIncomeService.getPresupuestosRango(any(PresupuestosRangoRequestDto.class)))
        .thenReturn(new PresupuestosRangoResponseDto());

    final PresupuestosRangoRequestDto request = new PresupuestosRangoRequestDto();
    request.setData(new PresupuestosRangoFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getPresupuestosRango(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getPresupuestosRango(ArgumentMatchers.any(PresupuestosRangoRequestDto.class));
  }

  @Test
  void getVentaCongelada() {
    when(this.meta4IcmWsCalcIncomeService.getVentaCongelada(any(VentaCongeladaRequestDto.class)))
        .thenReturn(new VentaCongeladaResponseDto());

    final VentaCongeladaRequestDto request = new VentaCongeladaRequestDto();
    request.setData(new VentaCongeladaFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getVentaCongelada(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getVentaCongelada(ArgumentMatchers.any(VentaCongeladaRequestDto.class));
  }

  @Test
  void getDesplazamientoMultiempresa() {
    when(this.meta4IcmWsCalcIncomeService
        .getDesplazamientosMultiempresa(any(DesplazamientosMultiempresaRequestDto.class)))
            .thenReturn(new DesplazamientosMultiempresaResponseDto());

    final DesplazamientosMultiempresaRequestDto request = new DesplazamientosMultiempresaRequestDto();
    request.setData(DesplazamientosMultiempresaRequestItemDto.builder().build());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getDesplazamientoMultiempresa(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getDesplazamientosMultiempresa(ArgumentMatchers.any(DesplazamientosMultiempresaRequestDto.class));
  }

  @Test
  void getVentaManualWloc() {
    when(this.meta4IcmWsCalcIncomeService.getVentaManualWloc(any(VentaManualWlocRequestDto.class)))
        .thenReturn(new VentaManualWlocResponseDto());

    final VentaManualWlocRequestDto request = new VentaManualWlocRequestDto();
    request.setData(new VentaManualWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getVentaManualWloc(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getVentaManualWloc(ArgumentMatchers.any(VentaManualWlocRequestDto.class));
  }

  @Test
  void getEstadoWloc() {
    when(this.meta4IcmWsCalcIncomeService.getEstadoWloc(any(EstadoWlocRequestDto.class)))
        .thenReturn(new EstadoWlocResponseDto());

    final EstadoWlocRequestDto request = new EstadoWlocRequestDto();
    request.setData(new EstadoWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeSessionService.getEstadoWloc(request);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getEstadoWloc(ArgumentMatchers.any(EstadoWlocRequestDto.class));
  }

}
