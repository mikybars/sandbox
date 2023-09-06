package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;

import lombok.Data;

@Data
public class Meta4ClientFactory implements Serializable {

  private static final long serialVersionUID = 2155509396792510696L;

  private Meta4ClientCredentials meta4ClientCredentials;

  private Meta4ClientProperties meta4ClientProperties;

  private Meta4ClientAbstract<LoginService> loginServiceFactory;

  private Meta4ClientAbstract<IcmWsCalcIncomeService> icmWsCalcIncomeServiceFactory;

}
