package com.inditex.rrhh.icmclcwb.config.meta4.login.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.meta4.login.login.dto.LoginRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.login.service.Meta4LoginService;

@Aspect
@Component
public class Meta4SessionAspect {

    @Autowired
    private Logger LOG;

    @Autowired
    private Meta4LoginService meta4LoginService;

    @Value("${app.envars.meta4.user}")
    private String user;

    @Value("${app.envars.meta4.password}")
    private String password;

    @Value("${app.envars.meta4.language}")
    private String language;

    @Before(value = "execution(public * com.inditex.rrhh.icmclcwb.api.meta4.service.Meta4SessionService.*(..))")
    public void beforeMeta4SessionService() throws Exception {
        if (!meta4LoginService.retrieveM4Session()
                && !meta4LoginService.login(new LoginRequestDto(user, password, language))) {
            LOG.error("No se puede invocar un servicio Meta4 sin tener sessionID valido");
            throw new ApplicationException("No se puede invocar un servicio Meta4 sin tener sessionID valido");
        }
    }

}