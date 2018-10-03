package com.inditex.rrhh.icmclcwb.model.mapper.decorator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaFilterDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.PageDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrostiendaBlock;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrostiendaRecord;
import com.inditex.rrhh.icmclcwb.model.mapper.IcmWsIncomeMapper;

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