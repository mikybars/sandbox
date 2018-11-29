package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleados.dto.EmpleadosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchempleados.dto.SearchEmpleadosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto.TiendasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.meta4.service.Meta4PageableServiceImpl;

@Service
public class Meta4IcmWsCalcIncomeSessionServiceImpl extends Meta4PageableServiceImpl implements Meta4IcmWsCalcIncomeSessionService {

	@Autowired
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;
	
    @Autowired
    @Qualifier("getTiendasEmpleadoDto")
    private Meta4PropertiesDto getTiendasEmpleadoDto;
    
    @Autowired
    @Qualifier("searchTiendasDto")
    private Meta4PropertiesDto searchTiendasDto;
	   
    @Autowired
    @Qualifier("getTiendasDto")
    private Meta4PropertiesDto getTiendasDto;

    @Autowired
    @Qualifier("searchEmpleadosDto")
    private Meta4PropertiesDto searchEmpleadosDto;
    
    @Autowired
    @Qualifier("getComisionEmpleadoDto")
    private Meta4PropertiesDto getComisionEmpleadoDto;
    
    @Autowired
    @Qualifier("getEmpleadosDto")
    private Meta4PropertiesDto getEmpleadosDto;
    
    
    @Override
    public List<TiendasEmpleadoResultItemDto> getTiendasEmpleado(final TiendasEmpleadoRequestDto request)
            throws Exception {
    	return getResultItem(request, meta4IcmWsCalcIncomeService, "getTiendasEmpleado", getTiendasEmpleadoDto.getFilter().getMaxPageSize());
    }
    
    @Override
    public List<SearchTiendasResultItemDto> searchTiendas(final SearchTiendasRequestDto request) throws Exception {
    	return getResultItem(request, meta4IcmWsCalcIncomeService, "searchTiendas", searchTiendasDto.getFilter().getMaxPageSize());
    }
    
    @Override
    public List<TiendasResultItemDto> getTiendas(final TiendasRequestDto request) throws Exception {
    	return getResultItem(request, meta4IcmWsCalcIncomeService, "getTiendas", getTiendasDto.getFilter().getMaxPageSize());
    }
    
    @Override
    public List<SearchEmpleadosResultItemDto> searchEmpleados(final SearchEmpleadosRequestDto request) throws Exception {
    	return getResultItem(request, meta4IcmWsCalcIncomeService, "searchEmpleados", searchEmpleadosDto.getFilter().getMaxPageSize());
    }

    @Override
    public List<ComisionEmpleadoResultItemDto> getComisionEmpleado(final ComisionEmpleadoRequestDto request) throws Exception {
    	return getResultItem(request, meta4IcmWsCalcIncomeService, "getComisionEmpleado", getComisionEmpleadoDto.getFilter().getMaxPageSize());
    }
    
    @Override
    public List<EmpleadosResultItemDto> getEmpleados(final EmpleadosRequestDto request) throws Exception {
    	return getResultItem(request, meta4IcmWsCalcIncomeService, "getEmpleados", getEmpleadosDto.getFilter().getMaxPageSize());
    }
    
    
}