package com.inditex.rrhh.icmclcwb.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmWsIncomeService;

@Configuration
public class Meta4ClientIncomeConfig extends Meta4ClientConfigAbstract<IcmWsIncomeService> {

	@Autowired
    private Logger LOG;

	@Bean(name = "meta4ClientIncome")
	@Override
	public IcmWsIncomeService init() {
		LOG.info("INICIO init()");
		IcmWsIncomeService result = super.build(IcmWsIncomeService.class);
		LOG.info("FIN init()");
		return result;
	}

    @Value("${app.envars.meta4.income.server}")
	@Override
	protected void setServer(String server) {
		LOG.info("INICIO setServer() server: {}", server);
		super.server = server;
		LOG.info("FIN setServer() server: {}", server);
	}

}