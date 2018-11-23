package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmWsCalcIncomeService;

@Service
public class Meta4IcmWsCalcIncomeServiceImpl implements Meta4IcmWsCalcIncomeService {

	@Autowired
	@Qualifier("meta4IcmWsCalcIncomeClient")
	private IcmWsCalcIncomeService meta4IcmWsCalcIncomeClient;

}