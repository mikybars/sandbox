package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.mapper.decorator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaFilterDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.PageDTO;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrostiendaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrostiendaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.mapper.IcmWsIncomeMapper;

public abstract class IcmWsIncomeMapperDecorator implements IcmWsIncomeMapper {

	@Autowired
    @Qualifier("delegate")
    private IcmWsIncomeMapper delegate;

	@Override
	public IcmParametrospaginacionBlock asIcmParametrospaginacionBlock(PageDTO src) {
		IcmParametrospaginacionBlock result = delegate.asIcmParametrospaginacionBlock(src);
		result.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
		return result;
	}

	@Override
	public IcmParametrostiendaBlock asIcmParametrostiendaBlock(GetEmpleadosTiendaFilterDTO src) {
		IcmParametrostiendaBlock result = delegate.asIcmParametrostiendaBlock(src);
		result.getIcmParametrostiendaRecordSet().add(new IcmParametrostiendaRecord());
		return result;
	}
	
}