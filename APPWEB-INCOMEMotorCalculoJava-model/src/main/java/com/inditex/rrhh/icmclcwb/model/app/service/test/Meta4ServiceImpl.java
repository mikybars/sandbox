package com.inditex.rrhh.icmclcwb.model.app.service.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.Meta4IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.service.Meta4Service;
import com.inditex.rrhh.icmclcwb.api.app.util.annotation.Meta4Session;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResultItemDto;

@Service
public class Meta4ServiceImpl implements Meta4Service {

	//TODO DTENREIRO
//	@Autowired
//	private ApplicationContext appContext;
	
	@Autowired
	private Meta4IcmWsIncomeService meta4IcmWsIncomeService;
    
	@Meta4Session
	@Override
	public List<EmpleadosTiendaResultItemDto> getEmpleadosTienda(TrabajoDto trabajo) throws Exception {
		List<EmpleadosTiendaResultItemDto> result = new ArrayList<>();
		EmpleadosTiendaRequestDto request = new EmpleadosTiendaRequestDto();

		request.setPage(PaginationPropertiesFactory.getProperties(new Object() {}
	      .getClass()
	      .getEnclosingMethod()
	      .getName()));
		
		EmpleadosTiendaFilterDto data = new EmpleadosTiendaFilterDto();
		if (trabajo.getFechaInicioPeriodo() != null) {
			data.setFechaInicio(trabajo.getFechaInicioPeriodo());
		}
		if (trabajo.getFechaFinPeriodo() != null) {
			data.setFechaFin(trabajo.getFechaFinPeriodo());
		}
		if (StringUtils.isNotBlank(trabajo.getIdTienda())) {
			data.setIdLugarTrabajo("T" + trabajo.getIdTienda());
		}
		request.setData(data);
		
		boolean hasNext = false;
		do {
			hasNext = false;
			EmpleadosTiendaResponseDto response = meta4IcmWsIncomeService.getEmpleadosTienda(request);
			if (response != null) {
				if (CollectionUtils.isNotEmpty(response.getData())) {
					result.addAll(response.getData());
				}
				if (response.getPage() != null && response.getPage().hasNext()) {
					hasNext = true;
					request.setPage(response.getPage().next());
				}
			}
		} while (hasNext);

		return result;
	}

	@Meta4Session
	@Override
	public List<EmpleadosTiendaResultItemDto> getEmpleadosTienda(EmpleadosTiendaRequestDto request) throws Exception {
		List<EmpleadosTiendaResultItemDto> result = new ArrayList<>();
		
		boolean hasNext = false;
		do {
			hasNext = false;
			EmpleadosTiendaResponseDto response = meta4IcmWsIncomeService.getEmpleadosTienda(request);
			if (response != null) {
				if (CollectionUtils.isNotEmpty(response.getData())) {
					result.addAll(response.getData());
				}
				if (response.getPage() != null && response.getPage().hasNext()) {
					hasNext = true;
					request.setPage(response.getPage().next());
				}
			}
		} while (hasNext);

		return result;
	}

	
	@Meta4Session
	@Override
	public List<EmpleadosEstructuraResultItemDto> getEmpleadosEstructura(EmpleadosEstructuraRequestDto request) throws Exception {
		List<EmpleadosEstructuraResultItemDto> result = new ArrayList<>();
		
		EmpleadosEstructuraResponseDto response = meta4IcmWsIncomeService.getEmpleadosEstructura(request);

		if (response != null){
			if (CollectionUtils.isNotEmpty(response.getData())) {
				result.addAll(response.getData());
			}
		}
		
		return result;
	}
	
	@Meta4Session
	@Override
	public List<ValoresCondicionesResultItemDto> getValoresCondiciones(ValoresCondicionesRequestDto request) throws Exception{
		List<ValoresCondicionesResultItemDto> result = new ArrayList<>();
	
		boolean hasNext = false;
		do {
			hasNext = false;
			ValoresCondicionesResponseDto response = meta4IcmWsIncomeService.getValoresCondiciones(request);
			if (response != null) {
				if (CollectionUtils.isNotEmpty(response.getData())) {
					result.addAll(response.getData());
				}
				if (response.getPage() != null && response.getPage().hasNext()) {
					hasNext = true;
					request.setPage(response.getPage().next());
				}
			}
		} while (hasNext);
		
		return result;
	}

}