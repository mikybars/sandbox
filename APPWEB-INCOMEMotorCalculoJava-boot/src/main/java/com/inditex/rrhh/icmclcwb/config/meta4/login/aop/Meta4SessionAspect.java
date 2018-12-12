package com.inditex.rrhh.icmclcwb.config.meta4.login.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.meta4.login.login.dto.LoginRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.login.service.Meta4LoginService;

//@Aspect
//@Component
//public class Meta4SessionAspect {
//
//    @Autowired
//    private Logger log;
//
//    @Autowired
//    private Meta4LoginService meta4LoginService;
//
//    @Value("${app.envars.meta4.user}")
//    private String user;
//
//    @Value("${app.envars.meta4.password}")
//    private String password;
//
//    @Value("${app.envars.meta4.language}")
//    private String language;
//
//    @Pointcut(value = "execution(public * com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.service.Meta4IcmWsIncomeSessionService.*(..))")
//    public void icmWsIncomePointcut() {
//        throw new UnsupportedOperationException();
//    }
//    
//    @Pointcut(value = "execution(public * com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionService.*(..))")
//    public void icmWsCalcIncomePointcut() {
//        throw new UnsupportedOperationException();
//    }
//    
//    @Before(value = "icmWsIncomePointcut() || icmWsCalcIncomePointcut()")
//    public void beforeMeta4SessionService() throws Exception {
//        if (!meta4LoginService.retrieveM4Session()
//                && !meta4LoginService.login(new LoginRequestDto(user, password, language))) {
//            log.error("No se puede invocar un servicio Meta4 sin tener sessionID valido");
//            throw new ApplicationException("No se puede invocar un servicio Meta4 sin tener sessionID valido");
//        }
//    }
//
//}