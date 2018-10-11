package com.inditex.rrhh.icmclcwb.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.service.Meta4LoginService;
import com.inditex.rrhh.icmclcwb.api.meta4.login.dto.LoginDto;

@Aspect
@Component
public class Meta4SessionAspect {

	@Autowired
    private Logger LOG;
	
	@Autowired
	private Meta4LoginService meta4LoginService;
	
	@Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.util.annotation.Meta4Session)")
	public void meta4SessionAnnotationPointCutDefinition(){}
	
	@Before("meta4SessionAnnotationPointCutDefinition()")
	public void beforeMeta4SessionAnnotationPointCutDefinition() throws Throwable {
		LOG.info("INICIO beforeMeta4SessionAnnotationPointCutDefinition(): login");
		if (meta4LoginService.retrieveM4Session() || meta4LoginService.login(new LoginDto("INCOME", "123", "2"))) {
			LOG.info("beforeMeta4SessionAnnotationPointCutDefinition(): Con permisos");
		} else {
			LOG.error("beforeMeta4SessionAnnotationPointCutDefinition(): Sin permisos");
		}
		LOG.info("FIN beforeMeta4SessionAnnotationPointCutDefinition(): login");
	}

}