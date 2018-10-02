package com.inditex.rrhh.icmclcwb.model.service;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.service.Meta4LoginService;
import com.inditex.rrhh.icmclcwb.api.service.Meta4Service;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.login.LoginDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.GetempleadostiendaOutput;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrostiendaBlock;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrostiendaRecord;
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
	@Qualifier("meta4ClientIncome")
	private IcmWsIncomeService meta4ClientIncome;

	@Override
	public boolean obtenerEmpleadosTienda(String idTienda) throws Exception {
		boolean result = false;
		if (meta4LoginService.retrieveM4Session() || meta4LoginService.login(new LoginDTO("INCOME", "123", "2"))) {
			
			String defaultValue = StringUtils.EMPTY;
			
			IcmParametrospaginacionBlock icmParametrospaginacionBlock = new IcmParametrospaginacionBlock();
			icmParametrospaginacionBlock.setIdbusqueda(defaultValue);
			icmParametrospaginacionBlock.setCampoorden(defaultValue);
			icmParametrospaginacionBlock.setNumeropagina("1");
			icmParametrospaginacionBlock.setNumeroregistrospagina("1000");
			icmParametrospaginacionBlock.setNumerototalpaginas(defaultValue);
			icmParametrospaginacionBlock.setNumerototalresultados(defaultValue);
			icmParametrospaginacionBlock.setTipoorden("ASC");
			icmParametrospaginacionBlock.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
			
			IcmParametrostiendaBlock icmParametrostiendaBlock = new IcmParametrostiendaBlock();
			icmParametrostiendaBlock.setFechainicio("2017-09-01T00:00:00.000Z");
			icmParametrostiendaBlock.setFechafin("2017-09-30T00:00:00.000Z");
			icmParametrostiendaBlock.setIdlugartrabajo("T160");
			icmParametrostiendaBlock.setIdestado(defaultValue);
			icmParametrostiendaBlock.setIdestadomtu(defaultValue);
			icmParametrostiendaBlock.getIcmParametrostiendaRecordSet().add(new IcmParametrostiendaRecord());
			
			GetempleadostiendaOutput getempleadostiendaOutput = meta4ClientIncome.getempleadostienda(icmParametrospaginacionBlock, icmParametrostiendaBlock);
			LOG.info("getempleadostiendaOutput.getReturn(): " + getempleadostiendaOutput.getReturn());
			if (getempleadostiendaOutput != null && getempleadostiendaOutput.getIcmEmpleadostienda() != null && getempleadostiendaOutput.getIcmEmpleadostienda().getIcmEmpleadostiendaRecordSet() != null && CollectionUtils.isNotEmpty(getempleadostiendaOutput.getIcmEmpleadostienda().getIcmEmpleadostiendaRecordSet())) {
				LOG.info("Se han recuperado: " + getempleadostiendaOutput.getIcmEmpleadostienda().getIcmEmpleadostiendaRecordSet().size());
			} else {
				LOG.info("No hay elementos");
			}
			result = true;
		} else {
			LOG.error("No tenemos sesión válida");
		}
		return result;
	}

}