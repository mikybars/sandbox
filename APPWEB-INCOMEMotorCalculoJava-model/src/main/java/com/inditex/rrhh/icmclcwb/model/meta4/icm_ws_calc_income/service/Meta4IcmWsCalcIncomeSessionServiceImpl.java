package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
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
    
    @Autowired
    @Qualifier("getEmpleadosTiendaDto")
    private Meta4PropertiesDto getEmpleadosTiendaDto;
    
    
    @Override
    public List<GenericTiendaResultItemDto> getTiendasEmpleado(final TiendasEmpleadoRequestDto request)
            throws Exception {
    	return getResultItem(request, meta4IcmWsCalcIncomeService, "getTiendasEmpleado", getTiendasEmpleadoDto.getFilter().getMaxPageSize());
    }
    
    @Override
    public List<GenericTiendaResultItemDto> searchTiendas(final SearchTiendasRequestDto request) throws Exception {
    	return getResultItem(request, meta4IcmWsCalcIncomeService, "searchTiendas", searchTiendasDto.getFilter().getMaxPageSize());
    }
    
    @Override
    public List<GenericTiendaResultItemDto> getTiendas(final TiendasRequestDto request) throws Exception {
    	return getResultItem(request, meta4IcmWsCalcIncomeService, "getTiendas", getTiendasDto.getFilter().getMaxPageSize());
    }
    
    @Override
    public List<GenericEmpleadoResultItemDto> searchEmpleados(final SearchEmpleadosRequestDto request) throws Exception {
    	return getResultItem(request, meta4IcmWsCalcIncomeService, "searchEmpleados", searchEmpleadosDto.getFilter().getMaxPageSize());
    }

    @Override
    public List<GenericEmpleadoResultItemDto> getComisionEmpleado(final ComisionEmpleadoRequestDto request) throws Exception {
    	return getResultItem(request, meta4IcmWsCalcIncomeService, "getComisionEmpleado", getComisionEmpleadoDto.getFilter().getMaxPageSize());
    }
    
    @Override
    public List<GenericEmpleadoResultItemDto> getEmpleados(final EmpleadosRequestDto request) throws Exception {
    	return getResultItem(request, meta4IcmWsCalcIncomeService, "getEmpleados", getEmpleadosDto.getFilter().getMaxPageSize());
    }
    
    
}