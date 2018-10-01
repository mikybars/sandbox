package com.inditex.rrhh.icmclcwb.model.service;

import java.util.concurrent.Semaphore;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.service.Meta4Service;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.ArrayOfIcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.ArrayOfIcmParametrostiendaRecord;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.GetempleadostiendaOutput;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.IcmEmpleadostiendaRecord;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.IcmParametrostiendaBlock;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.schemas.Login;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.schemas.LoginService;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.schemas.M4LoginOutput;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.schemas.M4SoapException;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.schemas.ObjectFactory;

// http://www.springboottutorial.com/spring-boot-and-aop-with-spring-boot-starter-aop
// @After
@Service
public class Meta4ServiceImpl implements Meta4Service {

	@Autowired
    private Logger LOG;
	
	@Autowired
	@Qualifier("meta4ClientLogin")
	private LoginService meta4ClientLogin;
	
	@Autowired
	@Qualifier("meta4ClientIncome")
	private IcmWsIncomeService meta4ClientIncome;
	
	private static String sessionID;
	
	private final Semaphore semaforo = new Semaphore(1);

	@Override
	public boolean login() throws Exception {
		boolean result = false;
		try {
			semaforo.acquire();
			if (!this.retrieveM4Session()) {
				sessionID = null;
				ObjectFactory ofLogin = new ObjectFactory();
				Login login = ofLogin.createLogin();
				login.setIn0("HSW_USER_PRUEBA_4" /*user*/);
				login.setIn1("Inditex" /*pass*/);
				login.setIn2("2" /*lang*/);
				final M4LoginOutput loginResult = meta4ClientLogin.login(login.getIn0() /*user*/, login.getIn1() /*pass*/, login.getIn2() /*lang*/);
				if (loginResult != null && StringUtils.isNotBlank(loginResult.getSessionID())) {
					sessionID = loginResult.getSessionID();
					meta4ClientIncome.retrieveM4Session(sessionID);
					result = true;
				}
			} else {
				result = true;
			}
		} catch (M4SoapException e) {
			LOG.error("Error no controlado", e);
		} catch (InterruptedException e) {
			LOG.error("Se cancelo la peticion mientras se esperaba la adquisicon del semaforo", e);
		} finally {
			semaforo.release();
		}
		return result;
	}

	@Override
	public boolean retrieveM4Session() {
		boolean result = false;
		if (StringUtils.isNotBlank(sessionID)) {
			try {
				int retrieveM4SessionResult = meta4ClientLogin.retrieveM4Session(sessionID);
				if (retrieveM4SessionResult == 0) {
					result = true;
					LOG.info("sessionID activo");
				} else {
					LOG.error("Error no controlado: " + retrieveM4SessionResult);
				}
			} catch (M4SoapException e) {
				LOG.error("Error no controlado", e);
			}
		}
		return result;
	}

	@Override
	public boolean obtenerEmpleadosTienda(String idTienda) throws Exception {
		boolean result = false;
		if (this.retrieveM4Session() || this.login()) {
			IcmParametrospaginacionBlock icmParametrospaginacionBlock = new IcmParametrospaginacionBlock();
			ArrayOfIcmParametrospaginacionRecord arrayOfIcmParametrospaginacionRecord = new ArrayOfIcmParametrospaginacionRecord();
			//arrayOfIcmParametrospaginacionRecord.getItem();
			icmParametrospaginacionBlock.setIcmParametrospaginacionRecordSet(arrayOfIcmParametrospaginacionRecord);
			//icmParametrospaginacionBlock.setIdbusqueda(StringUtils.EMPTY);
			icmParametrospaginacionBlock.setCampoorden("ASC");
			icmParametrospaginacionBlock.setNumeropagina("1");
			icmParametrospaginacionBlock.setNumeroregistrospagina("1000");
			//icmParametrospaginacionBlock.setNumerototalpaginas(StringUtils.EMPTY);
			//icmParametrospaginacionBlock.setNumerototalresultados(StringUtils.EMPTY);
			//icmParametrospaginacionBlock.setTipoorden(StringUtils.EMPTY);
			IcmParametrostiendaBlock icmParametrostiendaBlock = new IcmParametrostiendaBlock();
			ArrayOfIcmParametrostiendaRecord arrayOfIcmParametrostiendaRecord = new ArrayOfIcmParametrostiendaRecord();
			//arrayOfIcmParametrostiendaRecord.getItem();
			icmParametrostiendaBlock.setIcmParametrostiendaRecordSet(arrayOfIcmParametrostiendaRecord);
			icmParametrostiendaBlock.setFechainicio("2017-09-01T00:00:00.000Z");
			icmParametrostiendaBlock.setFechafin("2017-09-30T00:00:00.000Z");
			icmParametrostiendaBlock.setIdlugartrabajo("T160");
			GetempleadostiendaOutput getempleadostiendaOutput = meta4ClientIncome.getempleadostienda(icmParametrospaginacionBlock, icmParametrostiendaBlock);
			LOG.info("getempleadostiendaOutput.getReturn(): " + getempleadostiendaOutput.getReturn());
			if (getempleadostiendaOutput != null && getempleadostiendaOutput.getIcmEmpleadostienda() != null && getempleadostiendaOutput.getIcmEmpleadostienda().getIcmEmpleadostiendaRecordSet() != null && CollectionUtils.isNotEmpty(getempleadostiendaOutput.getIcmEmpleadostienda().getIcmEmpleadostiendaRecordSet().getItem())) {
				for (IcmEmpleadostiendaRecord item : getempleadostiendaOutput.getIcmEmpleadostienda().getIcmEmpleadostiendaRecordSet().getItem()) {
					LOG.info("Item: " + item.toString());
				}
			}
			result = true;
		} else {
			LOG.error("No tenemos sesión válida");
		}
		return result;
	}

}