package com.inditex.rrhh.icmclcwb.model.meta4.login.service;

import java.util.concurrent.Semaphore;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.service.Meta4LoginService;
import com.inditex.rrhh.icmclcwb.api.meta4.login.dto.LoginRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.login.dto.LoginResponseDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.Login;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.mapper.LoginMapper;

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
	public boolean login(LoginRequestDto loginRequest) throws Exception {
		boolean result = false;
		LOG.info("Inicio :: Meta4LoginService.login(): {}", loginRequest);
		try {
			LOG.info("Inicio :: Meta4LoginService.login(): semaforo.acquire()");
			semaforo.acquire();
			LOG.info("Fin :: Meta4LoginService.login(): semaforo.acquire()");
			if (!this.retrieveM4Session()) {
				LOG.info("Meta4LoginService.login(): sessionID = Ko");
				sessionID = null;
				Login param = loginMapper.loginRequestDtoToLogin(loginRequest);
				LoginResponseDto LoginResponse = loginMapper.m4LoginOutputToLoginResponseDto(meta4ClientLogin
						.login(/* user */ param.getIn0(), /* pass */ param.getIn1(), /* lang */ param.getIn2()));
				if (LoginResponse != null && StringUtils.isNotBlank(LoginResponse.getSessionID())) {
					LOG.info("Inicio :: Meta4LoginService.login(): loginResult.getSessionID(): {}", sessionID);
					sessionID = LoginResponse.getSessionID();
					meta4ClientIncome.retrieveM4Session(sessionID);
					result = true;
					LOG.info("Fin :: Meta4LoginService.login(): loginResult.getSessionID(): {}", sessionID);
				} else {
					LOG.error("Inicio :: Meta4LoginService.login(): loginResult.getSessionID(): Ko");
				}
			} else {
				LOG.info("Meta4LoginService.login(): sessionID = Ok");
				result = true;
			}
		} catch (Exception e) {
			LOG.info("Meta4LoginService.login(): Error no controlado");
			sessionID = null;
			throw e;
		} finally {
			LOG.info("Inicio :: semaforo.release()");
			semaforo.release();
			LOG.info("Fin :: semaforo.release()");
		}
		LOG.info("Fin :: Meta4LoginService.login(): {}", loginRequest);
		return result;
	}

	@Override
	public boolean retrieveM4Session() throws Exception {
		boolean result = false;
		LOG.info("Inicio :: retrieveM4Session(): {}", sessionID);
		try {
			if (StringUtils.isNotBlank(sessionID)) {
				int retrieveM4SessionResult = meta4ClientLogin.retrieveM4Session(sessionID);
				if (retrieveM4SessionResult == 0) {
					LOG.info("retrieveM4Session(): sessionID activo: {}", sessionID);
					result = true;
				} else {
					LOG.info("retrieveM4Session(): sessionID inactivo: {}", sessionID);
				}
			} else {
				LOG.info("retrieveM4Session(): sessionID inexistente: {}", sessionID);
			}
		} catch (Exception e) {
			LOG.info("Meta4LoginService.retrieveM4Session(): Error no controlado");
			throw e;
		}
		LOG.info("Fin :: retrieveM4Session(): {}", sessionID);
		return result;
	}

}