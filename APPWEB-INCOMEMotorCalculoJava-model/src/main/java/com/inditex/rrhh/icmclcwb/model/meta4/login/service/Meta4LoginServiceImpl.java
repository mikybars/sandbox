package com.inditex.rrhh.icmclcwb.model.meta4.login.service;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.SesionMeta4Dto;
import com.inditex.rrhh.icmclcwb.api.meta4.login.login.dto.LoginRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.login.login.dto.LoginResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.login.service.Meta4LoginService;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.Login;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.mapper.LoginMapper;

@Service
public class Meta4LoginServiceImpl implements Meta4LoginService {

	private final Semaphore semaforo = new Semaphore(1);

	//TODO Con solo una sesión no permite una concurrencia alta contras Meta4
	//private static ThreadLocal<SesionMeta4Dto> tlSesionMeta4Dto = new ThreadLocal<>();
	private static SesionMeta4Dto sesionMeta4Dto = new SesionMeta4Dto();

	@Autowired
	private Logger LOG;

//	@Autowired
//	private ApplicationContext ctx;

	@Autowired
	private LoginMapper loginMapper;

	@Autowired
	@Qualifier("meta4ClientLogin")
	private LoginService meta4ClientLogin;

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
				sesionMeta4Dto = new SesionMeta4Dto();
				Login param = loginMapper.loginRequestDtoToLogin(loginRequest);
				LoginResponseDto LoginResponse = loginMapper.m4LoginOutputToLoginResponseDto(meta4ClientLogin
						.login(/* user */ param.getIn0(), /* pass */ param.getIn1(), /* lang */ param.getIn2()));
				if (LoginResponse != null && StringUtils.isNotBlank(LoginResponse.getSessionID())) {
					LOG.info("Inicio :: Meta4LoginService.login(): loginResult.getSessionID(): {}", sesionMeta4Dto);
					sesionMeta4Dto.setId(LoginResponse.getSessionID());
					sesionMeta4Dto.setUser(loginRequest.getUsername());
					sesionMeta4Dto.setPassword(loginRequest.getPassword());
					sesionMeta4Dto.setLanguage(loginRequest.getLanguage());
					sesionMeta4Dto.setFechaCreacion(LocalDateTime.now());
					sesionMeta4Dto.setActiva(Boolean.TRUE);
					meta4ClientIncome.retrieveM4Session(sesionMeta4Dto.getId());
					result = true;
					LOG.info("Fin :: Meta4LoginService.login(): loginResult.getSessionID(): {}", sesionMeta4Dto);
				} else {
					LOG.error("Inicio :: Meta4LoginService.login(): loginResult.getSessionID(): Ko");
				}
			} else {
				LOG.info("Meta4LoginService.login(): sessionID = Ok");
				result = true;
			}
		} catch (Exception e) {
			LOG.error("Meta4LoginService.login(): Error no controlado");
			logout();
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
		LOG.info("Inicio :: retrieveM4Session(): {}", sesionMeta4Dto);
		try {
			if (sesionMeta4Dto != null) {
				if (StringUtils.isNotBlank(sesionMeta4Dto.getId()) && Boolean.TRUE.equals(sesionMeta4Dto.getActiva())) {
					int retrieveM4SessionResult = meta4ClientLogin.retrieveM4Session(sesionMeta4Dto.getId());
					if (retrieveM4SessionResult == 0) {
						LOG.info("retrieveM4Session(): sessionID activo: {}", sesionMeta4Dto);
						result = true;
					} else {
						LOG.info("retrieveM4Session(): sessionID inactivo: {}", sesionMeta4Dto);
					}
				} else {
					LOG.info("retrieveM4Session(): sessionID inexistente: {}", sesionMeta4Dto);
				}
			} else {
				LOG.info("retrieveM4Session(): tlSesionMeta4Dto inexistente: {}", sesionMeta4Dto);
			}
		} catch (SOAPFaultException e) {
			// No es valida la sesion o algo no controlado ha fallado 
			LOG.error("Meta4LoginService.retrieveM4Session(): Error no controlado", e);
		} catch (Exception e) {
			LOG.error("Meta4LoginService.retrieveM4Session(): Error no controlado", e);
			throw e;
		}
		LOG.info("Fin :: retrieveM4Session(): {}", sesionMeta4Dto);
		return result;
	}

	@Override
	public boolean logout() {
		boolean result = false;
		LOG.info("Inicio :: logout(): {}", sesionMeta4Dto);
		try {
			LOG.info("Inicio :: logout(): if (sesionMeta4Dto != null) {");
			if (sesionMeta4Dto != null) {
				LOG.info("sesionMeta4Dto != null");
				sesionMeta4Dto.setActiva(Boolean.FALSE);
				meta4ClientLogin.logout();
			}
			LOG.info("Fin :: logout(): if (sesionMeta4Dto != null) {");
		} catch (Exception e) {
			LOG.error("Meta4LoginService.logout(): Error no controlado", e);
		}
		LOG.info("Fin :: logout(): {}", sesionMeta4Dto);
		return result;
	}

}