package com.inditex.rrhh.icmclcwb.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.service.Meta4LoginService;
import com.inditex.rrhh.icmclcwb.api.meta4.login.login.dto.LoginRequestDto;

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

	@Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.util.annotation.Meta4Session)")
	public void meta4SessionAnnotationPointCutDefinition() {
	}

	@Before("meta4SessionAnnotationPointCutDefinition()")
	public void beforeMeta4SessionAnnotationPointCutDefinition() throws Throwable {
		LOG.info("Inicio :: beforeMeta4SessionAnnotationPointCutDefinition()");
		if (meta4LoginService.retrieveM4Session() || meta4LoginService.login(new LoginRequestDto(user, password, language))) {
			LOG.info("Inicio :: beforeMeta4SessionAnnotationPointCutDefinition(): Login = Ok");
		} else {
			LOG.error("Inicio :: beforeMeta4SessionAnnotationPointCutDefinition(): Login = Ko");
			throw new ApplicationException("No se puede invocar un servicio Meta4 sin tener sessionID valido");
		}
		LOG.info("Fin :: beforeMeta4SessionAnnotationPointCutDefinition()");
	}

}