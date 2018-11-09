package com.inditex.rrhh.icmclcwb.config.meta4;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;

@Configuration
public class Meta4ClientLoginConfig extends Meta4ClientConfigAbstract<LoginService> {

	@Autowired
    private Logger LOG;

	@Bean(name = "meta4ClientLogin")
	@Override
	public LoginService init() {
		LOG.info("Inicio :: Meta4ClientIncomeConfig.init()");
		LoginService result = super.build(LoginService.class);
		LOG.info("Fin :: Meta4ClientIncomeConfig.init()");
		return result;
	}

	@Value("${app.envars.meta4.login.server}")
	@Override
	protected void setServer(String server) {
		LOG.info("Inicio :: Meta4ClientIncomeConfig.setServer(): {}", server);
		super.server = server;
		LOG.info("Fin :: Meta4ClientIncomeConfig.setServer(): {}", server);
	}

}