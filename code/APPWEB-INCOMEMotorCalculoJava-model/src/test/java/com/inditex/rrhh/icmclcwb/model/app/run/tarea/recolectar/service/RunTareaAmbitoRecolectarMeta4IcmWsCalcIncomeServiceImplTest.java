package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.IncomeMetaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionCadenaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionConfiguracionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaConfiguracionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaConfiguracionPrecioHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionCalcularAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionFestivoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionOnlineHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresupuestoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresupuestoVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaAusenciaHistoricoAsyncService;
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
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4FilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraFilterDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
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
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.PresupuestosWlocMapper;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TiendaMapper;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoVentaConceptoChallengeMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.rest.client.dto.AgrupacionesOnlineResponseDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ConfiguracionPrecioHoraResponseDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.TiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.TiposVentaChallengeResponseDTO;

import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImplTest {

  @Mock
  private TareaPersonaEstructuraService tareaPersonaEstructuraService;

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
  private TareaLocalizacionEstadoAsyncService tareaLocalizacionEstadoAsyncService;

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

  @Mock
  private TareaConfiguracionPrecioHoraAsyncService tareaConfiguracionPrecioHoraAsyncService;

  @Mock
  private IncomeMetaService incomeMetaService;

  @Mock
  private TipoVentaConceptoChallengeMapper tipoVentaConceptoChallengeMapper;

  @Mock
  private TareaPersonaAusenciaHistoricoAsyncService tareaPersonaAusenciaHistoricoAsyncService;

  @Mock
  private TareaConfiguracionAsyncService tareaConfiguracionAsyncService;

  @Mock
  private TiendaMapper tiendaMapper;

  @Mock
  private PresupuestosWlocMapper presupuestosWlocMapper;

  @Mock
  private TareaLocalizacionPresupuestoAsyncService tareaLocalizacionPresupuestoAsyncService;

  @InjectMocks
  private RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

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
    final List<EmpleadoDTO> empleados = new ArrayList<>();
    empleados.add(new EmpleadoDTO());
    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto("95"));
    final CompletableFuture<Void> cfSave = CompletableFuture.completedFuture(AsyncConstants.NIL);

    when(this.tareaAmbitoGlobalEmpresaService.findIdEmpresaByIdTarea(any(Long.class))).thenReturn(empresa);

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class))).thenReturn(new PeriodoDto());

    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtotoSearchEmpleadosFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new SearchEmpleadosFilterDto());

    when(this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS)).thenReturn(properties);
    when(this.incomeMetaService.searchEmpleados(any(SearchEmpleadosRequestDto.class)))
        .thenReturn(empleados);
    when(this.tareaPersonaHistoricoAsyncService.saveEmpleadoDto(any(), any(TareaDto.class))).thenReturn(cfSave);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.personaByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);

    verify(this.incomeMetaService, timeout(1000).times(1))
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
  public void localizacionByRunTareaAndTareaAmbitoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final RunTareaDto runTarea = new RunTareaDto();
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(new TrabajoDTO());
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();

    tareaAmbito.setCclIdOrigen("11");
    when(tarea.getId()).thenReturn(1L);
    when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2023, 1, 1));
    when(tarea.getFechaFinPeriodo()).thenReturn(LocalDate.of(2023, 1, 31));
    when(tarea.getIdOrganization()).thenReturn("0001");

    final List<TiendaResponseDTO> tiendasLista = Instancio.createList(TiendaResponseDTO.class);
    final List<IdEmpresaDto> empresa = new ArrayList<>();
    final PeriodoDto periodo = new PeriodoDto();
    periodo.setFechaFinPeriodo(LocalDate.of(2023, 1, 31));
    periodo.setFechaInicioPeriodo(LocalDate.of(2023, 1, 1));
    empresa.add(new IdEmpresaDto("95"));

    when(this.incomeMetaService.getTiendas(
        "11",
        List.of("95"),
        true,
        LocalDate.of(2023, 1, 1),
        LocalDate.of(2023, 1, 31),
        "0001")).thenReturn(tiendasLista);

    when(this.tiendaMapper.toGenericTiendaResultItemDtoList(any(List.class), anyString())).thenReturn(tiendasLista);
    when(this.tareaAmbitoGlobalEmpresaService.findIdEmpresaByIdTarea(any(Long.class))).thenReturn(empresa);
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class))).thenReturn(periodo);
    final CompletableFuture<Void> validFuture = CompletableFuture.completedFuture(null);
    when(this.tareaLocalizacionHistoricoAsyncService.saveGenericTiendaResultItemDto(any(), any())).thenReturn(validFuture);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.localizacionByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);

    verify(this.incomeMetaService, timeout(1000).times(1))
        .getTiendas("11", List.of("95"), true, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 31), "0001");
  }

  @Test
  public void empleadosPresenciaByRunTareaAndTareaAmbitoTest() {
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

    when(this.meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_PRESENCIA)).thenReturn(properties);

    final CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture.completedFuture(new ArrayList<>());

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.tareaAmbitoGlobalEmpresaService.findIdEmpresaByIdTarea(any(Long.class))).thenReturn(empresa);

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class))).thenReturn(new PeriodoDto());

    when(this.tareaMapper
        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(any(TrabajoDTO.class), any(TareaDto.class),
            any(TareaAmbitoDto.class), any(PeriodoDto.class)))
                .thenReturn(new GenericFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getEmpleadosPresencia(any(EmpleadosPresenciaRequestDto.class)))
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
            .thenReturn(new ArrayList<>(List.of(new IdPersonaHistoricoDto("1", "1"))));
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

    final List<IdLocalizacionDto> persona = new ArrayList<>(List.of(new IdLocalizacionDto("1")));
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

    final List<IdLocalizacionDto> persona = new ArrayList<>(List.of(new IdLocalizacionDto("1")));
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
            List.of(new IdPersonaHIstoricoLocalizacionDto("1",
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
            List.of(new IdPersonaHIstoricoLocalizacionDto("1",
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
            List.of(new IdPersonaHistoricoDto("1",
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
            List.of(new IdPersonaHistoricoDto("1",
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

    final List<IdLocalizacionDto> localizacion = new ArrayList<>(List.of(new IdLocalizacionDto("1")));

    final List<TiendaResponseDTO> listTiendasResponse = Instancio.createList(TiendaResponseDTO.class);

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

    when(this.incomeMetaService.getTiendas(anyString(), any(), any(Boolean.class), any(LocalDate.class), any(LocalDate.class), anyString()))
        .thenReturn(listTiendasResponse);
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

    final List<IdLocalizacionDto> localizacion = new ArrayList<>(List.of(new IdLocalizacionDto("1")));

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

    final GenericFilterDto genericFilterDto = new GenericFilterDto();
    genericFilterDto.setIdOrigen("1");

    final List<AgrupacionesOnlineResponseDTO> agrupacionesOnlineResponseDTOS = new ArrayList<>();
    agrupacionesOnlineResponseDTOS.add(new AgrupacionesOnlineResponseDTO());

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
        any(PeriodoDto.class))).thenReturn(genericFilterDto);
    when(this.incomeMetaService.getAgrupOnline(any(String.class)))
        .thenReturn(agrupacionesOnlineResponseDTOS);
    when(this.tareaAgrupacionCadenaAsyncService.save(ArgumentMatchers.any(),
        any(TareaDto.class))).thenReturn(cfNull);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.agrupacionesCadenaByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);
    verify(this.incomeMetaService, timeout(1000).times(1))
        .getAgrupOnline(ArgumentMatchers.any(String.class));

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

    final GenericFilterDto genericFilterDto = new GenericFilterDto();
    genericFilterDto.setIdOrigen("1");

    final List<AgrupacionesOnlineResponseDTO> agrupacionesOnlineResponseDTOS = new ArrayList<>();
    agrupacionesOnlineResponseDTOS.add(new AgrupacionesOnlineResponseDTO());

    final List<IdEmpresaDto> empresa = new ArrayList<>();
    empresa.add(new IdEmpresaDto());

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class)))
            .thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.AGRUPACION_ONLINE)).thenReturn(properties);
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class),
        any(PeriodoDto.class))).thenReturn(genericFilterDto);
    when(this.incomeMetaService.getAgrupOnline(any(String.class)))
        .thenReturn(null);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.agrupacionesCadenaByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);
    verify(this.incomeMetaService, timeout(1000).times(1))
        .getAgrupOnline(ArgumentMatchers.any(String.class));

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
        any(String.class))).thenReturn(new ArrayList<>(List.of(new IdCadenaDto("1"))));
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
        any(String.class))).thenReturn(new ArrayList<>(List.of(new IdCadenaDto("1"))));
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

    final List<EmpleadoDTO> empleados = new ArrayList<>();
    final CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> null);

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class)))
            .thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS)).thenReturn(properties);
    when(this.tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(
        any(Long.class),
        any(String.class),
        ArgumentMatchers.eq(Collections.singletonList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()))))
            .thenReturn(new ArrayList<>(List.of(new IdCadenaDto("1"))));

    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtotoSearchEmpleadosFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new SearchEmpleadosFilterDto());

    when(this.incomeMetaService.searchEmpleados(any(SearchEmpleadosRequestDto.class))).thenReturn(empleados);
    when(this.tareaPersonaHistoricoAsyncService.saveEmpleadoDto(ArgumentMatchers
        .any(), any(TareaDto.class)))
            .thenReturn(cfNull);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosCadenaByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);
    verify(this.incomeMetaService, timeout(1000).times(1))
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
      verify(this.incomeMetaService, timeout(1000).times(1))
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

    final List<EmpleadoDTO> empleados = new ArrayList<>();

    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class),
        any(Integer.class)))
            .thenReturn(new PeriodoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS)).thenReturn(properties);
    when(this.tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(
        any(Long.class),
        any(String.class),
        ArgumentMatchers.eq(Collections.singletonList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()))))
            .thenReturn(new ArrayList<>(List.of(new IdCadenaDto("1"))));
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtotoSearchEmpleadosFilterDto(any(TareaDto.class),
        any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new SearchEmpleadosFilterDto());
    when(this.incomeMetaService.searchEmpleados(any(SearchEmpleadosRequestDto.class)))
        .thenReturn(empleados);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosCadenaByRunTareaAndTareaAmbito(
        runTarea,
        tareaAmbito);
    verify(this.incomeMetaService, timeout(1000).times(1))
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
                .thenReturn(
                    new ArrayList<>(Collections.singletonList(IdPersonaHistoricoDto.builder().stdOrHrPeriod("1").stdIdHr("1").build())));
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
                .thenReturn(
                    new ArrayList<>(Collections.singletonList(IdPersonaHistoricoDto.builder().stdOrHrPeriod("1").stdIdHr("1").build())));
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
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(1L);
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
        RunTareaDto.builder().tarea(tarea).trabajo(trabajo).build(), TareaAmbitoDto.builder().cclIdOrigen(idOrigen).build());

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
        List.of(new IdLocalizacionDto("1"))));
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
        List.of(new IdLocalizacionDto("1"))));
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
          .getEstadoWloc(ArgumentMatchers.any(EstadoWlocRequestDto.class));
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
            List.of(new IdLocalizacionDto("1"))));
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class), any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToEstadoWlocFilterDto(
        any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new EstadoWlocFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getEstadoWloc(any(EstadoWlocRequestDto.class)))
        .thenReturn(cf);

    when(this.tareaLocalizacionEstadoAsyncService.saveEstadoWlocResultItemDto(ArgumentMatchers.any(),
        any(TareaDto.class))).thenReturn(cfNull);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estadoWlocByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getEstadoWloc(ArgumentMatchers.any(EstadoWlocRequestDto.class));
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
            List.of(new IdLocalizacionDto("1"))));
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(any(Long.class), any(Integer.class)))
        .thenReturn(new PeriodoDto());
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToEstadoWlocFilterDto(
        any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new EstadoWlocFilterDto());
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getEstadoWloc(any(EstadoWlocRequestDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estadoWlocByRunTareaAndTareaAmbito(runTarea,
        tareaAmbito);
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1))
        .getEstadoWloc(ArgumentMatchers.any(EstadoWlocRequestDto.class));
  }

  @Test
  void confChallengeTipoVentaByRunTareaAndTareaAmbitoTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    tarea.setStdIdLegEnt("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    tarea.setIdOrganization("org");
    runTarea.setTarea(tarea);

    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("origen");

    final List<TiposVentaChallengeResponseDTO> mockResponse = Collections.singletonList(new TiposVentaChallengeResponseDTO());
    when(this.incomeMetaService.getTiposVentaChallenge("1", 1, LocalDate.now(), LocalDate.now(), "1"))
        .thenReturn(mockResponse);

    final ConfChTpVentaResultItemDto confChTpVentaResultItemDto = ConfChTpVentaResultItemDto.builder().m4AutoGeneratedRecordID("1")
        .m4AutoGeneratedToDelete(true)
        .fechaInicio(LocalDate.now().atStartOfDay())
        .fechaFin(LocalDate.now().atStartOfDay())
        .idAgrupacion("1")
        .idConceptoVenta("1")
        .idOrigen("1")
        .build();

    final Meta4PropertiesDto mockMeta4PropertiesDto = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto mockFilter = new Meta4FilterPropertiesDto();
    mockFilter.setMaxPersistenceSize(10);
    mockMeta4PropertiesDto.setFilter(mockFilter);
    mockMeta4PropertiesDto.setPage(new PageDto(1, 100));

    this.meta4Properties.put(Meta4PropertiesConstants.CONFCHALLENGETPVENTA, mockMeta4PropertiesDto);
    when(this.meta4Properties.get(Meta4PropertiesConstants.CONFCHALLENGETPVENTA)).thenReturn(mockMeta4PropertiesDto);
    final List<ConfChTpVentaResultItemDto> mappedResponse = Collections.singletonList(confChTpVentaResultItemDto);
    when(this.tipoVentaConceptoChallengeMapper.confChTpVentaResultItemDtoListToConfChTpVentaResultItemDtoList(mockResponse))
        .thenReturn(mappedResponse);

    assertDoesNotThrow(() -> {
      this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl
          .confChallengeTipoVentaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
    });
  }

  @Test
  public void ausenciasByRunTareaAndTareaAmbitoTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("origen");

    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPersistenceSize(10);
    properties.setFilter(filter);
    properties.setPage(new PageDto(1, 100));
    when(this.meta4Properties.get(Meta4PropertiesConstants.AUSENCIAS)).thenReturn(properties);

    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(
        any(TareaDto.class), any(TareaAmbitoDto.class), any())).thenReturn(new GenericFilterDto());

    final CompletableFuture<List<AusenciasResultItemDto>> cfData = CompletableFuture.completedFuture(
        Collections.singletonList(new AusenciasResultItemDto()));
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getAusencias(any(AusenciasRequestDto.class)))
        .thenReturn(cfData);

    final CompletableFuture<Void> cfSave = CompletableFuture.completedFuture(null);
    when(this.tareaPersonaAusenciaHistoricoAsyncService.saveAusenciaResultItemDto(anyList(), any(TareaDto.class)))
        .thenReturn(cfSave);

    assertDoesNotThrow(() -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl
        .ausenciasByRunTareaAndTareaAmbito(runTarea, tareaAmbito));

    verify(this.meta4Properties, times(2)).get(Meta4PropertiesConstants.AUSENCIAS);
    verify(this.tareaMapper, times(1)).mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(
        any(TareaDto.class), any(TareaAmbitoDto.class), any());
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService, atLeastOnce()).getAusencias(any(AusenciasRequestDto.class));
    verify(this.tareaPersonaAusenciaHistoricoAsyncService, atLeastOnce())
        .saveAusenciaResultItemDto(anyList(), any(TareaDto.class));
  }

  @Test
  public void configuracionByRunTareaAndTareaAmbitoTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("origen");

    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPersistenceSize(10);
    properties.setFilter(filter);
    properties.setPage(new PageDto(1, 100));
    when(this.meta4Properties.get(Meta4PropertiesConstants.CONFIGURACION)).thenReturn(properties);

    final ConfiguracionesRequestDto request = new ConfiguracionesRequestDto();
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToConfiguracionesRequestDto(
        any(TareaDto.class), any(TareaAmbitoDto.class), any())).thenReturn(request);

    final ConfiguracionesResponseDto response = new ConfiguracionesResponseDto();
    final ConfiguracionItemDto item = ConfiguracionItemDto.builder().build();
    response.setItems(List.of(item));
    final CompletableFuture<ConfiguracionesResponseDto> cfData = CompletableFuture.completedFuture(response);
    when(this.meta4IcmWsCalcIncomeAsyncService.getConfiguraciones(any(ConfiguracionesRequestDto.class)))
        .thenReturn(cfData);

    final CompletableFuture<Void> cfSave = CompletableFuture.completedFuture(null);
    when(this.tareaConfiguracionAsyncService.saveConfiguracionItemDto(anyList(), any(TareaDto.class)))
        .thenReturn(cfSave);

    assertDoesNotThrow(() -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl
        .configuracionByRunTareaAndTareaAmbito(runTarea, tareaAmbito));

    verify(this.meta4Properties, times(1)).get(Meta4PropertiesConstants.CONFIGURACION);
    verify(this.tareaMapper, times(1)).mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToConfiguracionesRequestDto(
        any(TareaDto.class), any(TareaAmbitoDto.class), any());
    verify(this.meta4IcmWsCalcIncomeAsyncService, times(1)).getConfiguraciones(any(ConfiguracionesRequestDto.class));
    verify(this.tareaConfiguracionAsyncService, atLeastOnce())
        .saveConfiguracionItemDto(anyList(), any(TareaDto.class));
  }

  @Test
  public void localizacionCadenaByRunTareaAndTareaAmbitoTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now().plusDays(1));
    tarea.setIdOrganization("org");
    runTarea.setTarea(tarea);

    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("origen");

    final List<IdCadenaDto> cadenas = Collections.singletonList(new IdCadenaDto("cadena1"));
    final List<GenericTiendaResultItemDto> tiendas = Collections.singletonList(new GenericTiendaResultItemDto());

    when(this.tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(
        any(Long.class), any(String.class), anyList())).thenReturn(cadenas);

    when(this.incomeMetaService.getTiendas(anyString(), anyList(), anyBoolean(), any(LocalDate.class), any(LocalDate.class), anyString()))
        .thenReturn(Collections.emptyList());

    when(this.tiendaMapper.toGenericTiendaResultItemDtoList(anyList(), anyString())).thenReturn(tiendas);

    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPersistenceSize(10);
    properties.setFilter(filter);
    when(this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_TIENDAS)).thenReturn(properties);

    final CompletableFuture<Void> cfSave = CompletableFuture.completedFuture(null);
    when(this.tareaLocalizacionHistoricoAsyncService.saveGenericTiendaResultItemDto(anyList(), any(TareaDto.class)))
        .thenReturn(cfSave);

    assertDoesNotThrow(() -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl
        .localizacionCadenaByRunTareaAndTareaAmbito(runTarea, tareaAmbito));

    verify(this.tareaLocalizacionHistoricoService, times(1))
        .findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(any(Long.class), any(String.class), anyList());
    verify(this.incomeMetaService, times(1))
        .getTiendas(anyString(), anyList(), anyBoolean(), any(LocalDate.class), any(LocalDate.class), anyString());
    verify(this.tiendaMapper, times(1)).toGenericTiendaResultItemDtoList(anyList(), anyString());
    verify(this.tareaLocalizacionHistoricoAsyncService, times(1))
        .saveGenericTiendaResultItemDto(anyList(), any(TareaDto.class));
  }

  @Test
  void testPresupuestosWlocByRunTareaAndTareaAmbito() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setCclIdOrigen("origen");
    final List<IdEmpresaDto> empresasAmbito = Collections.singletonList(mock(IdEmpresaDto.class));
    final List<IdPersonaLocalDto> personasChallenge = Collections.singletonList(mock(IdPersonaLocalDto.class));

    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPersistenceSize(10);
    properties.setFilter(filter);
    properties.setPage(new PageDto(1, 100));
    when(this.meta4Properties.get(Meta4PropertiesConstants.PRESUPUESTOSWLOC)).thenReturn(properties);

    when(this.tareaPersonaEstructuraService.findPersonasChallenge(tarea)).thenReturn(personasChallenge);
    when(this.tareaMapper.idEmpresaDtoToPresupuestosWlocFilterParametersDto(any(IdEmpresaDto.class))).thenReturn(
        Instancio.create(PresupuestosWlocFilterParametersDto.class));
    when(this.tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPresupuestosWlocFilterDto(any(), any(), any()))
        .thenReturn(Instancio.create(PresupuestosWlocFilterDto.class));

    final CompletableFuture<Void> cfSave = CompletableFuture.completedFuture(null);
    when(this.tareaLocalizacionPresupuestoAsyncService.save(anyList(), any(TareaDto.class)))
        .thenReturn(cfSave);

    final List<PresupuestosWlocResultItemDto> response = Instancio.createList(PresupuestosWlocResultItemDto.class);
    final CompletableFuture<List<PresupuestosWlocResultItemDto>> cfData = CompletableFuture.completedFuture(response);
    when(this.tareaAmbitoGlobalEmpresaService.findIdEmpresaByIdTarea(tarea.getId())).thenReturn(empresasAmbito);

    final List<PresupuestosWlocResultItemDto> resultData = Instancio.createList(PresupuestosWlocResultItemDto.class);
    when(this.meta4IcmWsCalcIncomeSessionAsyncService.getPresupuestosWloc(any()))
        .thenReturn(CompletableFuture.completedFuture(resultData));

    // Act
    assertDoesNotThrow(
        () -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.presupuestosWlocByRunTareaAndTareaAmbito(runTarea, tareaAmbito));

    // Assert
    verify(this.tareaPersonaEstructuraService).findPersonasChallenge(tarea);
    verify(this.tareaAmbitoGlobalEmpresaService).findIdEmpresaByIdTarea(tarea.getId());
    verify(this.meta4IcmWsCalcIncomeSessionAsyncService).getPresupuestosWloc(any(PresupuestosWlocRequestDto.class));
  }

  @Test
  void testPresupuestosWlocByRunTareaAndTareaAmbito_Exception() {
    // Arrange
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);

    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();

    when(this.tareaPersonaEstructuraService.findPersonasChallenge(tarea)).thenThrow(new RuntimeException("Test exception"));

    assertThrows(RuntimeException.class,
        () -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.presupuestosWlocByRunTareaAndTareaAmbito(runTarea, tareaAmbito));

    verify(this.tareaPersonaEstructuraService, times(1)).findPersonasChallenge(tarea);

  }

  @Test
  void confPrecioHoraByRunTareaAndTareaAmbito_Success() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    tarea.setIdOrganization("PL");
    runTarea.setTarea(tarea);

    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();

    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPersistenceSize(10);
    final ConfPrecioHoraFilterDto filterDto = new ConfPrecioHoraFilterDto();
    filterDto.setIdOrigen("1");
    filterDto.setFechaInicio(LocalDateTime.now());
    filterDto.setFechaFin(LocalDateTime.now().plusDays(30));
    properties.setFilter(filter);
    properties.setPage(new PageDto(1, 100));
    when(this.meta4Properties.get(Meta4PropertiesConstants.CONFPRECIOHORA)).thenReturn(properties);

    final List<ConfiguracionPrecioHoraResponseDTO> data = List.of(new ConfiguracionPrecioHoraResponseDTO());
    when(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToConfPrecioHoraFilterDto(any(), any(), any()))
        .thenReturn(filterDto);
    when(this.incomeMetaService.getConfPrecioHora(anyString(), any(), any())).thenReturn(data);

    final CompletableFuture<Void> cfSave = CompletableFuture.completedFuture(AsyncConstants.NIL);
    when(this.tareaConfiguracionPrecioHoraAsyncService.saveConfiguracionPrecioHoraResponseDTO(anyList(), any(), anyString()))
        .thenReturn(cfSave);

    assertDoesNotThrow(() -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl
        .confPrecioHoraByRunTareaAndTareaAmbito(runTarea, tareaAmbito));

    verify(this.meta4Properties, times(2)).get(Meta4PropertiesConstants.CONFPRECIOHORA);
    verify(this.incomeMetaService, times(1)).getConfPrecioHora(anyString(), any(), any());
    verify(this.tareaConfiguracionPrecioHoraAsyncService, times(1)).saveConfiguracionPrecioHoraResponseDTO(anyList(), any(), anyString());
  }
}
