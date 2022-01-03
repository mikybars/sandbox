package com.inditex.rrhh.icmclcwb.config.meta4.icmwscalcincome;

import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientAbstract;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Meta4IcmWsCalcIncomeClientConfig extends Meta4ClientAbstract<IcmWsCalcIncomeService> {

  private static final long serialVersionUID = 5789350594490522765L;

  @Value("${app.envars.meta4.icmwscalcincome.server}")
  @Override
  protected void setServer(String server) {
    super.server = server;
  }

  @Bean(name = "meta4IcmWsCalcIncomeClientFactory")
  @Override
  protected Meta4ClientAbstract<IcmWsCalcIncomeService> factory() {
    return this;
  }

}
