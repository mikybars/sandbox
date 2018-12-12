package com.inditex.rrhh.icmclcwb.config.meta4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientAbstract;

@Configuration
public class Meta4IcmWsCalcIncomeClientConfig extends Meta4ClientAbstract<IcmWsCalcIncomeService> {

	@Value("${app.envars.meta4.icm-ws-calc-income.server}")
	@Override
	protected void setServer(String server) {
		super.server = server;
	}
	
	@Bean(name = "meta4IcmWsCalcIncomeClient")
	@Override
	public IcmWsCalcIncomeService client() {
		return super.build(IcmWsCalcIncomeService.class);
	}

	@Bean(name = "meta4IcmWsCalcIncomeClientFactory")
	@Override
	protected Meta4ClientAbstract<IcmWsCalcIncomeService> factory() {
		return this;
	}

}