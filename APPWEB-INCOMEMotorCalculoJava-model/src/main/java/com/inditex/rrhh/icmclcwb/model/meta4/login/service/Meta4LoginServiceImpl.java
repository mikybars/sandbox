package com.inditex.rrhh.icmclcwb.model.meta4.login.service;

import java.util.concurrent.Semaphore;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.service.Meta4LoginService;
import com.inditex.rrhh.icmclcwb.api.meta4.login.dto.LoginDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.Login;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.M4LoginOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.M4SoapException_Exception;
import com.inditex.rrhh.icmclcwb.model.meta4.login.mapper.LoginMapper;

// http://www.springboottutorial.com/spring-boot-and-aop-with-spring-boot-starter-aop
// @After
@Service
public class Meta4LoginServiceImpl implements Meta4LoginService {

	private static String sessionID;
	
	private final Semaphore semaforo = new Semaphore(1);
	
	@Autowired
    private Logger LOG;
	
	@Autowired
	@Qualifier("meta4ClientLogin")
	private LoginService meta4ClientLogin;
	
	@Autowired
    private LoginMapper loginMapper;
	
	@Autowired
	@Qualifier("meta4ClientIncome")
	private IcmWsIncomeService meta4ClientIncome;

	@Override
	public boolean login(LoginDto login) throws Exception {
		boolean result = false;
		try {
			semaforo.acquire();
			if (!this.retrieveM4Session()) {
				sessionID = null;
				Login param = loginMapper.asLogin(login);
				final M4LoginOutput loginResult = meta4ClientLogin.login(param.getIn0() /*user*/, param.getIn1() /*pass*/, param.getIn2() /*lang*/);
				if (loginResult != null && StringUtils.isNotBlank(loginResult.getSessionID())) {
					sessionID = loginResult.getSessionID();
					meta4ClientIncome.retrieveM4Session(sessionID);
					result = true;
				}
			} else {
				result = true;
			}
		} catch (M4SoapException_Exception e) {
			LOG.error("Error no controlado", e);
		} catch (InterruptedException e) {
			LOG.error("Se cancelo la peticion mientras se esperaba la adquisicon del semaforo", e);
		} catch (SOAPFaultException e) {
			LOG.error("Error no controlado (Sesion-login)", e);
		} finally {
			semaforo.release();
		}
		return result;
	}

	@Override
	public boolean retrieveM4Session() {
		boolean result = false;
		LOG.info("sessionID (check): " + sessionID);
		if (StringUtils.isNotBlank(sessionID)) {
			try {
				int retrieveM4SessionResult = meta4ClientLogin.retrieveM4Session(sessionID);
				if (retrieveM4SessionResult == 0) {
					result = true;
					LOG.info("sessionID activo: " + sessionID);
				} else {
					LOG.error("Error no controlado: " + retrieveM4SessionResult);
				}
			} catch (M4SoapException_Exception e) {
				LOG.error("Error no controlado", e);
			} catch (SOAPFaultException e) {
				LOG.error("Error no controlado (Sesion-retrieveM4Session)", e);
			}
		}
		return result;
	}

}