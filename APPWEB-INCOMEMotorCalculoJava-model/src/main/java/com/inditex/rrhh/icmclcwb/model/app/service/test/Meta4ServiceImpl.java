package com.inditex.rrhh.icmclcwb.model.app.service.test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;
import com.inditex.rrhh.icmclcwb.api.app.service.Meta4IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.service.Meta4Service;
import com.inditex.rrhh.icmclcwb.api.app.util.annotation.Meta4Session;
import com.inditex.rrhh.icmclcwb.api.meta4.PageDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadosestructura.dto.EmpleadosEstructuraRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadosestructura.dto.EmpleadosEstructuraResponseDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadosestructura.dto.EmpleadosEstructuraResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaFilterDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.valorescondiciones.dto.ValoresCondicionesRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.valorescondiciones.dto.ValoresCondicionesResponseDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.valorescondiciones.dto.ValoresCondicionesResultItemDTO;

@Service
public class Meta4ServiceImpl implements Meta4Service {

	//TODO DTENREIRO
//	@Autowired
//	private ApplicationContext appContext;
	
	@Autowired
	private Meta4IcmWsIncomeService meta4IcmWsIncomeService;


	
	@Meta4Session
	@Override
	public List<EmpleadosTiendaResultItemDTO> getEmpleadosTienda(JobDto jobDto) throws Exception {
		List<EmpleadosTiendaResultItemDTO> result = new ArrayList<>();
		
		EmpleadosTiendaRequestDTO request = new EmpleadosTiendaRequestDTO();
		PageDTO page = new PageDTO();
		page.setIdBusqueda(StringUtils.EMPTY);
		page.setCampoOrden("idempleado");
		page.setNumeroPagina(1);
		page.setNumeroRegistrosPagina(10);
		page.setNumeroTotalPaginas(null);
		page.setNumeroTotalResultados(null);
		page.setTipoOrden("DESC");
		request.setPage(page);
		
		EmpleadosTiendaFilterDTO data = new EmpleadosTiendaFilterDTO();
		if (jobDto.getFechaInicioPeriodo() != null) {
			data.setFechaInicio(jobDto.getFechaInicioPeriodo());
		}
		if (jobDto.getFechaFinPeriodo() != null) {
			data.setFechaFin(jobDto.getFechaFinPeriodo());
		}
		data.setIdLugarTrabajo(jobDto.getIdTienda());
		request.setData(data);
		
		boolean hasNext = false;
		do {
			hasNext = false;
			EmpleadosTiendaResponseDTO response = meta4IcmWsIncomeService.getEmpleadosTienda(request);
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
	public List<EmpleadosTiendaResultItemDTO> getEmpleadosTienda(EmpleadosTiendaRequestDTO request) throws Exception {
		List<EmpleadosTiendaResultItemDTO> result = new ArrayList<>();
		
		boolean hasNext = false;
		do {
			hasNext = false;
			EmpleadosTiendaResponseDTO response = meta4IcmWsIncomeService.getEmpleadosTienda(request);
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
	public List<EmpleadosEstructuraResultItemDTO> getEmpleadosEstructura(EmpleadosEstructuraRequestDTO request) throws Exception {
		List<EmpleadosEstructuraResultItemDTO> result = new ArrayList<>();
		
		EmpleadosEstructuraResponseDTO response = meta4IcmWsIncomeService.getEmpleadosEstructura(request);

		if (response != null){
			if (CollectionUtils.isNotEmpty(response.getData())) {
				result.addAll(response.getData());
			}
		}
		
		return result;
	}
	
	@Meta4Session
	@Override
	public List<ValoresCondicionesResultItemDTO> getValoresCondiciones(ValoresCondicionesRequestDTO request) throws Exception{
		List<ValoresCondicionesResultItemDTO> result = new ArrayList<>();
	
		boolean hasNext = false;
		do {
			hasNext = false;
			ValoresCondicionesResponseDTO response = meta4IcmWsIncomeService.getValoresCondiciones(request);
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