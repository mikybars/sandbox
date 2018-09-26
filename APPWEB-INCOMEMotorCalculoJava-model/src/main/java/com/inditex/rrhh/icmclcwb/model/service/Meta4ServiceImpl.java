package com.inditex.rrhh.icmclcwb.model.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.service.Meta4Service;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.GETCALENDARIOTIENDA;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.GetcalendariotiendaOutput;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.schemas.Login;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.schemas.LoginService;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.schemas.M4LoginOutput;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.schemas.ObjectFactory;

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

	@Override
	public void test() throws Exception {
		
		// Generación de objetos de LOGIN
		ObjectFactory ofLogin = new ObjectFactory();
		// Llamada a servicio de LOGIN
		Login login = ofLogin.createLogin();
		login.setIn0("HSW_USER_PRUEBA_4" /*user*/);
		login.setIn1("Inditex" /*pass*/);
		login.setIn2("2" /*lang*/);
		//TODO Validar objeto de entrada
		final M4LoginOutput loginOutput001 = meta4ClientLogin.login(login.getIn0() /*user*/, login.getIn1() /*pass*/, login.getIn2() /*lang*/);
		LOG.info("SessionID001: " + loginOutput001.getSessionID());
		// Recuperar la sesion 001
		meta4ClientIncome.retrieveM4Session(loginOutput001.getSessionID());
		//final M4LoginOutput loginOutput002 = meta4ClientLogin.login(login.getIn0() /*user*/, login.getIn1() /*pass*/, login.getIn2() /*lang*/);
		//logger.info("SessionID002: " + loginOutput002.getSessionID());
		
		// Generación de objetos de INCOME
		com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.ObjectFactory ofIncome = new com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.ObjectFactory();
		// Llamada a servicio de INCOME
		GETCALENDARIOTIENDA paramGetcalendariotienda = ofIncome.createGETCALENDARIOTIENDA();
		//TODO Validar objeto de entrada
		GetcalendariotiendaOutput getcalendariotiendaOutput001 = meta4ClientIncome.getcalendariotienda(paramGetcalendariotienda.getICMPARAMETROSTIENDA());
		
		int resultLogout001 = meta4ClientLogin.logout();
		LOG.info("resultLogout001: " + resultLogout001);
		// Recuperar la sesion 002
		//meta4ClientIncome.retrieveM4Session(loginOutput002.getSessionID());
		//GetcalendariotiendaOutput getcalendariotiendaOutput002 = meta4ClientIncome.getcalendariotienda(paramGetcalendariotienda.getICMPARAMETROSTIENDA());
		//int resultLogout002 = meta4ClientLogin.logout();
		//logger.info("resultLogout002: " + resultLogout002);
		
	}

}
