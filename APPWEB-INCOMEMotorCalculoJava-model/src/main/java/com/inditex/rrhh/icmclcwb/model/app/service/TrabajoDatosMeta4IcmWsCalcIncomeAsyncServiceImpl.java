package com.inditex.rrhh.icmclcwb.model.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeService;

@Service
public class TrabajoDatosMeta4IcmWsCalcIncomeAsyncServiceImpl implements TrabajoDatosMeta4IcmWsCalcIncomeAsyncService {

	@Autowired
	private TrabajoDatosMeta4IcmWsCalcIncomeService trabajoDatosMeta4IcmWsCalcIncomeService;

}