package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import lombok.Data;

import java.io.Serializable;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;

@Data
public class Meta4ClientFactory implements Serializable {

	private static final long serialVersionUID = 2155509396792510696L;

	private Meta4ClientCredentials meta4ClientCredentials;

	private Meta4ClientAbstract<LoginService> loginServiceFactory;

	private Meta4ClientAbstract<IcmWsIncomeService> icmWsIncomeServiceFactory;

	private Meta4ClientAbstract<IcmWsCalcIncomeService> icmWsCalcIncomeServiceFactory;

}
