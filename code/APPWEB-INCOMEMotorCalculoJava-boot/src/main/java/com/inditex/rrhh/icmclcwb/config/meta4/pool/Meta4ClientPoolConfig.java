package com.inditex.rrhh.icmclcwb.config.meta4.pool;

import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientAbstract;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientFactory;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Meta4ClientPoolConfig {

  @Autowired
  @Qualifier("meta4ClientConfigProperties")
  private Meta4ClientConfigProperties config;

  @Bean(name = "meta4ClientPool")
  public Meta4ClientPool meta4ClientPool(
      @Qualifier("meta4LoginClientFactory") final Meta4ClientAbstract<LoginService> meta4LoginClientFactory,
      @Qualifier("meta4IcmWsCalcIncomeClientFactory") final Meta4ClientAbstract<IcmWsCalcIncomeService> meta4IcmWsCalcIncomeClientFactory) {
    final Meta4ClientFactory meta4ClientFactory = new Meta4ClientFactory();
    meta4ClientFactory.setMeta4ClientCredentials(this.config.getCredentials());
    meta4ClientFactory.setMeta4ClientProperties(this.config.getPool());
    meta4ClientFactory.setLoginServiceFactory(meta4LoginClientFactory);
    meta4ClientFactory.setIcmWsCalcIncomeServiceFactory(meta4IcmWsCalcIncomeClientFactory);
    return new Meta4ClientPool(meta4ClientFactory);
  }

}
