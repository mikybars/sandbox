package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4FilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResponseDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultErrorDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper.IcmWsCalcIncomeMapper;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

@RunWith(MockitoJUnitRunner.class)
public class Meta4IcmWsCalcIncomeSessionServiceImplTest {

    @Mock
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;
    
    @Mock
    private Meta4ClientPool meta4ClientPool;
    
    @Mock
    private IcmWsCalcIncomeMapper icmWsCalcIncomeMapper;
    
    @Mock
    private Map<String, Meta4PropertiesDto> meta4Properties;
    
    @InjectMocks
    private Meta4IcmWsCalcIncomeSessionServiceImpl meta4IcmWsCalcIncomeSessionServiceImpl;
    
    @Test
    public void getFlagCalcula() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getFlagCalcula(any(FlagCalculaRequestDto.class))).thenReturn(new FlagCalculaResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.FLAG_CALCULA)).thenReturn(properties);

        FlagCalculaRequestDto request = new FlagCalculaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getFlagCalcula(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getFlagCalcula(ArgumentMatchers.any(FlagCalculaRequestDto.class));
    }
    
    @Test
    public void getFestivos() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getFestivos(any(FestivosRequestDto.class))).thenReturn(new FestivosResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.FESTIVOS)).thenReturn(properties);

        FestivosRequestDto request = new FestivosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getFestivos(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getFestivos(ArgumentMatchers.any(FestivosRequestDto.class));
    }
    
    @Test
    public void getCoefJornada() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getCoefJornada(any(CoefJornadaRequestDto.class))).thenReturn(new CoefJornadaResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.COEF_JORNADA)).thenReturn(properties);

        CoefJornadaRequestDto request = new CoefJornadaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getCoefJornada(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getCoefJornada(ArgumentMatchers.any(CoefJornadaRequestDto.class));
    }
    
    @Test
    public void getPresenciaManual() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getPresenciaManual(any(PresenciaManualRequestDto.class))).thenReturn(new PresenciaManualResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.PRESENCIA_MANUAL)).thenReturn(properties);

        PresenciaManualRequestDto request = new PresenciaManualRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getPresenciaManual(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getPresenciaManual(ArgumentMatchers.any(PresenciaManualRequestDto.class));
    }
    
    @Test
    public void getEmpleadosPresencia() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getEmpleadosPresencia(any(EmpleadosPresenciaRequestDto.class))).thenReturn(new EmpleadosPresenciaResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_PRESENCIA)).thenReturn(properties);

        EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getEmpleadosPresencia(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getEmpleadosPresencia(ArgumentMatchers.any(EmpleadosPresenciaRequestDto.class));
    }
    
    @Test
    public void getPeriodos() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getPeriodos(any(PeriodosRequestDto.class))).thenReturn(new PeriodosResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.PERIODOS)).thenReturn(properties);

        PeriodosRequestDto request = new PeriodosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getPeriodos(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getPeriodos(ArgumentMatchers.any(PeriodosRequestDto.class));
    }
    
    @Test
    public void getTiendasEmpleado() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getTiendasEmpleado(any(TiendasEmpleadoRequestDto.class))).thenReturn(new TiendasEmpleadoResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.TIENDAS_EMPLEADO)).thenReturn(properties);

        TiendasEmpleadoRequestDto request = new TiendasEmpleadoRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getTiendasEmpleado(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getTiendasEmpleado(ArgumentMatchers.any(TiendasEmpleadoRequestDto.class));
    }
    
    @Test
    public void searchTiendas() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.searchTiendas(any(SearchTiendasRequestDto.class))).thenReturn(new SearchTiendasResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.SEARCH_TIENDAS)).thenReturn(properties);

        SearchTiendasRequestDto request = new SearchTiendasRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.searchTiendas(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).searchTiendas(ArgumentMatchers.any(SearchTiendasRequestDto.class));
    }
    
    @Test
    public void getTiendas() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getTiendas(any(TiendasRequestDto.class))).thenReturn(new TiendasResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.TIENDAS)).thenReturn(properties);

        TiendasRequestDto request = new TiendasRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getTiendas(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getTiendas(ArgumentMatchers.any(TiendasRequestDto.class));
    }
    
    @Test
    public void searchEmpleados() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.searchEmpleados(any(SearchEmpleadosRequestDto.class))).thenReturn(new SearchEmpleadosResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS)).thenReturn(properties);

        SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.searchEmpleados(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).searchEmpleados(ArgumentMatchers.any(SearchEmpleadosRequestDto.class));
    }
    
    @Test
    public void getEmpleados() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getEmpleados(any(EmpleadosRequestDto.class))).thenReturn(new EmpleadosResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS)).thenReturn(properties);

        EmpleadosRequestDto request = new EmpleadosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getEmpleados(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getEmpleados(ArgumentMatchers.any(EmpleadosRequestDto.class));
    }
    
    @Test
    public void getConfiguracionVentaOnline() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getConfVentaOnline(any(ConfiguracionVentaOnlineRequestDto.class))).thenReturn(new ConfiguracionVentaOnlineResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.CONF_VENTA_ONLINE)).thenReturn(properties);

        ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getConfiguracionVentaOnline(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getConfVentaOnline(ArgumentMatchers.any(ConfiguracionVentaOnlineRequestDto.class));
    }
    
    @Test
    public void getAgrupacionesOnline() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getAgrupOnline(any(AgrupOnlineRequestDto.class))).thenReturn(new AgrupOnlineResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.AGRUPACION_ONLINE)).thenReturn(properties);

        AgrupOnlineRequestDto request = new AgrupOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getAgrupacionesOnline(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getAgrupOnline(ArgumentMatchers.any(AgrupOnlineRequestDto.class));
    }
    
    @Test
    public void tiendaOnline() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getTiendasOnline(any(TiendaOnlineRequestDto.class))).thenReturn(new TiendaOnlineResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.TIENDAS_ONLINE)).thenReturn(properties);

        TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.tiendaOnline(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getTiendasOnline(ArgumentMatchers.any(TiendaOnlineRequestDto.class));
    }
    
    @Test
    public void getEmpresa() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getEmpresa(any(EmpresaRequestDto.class))).thenReturn(new EmpresaResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.EMPRESA)).thenReturn(properties);

        EmpresaRequestDto request = new EmpresaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getEmpresa(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getEmpresa(ArgumentMatchers.any(EmpresaRequestDto.class));
    }
    
    @Test
    public void getOrigen() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getOrigen(any(OrigenRequestDto.class))).thenReturn(new OrigenResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.ORIGEN)).thenReturn(properties);

        OrigenRequestDto request = new OrigenRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getOrigen(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getOrigen(ArgumentMatchers.any(OrigenRequestDto.class));
    }
    
    @Test
    public void getConfiguracionProductoVenta() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getConfiguracionProductoVenta(any(ConfiguracionProductoVentaRequestDto.class))).thenReturn(new ConfiguracionProductoVentaResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.CONF_PRODUCTO_VENTA)).thenReturn(properties);

        ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getConfiguracionProductoVenta(request);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getConfiguracionProductoVenta(ArgumentMatchers.any(ConfiguracionProductoVentaRequestDto.class));
    }
    
    @Test
    public void getConfiguracionProductoVentaIdTareaCclIdOrigen() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getConfiguracionProductoVenta(any(ConfiguracionProductoVentaRequestDto.class))).thenReturn(new ConfiguracionProductoVentaResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.CONF_PRODUCTO_VENTA)).thenReturn(properties);

        Long idTarea = 1L;
        String cclIdOrigen = "38";
        
        meta4IcmWsCalcIncomeSessionServiceImpl.getConfiguracionProductoVenta(idTarea, cclIdOrigen);

        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getConfiguracionProductoVenta(ArgumentMatchers.any(ConfiguracionProductoVentaRequestDto.class));
    }

    @Test
    public void getEmpleadosDesplazamiento() {
        Meta4PropertiesDto properties = new Meta4PropertiesDto();
        Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        properties.setFilter(filter);
        when(meta4IcmWsCalcIncomeService.getEmpleadosDesplazamiento(any(EmpleadosDesplazamientoRequestDto.class))).thenReturn(new EmpleadosDesplazamientoResponseDto());
        when(meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_DESPLAZAMIENTO)).thenReturn(properties);

        EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeSessionServiceImpl.getEmpleadosDesplazamiento(request);
        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getEmpleadosDesplazamiento(ArgumentMatchers.any(EmpleadosDesplazamientoRequestDto.class));
    }
    
    @Test
    public void saveProceso() {
        SaveProcesoDto dto = new SaveProcesoDto();
        SaveResultDto result = new SaveResultDto();
        result.setResultadoOk(Boolean.TRUE);
        result.setResultadoError(Boolean.FALSE);

        when(meta4IcmWsCalcIncomeService.saveProceso(any(SaveProcesoDto.class))).thenReturn(result);

        meta4IcmWsCalcIncomeSessionServiceImpl.saveProceso(dto);
        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).saveProceso(ArgumentMatchers.any(SaveProcesoDto.class));
    }
    
    @Test(expected = IcmclcwbException.class)
    public void saveProcesoException() {
        SaveProcesoDto dto = new SaveProcesoDto();
        SaveResultDto result = new SaveResultDto();
        result.setData(new ArrayList<>());
        result.getData().add(new SaveResultErrorDto());
        result.setResultadoOk(Boolean.FALSE);
        result.setResultadoError(Boolean.TRUE);

        when(meta4IcmWsCalcIncomeService.saveProceso(any(SaveProcesoDto.class))).thenReturn(result);

        meta4IcmWsCalcIncomeSessionServiceImpl.saveProceso(dto);
        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).saveProceso(ArgumentMatchers.any(SaveProcesoDto.class));
    }
}
