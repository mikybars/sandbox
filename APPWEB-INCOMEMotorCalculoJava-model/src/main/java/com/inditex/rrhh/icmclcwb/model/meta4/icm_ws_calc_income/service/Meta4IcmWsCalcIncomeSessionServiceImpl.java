package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.meta4.service.Meta4PageableServiceImpl;

@Service
public class Meta4IcmWsCalcIncomeSessionServiceImpl extends Meta4PageableServiceImpl implements Meta4IcmWsCalcIncomeSessionService {

	@Autowired
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;
	   
    @Override
    public List<TiendasEmpleadoResultItemDto> getTiendasEmpleado(final TiendasEmpleadoRequestDto request)
            throws Exception {
    	return getResultItem(request, meta4IcmWsCalcIncomeService, "getTiendasEmpleado", 10);
    }

}