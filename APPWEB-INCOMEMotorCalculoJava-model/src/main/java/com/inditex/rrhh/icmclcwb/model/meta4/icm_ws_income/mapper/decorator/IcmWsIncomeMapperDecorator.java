package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.mapper.decorator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inditex.rrhh.icmclcwb.api.meta4.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesFilterDto;
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
	public IcmParametrospaginacionBlock asIcmParametrospaginacionBlock(PageDto src) {
		IcmParametrospaginacionBlock result = delegate.asIcmParametrospaginacionBlock(src);
		result.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
		return result;
	}

	@Override
	public IcmParametrostiendaBlock asIcmParametrostiendaBlock(EmpleadosTiendaFilterDto src) {
		IcmParametrostiendaBlock result = delegate.asIcmParametrostiendaBlock(src);
		result.getIcmParametrostiendaRecordSet().add(new IcmParametrostiendaRecord());
		return result;
	}
	
	@Override
	public IcmParametrosempleadoBlock asIcmParametrosempleadoBlock(EmpleadosEstructuraFilterDto src) {
		IcmParametrosempleadoBlock result = delegate.asIcmParametrosempleadoBlock(src);
		result.getIcmParametrosempleadoRecordSet().add(new IcmParametrosempleadoRecord());
		return result;
	}
	
	@Override
	public IcmParametrosplantillaBlock asIcmParametrosplantillaBlock(ValoresCondicionesFilterDto src) {
		IcmParametrosplantillaBlock result = delegate.asIcmParametrosplantillaBlock(src);
		result.getIcmParametrosplantillaRecordSet().add(new IcmParametrosplantillaRecord());
		return result;
	}	
}