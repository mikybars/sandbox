package com.inditex.rrhh.icmclcwb.model.meta4.login.service;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.login.login.dto.LoginRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.login.login.dto.LoginResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.login.login.dto.SesionMeta4Dto;
import com.inditex.rrhh.icmclcwb.api.meta4.login.service.Meta4LoginService;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.Login;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.mapper.LoginMapper;

@Service
public class Meta4LoginServiceImpl implements Meta4LoginService {

    private final Semaphore semaforo = new Semaphore(1);

    // TODO Con solo una sesión no permite una concurrencia alta contras Meta4
    // private static ThreadLocal<SesionMeta4Dto> tlSesionMeta4Dto = new
    // ThreadLocal<>();
    private static SesionMeta4Dto sesionMeta4Dto = new SesionMeta4Dto();

//	@Autowired
//	private ApplicationContext ctx;

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    @Qualifier("meta4LoginClient")
    private LoginService meta4LoginClient;

    @Autowired
    @Qualifier("meta4IcmWsIncomeClient")
    private IcmWsIncomeService meta4IcmWsIncomeClient;

    @Override
    public boolean login(LoginRequestDto loginRequest) throws Exception {
        boolean result = false;
        try {
            semaforo.acquire();
            if (!this.retrieveM4Session()) {
                sesionMeta4Dto = new SesionMeta4Dto();
                Login param = loginMapper.loginRequestDtoToLogin(loginRequest);
                LoginResponseDto LoginResponse = loginMapper.m4LoginOutputToLoginResponseDto(meta4LoginClient
                        .login(/* user */ param.getIn0(), /* pass */ param.getIn1(), /* lang */ param.getIn2()));
                if (LoginResponse != null && StringUtils.isNotBlank(LoginResponse.getSessionID())) {
                    sesionMeta4Dto.setId(LoginResponse.getSessionID());
                    sesionMeta4Dto.setUser(loginRequest.getUsername());
                    sesionMeta4Dto.setPassword(loginRequest.getPassword());
                    sesionMeta4Dto.setLanguage(loginRequest.getLanguage());
                    sesionMeta4Dto.setFechaCreacion(LocalDateTime.now());
                    sesionMeta4Dto.setActiva(Boolean.TRUE);
                    meta4IcmWsIncomeClient.retrieveM4Session(sesionMeta4Dto.getId());
                    result = true;
                }
            } else {
                result = true;
            }
        } catch (Exception e) {
            logout();
            throw e;
        } finally {
            semaforo.release();
        }
        return result;
    }

    @Override
    public boolean retrieveM4Session() throws Exception {
        boolean result = false;
        try {
            if (sesionMeta4Dto != null) {
                if (StringUtils.isNotBlank(sesionMeta4Dto.getId()) && Boolean.TRUE.equals(sesionMeta4Dto.getActiva())) {
                    int retrieveM4SessionResult = meta4LoginClient.retrieveM4Session(sesionMeta4Dto.getId());
                    if (retrieveM4SessionResult == 0) {
                        result = true;
                    }
                }
            }
        } catch (SOAPFaultException e) {
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    @Override
    public boolean logout() {
        boolean result = false;
        try {
            if (sesionMeta4Dto != null) {
                sesionMeta4Dto.setActiva(Boolean.FALSE);
                meta4LoginClient.logout();
            }
        } catch (Exception e) {
        }
        return result;
    }

}