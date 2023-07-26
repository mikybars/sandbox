package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHIstoricoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionCadenaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionConfiguracionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionCalcularAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionFestivoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionOnlineHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresupuestoVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaCoeficienteAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaEstructuraPoliticaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTipoHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalFechaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4FilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImplTest {

  @Mock
  private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  @Mock
  private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

  @Mock
  private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  @Mock
  private TareaPersonaHistoricoAsyncService tareaPersonaHistoricoAsyncService;

  @Mock
  private TareaPersonaHistoricoService tareaPersonaHistoricoService;

  @Mock
  private TareaPersonaCoeficienteAsyncService tareaPersonaCoeficienteAsyncService;

  @Mock
  private TareaPersonaEstructuraAsyncService tareaPersonaEstructuraAsyncService;

  @Mock
  private TareaLocalizacionHistoricoAsyncService tareaLocalizacionHistoricoAsyncService;

  @Mock
  private TareaPersonaEstructuraPoliticaAsyncService tareaPersonaEstructuraPoliticaAsyncService;

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService tareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService;

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService tareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService;

  @Mock
  private TareaLocalizacionOnlineHistoricoAsyncService tareaLocalizacionOnlineHistoricoAsyncService;

  @Mock
  private TareaAgrupacionConfiguracionAsyncService tareaAgrupacionConfiguracionAsyncService;

  @Mock
  private TareaLocalizacionPersonaPresenciaAsyncService tareaLocalizacionPersonaSeccionPresenciaAsyncService;

  @Mock
  private TareaLocalizacionComisionHistoricoAsyncService tareaLocalizacionComisionHistoricoAsyncService;

  @Mock
  private TareaAgrupacionCadenaAsyncService tareaAgrupacionCadenaAsyncService;

  @Mock
  private TareaLocalizacionCalcularAsyncService tareaLocalizacionCalcularAsyncService;

  @Mock
  private TareaLocalizacionFestivoAsyncService tareaLocalizacionFestivoAsyncService;

  @Mock
  private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  @Mock
  private TareaAmbitoGlobalFechaService tareaAmbitoGlobalFechaService;

  @Mock
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @Mock
  private TareaLocalizacionPresupuestoVentaAsyncService tareaLocalizacionPresupuestoVentaAsyncService;

  @Mock
  private Map<String, Meta4PropertiesDto> meta4Properties;

  @Mock
  private RecolectarPropertiesDto recolectarProperties;

  @Mock
  private TareaMapper tareaMapper;

  @Mock
  private Meta4IcmWsCalcIncomeAsyncService meta4IcmWsCalcIncomeAsyncService;

  @Mock
  private TareaTipoHoraAsyncService tareaTipoHoraAsyncService;

  @InjectMocks
  private RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl;

  @Test
  @Disabled("Revisar este test")
  public void personaByRunTareaAndTareaAmbitoException()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.personaByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);

    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .searchEmpleados(ArgumentMatchers.any(SearchEmpleadosRequestDto.class));
  }

  @Test
  public void personaByRunTareaAndTareaAmbito()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    final TareaDto tarea = mock(TareaDto.class);
    final RunTareaDto runTarea = new RunTareaDto();
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);
    final CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto("95"));

    when(this.tareaAmbitoGlobalEmpresaService.findIdEmpresaByIdTarea(any(Long.class))).thenReturn(empresa);

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class))).thenReturn(new PeriodoDto());

    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtotoSearchEmpleadosFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new SearchEmpleadosFilterDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS)).thenReturn(properties);
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.searchEmpleados(any(SearchEmpleadosRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.personaByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);

    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .searchEmpleados(ArgumentMatchers.any(SearchEmpleadosRequestDto.class));
  }

  @Test
  public void localizacionByRunTareaAndTareaAmbitoException()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.localizacionByRunTareaAndTareaAmbito(
          runTarea,
          tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .searchTiendas(ArgumentMatchers.any(SearchTiendasRequestDto.class));
    });
  }

  @Test
  public void localizacionByRunTareaAndTareaAmbito() {
    final TareaDto tarea = mock(TareaDto.class);
    final RunTareaDto runTarea = new RunTareaDto();
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);
    final CompletableFuture<List<GenericTiendaResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto("95"));

    when(this.tareaAmbitoGlobalEmpresaService.findIdEmpresaByIdTarea(any(Long.class))).thenReturn(empresa);

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class))).thenReturn(new PeriodoDto());

    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToSearchTiendasFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new SearchTiendasFilterDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_TIENDAS)).thenReturn(properties);
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.searchTiendas(any(SearchTiendasRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.localizacionByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .searchTiendas(ArgumentMatchers.any(SearchTiendasRequestDto.class));

  }

  @Test
  public void empleadosPresenciaByRunTareaAndTareaAmbito() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = mock(TareaDto.class);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);
    final CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.tareaAmbitoGlobalEmpresaService.findIdEmpresaByIdTarea(any(Long.class))).thenReturn(empresa);

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class))).thenReturn(new PeriodoDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_PRESENCIA)).thenReturn(properties);
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
        any(Long.class),
        any(Integer.class))).thenReturn(new PeriodoDto());
    when(this.tareaMapper
        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(any(TrabajoDTO.class), any(TareaDto.class),
            any(TareaAmbitoDto.class), any(PeriodoDto.class)))
        .thenReturn(new GenericFilterDto());

    when(this.meta4IcmWsCalcIncomeSessionAsyncService
        .getEmpleadosPresencia(any(EmpleadosPresenciaRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosPresenciaByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getEmpleadosPresencia(ArgumentMatchers.any(EmpleadosPresenciaRequestDto.class));

  }

  @Test
  public void coefJornadaByRunTareaAndTareaAmbitoException()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.coefJornadaByRunTareaAndTareaAmbito(runTarea,
          tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .getCoefJornada(ArgumentMatchers.any(CoefJornadaRequestDto.class));
    });
  }

  @Test
  public void coefJornadaByRunTareaAndTareaAmbito() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.COEF_JORNADA)).thenReturn(properties);
    when(this.tareaPersonaHistoricoService.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
        any(Long.class), any(String.class), ArgumentMatchers.any()))
        .thenReturn(new ArrayList<>(Arrays.asList(new IdPersonaHistoricoDto("1", "1"))));
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getCoefJornada(any(CoefJornadaRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.coefJornadaByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getCoefJornada(ArgumentMatchers.any(CoefJornadaRequestDto.class));
  }

  @Test
  public void flagCalculaByRunTareaAndTareaAmbitoException()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.flagCalculaByRunTareaAndTareaAmbito(runTarea,
          tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .getFlagCalcula(ArgumentMatchers.any(FlagCalculaRequestDto.class));
    });
  }

  @Test
  public void flagCalculaByRunTareaAndTareaAmbito() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final List<IdLocalizacionDto> persona = new ArrayList<>(Arrays.asList(new IdLocalizacionDto("1")));
    final CompletableFuture<List<GenericTiendaResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.FLAG_CALCULA)).thenReturn(properties);
    when(this.tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(
        any(Long.class),
        any(String.class))).thenReturn(persona);
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getFlagCalcula(any(FlagCalculaRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.flagCalculaByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getFlagCalcula(ArgumentMatchers.any(FlagCalculaRequestDto.class));

  }

  @Test
  public void presenciaManualByRunTareaAndTareaAmbitoException()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.presenciaManualByRunTareaAndTareaAmbito(
          runTarea,
          tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .getPresenciaManual(ArgumentMatchers.any(PresenciaManualRequestDto.class));
    });
  }

  @Test
  public void presenciaManualByRunTareaAndTareaAmbito() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final List<IdLocalizacionDto> persona = new ArrayList<>(Arrays.asList(new IdLocalizacionDto("1")));
    final CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    final List<IdLocalizacionEmpresaDto> localizacionEmpresa = new ArrayList<>();
    localizacionEmpresa.add(new IdLocalizacionEmpresaDto());

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class)))
        .thenReturn(new PeriodoDto());

    when(this.tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
        any(Long.class),
        any(String.class), any(List.class)))
        .thenReturn(localizacionEmpresa);

    when(this.tareaAmbitoGlobalEmpresaService.findIdEmpresaByIdTarea(any(Long.class)))
        .thenReturn(empresa);

    when(this.meta4Properties.get(Meta4PropertiesConstants.PRESENCIA_MANUAL)).thenReturn(properties);
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getPresenciaManual(any(PresenciaManualRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.presenciaManualByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getPresenciaManual(ArgumentMatchers.any(PresenciaManualRequestDto.class));

  }

  @Test
  public void estructurasComByRunTareaAndTareaAmbitoException()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasComByRunTareaAndTareaAmbito(
          runTarea,
          tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .getEstructurasCom(ArgumentMatchers.any(EstructurasComRequestDto.class));
    });
  }

  @Test
  public void estructurasComByRunTareaAndTareaAmbitoTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<EstructurasComResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      final List<EstructurasComResultItemDto> comision = new ArrayList<>();
      comision.add(EstructurasComResultItemDto.builder().build());
      return comision;
    });

    final CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
      return null;
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_COM)).thenReturn(properties);
    when(this.tareaPersonaHistoricoService.findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(any(Long.class),
        any(String.class))).thenReturn(new ArrayList<>(
            Arrays.asList(new IdPersonaHIstoricoLocalizacionDto("1",
                "1", "1", "1"))));
    when(this.tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToEstructurasComFilterDto(
        any(TrabajoDTO.class),
        any(TareaDto.class), any(TareaAmbitoDto.class))).thenReturn(new EstructurasComFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getEstructurasCom(any(EstructurasComRequestDto.class)))
        .thenReturn(cf);
    when(this.tareaPersonaEstructuraAsyncService.saveEstructurasComResultItemDto(
        ArgumentMatchers.any(),
        any(TareaDto.class)))
        .thenReturn(cfNull);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasComByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getEstructurasCom(ArgumentMatchers.any(EstructurasComRequestDto.class));
  }

  @Test
  public void estructurasComByRunTareaAndTareaAmbitoEmptyResult() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<EstructurasComResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_COM)).thenReturn(properties);
    when(this.tareaPersonaHistoricoService.findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(any(Long.class),
        any(String.class))).thenReturn(new ArrayList<>(
            Arrays.asList(new IdPersonaHIstoricoLocalizacionDto("1",
                "1", "1", "1"))));
    when(this.tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToEstructurasComFilterDto(
        any(TrabajoDTO.class),
        any(TareaDto.class), any(TareaAmbitoDto.class))).thenReturn(new EstructurasComFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getEstructurasCom(any(EstructurasComRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasComByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getEstructurasCom(ArgumentMatchers.any(EstructurasComRequestDto.class));
  }

  @Test
  public void estructurasPolByRunTareaAndTareaAmbitoException()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasPolByRunTareaAndTareaAmbito(
          runTarea,
          tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .getEstructurasPol(ArgumentMatchers.any(EstructurasPolRequestDto.class));
    });
  }

  @Test
  public void estructurasPolByRunTareaAndTareaAmbito() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<EstructurasPolResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      final List<EstructurasPolResultItemDto> comision = new ArrayList<>();
      comision.add(EstructurasPolResultItemDto.builder().build());
      return comision;
    });

    final CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
      return null;
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_POL)).thenReturn(properties);
    when(this.tareaPersonaHistoricoService.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(any(Long.class),
        any(String.class))).thenReturn(new ArrayList<>(
            Arrays.asList(new IdPersonaHistoricoDto("1",
                "1"))));
    when(this.tareaPersonaHistoricoService.findPeriodoByIdTareaDto(any(Long.class))).thenReturn(new PeriodoDto());
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getEstructurasPol(any(EstructurasPolRequestDto.class)))
        .thenReturn(cf);
    when(this.tareaPersonaEstructuraPoliticaAsyncService.saveEstructurasPolResultItemDto(
        ArgumentMatchers.any(),
        any(TareaDto.class))).thenReturn(cfNull);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasPolByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getEstructurasPol(ArgumentMatchers.any(EstructurasPolRequestDto.class));
  }

  @Test
  public void estructurasPolByRunTareaAndTareaAmbitoEmptyResult() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<EstructurasPolResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_POL)).thenReturn(properties);
    when(this.tareaPersonaHistoricoService.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(any(Long.class),
        any(String.class))).thenReturn(new ArrayList<>(
            Arrays.asList(new IdPersonaHistoricoDto("1",
                "1"))));
    when(this.tareaPersonaHistoricoService.findPeriodoByIdTareaDto(any(Long.class))).thenReturn(new PeriodoDto());
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getEstructurasPol(any(EstructurasPolRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasPolByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getEstructurasPol(ArgumentMatchers.any(EstructurasPolRequestDto.class));
  }

  @Test
  public void configuracionVentaOnlineByRunTareaAndTareaAmbitoException()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl
          .configuracionVentaOnlineByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .getConfiguracionVentaOnline(ArgumentMatchers.any(ConfiguracionVentaOnlineRequestDto.class));
    });
  }

  @Test
  public void configuracionVentaOnlineByRunTareaAndTareaAmbito() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<ConfiguracionVentaOnlineResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      final List<ConfiguracionVentaOnlineResultItemDto> conf = new ArrayList<>();
      conf.add(new ConfiguracionVentaOnlineResultItemDto());
      return conf;
    });

    final CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
      return null;
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.CONF_VENTA_ONLINE)).thenReturn(properties);

    when(this.meta4IcmWsCalcIncomeSessionAsyncService
        .getConfiguracionVentaOnline(any(ConfiguracionVentaOnlineRequestDto.class))).thenReturn(cf);
    when(this.tareaAgrupacionConfiguracionAsyncService.saveAgrupacionConfiguracionDto(
        ArgumentMatchers.any(),
        any(RunTareaDto.class))).thenReturn(cfNull);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl
        .configuracionVentaOnlineByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getConfiguracionVentaOnline(ArgumentMatchers.any(ConfiguracionVentaOnlineRequestDto.class));

  }

  @Test
  public void configuracionVentaOnlineByRunTareaAndTareaAmbitoEmpty() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(8902L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<ConfiguracionVentaOnlineResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.CONF_VENTA_ONLINE)).thenReturn(properties);

    when(this.meta4IcmWsCalcIncomeSessionAsyncService
        .getConfiguracionVentaOnline(any(ConfiguracionVentaOnlineRequestDto.class))).thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl
        .configuracionVentaOnlineByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getConfiguracionVentaOnline(ArgumentMatchers.any(ConfiguracionVentaOnlineRequestDto.class));

  }

  @Test
  public void tiendasComisionableByRunTareaAndTareaAmbitoException()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasComisionableByRunTareaAndTareaAmbito(
          runTarea,
          tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .getTiendas(ArgumentMatchers.any(TiendasRequestDto.class));
    });
  }

  @Test
  public void tiendasComisionableByRunTareaAndTareaAmbito() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final List<IdLocalizacionDto> localizacion = new ArrayList<>(Arrays.asList(new IdLocalizacionDto("1")));

    final CompletableFuture<List<GenericTiendaResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      final List<GenericTiendaResultItemDto> tienda = new ArrayList<>();
      tienda.add(new GenericTiendaResultItemDto());
      return tienda;
    });

    final CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
      return null;
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.TIENDAS)).thenReturn(properties);
    when(this.tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(
        any(Long.class),
        any(String.class))).thenReturn(localizacion);
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getTiendas(any(TiendasRequestDto.class))).thenReturn(cf);
    when(this.tareaLocalizacionComisionHistoricoAsyncService.saveGenericTiendaResultItemDto(
        ArgumentMatchers.any(),
        any(TareaDto.class))).thenReturn(cfNull);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasComisionableByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getTiendas(ArgumentMatchers.any(TiendasRequestDto.class));

  }

  @Test
  public void tiendasComisionableByRunTareaAndTareaAmbitoEmpty() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final List<IdLocalizacionDto> localizacion = new ArrayList<>(Arrays.asList(new IdLocalizacionDto("1")));

    final CompletableFuture<List<GenericTiendaResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.TIENDAS)).thenReturn(properties);
    when(this.tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(
        any(Long.class),
        any(String.class))).thenReturn(localizacion);
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class),
        any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getTiendas(any(TiendasRequestDto.class))).thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasComisionableByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getTiendas(ArgumentMatchers.any(TiendasRequestDto.class));

  }

  @Test
  public void agrupacionesCadenaByRunTareaAndTareaAmbitoException()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.agrupacionesCadenaByRunTareaAndTareaAmbito(
          runTarea,
          tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .getAgrupacionesOnline(ArgumentMatchers.any(AgrupOnlineRequestDto.class));
    });
  }

  @Test
  public void agrupacionesCadenaByRunTareaAndTareaAmbito() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<AgrupOnlineResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      final List<AgrupOnlineResultItemDto> agrup = new ArrayList<>();
      agrup.add(new AgrupOnlineResultItemDto());
      return agrup;
    });

    final CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
      return null;
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.AGRUPACION_ONLINE)).thenReturn(properties);
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class),
        any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getAgrupacionesOnline(any(AgrupOnlineRequestDto.class)))
        .thenReturn(cf);
    when(this.tareaAgrupacionCadenaAsyncService.save(ArgumentMatchers.any(),
        any(TareaDto.class))).thenReturn(cfNull);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.agrupacionesCadenaByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getAgrupacionesOnline(ArgumentMatchers.any(AgrupOnlineRequestDto.class));

  }

  @Test
  public void agrupacionesCadenaByRunTareaAndTareaAmbitoEmpty() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(89989L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<AgrupOnlineResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.AGRUPACION_ONLINE)).thenReturn(properties);
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class),
        any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getAgrupacionesOnline(any(AgrupOnlineRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.agrupacionesCadenaByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getAgrupacionesOnline(ArgumentMatchers.any(AgrupOnlineRequestDto.class));

  }

  @Test
  public void localizacionesOnlineByRunTareaAndTareaAmbitoException()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.localizacionesOnlineByRunTareaAndTareaAmbito(
          runTarea,
          tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .getTiendasOnline(ArgumentMatchers.any(TiendaOnlineRequestDto.class));
    });
  }

  @Test
  public void localizacionesOnlineByRunTareaAndTareaAmbito() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<TiendaOnlineResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      final List<TiendaOnlineResultItemDto> tienda = new ArrayList<>();
      tienda.add(new TiendaOnlineResultItemDto());
      return tienda;
    });

    final CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
      return null;
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.TIENDAS_ONLINE)).thenReturn(properties);
    when(this.tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigen(any(Long.class),
        any(String.class))).thenReturn(new ArrayList<>(Arrays.asList(new IdCadenaDto("1"))));
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getTiendasOnline(any(TiendaOnlineRequestDto.class)))
        .thenReturn(cf);
    when(this.tareaLocalizacionOnlineHistoricoAsyncService.save(ArgumentMatchers
        .any(), any(TareaDto.class)))
        .thenReturn(cfNull);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.localizacionesOnlineByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getTiendasOnline(ArgumentMatchers.any(TiendaOnlineRequestDto.class));

  }

  @Test
  public void localizacionesOnlineByRunTareaAndTareaAmbitoEmpty() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<TiendaOnlineResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.TIENDAS_ONLINE)).thenReturn(properties);
    when(this.tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigen(any(Long.class),
        any(String.class))).thenReturn(new ArrayList<>(Arrays.asList(new IdCadenaDto("1"))));
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getTiendasOnline(any(TiendaOnlineRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.localizacionesOnlineByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getTiendasOnline(ArgumentMatchers.any(TiendaOnlineRequestDto.class));

  }

  @Test
  public void empleadosDesplazamientoByRunTareaAndTareaAmbitoException()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl
          .empleadosDesplazamientoByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .getEmpleadosDesplazamiento(ArgumentMatchers.any(EmpleadosDesplazamientoRequestDto.class));
    });
  }

  @Test
  public void empleadosDesplazamientoByRunTareaAndTareaAmbito() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = mock(TareaDto.class);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      final List<GenericEmpleadoResultItemDto> emp = new ArrayList<>();
      emp.add(new GenericEmpleadoResultItemDto());
      return emp;
    });

    final CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
      return null;
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_DESPLAZAMIENTO)).thenReturn(properties);

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
        any(Long.class),
        any(Integer.class))).thenReturn(new PeriodoDto());
    when(this.tareaMapper
        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(any(TrabajoDTO.class), any(TareaDto.class),
            any(TareaAmbitoDto.class), any(PeriodoDto.class)))
        .thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService
        .getEmpleadosDesplazamiento(any(EmpleadosDesplazamientoRequestDto.class))).thenReturn(cf);
    when(this.tareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService
        .saveGenericEmpleadoResultItemDto(ArgumentMatchers.any(),
            any(TareaDto.class)))
        .thenReturn(cfNull);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl
        .empleadosDesplazamientoByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getEmpleadosDesplazamiento(ArgumentMatchers.any(EmpleadosDesplazamientoRequestDto.class));

  }

  @Test
  public void empleadosDesplazamientoByRunTareaAndTareaAmbitoEmpty() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    when(this.meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_DESPLAZAMIENTO)).thenReturn(properties);
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
        any(Long.class),
        any(Integer.class))).thenReturn(new PeriodoDto());

    when(this.tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(any(TrabajoDTO.class),
        any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());

    when(this.meta4IcmWsCalcIncomeSessionAsyncService
        .getEmpleadosDesplazamiento(any(EmpleadosDesplazamientoRequestDto.class))).thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl
        .empleadosDesplazamientoByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getEmpleadosDesplazamiento(ArgumentMatchers.any(EmpleadosDesplazamientoRequestDto.class));

  }

  @Test
  public void empleadosCadenaByRunTareaAndTareaAmbitoTest() {

    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      final List<GenericEmpleadoResultItemDto> empleado = new ArrayList<>();
      empleado.add(new GenericEmpleadoResultItemDto());
      return empleado;
    });

    final CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> null);

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS)).thenReturn(properties);
    when(this.tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(
        any(Long.class),
        any(String.class),
        ArgumentMatchers.eq(Arrays.asList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()))))
        .thenReturn(new ArrayList<>(Arrays.asList(new IdCadenaDto("1"))));
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtotoSearchEmpleadosFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new SearchEmpleadosFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.searchEmpleados(any(SearchEmpleadosRequestDto.class)))
        .thenReturn(cf);
    when(this.tareaPersonaHistoricoAsyncService.saveGenericEmpleadoResultItemDto(ArgumentMatchers
        .any(), any(TareaDto.class)))
        .thenReturn(cfNull);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosCadenaByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .searchEmpleados(ArgumentMatchers.any(SearchEmpleadosRequestDto.class));

  }

  @Test
  public void empleadosCadenaByRunTareaAndTareaAmbitoExceptionTest()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosCadenaByRunTareaAndTareaAmbito(
          runTarea,
          tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .searchEmpleados(ArgumentMatchers.any(SearchEmpleadosRequestDto.class));
    });
  }

  @Test
  public void empleadosCadenaByRunTareaAndTareaAmbitoEmptyTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture
        .supplyAsync(() -> new ArrayList<>());

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS)).thenReturn(properties);
    when(this.tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(
        any(Long.class),
        any(String.class),
        ArgumentMatchers.eq(Arrays.asList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()))))
        .thenReturn(new ArrayList<>(Arrays.asList(new IdCadenaDto("1"))));
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtotoSearchEmpleadosFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new SearchEmpleadosFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.searchEmpleados(any(SearchEmpleadosRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosCadenaByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .searchEmpleados(ArgumentMatchers.any(SearchEmpleadosRequestDto.class));

  }

  @Test
  public void estructurasPolCadenaByRunTareaAndAmbitoTest() {

    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<EstructurasPolResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      final List<EstructurasPolResultItemDto> politicas = new ArrayList<>();
      politicas.add(EstructurasPolResultItemDto.builder().build());
      return politicas;
    });

    final CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> null);

    when(this.tareaPersonaHistoricoService.findPeriodoByIdTareaDto(any(Long.class))).thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_POL)).thenReturn(properties);
    when(this.tareaPersonaHistoricoService
        .findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(
            any(Long.class),
            any(String.class)))
        .thenReturn(new ArrayList<>(Arrays
            .asList(IdPersonaHistoricoDto.builder().stdOrHrPeriod("1").stdIdHr("1").build())));
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getEstructurasPol(any(EstructurasPolRequestDto.class)))
        .thenReturn(cf);
    when(this.tareaPersonaEstructuraPoliticaAsyncService.saveEstructurasPolResultItemDto(ArgumentMatchers
        .any(), any(TareaDto.class)))
        .thenReturn(cfNull);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasPolCadenaByRunTareaAndAmbito(
        runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getEstructurasPol(ArgumentMatchers.any(EstructurasPolRequestDto.class));

  }

  @Test
  public void estructurasPolCadenaByRunTareaAndAmbitoExceptionTest()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasPolCadenaByRunTareaAndAmbito(
          runTarea,
          tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .getEstructurasPol(ArgumentMatchers.any(EstructurasPolRequestDto.class));
    });
  }

  @Test
  public void estructurasPolCadenaByRunTareaAndAmbitoAmbitoEmptyTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<EstructurasPolResultItemDto>> cf = CompletableFuture
        .supplyAsync(() -> new ArrayList<>());

    when(this.tareaPersonaHistoricoService.findPeriodoByIdTareaDto(any(Long.class))).thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_POL)).thenReturn(properties);
    when(this.tareaPersonaHistoricoService
        .findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(
            any(Long.class),
            any(String.class)))
        .thenReturn(new ArrayList<>(Arrays
            .asList(IdPersonaHistoricoDto.builder().stdOrHrPeriod("1").stdIdHr("1").build())));
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getEstructurasPol(any(EstructurasPolRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasPolCadenaByRunTareaAndAmbito(
        runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getEstructurasPol(ArgumentMatchers.any(EstructurasPolRequestDto.class));

  }

  @Test
  public void tiposHorasByRunTareaAndAmbitoTest() {

    final String idOrigen = "11";
    final String idEmpresa = "28";
    final TareaDto tarea = new TareaDto();
    tarea.setId(11L);
    tarea.setStdIdLegEnt(idEmpresa);
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPersistenceSize(3);
    properties.setFilter(filter);
    final TiposHoraRequestDto request = TiposHoraRequestDto
        .builder()
        .idsEmpresa(Collections.singletonList(idEmpresa))
        .idOrigen(idOrigen)
        .build();
    final TiposHoraResponseDto response = TiposHoraResponseDto
        .builder()
        .items(Collections.singletonList(TiposHoraResultItemDto.builder().build()))
        .build();
    final CompletableFuture<TiposHoraResponseDto> cfResponse = CompletableFuture.supplyAsync(() -> response);
    final CompletableFuture<Void> cfSave = CompletableFuture.supplyAsync(() -> AsyncConstants.NIL);
    when(this.meta4IcmWsCalcIncomeAsyncService.getTiposHora(any(TiposHoraRequestDto.class))).thenReturn(cfResponse);
    when(this.meta4Properties.get(any(String.class))).thenReturn(properties);
    when(this.tareaTipoHoraAsyncService.save(any(TiposHoraResponseDto.class), any(TareaDto.class)))
        .thenReturn(cfSave);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiposHoraByRunTareaAndTareaAmbito(
        RunTareaDto.builder().tarea(tarea).build(), TareaAmbitoDto.builder().cclIdOrigen(idOrigen).build());

    verify(this.meta4IcmWsCalcIncomeAsyncService, times(1)).getTiposHora(request);
    verify(this.tareaTipoHoraAsyncService, times(1)).save(response, tarea);
  }

  @Test
  public void ventaCongeladaByRunTareaAndTareaAmbitoException()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.ventaCongeladaByRunTareaAndTareaAmbito(
          runTarea,
          tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .getVentaCongelada(ArgumentMatchers.any(VentaCongeladaRequestDto.class));
    });
  }

  @Test
  public void ventaCongeladaByRunTareaAndTareaAmbitoTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<VentaCongeladaResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      final List<VentaCongeladaResultItemDto> ventaCongeladaResultItemDtos = new ArrayList<>();
      ventaCongeladaResultItemDtos.add(new VentaCongeladaResultItemDto());
      return ventaCongeladaResultItemDtos;
    });

    final CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
      return null;
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.VENTACONGELADA)).thenReturn(properties);
    when(this.tareaLocalizacionHistoricoService.findIdLocalizacionByIdTarea(any(Long.class))).thenReturn(new ArrayList<>(
        Arrays.asList(new IdLocalizacionDto("1"))));
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class), any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.tareaMapper.mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToVentaCongeladaFilterDto(
        any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new VentaCongeladaFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getVentaCongelada(any(VentaCongeladaRequestDto.class)))
        .thenReturn(cf);
    when(this.tareaLocalizacionPresupuestoVentaAsyncService.saveVentaCongeladaResultItemDto(
        ArgumentMatchers.any(),
        any(TareaDto.class)))
        .thenReturn(cfNull);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.ventaCongeladaByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getVentaCongelada(ArgumentMatchers.any(VentaCongeladaRequestDto.class));
  }

  @Test
  public void ventaCongeladaByRunTareaAndTareaAmbitoEmptyResult() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<VentaCongeladaResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.VENTACONGELADA)).thenReturn(properties);
    when(this.tareaLocalizacionHistoricoService.findIdLocalizacionByIdTarea(any(Long.class))).thenReturn(new ArrayList<>(
        Arrays.asList(new IdLocalizacionDto("1"))));
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class), any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.tareaMapper.mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToVentaCongeladaFilterDto(
        any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new VentaCongeladaFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getVentaCongelada(any(VentaCongeladaRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.ventaCongeladaByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getVentaCongelada(ArgumentMatchers.any(VentaCongeladaRequestDto.class));
  }

  @Test
  public void estadoWlocByRunTareaAndTareaAmbitoException()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    Assertions.assertThrows(Exception.class, () -> {
      final RunTareaDto runTarea = new RunTareaDto();
      final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estadoWlocByRunTareaAndTareaAmbito(
          runTarea,
          tareaAmbito);
      verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
          .estadoWloc(ArgumentMatchers.any(EstadoWlocRequestDto.class));
    });
  }

  @Test
  public void estadoWlocByRunTareaAndTareaAmbitoTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<EstadoWlocResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      final List<EstadoWlocResultItemDto> estadoWlocResultItemDtos = new ArrayList<>();
      estadoWlocResultItemDtos.add(new EstadoWlocResultItemDto());
      return estadoWlocResultItemDtos;
    });

    final CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
      return null;
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.ESTADO_WLOC)).thenReturn(properties);
    when(this.tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(any(Long.class), any(String.class)))
        .thenReturn(new ArrayList<>(
            Arrays.asList(new IdLocalizacionDto("1"))));
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class), any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToEstadoWlocFilterDto(
        any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new EstadoWlocFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.estadoWloc(any(EstadoWlocRequestDto.class)))
        .thenReturn(cf);
    /*
     * when(this.tareaLocalizacionPresupuestoVentaAsyncService.saveVentaCongeladaResultItemDto( ArgumentMatchers.any(),
     * any(TareaDto.class))) .thenReturn(cfNull);
     */

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estadoWlocByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .estadoWloc(ArgumentMatchers.any(EstadoWlocRequestDto.class));
  }

  @Test
  public void estadoWlocByRunTareaAndTareaAmbitoEmptyResult() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final PageDto page = new PageDto(1, 100);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("38");
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    final CompletableFuture<List<EstadoWlocResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
      return new ArrayList<>();
    });

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.ESTADO_WLOC)).thenReturn(properties);
    when(this.tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(any(Long.class), any(String.class)))
        .thenReturn(new ArrayList<>(
            Arrays.asList(new IdLocalizacionDto("1"))));
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class), any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToEstadoWlocFilterDto(
        any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new EstadoWlocFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.estadoWloc(any(EstadoWlocRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estadoWlocByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .estadoWloc(ArgumentMatchers.any(EstadoWlocRequestDto.class));
  }

}
