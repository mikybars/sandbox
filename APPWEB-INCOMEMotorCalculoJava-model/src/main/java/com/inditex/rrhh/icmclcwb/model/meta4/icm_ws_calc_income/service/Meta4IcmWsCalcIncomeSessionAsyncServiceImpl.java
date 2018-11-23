package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionService;

@Service
public class Meta4IcmWsCalcIncomeSessionAsyncServiceImpl implements Meta4IcmWsCalcIncomeSessionAsyncService {

    @Autowired
	private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

}