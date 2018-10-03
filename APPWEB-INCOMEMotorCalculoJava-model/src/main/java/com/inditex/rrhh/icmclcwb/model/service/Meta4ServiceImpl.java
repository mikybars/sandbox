package com.inditex.rrhh.icmclcwb.model.service;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.service.Meta4IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.service.Meta4LoginService;
import com.inditex.rrhh.icmclcwb.api.service.Meta4Service;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaFilterDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.PageDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.login.LoginDTO;

// http://www.springboottutorial.com/spring-boot-and-aop-with-spring-boot-starter-aop
// @After
@Service
public class Meta4ServiceImpl implements Meta4Service {

	@Autowired
    private Logger LOG;
	
	@Autowired
	private Meta4LoginService meta4LoginService;
	
	@Autowired
	private Meta4IcmWsIncomeService meta4IcmWsIncomeService;

	@Override
	public List<GetEmpleadosTiendaResultItemDTO> obtenerEmpleadosTienda(String idTienda) throws Exception {
		List<GetEmpleadosTiendaResultItemDTO> result = new ArrayList<>();
		if (meta4LoginService.retrieveM4Session() || meta4LoginService.login(new LoginDTO("INCOME", "123", "2"))) {
			
			GetEmpleadosTiendaRequestDTO param = new GetEmpleadosTiendaRequestDTO();
			PageDTO page = new PageDTO();
			page.setIdBusqueda(StringUtils.EMPTY);
			page.setCampoOrden(StringUtils.EMPTY);
			page.setNumeroPagina(1);
			page.setNumeroRegistrosPagina(10);
			page.setNumeroTotalPaginas(null);
			page.setNumeroTotalResultados(null);
			page.setTipoOrden("ASC");
			param.setPage(page);
			
			GetEmpleadosTiendaFilterDTO data = new GetEmpleadosTiendaFilterDTO();
			data.setFechaInicio(LocalDateTime.of(2017, Month.SEPTEMBER, 01, 00, 00));
			data.setFechaFin(LocalDateTime.of(2017, Month.SEPTEMBER, 01, 00, 00).with(TemporalAdjusters.lastDayOfMonth()));
			data.setIdLugarTrabajo("T160");
			data.setIdEstado(StringUtils.EMPTY);
			data.setIdEstadoMtu(StringUtils.EMPTY);
			param.setData(data);
			
			GetEmpleadosTiendaResponseDTO response = meta4IcmWsIncomeService.obtenerEmpleadosTienda(param);
			result.addAll(response.getData());
		} else {
			LOG.error("No tenemos sesión válida");
		}
		return result;
	}

}