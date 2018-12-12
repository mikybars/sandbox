package com.inditex.rrhh.icmclcwb.config.meta4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientAbstract;

@Configuration
public class Meta4IcmWsIncomeClientConfig extends Meta4ClientAbstract<IcmWsIncomeService> {

	@Value("${app.envars.meta4.icm-ws-income.server}")
	@Override
	protected void setServer(String server) {
		super.server = server;
	}
	
	@Bean(name = "meta4IcmWsIncomeClient")
	@Override
	public IcmWsIncomeService client() {
		return super.build(IcmWsIncomeService.class);
	}

	@Bean(name = "meta4IcmWsIncomeClientFactory")
	@Override
	protected Meta4ClientAbstract<IcmWsIncomeService> factory() {
		return this;
	}

}