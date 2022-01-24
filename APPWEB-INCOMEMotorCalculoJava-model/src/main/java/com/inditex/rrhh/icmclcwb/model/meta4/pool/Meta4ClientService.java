package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;

import lombok.Data;

@Data
public class Meta4ClientService implements Serializable {

  private static final long serialVersionUID = -3473147313502370674L;

  private LoginService loginService;

  private IcmWsCalcIncomeService icmWsCalcIncomeService;

}
