package com.inditex.rrhh.icmclcwb.config.meta4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmWsIncomeService;

@Configuration
public class Meta4IcmWsIncomeClientConfig extends Meta4ClientConfigAbstract<IcmWsIncomeService> {

	//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean(name = "meta4IcmWsIncomeClient")
	@Override
	public IcmWsIncomeService init() {
		return super.build(IcmWsIncomeService.class);
	}

    @Value("${app.envars.meta4.icm-ws-income.server}")
	@Override
	protected void setServer(String server) {
		super.server = server;
	}

}