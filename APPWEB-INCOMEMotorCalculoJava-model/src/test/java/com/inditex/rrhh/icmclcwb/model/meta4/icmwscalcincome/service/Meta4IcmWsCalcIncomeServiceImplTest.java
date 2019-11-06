package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolRequestDto;
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
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestructurascomOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestructuraspolOutput;
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
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempresasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempresasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaestructuraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaestructuraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaorigenesBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaorigenesRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaperiodosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaperiodosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapoliticasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapoliticasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoBlock;
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaconfiguracion(block);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(GenericFilterDto.class))).thenReturn(origen);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getagruponline(any(IcmParamcalorigenBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        AgrupOnlineRequestDto request = new AgrupOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getAgrupOnline(request);
        verify(meta4ClientPool, times(1)).getagruponline(any(IcmParamcalorigenBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getAgrupOnlineTestNullOutput() {
        IcmParamcalorigenBlock origen = new IcmParamcalorigenBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(GenericFilterDto.class))).thenReturn(origen);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getagruponline(any(IcmParamcalorigenBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        AgrupOnlineRequestDto request = new AgrupOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getAgrupOnline(request);
        verify(meta4ClientPool, times(1)).getagruponline(any(IcmParamcalorigenBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getAgrupOnlineTestNullPageNullData() {
        IcmParamcalorigenBlock origen = new IcmParamcalorigenBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListaconfiguracionBlock block = new IcmListaconfiguracionBlock(); 
        GetagruponlineOutput output = new GetagruponlineOutput();
        block.getIcmListaconfiguracionRecordSet().add(new IcmListaconfiguracionRecord());
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListaconfiguracion(null);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(GenericFilterDto.class))).thenReturn(origen);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getagruponline(any(IcmParamcalorigenBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        AgrupOnlineRequestDto request = new AgrupOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListatiendas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getflagcalcula(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        FlagCalculaRequestDto request = new FlagCalculaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getFlagCalcula(request);
        verify(meta4ClientPool, times(1)).getflagcalcula(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getFlagCalculaTestNullOutput() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getflagcalcula(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        FlagCalculaRequestDto request = new FlagCalculaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getFlagCalcula(request);
        verify(meta4ClientPool, times(1)).getflagcalcula(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getFlagCalculaTestNullPageNullData() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListatiendasBlock block = new IcmListatiendasBlock(); 
        GetflagcalculaOutput output = new GetflagcalculaOutput();
        block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListatiendas(null);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getflagcalcula(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        FlagCalculaRequestDto request = new FlagCalculaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaempleados(block);
       
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getcoefjornada(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        CoefJornadaRequestDto request = new CoefJornadaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getCoefJornada(request);
        verify(meta4ClientPool, times(1)).getcoefjornada(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getCoefJornadaTestNullOutput() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
       
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getcoefjornada(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        CoefJornadaRequestDto request = new CoefJornadaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getCoefJornada(request);
        verify(meta4ClientPool, times(1)).getcoefjornada(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getCoefJornadaTestNullPageNullData() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListaempleadosBlock block = new IcmListaempleadosBlock(); 
        GetcoefjornadaOutput output = new GetcoefjornadaOutput();
        block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListaempleados(null);
       
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getcoefjornada(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        CoefJornadaRequestDto request = new CoefJornadaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListatiendas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getfestivos(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        FestivosRequestDto request = new FestivosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getFestivos(request);
        verify(meta4ClientPool, times(1)).getfestivos(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getFestivosNullOutput() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListatiendasBlock block = new IcmListatiendasBlock(); 
        block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getfestivos(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        FestivosRequestDto request = new FestivosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getFestivos(request);
        verify(meta4ClientPool, times(1)).getfestivos(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getFestivosNullPageNullData() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListatiendasBlock block = new IcmListatiendasBlock(); 
        GetfestivosOutput output = new GetfestivosOutput();
        block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListatiendas(null);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getfestivos(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        FestivosRequestDto request = new FestivosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaempleados(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getpresenciamanual(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        PresenciaManualRequestDto request = new PresenciaManualRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getPresenciaManual(request);
        verify(meta4ClientPool, times(1)).getpresenciamanual(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getPresenciaManualNullOutput() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListaempleadosBlock block = new IcmListaempleadosBlock(); 
        block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getpresenciamanual(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        PresenciaManualRequestDto request = new PresenciaManualRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getPresenciaManual(request);
        verify(meta4ClientPool, times(1)).getpresenciamanual(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getPresenciaManualNullPageNullData() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetpresenciamanualOutput output = new GetpresenciamanualOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListaempleados(null);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getpresenciamanual(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        PresenciaManualRequestDto request = new PresenciaManualRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaempleados(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempleadospresencia(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getEmpleadosPresencia(request);
        verify(meta4ClientPool, times(1)).getempleadospresencia(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getEmpleadosPresenciaNullOutput() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListaempleadosBlock block = new IcmListaempleadosBlock(); 
        block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempleadospresencia(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getEmpleadosPresencia(request);
        verify(meta4ClientPool, times(1)).getempleadospresencia(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getEmpleadosPresenciaNullPageNullData() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetempleadospresenciaOutput output = new GetempleadospresenciaOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListaempleados(null);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempleadospresencia(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaperiodos(block);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalperiodoBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getperiodos(any(IcmParamcalperiodoBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        PeriodosRequestDto request = new PeriodosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getPeriodos(request);
        verify(meta4ClientPool, times(1)).getperiodos(any(IcmParamcalperiodoBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getPeriodosNullOutput() {
        IcmParamcalperiodoBlock entrada = new IcmParamcalperiodoBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParamcalperiodoBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getperiodos(any(IcmParamcalperiodoBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        PeriodosRequestDto request = new PeriodosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getPeriodos(request);
        verify(meta4ClientPool, times(1)).getperiodos(any(IcmParamcalperiodoBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getPeriodosNullPageNullData() {
        IcmParamcalperiodoBlock entrada = new IcmParamcalperiodoBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListaperiodosBlock block = new IcmListaperiodosBlock(); 
        GetperiodosOutput output = new GetperiodosOutput();
        block.getIcmListaperiodosRecordSet().add(new IcmListaperiodosRecord());
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListaperiodos(null);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalperiodoBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getperiodos(any(IcmParamcalperiodoBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        PeriodosRequestDto request = new PeriodosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListatiendas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.gettiendasempleado(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        TiendasEmpleadoRequestDto request = new TiendasEmpleadoRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getTiendasEmpleado(request);
        verify(meta4ClientPool, times(1)).gettiendasempleado(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getTiendasEmpleadoNullOutput() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.gettiendasempleado(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        TiendasEmpleadoRequestDto request = new TiendasEmpleadoRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getTiendasEmpleado(request);
        verify(meta4ClientPool, times(1)).gettiendasempleado(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getTiendasEmpleadoNullPageNullData() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GettiendasempleadoOutput output = new GettiendasempleadoOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListatiendas(null);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.gettiendasempleado(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        TiendasEmpleadoRequestDto request = new TiendasEmpleadoRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListatiendas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.searchtiendas(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        SearchTiendasRequestDto request = new SearchTiendasRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.searchTiendas(request);
        verify(meta4ClientPool, times(1)).searchtiendas(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void searchTiendasNullOutput() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.searchtiendas(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        SearchTiendasRequestDto request = new SearchTiendasRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.searchTiendas(request);
        verify(meta4ClientPool, times(1)).searchtiendas(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void searchTiendasNullPageNullData() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        SearchtiendasOutput output = new SearchtiendasOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListatiendas(null);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.searchtiendas(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        SearchTiendasRequestDto request = new SearchTiendasRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListatiendas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.gettiendasincome(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class))).thenReturn(output);

        TiendasRequestDto request = new TiendasRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getTiendas(request);
        verify(meta4ClientPool, times(1)).gettiendasincome(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class));
    }
    
    @Test
    public void getTiendasNullOutput() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.gettiendasincome(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class))).thenReturn(null);

        TiendasRequestDto request = new TiendasRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getTiendas(request);
        verify(meta4ClientPool, times(1)).gettiendasincome(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class));
    }
    
    @Test
    public void getTiendasNullPageNullData() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GettiendasincomeOutput output = new GettiendasincomeOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListatiendas(null);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.gettiendasincome(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class))).thenReturn(output);

        TiendasRequestDto request = new TiendasRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getTiendas(request);
        verify(meta4ClientPool, times(1)).gettiendasincome(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class));
    }

    @Test
    public void searchEmpleados() {
        IcmParamcalempleadoBlock entrada = new IcmParamcalempleadoBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        IcmListaempleadoBlock block = new IcmListaempleadoBlock(); 
        SearchempleadosOutput output = new SearchempleadosOutput();
        block.getIcmListaempleadoRecordSet().add(new IcmListaempleadoRecord());
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaempleado(block);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalempleadoBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.searchempleados(any(IcmParametrospaginacionBlock.class), any(IcmParamcalempleadoBlock.class))).thenReturn(output);

        SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.searchEmpleados(request);
        
        verify(meta4ClientPool, times(1)).searchempleados(any(IcmParametrospaginacionBlock.class), any(IcmParamcalempleadoBlock.class));
    }
    
    @Test
    public void searchEmpleadosNullOutput() {
        IcmParamcalempleadoBlock entrada = new IcmParamcalempleadoBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParamcalempleadoBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.searchempleados(any(IcmParametrospaginacionBlock.class), any(IcmParamcalempleadoBlock.class))).thenReturn(null);

        SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.searchEmpleados(request);
        
        verify(meta4ClientPool, times(1)).searchempleados(any(IcmParametrospaginacionBlock.class), any(IcmParamcalempleadoBlock.class));
    }
    
    @Test
    public void searchEmpleadosNullPageNullData() {
        IcmParamcalempleadoBlock entrada = new IcmParamcalempleadoBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        SearchempleadosOutput output = new SearchempleadosOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListaempleado(null);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalempleadoBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.searchempleados(any(IcmParametrospaginacionBlock.class), any(IcmParamcalempleadoBlock.class))).thenReturn(output);

        SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.searchEmpleados(request);
        
        verify(meta4ClientPool, times(1)).searchempleados(any(IcmParametrospaginacionBlock.class), any(IcmParamcalempleadoBlock.class));
    }
    
    @Test
    public void getEstructurasCom() {
        IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock(); 
        IcmListaestructuraBlock block = new IcmListaestructuraBlock(); 
        GetestructurascomOutput output = new GetestructurascomOutput();
        block.getIcmListaestructuraRecordSet().add(new IcmListaestructuraRecord());
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmListaestructura(block);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(EstructurasComFilterDto.class))).thenReturn(entrada);
        when(meta4ClientPool.getestructurascom(any(IcmParamcalestructuraBlock.class))).thenReturn(output);

        EstructurasComRequestDto request = new EstructurasComRequestDto();
        request.setData(new EstructurasComFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getEstructurasCom(request);
        verify(meta4ClientPool, times(1)).getestructurascom(any(IcmParamcalestructuraBlock.class));
    }
    
    
    @Test
    public void getEstructurasComNullOutput() {
        IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock(); 
        
        when(icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(EstructurasComFilterDto.class))).thenReturn(entrada);
        when(meta4ClientPool.getestructurascom(any(IcmParamcalestructuraBlock.class))).thenReturn(null);

        EstructurasComRequestDto request = new EstructurasComRequestDto();
        request.setData(new EstructurasComFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getEstructurasCom(request);
        verify(meta4ClientPool, times(1)).getestructurascom(any(IcmParamcalestructuraBlock.class));
    }
    
    @Test
    public void getEstructurasComNullData() {
        IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock(); 
        GetestructurascomOutput output = new GetestructurascomOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmListaestructura(null);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(EstructurasComFilterDto.class))).thenReturn(entrada);
        when(meta4ClientPool.getestructurascom(any(IcmParamcalestructuraBlock.class))).thenReturn(output);

        EstructurasComRequestDto request = new EstructurasComRequestDto();
        request.setData(new EstructurasComFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getEstructurasCom(request);
        verify(meta4ClientPool, times(1)).getestructurascom(any(IcmParamcalestructuraBlock.class));
    }
    
    @Test
    public void getEstructurasPol() {
        IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock(); 
        IcmListapoliticasBlock block = new IcmListapoliticasBlock(); 
        GetestructuraspolOutput output = new GetestructuraspolOutput();
        block.getIcmListapoliticasRecordSet().add(new IcmListapoliticasRecord());
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmListapoliticas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(meta4ClientPool.getestructuraspol(any(IcmParamcalestructuraBlock.class))).thenReturn(output);

        EstructurasPolRequestDto request = new EstructurasPolRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getEstructurasPol(request);
        verify(meta4ClientPool, times(1)).getestructuraspol(any(IcmParamcalestructuraBlock.class));
    }
    
    @Test
    public void getEstructurasPolNullOutput() {
        IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock(); 
        
        when(icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(meta4ClientPool.getestructuraspol(any(IcmParamcalestructuraBlock.class))).thenReturn(null);

        EstructurasPolRequestDto request = new EstructurasPolRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getEstructurasPol(request);
        verify(meta4ClientPool, times(1)).getestructuraspol(any(IcmParamcalestructuraBlock.class));
    }
    
    @Test
    public void getEstructurasPolNullData() {
        IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock(); 
        GetestructuraspolOutput output = new GetestructuraspolOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmListapoliticas(null);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(meta4ClientPool.getestructuraspol(any(IcmParamcalestructuraBlock.class))).thenReturn(output);

        EstructurasPolRequestDto request = new EstructurasPolRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto());
        meta4IcmWsCalcIncomeServiceImpl.getEstructurasPol(request);
        verify(meta4ClientPool, times(1)).getestructuraspol(any(IcmParamcalestructuraBlock.class));
    }

    @Test
    public void getEmpleados() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetempleadosOutput output = new GetempleadosOutput();
        IcmListaempleadosBlock block = new IcmListaempleadosBlock(); 
        block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaempleados(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempleados(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        EmpleadosRequestDto request = new EmpleadosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getEmpleados(request);
        verify(meta4ClientPool, times(1)).getempleados(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getEmpleadosNullOutput() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempleados(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        EmpleadosRequestDto request = new EmpleadosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getEmpleados(request);
        verify(meta4ClientPool, times(1)).getempleados(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getEmpleadosNullPageNullData() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetempleadosOutput output = new GetempleadosOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListaempleados(null);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempleados(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        EmpleadosRequestDto request = new EmpleadosRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaconfiguracion(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getconfventaonline(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getConfVentaOnline(request);
        verify(meta4ClientPool, times(1)).getconfventaonline(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getConfVentaOnlineNullOutput() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getconfventaonline(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getConfVentaOnline(request);
        verify(meta4ClientPool, times(1)).getconfventaonline(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getConfVentaOnlineNullPageNullData() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetconfventaonlineOutput output = new GetconfventaonlineOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListaconfiguracion(null);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getconfventaonline(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListatiendas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.gettiendasonline(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class))).thenReturn(output);

        TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getTiendasOnline(request);
        verify(meta4ClientPool, times(1)).gettiendasonline(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class));
    }
    
    @Test
    public void getTiendasOnlineNullOutput() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.gettiendasonline(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class))).thenReturn(null);

        TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getTiendasOnline(request);
        verify(meta4ClientPool, times(1)).gettiendasonline(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class));
    }
    
    @Test
    public void getTiendasOnlineNullPageNullData() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GettiendasonlineOutput output = new GettiendasonlineOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListatiendas(null);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.gettiendasonline(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class))).thenReturn(output);

        TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaconfiguracion(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getconfprodventa(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getConfiguracionProductoVenta(request);
        verify(meta4ClientPool, times(1)).getconfprodventa(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getConfiguracionProductoVentaNullOutput() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getconfprodventa(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getConfiguracionProductoVenta(request);
        verify(meta4ClientPool, times(1)).getconfprodventa(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getConfiguracionProductoVentaNullPageNullData() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetconfprodventaOutput output = new GetconfprodventaOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListaconfiguracion(null);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getconfprodventa(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListacadenas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getcadena(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        CadenaRequestDto request = new CadenaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getCadena(request);
        verify(meta4ClientPool, times(1)).getcadena(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getCadenaNullOutput() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getcadena(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        CadenaRequestDto request = new CadenaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getCadena(request);
        verify(meta4ClientPool, times(1)).getcadena(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));
    }
  
    @Test
    public void getCadenaNullPageNullData() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetcadenaOutput output = new GetcadenaOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListacadenas(null);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getcadena(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        CadenaRequestDto request = new CadenaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaempresas(block);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempresas(any(IcmParamcalorigenBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        EmpresaRequestDto request = new EmpresaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getEmpresa(request);
        verify(meta4ClientPool, times(1)).getempresas(any(IcmParamcalorigenBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getEmpresaNullOutput() {
        IcmParamcalorigenBlock entrada = new IcmParamcalorigenBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempresas(any(IcmParamcalorigenBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        EmpresaRequestDto request = new EmpresaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getEmpresa(request);
        verify(meta4ClientPool, times(1)).getempresas(any(IcmParamcalorigenBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getEmpresaNullPageNullData() {
        IcmParamcalorigenBlock entrada = new IcmParamcalorigenBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetempresasOutput output = new GetempresasOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListaempresas(null);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempresas(any(IcmParamcalorigenBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        EmpresaRequestDto request = new EmpresaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaorigenes(block);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalsociedadBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getorigenes(any(IcmParamcalsociedadBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        OrigenRequestDto request = new OrigenRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getOrigen(request);
        verify(meta4ClientPool, times(1)).getorigenes(any(IcmParamcalsociedadBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    
    @Test
    public void getOrigenNullOutput() {
        IcmParamcalsociedadBlock entrada = new IcmParamcalsociedadBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParamcalsociedadBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getorigenes(any(IcmParamcalsociedadBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(null);

        OrigenRequestDto request = new OrigenRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getOrigen(request);
        verify(meta4ClientPool, times(1)).getorigenes(any(IcmParamcalsociedadBlock.class), any(IcmParametrospaginacionBlock.class));
    }

    @Test
    public void getOrigenNullPageNullData() {
        IcmParamcalsociedadBlock entrada = new IcmParamcalsociedadBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetorigenesOutput output = new GetorigenesOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListaorigenes(null);
        
        when(icmWsCalcIncomeMapper.asIcmParamcalsociedadBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getorigenes(any(IcmParamcalsociedadBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);

        OrigenRequestDto request = new OrigenRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getOrigen(request);
        verify(meta4ClientPool, times(1)).getorigenes(any(IcmParamcalsociedadBlock.class), any(IcmParametrospaginacionBlock.class));
    }
    

    @Test
    public void getEmpleadosDesplazamiento() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetempleadosdesplazOutput output = new GetempleadosdesplazOutput();
        IcmListaempleadosBlock block = new IcmListaempleadosBlock(); 
        block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(paginacion);
        output.setIcmListaempleados(block);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempleadosdesplaz(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class))).thenReturn(output);

        EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getEmpleadosDesplazamiento(request);
        verify(meta4ClientPool, times(1)).getempleadosdesplaz(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class));
    }
    
    @Test
    public void getEmpleadosDesplazamientoNullOutput() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempleadosdesplaz(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class))).thenReturn(null);

        EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        meta4IcmWsCalcIncomeServiceImpl.getEmpleadosDesplazamiento(request);
        verify(meta4ClientPool, times(1)).getempleadosdesplaz(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class));
    }
    
    @Test
    public void getEmpleadosDesplazamientoNullPageNullData() {
        IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock(); 
        IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
        GetempleadosdesplazOutput output = new GetempleadosdesplazOutput();
        output.setReturn(NumberUtils.DOUBLE_ZERO);
        output.setIcmParametrospaginacion(null);
        output.setIcmListaempleados(null);
        
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
        when(meta4ClientPool.getempleadosdesplaz(any(IcmParametrospaginacionBlock.class), any(IcmParametrosentradaBlock.class))).thenReturn(output);

        EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
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
