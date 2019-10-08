package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetagruponlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcadenaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcoefjornadaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfprodventaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfventaonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosdesplazOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadospresenciaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempresasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestrcomisionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestrpoliticasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetfestivosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetflagcalculaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetorigenesOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetperiodosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresenciamanualOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasincomeOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacadenasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacadenasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfiguracionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfiguracionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempresasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempresasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaestructurasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaestructurasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaorigenesBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaorigenesRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaperiodosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaperiodosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmResultadoguardadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SaveprocesoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper.IcmWsCalcIncomeMapper;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

@RunWith(MockitoJUnitRunner.class)
public class Meta4IcmWsCalcIncomeServiceImplTest {

    @Mock
    private Meta4ClientPool meta4ClientPool;
    
    @Mock
    private IcmWsCalcIncomeMapper icmWsCalcIncomeMapper;

    @InjectMocks
    private Meta4IcmWsCalcIncomeServiceImpl meta4IcmWsCalcIncomeServiceImpl;

    @Test
    public void getAgrupOnlineTest() {
        IcmParamcalorigenBlock origen = new IcmParamcalorigenBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListaconfiguracionBlock block = new IcmListaconfiguracionBlock(); 
        GetagruponlineOutput output = new GetagruponlineOutput();
        block.getIcmListaconfiguracionRecordSet().add(new IcmListaconfiguracionRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaconfiguracion(block);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(GenericFilterDto.class))).thenReturn(origen);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getagruponline(any(IcmParamcalorigenBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        AgrupOnlineRequestDto request = new AgrupOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getAgrupOnline(request);
        verify(meta4ClientPool, times(1)).getagruponline(any(IcmParamcalorigenBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getFlagCalculaTest() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListatiendasBlock block = new IcmListatiendasBlock(); 
        GetflagcalculaOutput output = new GetflagcalculaOutput();
        block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListatiendas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getflagcalcula(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        FlagCalculaRequestDto request = new FlagCalculaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getFlagCalcula(request);
        verify(meta4ClientPool, times(1)).getflagcalcula(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getCoefJornadaTest() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListaempleadosBlock block = new IcmListaempleadosBlock(); 
        GetcoefjornadaOutput output = new GetcoefjornadaOutput();
        block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaempleados(block);
       
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getcoefjornada(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        CoefJornadaRequestDto request = new CoefJornadaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getCoefJornada(request);
        verify(meta4ClientPool, times(1)).getcoefjornada(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getFestivos() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListatiendasBlock block = new IcmListatiendasBlock(); 
        GetfestivosOutput output = new GetfestivosOutput();
        block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListatiendas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getfestivos(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        FestivosRequestDto request = new FestivosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getFestivos(request);
        verify(meta4ClientPool, times(1)).getfestivos(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getPresenciaManual() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListaempleadosBlock block = new IcmListaempleadosBlock(); 
        GetpresenciamanualOutput output = new GetpresenciamanualOutput();
        block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaempleados(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getpresenciamanual(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        PresenciaManualRequestDto request = new PresenciaManualRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getPresenciaManual(request);
        verify(meta4ClientPool, times(1)).getpresenciamanual(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getEmpleadosPresencia() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListaempleadosBlock block = new IcmListaempleadosBlock(); 
        GetempleadospresenciaOutput output = new GetempleadospresenciaOutput();
        block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaempleados(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempleadospresencia(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getEmpleadosPresencia(request);
        verify(meta4ClientPool, times(1)).getempleadospresencia(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getPeriodos() {
        IcmParamcalperiodoBlock entrada = new IcmParamcalperiodoBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListaperiodosBlock block = new IcmListaperiodosBlock(); 
        GetperiodosOutput output = new GetperiodosOutput();
        block.getIcmListaperiodosRecordSet().add(new IcmListaperiodosRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaperiodos(block);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalperiodoBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getperiodos(any(IcmParamcalperiodoBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        PeriodosRequestDto request = new PeriodosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getPeriodos(request);
        verify(meta4ClientPool, times(1)).getperiodos(any(IcmParamcalperiodoBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getTiendasEmpleado() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListatiendasBlock block = new IcmListatiendasBlock(); 
        GettiendasempleadoOutput output = new GettiendasempleadoOutput();
        block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListatiendas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.gettiendasempleado(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        TiendasEmpleadoRequestDto request = new TiendasEmpleadoRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getTiendasEmpleado(request);
        verify(meta4ClientPool, times(1)).gettiendasempleado(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void searchTiendas() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListatiendasBlock block = new IcmListatiendasBlock(); 
        SearchtiendasOutput output = new SearchtiendasOutput();
        block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListatiendas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.searchtiendas(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        SearchTiendasRequestDto request = new SearchTiendasRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.searchTiendas(request);
        verify(meta4ClientPool, times(1)).searchtiendas(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getTiendas() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListatiendasBlock block = new IcmListatiendasBlock(); 
        GettiendasincomeOutput output = new GettiendasincomeOutput();
        block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListatiendas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.gettiendasincome(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class))).thenReturn(output);

        TiendasRequestDto request = new TiendasRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getTiendas(request);
        verify(meta4ClientPool, times(1)).gettiendasincome(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class));
    }

    @Test
    public void searchEmpleados() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListaempleadosBlock block = new IcmListaempleadosBlock(); 
        SearchempleadosOutput output = new SearchempleadosOutput();
        block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaempleados(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.searchempleados(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class))).thenReturn(output);

        SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.searchEmpleados(request);
        
        verify(meta4ClientPool, times(1)).searchempleados(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class));
    }

    @Test
    public void getComisionEmpleado() {
        IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock(); 
        IcmListaestructurasBlock block = new IcmListaestructurasBlock(); 
        GetestrcomisionOutput output = new GetestrcomisionOutput();
        block.getIcmListaestructurasRecordSet().add(new IcmListaestructurasRecord());
        output.setReturn(0.0);
        output.setIcmListaestructuras(block);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(meta4ClientPool.getestrcomision(any(IcmParamcalestructuraBlock.class))).thenReturn(output);

        ComisionEmpleadoRequestDto request = new ComisionEmpleadoRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getComisionEmpleado(request);
        verify(meta4ClientPool, times(1)).getestrcomision(any(IcmParamcalestructuraBlock.class));
    }

    @Test
    public void getEmpleados() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetempleadosOutput output = new GetempleadosOutput();
        IcmListaempleadosBlock block = new IcmListaempleadosBlock(); 
        block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaempleados(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempleados(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        EmpleadosRequestDto request = new EmpleadosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getEmpleados(request);
        verify(meta4ClientPool, times(1)).getempleados(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getConfVentaOnline() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetconfventaonlineOutput output = new GetconfventaonlineOutput();
        IcmListaconfiguracionBlock block = new IcmListaconfiguracionBlock(); 
        block.getIcmListaconfiguracionRecordSet().add(new IcmListaconfiguracionRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaconfiguracion(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getconfventaonline(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getConfVentaOnline(request);
        verify(meta4ClientPool, times(1)).getconfventaonline(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getTiendasOnline() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GettiendasonlineOutput output = new GettiendasonlineOutput();
        IcmListatiendasBlock block = new IcmListatiendasBlock(); 
        block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListatiendas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.gettiendasonline(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class))).thenReturn(output);

        TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getTiendasOnline(request);
        verify(meta4ClientPool, times(1)).gettiendasonline(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class));
    }

    @Test
    public void getConfiguracionProductoVenta() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetconfprodventaOutput output = new GetconfprodventaOutput();
        IcmListaconfiguracionBlock block = new IcmListaconfiguracionBlock(); 
        block.getIcmListaconfiguracionRecordSet().add(new IcmListaconfiguracionRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaconfiguracion(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getconfprodventa(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getConfiguracionProductoVenta(request);
        verify(meta4ClientPool, times(1)).getconfprodventa(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getCadena() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetcadenaOutput output = new GetcadenaOutput();
        IcmListacadenasBlock block = new IcmListacadenasBlock(); 
        block.getIcmListacadenasRecordSet().add(new IcmListacadenasRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListacadenas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getcadena(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        CadenaRequestDto request = new CadenaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getCadena(request);
        verify(meta4ClientPool, times(1)).getcadena(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
  
    @Test
    public void getEmpresa() {
        IcmParamcalorigenBlock entrada = new IcmParamcalorigenBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetempresasOutput output = new GetempresasOutput();
        IcmListaempresasBlock block = new IcmListaempresasBlock(); 
        block.getIcmListaempresasRecordSet().add(new IcmListaempresasRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaempresas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempresas(any(IcmParamcalorigenBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        EmpresaRequestDto request = new EmpresaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getEmpresa(request);
        verify(meta4ClientPool, times(1)).getempresas(any(IcmParamcalorigenBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getOrigen() {
        IcmParamcalsociedadBlock entrada = new IcmParamcalsociedadBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetorigenesOutput output = new GetorigenesOutput();
        IcmListaorigenesBlock block = new IcmListaorigenesBlock(); 
        block.getIcmListaorigenesRecordSet().add(new IcmListaorigenesRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaorigenes(block);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalsociedadBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getorigenes(any(IcmParamcalsociedadBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        OrigenRequestDto request = new OrigenRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getOrigen(request);
        verify(meta4ClientPool, times(1)).getorigenes(any(IcmParamcalsociedadBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getEstructurasPoliticas() {
        IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock(); 
        GetestrpoliticasOutput output = new GetestrpoliticasOutput();
        IcmListaestructurasBlock block = new IcmListaestructurasBlock(); 
        block.getIcmListaestructurasRecordSet().add(new IcmListaestructurasRecord());
        output.setReturn(0.0);
        output.setIcmListaestructuras(block);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(meta4ClientPool.getestrpoliticas(any(IcmParamcalestructuraBlock.class))).thenReturn(output);

        ComisionEmpleadoRequestDto request = new ComisionEmpleadoRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getEstructurasPoliticas(request);
        verify(meta4ClientPool, times(1)).getestrpoliticas(any(IcmParamcalestructuraBlock.class));
    }
    
    @Test
    public void getEmpleadosDesplazamiento() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetempleadosdesplazOutput output = new GetempleadosdesplazOutput();
        IcmListaempleadosBlock block = new IcmListaempleadosBlock(); 
        block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
        output.setReturn(0.0);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaempleados(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempleadosdesplaz(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class))).thenReturn(output);

        EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getEmpleadosDesplazamiento(request);
        verify(meta4ClientPool, times(1)).getempleadosdesplaz(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class));
    }

    @Test
    public void saveProceso() {
        IcmParamcalprocesoBlock entrada = new IcmParamcalprocesoBlock();
        SaveprocesoOutput output = new SaveprocesoOutput();
        output.setIcmResultadoguardado(new IcmResultadoguardadoBlock());
        when(icmWsCalcIncomeMapper.asIcmParamcalprocesoBlock(any(SaveProcesoDto.class))).thenReturn(entrada);
        when(meta4ClientPool.saveproceso(any(IcmParamcalprocesoBlock.class))).thenReturn(output);

        SaveProcesoDto dto = mock(SaveProcesoDto.class);
        meta4IcmWsCalcIncomeServiceImpl.saveProceso(dto);
        verify(meta4ClientPool, times(1)).saveproceso(any(IcmParamcalprocesoBlock.class));
    }


}
