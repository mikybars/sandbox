package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;

@RunWith(MockitoJUnitRunner.class)
public class Meta4IcmWsCalcIncomeSessionAsyncServiceImplTest {

    @Mock
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;
    
    @InjectMocks
    private Meta4IcmWsCalcIncomeSessionAsyncServiceImpl meta4IcmWsCalcIncomeSessionAsyncServiceImpl;
    
    @Test
    public void getFlagCalcula() {
        when(meta4IcmWsCalcIncomeSessionService.getFlagCalcula(any(FlagCalculaRequestDto.class))).thenReturn(new ArrayList<GenericTiendaResultItemDto>());

        FlagCalculaRequestDto request = new FlagCalculaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getFlagCalcula(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getFlagCalcula(ArgumentMatchers.any(FlagCalculaRequestDto.class));

    }
    
    @Test
    public void getCoefJornada() {
        when(meta4IcmWsCalcIncomeSessionService.getCoefJornada(any(CoefJornadaRequestDto.class))).thenReturn(new ArrayList<GenericEmpleadoResultItemDto>());

        CoefJornadaRequestDto request = new CoefJornadaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getCoefJornada(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getCoefJornada(ArgumentMatchers.any(CoefJornadaRequestDto.class));

    }
    
    @Test
    public void getFestivos() {
        when(meta4IcmWsCalcIncomeSessionService.getFestivos(any(FestivosRequestDto.class))).thenReturn(new ArrayList<GenericTiendaResultItemDto>());

        FestivosRequestDto request = new FestivosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getFestivos(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getFestivos(ArgumentMatchers.any(FestivosRequestDto.class));

    }
    
    @Test
    public void getPresenciaManual() {
        when(meta4IcmWsCalcIncomeSessionService.getPresenciaManual(any(PresenciaManualRequestDto.class))).thenReturn(new ArrayList<GenericEmpleadoResultItemDto>());

        PresenciaManualRequestDto request = new PresenciaManualRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getPresenciaManual(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getPresenciaManual(ArgumentMatchers.any(PresenciaManualRequestDto.class));

    }
    
    @Test
    public void getEmpleadosPresencia() {
        when(meta4IcmWsCalcIncomeSessionService.getEmpleadosPresencia(any(EmpleadosPresenciaRequestDto.class))).thenReturn(new ArrayList<GenericEmpleadoResultItemDto>());

        EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getEmpleadosPresencia(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getEmpleadosPresencia(ArgumentMatchers.any(EmpleadosPresenciaRequestDto.class));

    }
    
    @Test
    public void getPeriodos() {
        when(meta4IcmWsCalcIncomeSessionService.getPeriodos(any(PeriodosRequestDto.class))).thenReturn(new ArrayList<PeriodosResultItemDto>());

        PeriodosRequestDto request = new PeriodosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getPeriodos(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getPeriodos(ArgumentMatchers.any(PeriodosRequestDto.class));

    }
    
    @Test
    public void getTiendasEmpleado() {
        when(meta4IcmWsCalcIncomeSessionService.getTiendasEmpleado(any(TiendasEmpleadoRequestDto.class))).thenReturn(new ArrayList<GenericTiendaResultItemDto>());

        TiendasEmpleadoRequestDto request = new TiendasEmpleadoRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getTiendasEmpleado(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getTiendasEmpleado(ArgumentMatchers.any(TiendasEmpleadoRequestDto.class));

    }
    
    @Test
    public void searchTiendas() {
        when(meta4IcmWsCalcIncomeSessionService.searchTiendas(any(SearchTiendasRequestDto.class))).thenReturn(new ArrayList<GenericTiendaResultItemDto>());

        SearchTiendasRequestDto request = new SearchTiendasRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.searchTiendas(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).searchTiendas(ArgumentMatchers.any(SearchTiendasRequestDto.class));

    }
    
    @Test
    public void getTiendas() {
        when(meta4IcmWsCalcIncomeSessionService.getTiendas(any(TiendasRequestDto.class))).thenReturn(new ArrayList<GenericTiendaResultItemDto>());

        TiendasRequestDto request = new TiendasRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getTiendas(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getTiendas(ArgumentMatchers.any(TiendasRequestDto.class));

    }
    
    @Test
    public void searchEmpleados() {
        when(meta4IcmWsCalcIncomeSessionService.searchEmpleados(any(SearchEmpleadosRequestDto.class))).thenReturn(new ArrayList<GenericEmpleadoResultItemDto>());

        SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.searchEmpleados(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).searchEmpleados(ArgumentMatchers.any(SearchEmpleadosRequestDto.class));

    }
    
    @Test
    public void getEstructurasCom() {
        when(meta4IcmWsCalcIncomeSessionService.getEstructurasCom(any(EstructurasComRequestDto.class))).thenReturn(new ArrayList<EstructurasComResultItemDto>());

        EstructurasComRequestDto request = new EstructurasComRequestDto();
        request.setData(new EstructurasComFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getEstructurasCom(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getEstructurasCom(ArgumentMatchers.any(EstructurasComRequestDto.class));

    }
    
    @Test
    public void getEstructurasPol() {
        when(meta4IcmWsCalcIncomeSessionService.getEstructurasPol(any(EstructurasPolRequestDto.class))).thenReturn(new ArrayList<EstructurasPolResultItemDto>());

        EstructurasPolRequestDto request = new EstructurasPolRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getEstructurasPol(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getEstructurasPol(ArgumentMatchers.any(EstructurasPolRequestDto.class));

    }
    
    @Test
    public void getEmpleados() {
        when(meta4IcmWsCalcIncomeSessionService.getEmpleados(any(EmpleadosRequestDto.class))).thenReturn(new ArrayList<GenericEmpleadoResultItemDto>());

        EmpleadosRequestDto request = new EmpleadosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getEmpleados(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getEmpleados(ArgumentMatchers.any(EmpleadosRequestDto.class));

    }
    
    @Test
    public void getConfiguracionVentaOnline() {
        when(meta4IcmWsCalcIncomeSessionService.getConfiguracionVentaOnline(any(ConfiguracionVentaOnlineRequestDto.class))).thenReturn(new ArrayList<ConfiguracionVentaOnlineResultItemDto>());

        ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getConfiguracionVentaOnline(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getConfiguracionVentaOnline(ArgumentMatchers.any(ConfiguracionVentaOnlineRequestDto.class));

    }
    
    @Test
    public void getAgrupacionesOnline() {
        when(meta4IcmWsCalcIncomeSessionService.getAgrupacionesOnline(any(AgrupOnlineRequestDto.class))).thenReturn(new ArrayList<AgrupOnlineResultItemDto>());

        AgrupOnlineRequestDto request = new AgrupOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getAgrupacionesOnline(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getAgrupacionesOnline(ArgumentMatchers.any(AgrupOnlineRequestDto.class));

    }
    
    @Test
    public void getTiendasOnline() {
        when(meta4IcmWsCalcIncomeSessionService.tiendaOnline(any(TiendaOnlineRequestDto.class))).thenReturn(new ArrayList<TiendaOnlineResultItemDto>());

        TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getTiendasOnline(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).tiendaOnline(ArgumentMatchers.any(TiendaOnlineRequestDto.class));

    }
    
    @Test
    public void getEmpresa() {
        when(meta4IcmWsCalcIncomeSessionService.getEmpresa(any(EmpresaRequestDto.class))).thenReturn(new ArrayList<EmpresaResultItemDto>());

        EmpresaRequestDto request = new EmpresaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getEmpresa(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getEmpresa(ArgumentMatchers.any(EmpresaRequestDto.class));

    }
    
    @Test
    public void getOrigen() {
        when(meta4IcmWsCalcIncomeSessionService.getOrigen(any(OrigenRequestDto.class))).thenReturn(new ArrayList<OrigenResultItemDto>());

        OrigenRequestDto request = new OrigenRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getOrigen(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getOrigen(ArgumentMatchers.any(OrigenRequestDto.class));

    }
    
    @Test
    public void getConfiguracionProductoVenta() {
        when(meta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(any(ConfiguracionProductoVentaRequestDto.class))).thenReturn(new ArrayList<ConfiguracionProductoVentaResultItemDto>());

        ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getConfiguracionProductoVenta(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getConfiguracionProductoVenta(ArgumentMatchers.any(ConfiguracionProductoVentaRequestDto.class));

    }
    
    @Test
    public void getEmpleadosDesplazamiento() {
        when(meta4IcmWsCalcIncomeSessionService.getEmpleadosDesplazamiento(any(EmpleadosDesplazamientoRequestDto.class))).thenReturn(new ArrayList<GenericEmpleadoResultItemDto>());

        EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionAsyncServiceImpl.getEmpleadosDesplazamiento(request));

        verify(meta4IcmWsCalcIncomeSessionService, timeout(1000).times(1)).getEmpleadosDesplazamiento(ArgumentMatchers.any(EmpleadosDesplazamientoRequestDto.class));

    }
}
