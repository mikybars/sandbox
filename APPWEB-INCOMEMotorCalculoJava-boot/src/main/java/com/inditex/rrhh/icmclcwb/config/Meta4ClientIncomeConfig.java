package com.inditex.rrhh.icmclcwb.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmWsIncomeService;

@Configuration
public class Meta4ClientIncomeConfig extends Meta4ClientConfigAbstract<IcmWsIncomeService> {

	@Autowired
    private Logger LOG;

	//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean(name = "meta4ClientIncome")
	@Override
	public IcmWsIncomeService init() {
		LOG.info("Inicio :: Meta4ClientIncomeConfig.init()");
		IcmWsIncomeService result = super.build(IcmWsIncomeService.class);
		LOG.info("Fin :: Meta4ClientIncomeConfig.init()");
		return result;
	}

    @Value("${app.envars.meta4.icm-ws-income.server}")
	@Override
	protected void setServer(String server) {
		LOG.info("Inicio :: Meta4ClientIncomeConfig.setServer(): {}", server);
		super.server = server;
		LOG.info("Fin :: Meta4ClientIncomeConfig.setServer(): {}", server);
	}

}