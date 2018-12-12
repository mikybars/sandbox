package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import lombok.Data;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;

@Data
public class Meta4ClientService implements Serializable {

	private static final long serialVersionUID = -3473147313502370674L;

	private LoginService loginService;

	private IcmWsIncomeService icmWsIncomeService;

	private IcmWsCalcIncomeService icmWsCalcIncomeService;

}