package com.inditex.rrhh.icmclcwb.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.LoginService;

@Configuration
public class Meta4ClientLoginConfig extends Meta4ClientConfigAbstract<LoginService> {

	@Autowired
    private Logger LOG;

	@Bean(name = "meta4ClientLogin")
	@Override
	public LoginService init() {
		LOG.info("INICIO init()");
		LoginService result = super.build(LoginService.class);
		LOG.info("FIN init()");
		return result;
	}

	@Value("${app.envars.meta4.login.server}")
	@Override
	protected void setServer(String server) {
		LOG.info("INICIO setServer() server: {}", server);
		super.server = server;
		LOG.info("FIN setServer() server: {}", server);
	}

}