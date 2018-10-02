package com.inditex.rrhh.icmclcwb.model.service;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.service.Meta4IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.service.Meta4LoginService;
import com.inditex.rrhh.icmclcwb.api.service.Meta4Service;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaFilterDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.PageDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.login.LoginDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmWsIncomeService;

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
	
	@Autowired
	@Qualifier("meta4ClientIncome")
	private IcmWsIncomeService meta4ClientIncome;

	@Override
	public boolean obtenerEmpleadosTienda(String idTienda) throws Exception {
		boolean result = false;
		if (meta4LoginService.retrieveM4Session() || meta4LoginService.login(new LoginDTO("INCOME", "123", "2"))) {
			
			GetEmpleadosTiendaRequestDTO param = new GetEmpleadosTiendaRequestDTO();
			
			PageDTO page = new PageDTO();
			page.setIdBusqueda(StringUtils.EMPTY);
			page.setCampoOrden(StringUtils.EMPTY);
			page.setNumeroPagina(1);
			page.setNumeroRegistrosPagina(1000);
			page.setNumeroTotalPaginas(null);
			page.setNumeroTotalResultados(null);
			page.setTipoOrden("ASC");
			param.setPage(page);
			
			GetEmpleadosTiendaFilterDTO data = new GetEmpleadosTiendaFilterDTO();
			data.setFechaInicio(new Date());
			data.setFechaFin(new Date());
			data.setIdLugarTrabajo("T160");
			data.setIdEstado(StringUtils.EMPTY);
			data.setIdEstadoMtu(StringUtils.EMPTY);
			param.setData(data);
			
			result = meta4IcmWsIncomeService.obtenerEmpleadosTienda(param);
		} else {
			LOG.error("No tenemos sesión válida");
		}
		return result;
	}

}