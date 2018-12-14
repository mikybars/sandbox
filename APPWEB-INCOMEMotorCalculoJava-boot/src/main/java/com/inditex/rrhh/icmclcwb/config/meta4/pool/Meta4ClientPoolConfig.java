package com.inditex.rrhh.icmclcwb.config.meta4.pool;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientAbstract;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientCredentials;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientFactory;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

@Configuration
public class Meta4ClientPoolConfig {

	@Bean(name = "meta4ClientPool")
	public Meta4ClientPool meta4ClientPool(@Value("${app.envars.meta4.config.credentials.user}") final String user,
			@Value("${app.envars.meta4.config.credentials.password}") final String password,
			@Value("${app.envars.meta4.config.credentials.language}") final String language,
			@Qualifier("meta4LoginClientFactory") final Meta4ClientAbstract<LoginService> meta4LoginClientFactory,
			@Qualifier("meta4IcmWsIncomeClientFactory") final Meta4ClientAbstract<IcmWsIncomeService> meta4IcmWsIncomeClientFactory,
			@Qualifier("meta4IcmWsCalcIncomeClientFactory") final Meta4ClientAbstract<IcmWsCalcIncomeService> meta4IcmWsCalcIncomeClientFactory) {

		Meta4ClientCredentials meta4ClientCredentials = new Meta4ClientCredentials();
		meta4ClientCredentials.setUser(user);
		meta4ClientCredentials.setPassword(password);
		meta4ClientCredentials.setLanguage(language);

		Meta4ClientFactory meta4ClientFactory = new Meta4ClientFactory();
		meta4ClientFactory.setMeta4ClientCredentials(meta4ClientCredentials);
		meta4ClientFactory.setLoginServiceFactory(meta4LoginClientFactory);
		meta4ClientFactory.setIcmWsIncomeServiceFactory(meta4IcmWsIncomeClientFactory);
		meta4ClientFactory.setIcmWsCalcIncomeServiceFactory(meta4IcmWsCalcIncomeClientFactory);

		return new Meta4ClientPool(meta4ClientFactory);
	}

}
