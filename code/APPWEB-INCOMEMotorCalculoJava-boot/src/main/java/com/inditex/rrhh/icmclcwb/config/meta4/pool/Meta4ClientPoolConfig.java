package com.inditex.rrhh.icmclcwb.config.meta4.pool;

import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientAbstract;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientFactory;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Meta4ClientPoolConfig {

  private final Meta4ClientConfigProperties meta4ClientConfigProperties;

  @Bean(name = "meta4ClientPool")
  public Meta4ClientPool meta4ClientPool(
      @Qualifier("meta4LoginClientFactory") final Meta4ClientAbstract<LoginService> meta4LoginClientFactory,
      @Qualifier("meta4IcmWsCalcIncomeClientFactory") final Meta4ClientAbstract<IcmWsCalcIncomeService> meta4IcmWsCalcIncomeClientFactory) {
    Meta4ClientFactory meta4ClientFactory = new Meta4ClientFactory();
    meta4ClientFactory.setMeta4ClientCredentials(meta4ClientConfigProperties.getCredentials());
    meta4ClientFactory.setMeta4ClientProperties(meta4ClientConfigProperties.getPool());
    meta4ClientFactory.setLoginServiceFactory(meta4LoginClientFactory);
    meta4ClientFactory.setIcmWsCalcIncomeServiceFactory(meta4IcmWsCalcIncomeClientFactory);
    return new Meta4ClientPool(meta4ClientFactory);
  }

}
