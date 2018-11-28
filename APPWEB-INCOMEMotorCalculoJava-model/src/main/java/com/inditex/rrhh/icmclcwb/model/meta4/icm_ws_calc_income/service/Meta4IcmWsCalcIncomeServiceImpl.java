package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto.TiendasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.GettiendasempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.GettiendasincomeOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.SearchtiendasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.mapper.IcmWsCalcIncomeMapper;

@Service
public class Meta4IcmWsCalcIncomeServiceImpl implements Meta4IcmWsCalcIncomeService {

	@Autowired
	@Qualifier("meta4IcmWsCalcIncomeClient")
	private IcmWsCalcIncomeService meta4IcmWsCalcIncomeClient;
	
    @Autowired
    private IcmWsCalcIncomeMapper icmWsCalcIncomeMapper;
	
    @Override
    public TiendasEmpleadoResponseDto getTiendasEmpleado(TiendasEmpleadoRequestDto request) throws Exception {
        TiendasEmpleadoResponseDto result = new TiendasEmpleadoResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GettiendasempleadoOutput gettiendasempleadoOutput = meta4IcmWsCalcIncomeClient.gettiendasempleado(param1, param2);
        if (gettiendasempleadoOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, gettiendasempleadoOutput.getReturn()) == 0) {
            if (gettiendasempleadoOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(gettiendasempleadoOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (gettiendasempleadoOutput.getIcmListatiendas() != null
                    && gettiendasempleadoOutput.getIcmListatiendas().getIcmListatiendasRecordSet() != null
                    && CollectionUtils.isNotEmpty(
                            gettiendasempleadoOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
                List<TiendasEmpleadoResultItemDto> items = icmWsCalcIncomeMapper.asTiendasEmpleadoResultItemDtos(
                        gettiendasempleadoOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
                result.setData(items);
            }
        }
        return result;
    }
    
    @Override
    public SearchTiendasResponseDto searchTiendas(SearchTiendasRequestDto request) throws Exception{
    	SearchTiendasResponseDto result = new SearchTiendasResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        SearchtiendasOutput searchTiendasOutput = meta4IcmWsCalcIncomeClient.searchtiendas(param1, param2);
        if (searchTiendasOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, searchTiendasOutput.getReturn()) == 0) {
            if (searchTiendasOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(searchTiendasOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (searchTiendasOutput.getIcmListatiendas() != null
                    && searchTiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet() != null
                    && CollectionUtils.isNotEmpty(
                            searchTiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
                List<SearchTiendasResultItemDto> items = icmWsCalcIncomeMapper.asSearchTiendasResultItemDtos(
                        searchTiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
                result.setData(items);
            }
        }
        return result;
    }
    
    @Override
    public TiendasResponseDto getTiendas(TiendasRequestDto request) throws Exception{
    	TiendasResponseDto result = new TiendasResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GettiendasincomeOutput tiendasOutput = meta4IcmWsCalcIncomeClient.gettiendasincome(param2, param1);
        if (tiendasOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, tiendasOutput.getReturn()) == 0) {
            if (tiendasOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(tiendasOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (tiendasOutput.getIcmListatiendas() != null
                    && tiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet() != null
                    && CollectionUtils.isNotEmpty(
                            tiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
                List<TiendasResultItemDto> items = icmWsCalcIncomeMapper.asTiendasResultItemDtos(
                        tiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
                result.setData(items);
            }
        }
        return result;
    }

}