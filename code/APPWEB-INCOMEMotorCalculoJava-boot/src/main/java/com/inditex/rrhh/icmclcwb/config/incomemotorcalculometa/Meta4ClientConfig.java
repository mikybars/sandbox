package com.inditex.rrhh.icmclcwb.config.incomemotorcalculometa;

import com.inditex.amigafwk.common.soap.client.cxf.annotation.AmigaSoapClient;
import com.inditex.amigafwk.common.soap.client.cxf.factory.CxfClientFactoryBean;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Meta4ClientConfig {

  @AmigaSoapClient("login")
  public CxfClientFactoryBean<LoginService> loginBean() {
    return CxfClientFactoryBean.build(LoginService.class);
  }

  @AmigaSoapClient("meta4")
  public CxfClientFactoryBean<IcmWsCalcIncomeService> meta4Bean() {
    return CxfClientFactoryBean.build(IcmWsCalcIncomeService.class);
  }
}
