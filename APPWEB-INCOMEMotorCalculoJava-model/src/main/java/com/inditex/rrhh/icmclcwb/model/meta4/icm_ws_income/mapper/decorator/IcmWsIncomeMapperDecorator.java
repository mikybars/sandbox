package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.mapper.decorator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inditex.rrhh.icmclcwb.api.meta4.PageDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadosestructura.dto.EmpleadosEstructuraFilterDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaFilterDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.valorescondiciones.dto.ValoresCondicionesFilterDTO;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrosempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrosempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrosplantillaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrosplantillaRecord;
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
	public IcmParametrostiendaBlock asIcmParametrostiendaBlock(EmpleadosTiendaFilterDTO src) {
		IcmParametrostiendaBlock result = delegate.asIcmParametrostiendaBlock(src);
		result.getIcmParametrostiendaRecordSet().add(new IcmParametrostiendaRecord());
		return result;
	}
	
	@Override
	public IcmParametrosempleadoBlock asIcmParametrosempleadoBlock(EmpleadosEstructuraFilterDTO src) {
		IcmParametrosempleadoBlock result = delegate.asIcmParametrosempleadoBlock(src);
		result.getIcmParametrosempleadoRecordSet().add(new IcmParametrosempleadoRecord());
		return result;
	}
	
	@Override
	public IcmParametrosplantillaBlock asIcmParametrosplantillaBlock(ValoresCondicionesFilterDTO src) {
		IcmParametrosplantillaBlock result = delegate.asIcmParametrosplantillaBlock(src);
		result.getIcmParametrosplantillaRecordSet().add(new IcmParametrosplantillaRecord());
		return result;
	}	
}