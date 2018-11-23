package com.inditex.rrhh.icmclcwb.config.meta4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmWsCalcIncomeService;

@Configuration
public class Meta4IcmWsCalcIncomeClientConfig extends Meta4ClientConfigAbstract<IcmWsCalcIncomeService> {

	@Bean(name = "meta4IcmWsCalcIncomeClient")
	@Override
	public IcmWsCalcIncomeService init() {
		return super.build(IcmWsCalcIncomeService.class);
	}

	@Value("${app.envars.meta4.icm-ws-calc-income.server}")
	@Override
	protected void setServer(String server) {
		super.server = server;
	}

}