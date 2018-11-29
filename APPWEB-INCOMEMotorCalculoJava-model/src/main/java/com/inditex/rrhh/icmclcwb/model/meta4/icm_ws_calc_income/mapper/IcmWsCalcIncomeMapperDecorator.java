package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmParametrospaginacionRecord;

public abstract class IcmWsCalcIncomeMapperDecorator implements IcmWsCalcIncomeMapper {

	@Autowired
    @Qualifier("delegate")
    private IcmWsCalcIncomeMapper delegate;
	
	@Override
	public IcmParametrospaginacionBlock asIcmParametrospaginacionBlock(PageDto src) {
		IcmParametrospaginacionBlock result = delegate.asIcmParametrospaginacionBlock(src);
		result.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
		return result;
	}

}
