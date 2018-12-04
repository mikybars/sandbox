package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmListatiendasRecord;
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
	
	@Override
    public GenericTiendaResultItemDto asGenericTiendaResultItemDto(IcmListatiendasRecord src) {
        GenericTiendaResultItemDto mappedEntity = delegate.asGenericTiendaResultItemDto(src);
        mappedEntity.setEsComisionable(src.getEscomisionable().trim().equals("S"));
        return mappedEntity;
    }
	
	@Override
    public List<GenericTiendaResultItemDto> asGenericTiendaResultItemDtos(List<IcmListatiendasRecord> src) {
	    List<GenericTiendaResultItemDto> list = new ArrayList<>();
	    for(IcmListatiendasRecord record : src) {
	        GenericTiendaResultItemDto mappedEntity = delegate.asGenericTiendaResultItemDto(record);
	        mappedEntity.setEsComisionable(record.getEscomisionable().trim().equals("S"));
	        list.add(mappedEntity);
	    }
	    return list;
	}
    
	

}
