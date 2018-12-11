package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.comisionempleado.dto.ComisionEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleados.dto.EmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchempleados.dto.SearchEmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.GetcomisionempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.GettiendasempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.GettiendasincomeOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmParametrosentradaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.SearchempleadosOutput;
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
                List<GenericTiendaResultItemDto> items = icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(
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
                List<GenericTiendaResultItemDto> items = icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(
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
                List<GenericTiendaResultItemDto> items = icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(
                        tiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
                result.setData(items);
            }
        }
        return result;
    }
    
    @Override
    public SearchEmpleadosResponseDto searchEmpleados(SearchEmpleadosRequestDto request) throws Exception{
    	SearchEmpleadosResponseDto result = new SearchEmpleadosResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        SearchempleadosOutput searchEmpleadosOutput = meta4IcmWsCalcIncomeClient.searchempleados(param2, param1);
        if (searchEmpleadosOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, searchEmpleadosOutput.getReturn()) == 0) {
            if (searchEmpleadosOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(searchEmpleadosOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (searchEmpleadosOutput.getIcmListaempleados() != null
                    && searchEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet() != null
                    && CollectionUtils.isNotEmpty(
                            searchEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
                List<GenericEmpleadoResultItemDto> items = icmWsCalcIncomeMapper.asGenericEmpleadoResultItemDtos(
                        searchEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
                result.setData(items);
            }
        }
        return result;
    	
    }

    @Override
    public ComisionEmpleadoResponseDto getComisionEmpleado(ComisionEmpleadoRequestDto request) throws Exception {
    	ComisionEmpleadoResponseDto result = new ComisionEmpleadoResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        GetcomisionempleadoOutput getComisionEmpleadoOutput = meta4IcmWsCalcIncomeClient.getcomisionempleado(param1);
        if (getComisionEmpleadoOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, getComisionEmpleadoOutput.getReturn()) == 0 
                    && getComisionEmpleadoOutput.getIcmListaempleados() != null
                    && getComisionEmpleadoOutput.getIcmListaempleados().getIcmListaempleadosRecordSet() != null
                    && CollectionUtils.isNotEmpty(
                            getComisionEmpleadoOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
                List<GenericEmpleadoResultItemDto> items = icmWsCalcIncomeMapper.asGenericEmpleadoResultItemDtos(
                        getComisionEmpleadoOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
                result.setData(items);
            
        }
    	return result;
    }
    
    
    @Override
    public EmpleadosResponseDto getEmpleados(EmpleadosRequestDto request) throws Exception{
    	EmpleadosResponseDto result = new EmpleadosResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetempleadosOutput getEmpleadosOutput = meta4IcmWsCalcIncomeClient.getempleados(param1, param2);
        if (getEmpleadosOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, getEmpleadosOutput.getReturn()) == 0) {
            if (getEmpleadosOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getEmpleadosOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getEmpleadosOutput.getIcmListaempleados() != null
                    && getEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet() != null
                    && CollectionUtils.isNotEmpty(
                            getEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
                List<GenericEmpleadoResultItemDto> items = icmWsCalcIncomeMapper.asGenericEmpleadoResultItemDtos(
                        getEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
                result.setData(items);
            }
        }
        return result;
    }
    
}