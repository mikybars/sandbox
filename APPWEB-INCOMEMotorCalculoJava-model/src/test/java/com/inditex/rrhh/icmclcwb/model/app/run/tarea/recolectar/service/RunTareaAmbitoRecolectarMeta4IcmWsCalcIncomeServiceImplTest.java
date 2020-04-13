package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
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
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaCoeficienteAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaEstructuraPoliticaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4FilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;

@RunWith(MockitoJUnitRunner.class)
public class RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImplTest{
    
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
    private Map<String, Meta4PropertiesDto> meta4Properties;
    
    @Mock
    private RecolectarPropertiesDto recolectarProperties;
    
    @Mock
    private TareaMapper tareaMapper;
    
    @InjectMocks
    private RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl;

    @Test(expected = Exception.class)
    public void personaByRunTareaAndTareaAmbitoException() throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        RunTareaDto runTarea = new RunTareaDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.personaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);

        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).searchEmpleados(ArgumentMatchers.any(SearchEmpleadosRequestDto.class));
    }
    
    @Test
    public void personaByRunTareaAndTareaAmbito() throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        RunTareaDto runTarea = new RunTareaDto();
        runTarea.setTarea(new TareaDto());
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);
        CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            return new ArrayList<>();
        });
        
        CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });

        when(meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS)).thenReturn(properties);
        when(meta4IcmWsCalcIncomeSessionAsyncService.searchEmpleados(any(SearchEmpleadosRequestDto.class))).thenReturn(cf);

        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.personaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);

        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).searchEmpleados(ArgumentMatchers.any(SearchEmpleadosRequestDto.class));
    }
    
    @Test(expected = Exception.class)
    public void localizacionByRunTareaAndTareaAmbitoException() throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        RunTareaDto runTarea = new RunTareaDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.localizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).searchTiendas(ArgumentMatchers.any(SearchTiendasRequestDto.class));
    }
    
    @Test
    public void localizacionByRunTareaAndTareaAmbito() {
        RunTareaDto runTarea = new RunTareaDto();
        runTarea.setTarea(new TareaDto());
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);
        CompletableFuture<List<GenericTiendaResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            return new ArrayList<>();
        });
        
         CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });
         
        when(meta4Properties.get(Meta4PropertiesConstants.SEARCH_TIENDAS)).thenReturn(properties);
        when(meta4IcmWsCalcIncomeSessionAsyncService.searchTiendas(any(SearchTiendasRequestDto.class))).thenReturn(cf);

        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.localizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).searchTiendas(ArgumentMatchers.any(SearchTiendasRequestDto.class));

    }

    @Test
    public void empleadosPresenciaByRunTareaAndTareaAmbito() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2015, 3, 1));
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);
        CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            return new ArrayList<>();
        });
        
         CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });
         
        when(meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_PRESENCIA)).thenReturn(properties);
        when(tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(any(TrabajoDto.class), any(TareaDto.class), any(TareaAmbitoDto.class) )).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getEmpleadosPresencia(any(EmpleadosPresenciaRequestDto.class))).thenReturn(cf);
         
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosPresenciaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getEmpleadosPresencia(ArgumentMatchers.any(EmpleadosPresenciaRequestDto.class));

    }
    
    @Test(expected = Exception.class)
    public void festivosByRunTareaAndTareaAmbitoException() throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        RunTareaDto runTarea = new RunTareaDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.festivosByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getFestivos(ArgumentMatchers.any(FestivosRequestDto.class));
    }
    
    @Test
    public void festivosByRunTareaAndTareaAmbito() {
        RunTareaDto runTarea = new RunTareaDto();
        runTarea.setTarea(new TareaDto());
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);
        CompletableFuture<List<GenericTiendaResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            return new ArrayList<>();
        });
        
         CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });
         
        when(meta4Properties.get(Meta4PropertiesConstants.FESTIVOS)).thenReturn(properties);
        when(tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(any(TrabajoDto.class), any(TareaDto.class), any(TareaAmbitoDto.class) )).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getFestivos(any(FestivosRequestDto.class))).thenReturn(cf);
         
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.festivosByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getFestivos(ArgumentMatchers.any(FestivosRequestDto.class));

    }
    
    @Test(expected = Exception.class)
    public void coefJornadaByRunTareaAndTareaAmbitoException() throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        RunTareaDto runTarea = new RunTareaDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.coefJornadaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getCoefJornada(ArgumentMatchers.any(CoefJornadaRequestDto.class));
    }
    
    @Test
    public void coefJornadaByRunTareaAndTareaAmbito() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(1L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        tareaAmbito.setCclIdOrigen("38");
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            return new ArrayList<>();
        });
        
         CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });

        when(tareaLocalizacionPresupuestoService.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(new PeriodoDto());
        when(meta4Properties.get(Meta4PropertiesConstants.COEF_JORNADA)).thenReturn(properties);
        when(tareaPersonaHistoricoService.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(any(Long.class), any(String.class), (List<Integer>) any(List.class))).thenReturn(new ArrayList<>(Arrays.asList(new IdPersonaHistoricoDto("1", "1"))));
        when(tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getCoefJornada(any(CoefJornadaRequestDto.class))).thenReturn(cf);
         
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.coefJornadaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getCoefJornada(ArgumentMatchers.any(CoefJornadaRequestDto.class));
    }
    
    @Test(expected = Exception.class)
    public void flagCalculaByRunTareaAndTareaAmbitoException() throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        RunTareaDto runTarea = new RunTareaDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.flagCalculaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getFlagCalcula(ArgumentMatchers.any(FlagCalculaRequestDto.class));
   }
    
    @Test
    public void flagCalculaByRunTareaAndTareaAmbito() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(1L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        tareaAmbito.setCclIdOrigen("38");
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        List<IdLocalizacionDto> persona = new ArrayList<>(Arrays.asList(new IdLocalizacionDto("1")));
        CompletableFuture<List<GenericTiendaResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            return new ArrayList<>();
        });
        
         CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });

        when(tareaLocalizacionPresupuestoService.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(new PeriodoDto());
        when(meta4Properties.get(Meta4PropertiesConstants.FLAG_CALCULA)).thenReturn(properties);
        when(tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(any(Long.class), any(String.class))).thenReturn(persona);
        when(tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getFlagCalcula(any(FlagCalculaRequestDto.class))).thenReturn(cf);
         
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.flagCalculaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getFlagCalcula(ArgumentMatchers.any(FlagCalculaRequestDto.class));

    }
    
    @Test(expected = Exception.class)
    public void presenciaManualByRunTareaAndTareaAmbitoException() throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        RunTareaDto runTarea = new RunTareaDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.presenciaManualByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getPresenciaManual(ArgumentMatchers.any(PresenciaManualRequestDto.class));
    }
    
    
    @Test
    public void presenciaManualByRunTareaAndTareaAmbito() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(1L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        tareaAmbito.setCclIdOrigen("38");
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        when(tareaLocalizacionPresupuestoService.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(new PeriodoDto());

        List<IdLocalizacionDto> persona = new ArrayList<>(Arrays.asList(new IdLocalizacionDto("1")));
        CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            return new ArrayList<>();
        });
        
        CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });
         
        when(meta4Properties.get(Meta4PropertiesConstants.PRESENCIA_MANUAL)).thenReturn(properties);
        when(tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getPresenciaManual(any(PresenciaManualRequestDto.class))).thenReturn(cf);
        when(tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(any(Long.class), any(String.class))).thenReturn(persona);
         
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.presenciaManualByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getPresenciaManual(ArgumentMatchers.any(PresenciaManualRequestDto.class));

    }
        
    @Test(expected = Exception.class)
    public void estructurasComByRunTareaAndTareaAmbitoException() throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        RunTareaDto runTarea = new RunTareaDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasComByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getEstructurasCom(ArgumentMatchers.any(EstructurasComRequestDto.class));
    }
    
    @Test
    public void estructurasComByRunTareaAndTareaAmbitoTest() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(1L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        tareaAmbito.setCclIdOrigen("38");
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        CompletableFuture<List<EstructurasComResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            List<EstructurasComResultItemDto> comision = new ArrayList<>();
            comision.add(EstructurasComResultItemDto.builder().build());
            return comision;
        });
        
        CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });
         
        when(meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_COM)).thenReturn(properties);
        when(tareaPersonaHistoricoService.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(any(Long.class), any(String.class))).thenReturn(new ArrayList<>(Arrays.asList(new IdPersonaHistoricoDto("1", "1"))));
        when(tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToEstructurasComFilterDto(any(TrabajoDto.class), any(TareaDto.class), any(TareaAmbitoDto.class))).thenReturn(new EstructurasComFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getEstructurasCom(any(EstructurasComRequestDto.class))).thenReturn(cf);
        when(tareaPersonaEstructuraAsyncService.saveEstructurasComResultItemDto(any(List.class), any(TareaDto.class))).thenReturn(cfNull);

        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasComByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getEstructurasCom(ArgumentMatchers.any(EstructurasComRequestDto.class));
    }
    
    @Test
    public void estructurasComByRunTareaAndTareaAmbitoEmptyResult() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(1L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        tareaAmbito.setCclIdOrigen("38");
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        CompletableFuture<List<EstructurasComResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            return new ArrayList<>();
        });
         
        when(meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_COM)).thenReturn(properties);
        when(tareaPersonaHistoricoService.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(any(Long.class), any(String.class))).thenReturn(new ArrayList<>(Arrays.asList(new IdPersonaHistoricoDto("1", "1"))));
        when(tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToEstructurasComFilterDto(any(TrabajoDto.class), any(TareaDto.class), any(TareaAmbitoDto.class))).thenReturn(new EstructurasComFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getEstructurasCom(any(EstructurasComRequestDto.class))).thenReturn(cf);

        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasComByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getEstructurasCom(ArgumentMatchers.any(EstructurasComRequestDto.class));
    }

    @Test(expected = Exception.class)
    public void estructurasPolByRunTareaAndTareaAmbitoException() throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        RunTareaDto runTarea = new RunTareaDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasPolByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getEstructurasPol(ArgumentMatchers.any(EstructurasPolRequestDto.class));
    }
    
    @Test
    public void estructurasPolByRunTareaAndTareaAmbito() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(1L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        tareaAmbito.setCclIdOrigen("38");
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        CompletableFuture<List<EstructurasPolResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            List<EstructurasPolResultItemDto> comision = new ArrayList<>();
            comision.add(EstructurasPolResultItemDto.builder().build());
            return comision;
        });
        
        CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });
         
        when(meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_POL)).thenReturn(properties);
        when(tareaPersonaHistoricoService.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(any(Long.class), any(String.class))).thenReturn(new ArrayList<>(Arrays.asList(new IdPersonaHistoricoDto("1", "1"))));
        when(tareaPersonaHistoricoService.findPeriodoByIdTareaDto(any(Long.class))).thenReturn(new PeriodoDto());
        when(tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getEstructurasPol(any(EstructurasPolRequestDto.class))).thenReturn(cf);
        when(tareaPersonaEstructuraPoliticaAsyncService.saveEstructurasPolResultItemDto(any(List.class), any(TareaDto.class))).thenReturn(cfNull);

        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasPolByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getEstructurasPol(ArgumentMatchers.any(EstructurasPolRequestDto.class));
    }
    
    @Test
    public void estructurasPolByRunTareaAndTareaAmbitoEmptyResult() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(1L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        tareaAmbito.setCclIdOrigen("38");
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        CompletableFuture<List<EstructurasPolResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            return new ArrayList<>();
        });
         
        when(meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_POL)).thenReturn(properties);
        when(tareaPersonaHistoricoService.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(any(Long.class), any(String.class))).thenReturn(new ArrayList<>(Arrays.asList(new IdPersonaHistoricoDto("1", "1"))));
        when(tareaPersonaHistoricoService.findPeriodoByIdTareaDto(any(Long.class))).thenReturn(new PeriodoDto());
        when(tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getEstructurasPol(any(EstructurasPolRequestDto.class))).thenReturn(cf);

        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.estructurasPolByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getEstructurasPol(ArgumentMatchers.any(EstructurasPolRequestDto.class));
    }

    
    @Test(expected = Exception.class)
    public void configuracionVentaOnlineByRunTareaAndTareaAmbitoException() throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        RunTareaDto runTarea = new RunTareaDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.configuracionVentaOnlineByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getConfiguracionVentaOnline(ArgumentMatchers.any(ConfiguracionVentaOnlineRequestDto.class));
    }
    
    @Test
    public void configuracionVentaOnlineByRunTareaAndTareaAmbito() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(1L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        CompletableFuture<List<ConfiguracionVentaOnlineResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            List<ConfiguracionVentaOnlineResultItemDto> conf = new ArrayList<>();
            conf.add(new ConfiguracionVentaOnlineResultItemDto());
            return conf;
        });
        
        CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });

        when(tareaLocalizacionPresupuestoService.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(new PeriodoDto());
        when(meta4Properties.get(Meta4PropertiesConstants.CONF_VENTA_ONLINE)).thenReturn(properties);
        when(tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDtoWithDates(any(TareaDto.class), any(TareaAmbitoDto.class),
            any(PeriodoDto.class), any(RecolectarPropertiesDto.class))).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getConfiguracionVentaOnline(any(ConfiguracionVentaOnlineRequestDto.class))).thenReturn(cf);
        when(tareaAgrupacionConfiguracionAsyncService.saveAgrupacionConfiguracionDto(any(List.class), any(RunTareaDto.class))).thenReturn(cfNull);

        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.configuracionVentaOnlineByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getConfiguracionVentaOnline(ArgumentMatchers.any(ConfiguracionVentaOnlineRequestDto.class));

    }
    
    @Test
    public void configuracionVentaOnlineByRunTareaAndTareaAmbitoEmpty() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(8902L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        CompletableFuture<List<ConfiguracionVentaOnlineResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            return new ArrayList<>();
        });

        when(tareaLocalizacionPresupuestoService.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(new PeriodoDto());
        when(meta4Properties.get(Meta4PropertiesConstants.CONF_VENTA_ONLINE)).thenReturn(properties);
        when(tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDtoWithDates(any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class), any(RecolectarPropertiesDto.class))).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getConfiguracionVentaOnline(any(ConfiguracionVentaOnlineRequestDto.class))).thenReturn(cf);

        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.configuracionVentaOnlineByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getConfiguracionVentaOnline(ArgumentMatchers.any(ConfiguracionVentaOnlineRequestDto.class));

    }
    
    @Test(expected = Exception.class)
    public void tiendasComisionableByRunTareaAndTareaAmbitoException() throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        RunTareaDto runTarea = new RunTareaDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasComisionableByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getTiendas(ArgumentMatchers.any(TiendasRequestDto.class));
    }

    @Test
    public void tiendasComisionableByRunTareaAndTareaAmbito() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(1L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        tareaAmbito.setCclIdOrigen("38");
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        List<IdLocalizacionDto> localizacion = new ArrayList<>(Arrays.asList(new IdLocalizacionDto("1")));
        
        CompletableFuture<List<GenericTiendaResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            List<GenericTiendaResultItemDto> tienda = new ArrayList<>();
            tienda.add(new GenericTiendaResultItemDto());
            return tienda;
        });
        
        CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });

        when(tareaLocalizacionPresupuestoService.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(new PeriodoDto());
        when(meta4Properties.get(Meta4PropertiesConstants.TIENDAS)).thenReturn(properties);
        when(tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(any(Long.class), any(String.class))).thenReturn(localizacion);
        when(tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getTiendas(any(TiendasRequestDto.class))).thenReturn(cf);
        when(tareaLocalizacionComisionHistoricoAsyncService.saveGenericTiendaResultItemDto(any(List.class), any(TareaDto.class))).thenReturn(cfNull);
        
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasComisionableByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getTiendas(ArgumentMatchers.any(TiendasRequestDto.class));

    }
    
    @Test
    public void tiendasComisionableByRunTareaAndTareaAmbitoEmpty() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(1L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        tareaAmbito.setCclIdOrigen("38");
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        List<IdLocalizacionDto> localizacion = new ArrayList<>(Arrays.asList(new IdLocalizacionDto("1")));
        
        CompletableFuture<List<GenericTiendaResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            return new ArrayList<>();
        });

        when(tareaLocalizacionPresupuestoService.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(new PeriodoDto());
        when(meta4Properties.get(Meta4PropertiesConstants.TIENDAS)).thenReturn(properties);
        when(tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(any(Long.class), any(String.class))).thenReturn(localizacion);
        when(tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class), any(TareaAmbitoDto.class),
            any(PeriodoDto.class))).thenReturn(new GenericFilterDto());        when(meta4IcmWsCalcIncomeSessionAsyncService.getTiendas(any(TiendasRequestDto.class))).thenReturn(cf);
        
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.tiendasComisionableByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getTiendas(ArgumentMatchers.any(TiendasRequestDto.class));

    }

    @Test(expected = Exception.class)
    public void agrupacionesCadenaByRunTareaAndTareaAmbitoException() throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        RunTareaDto runTarea = new RunTareaDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.agrupacionesCadenaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getAgrupacionesOnline(ArgumentMatchers.any(AgrupOnlineRequestDto.class));
   }
    
    @Test
    public void agrupacionesCadenaByRunTareaAndTareaAmbito() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(1L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        CompletableFuture<List<AgrupOnlineResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            List<AgrupOnlineResultItemDto> agrup = new ArrayList<>();
            agrup.add(new AgrupOnlineResultItemDto());
            return agrup;
        });
        
        CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });

        when(tareaLocalizacionPresupuestoService.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(new PeriodoDto());
        when(meta4Properties.get(Meta4PropertiesConstants.AGRUPACION_ONLINE)).thenReturn(properties);
        when(tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class), any(TareaAmbitoDto.class),
            any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getAgrupacionesOnline(any(AgrupOnlineRequestDto.class))).thenReturn(cf);
        when(tareaAgrupacionCadenaAsyncService.save(any(List.class), any(TareaDto.class))).thenReturn(cfNull);
        
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.agrupacionesCadenaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getAgrupacionesOnline(ArgumentMatchers.any(AgrupOnlineRequestDto.class));

    }
    
    @Test
    public void agrupacionesCadenaByRunTareaAndTareaAmbitoEmpty() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(89989L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        CompletableFuture<List<AgrupOnlineResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            return new ArrayList<>();
        });

        when(tareaLocalizacionPresupuestoService.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(new PeriodoDto());
        when(meta4Properties.get(Meta4PropertiesConstants.AGRUPACION_ONLINE)).thenReturn(properties);
        when(tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class), any(TareaAmbitoDto.class),
            any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getAgrupacionesOnline(any(AgrupOnlineRequestDto.class))).thenReturn(cf);
        
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.agrupacionesCadenaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getAgrupacionesOnline(ArgumentMatchers.any(AgrupOnlineRequestDto.class));

    }
    
    @Test(expected = Exception.class)
    public void localizacionesOnlineByRunTareaAndTareaAmbitoException() throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        RunTareaDto runTarea = new RunTareaDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.localizacionesOnlineByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getTiendasOnline(ArgumentMatchers.any(TiendaOnlineRequestDto.class));
    }
    
    @Test
    public void localizacionesOnlineByRunTareaAndTareaAmbito() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(1L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        tareaAmbito.setCclIdOrigen("38");
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        CompletableFuture<List<TiendaOnlineResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            List<TiendaOnlineResultItemDto> tienda = new ArrayList<>();
            tienda.add(new TiendaOnlineResultItemDto());
            return tienda;
        });
        
        CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });

        when(tareaLocalizacionPresupuestoService.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(new PeriodoDto());
        when(meta4Properties.get(Meta4PropertiesConstants.TIENDAS_ONLINE)).thenReturn(properties);
        when(tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigen(any(Long.class), any(String.class))).thenReturn(new ArrayList<>(Arrays.asList(new IdCadenaDto("1"))));
        when(tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getTiendasOnline(any(TiendaOnlineRequestDto.class))).thenReturn(cf);
        when(tareaLocalizacionOnlineHistoricoAsyncService.save(any(List.class), any(TareaDto.class))).thenReturn(cfNull);

        
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.localizacionesOnlineByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getTiendasOnline(ArgumentMatchers.any(TiendaOnlineRequestDto.class));

    }
    
    @Test
    public void localizacionesOnlineByRunTareaAndTareaAmbitoEmpty() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = new TareaDto();
        tarea.setId(1L);
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        tareaAmbito.setCclIdOrigen("38");
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        CompletableFuture<List<TiendaOnlineResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            return new ArrayList<>();
        });

        when(tareaLocalizacionPresupuestoService.findPeriodoPresupuestoYTrabajo(any(Long.class))).thenReturn(new PeriodoDto());
        when(meta4Properties.get(Meta4PropertiesConstants.TIENDAS_ONLINE)).thenReturn(properties);
        when(tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigen(any(Long.class), any(String.class))).thenReturn(new ArrayList<>(Arrays.asList(new IdCadenaDto("1"))));
        when(tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(any(TareaDto.class), any(TareaAmbitoDto.class), any(PeriodoDto.class))).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getTiendasOnline(any(TiendaOnlineRequestDto.class))).thenReturn(cf);
        
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.localizacionesOnlineByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getTiendasOnline(ArgumentMatchers.any(TiendaOnlineRequestDto.class));

    }
    
    @Test(expected = Exception.class)
    public void empleadosDesplazamientoByRunTareaAndTareaAmbitoException() throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        RunTareaDto runTarea = new RunTareaDto();
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosDesplazamientoByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getEmpleadosDesplazamiento(ArgumentMatchers.any(EmpleadosDesplazamientoRequestDto.class));
    }
    
    @Test
    public void empleadosDesplazamientoByRunTareaAndTareaAmbito() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2015, 3, 1));
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            List<GenericEmpleadoResultItemDto> emp = new ArrayList<>();
            emp.add(new GenericEmpleadoResultItemDto());
            return emp;
        });
        
        CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });

        when(meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_DESPLAZAMIENTO)).thenReturn(properties);
        when(tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(any(TrabajoDto.class), any(TareaDto.class), any(TareaAmbitoDto.class))).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getEmpleadosDesplazamiento(any(EmpleadosDesplazamientoRequestDto.class))).thenReturn(cf);
        when(tareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService.saveGenericEmpleadoResultItemDto(any(List.class), any(TareaDto.class))).thenReturn(cfNull);
        
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosDesplazamientoByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getEmpleadosDesplazamiento(ArgumentMatchers.any(EmpleadosDesplazamientoRequestDto.class));

    }

    @Test
    public void empleadosDesplazamientoByRunTareaAndTareaAmbitoEmpty() {
        RunTareaDto runTarea = new RunTareaDto();
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2015, 3, 1));
        runTarea.setTarea(tarea);
        runTarea.setTrabajo(new TrabajoDto());
        PageDto page = new PageDto(1, 100);
        TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        CompletableFuture<List<GenericEmpleadoResultItemDto>> cf = CompletableFuture.supplyAsync(() -> {
            return new ArrayList<>();
        });
        
        when(meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_DESPLAZAMIENTO)).thenReturn(properties);
        when(tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(any(TrabajoDto.class), any(TareaDto.class), any(TareaAmbitoDto.class))).thenReturn(new GenericFilterDto());
        when(meta4IcmWsCalcIncomeSessionAsyncService.getEmpleadosDesplazamiento(any(EmpleadosDesplazamientoRequestDto.class))).thenReturn(cf);
        
        runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.empleadosDesplazamientoByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        verify(meta4IcmWsCalcIncomeSessionAsyncService, timeout(1000).times(1)).getEmpleadosDesplazamiento(ArgumentMatchers.any(EmpleadosDesplazamientoRequestDto.class));

    }

}
