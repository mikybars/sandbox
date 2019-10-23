package com.inditex.rrhh.icmclcwb.model.meta4.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.exception.Meta4IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetflagcalculaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper.IcmWsCalcIncomeMapper;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeServiceImpl;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

@RunWith(MockitoJUnitRunner.class)
public class Meta4PageableServiceImplTest {
    
    @InjectMocks
    private Meta4IcmWsCalcIncomeServiceImpl meta4IcmWsCalcIncomeService;

    @InjectMocks
    private Meta4PageableServiceImpl<?> meta4PageableServiceImpl;
    
    @Mock
    private IcmWsCalcIncomeMapper icmWsCalcIncomeMapper;
    
    @Mock
    private Meta4ClientPool meta4ClientPool;
    
    @Test(expected = Meta4IcmclcwbException.class)
    public void getResultItemException() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        PageableDto<Serializable> request = new PageableDto<>();
        Integer maxPageSize = 10;
        
        meta4PageableServiceImpl.getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.FLAG_CALCULA, maxPageSize);
        
        verify(meta4IcmWsCalcIncomeService, timeout(1000).times(1)).getFlagCalcula(ArgumentMatchers.any(FlagCalculaRequestDto.class));

    }
    
    @Test
    public void getResultItem() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        FlagCalculaRequestDto request = new FlagCalculaRequestDto();
        request.setData(new GenericFilterDto());
        request.setPage(new PageDto(1, 100));
        PageableListDto<Serializable> response = new PageableListDto<>();
        response.setData(new ArrayList<>());
        response.setPage(new PageDto(1, 100));
        Integer maxPageSize = 10;
        GetflagcalculaOutput output = new GetflagcalculaOutput();
        IcmListatiendasBlock tiendas = new IcmListatiendasBlock();
        tiendas.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
        output.setIcmListatiendas(tiendas);
        output.getIcmListatiendas().getIcmListatiendasRecordSet();
        IcmParametrospaginacionBlock block = new IcmParametrospaginacionBlock();
        block.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        output.setIcmParametrospaginacion(block);
        List<GenericTiendaResultItemDto> tienda = new ArrayList<GenericTiendaResultItemDto>();
        tienda.add(new GenericTiendaResultItemDto());
        when(icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(new IcmParametrosentradaBlock());
        when(icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(new IcmParametrospaginacionBlock());
        when(meta4ClientPool.getflagcalcula(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class))).thenReturn(output);
        when(icmWsCalcIncomeMapper.asPageDto(any(IcmParametrospaginacionBlock.class))).thenReturn(PageDto.builder().numeroPagina(1).numeroTotalPaginas(2).build());
        when(icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(any(List.class))).thenReturn(tienda);

        meta4PageableServiceImpl.getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.FLAG_CALCULA, maxPageSize);

        verify(meta4ClientPool, timeout(1000).times(2)).getflagcalcula(any(IcmParametrosentradaBlock.class), any(IcmParametrospaginacionBlock.class));

    }
    
}
