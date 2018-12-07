package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.mapper;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
	
	//TODO: Llegaban fechas con vacío y se controló manualmente
	@Override
    public GenericTiendaResultItemDto asGenericTiendaResultItemDto(IcmListatiendasRecord src) {
        GenericTiendaResultItemDto mappedEntity = delegate.asGenericTiendaResultItemDto(src);
        mappedEntity.setEsComisionable(src.getEscomisionable().trim().equals("S"));
        if ( StringUtils.isNotEmpty(src.getFechainicio()) ) {
            mappedEntity.setFechaInicio( java.time.LocalDateTime.parse( src.getFechainicio(), DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" ) ) );
        }
        if ( StringUtils.isNotEmpty(src.getFechafin())) {
            mappedEntity.setFechaInicio( java.time.LocalDateTime.parse( src.getFechainicio(), DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" ) ) );
        }
        return mappedEntity;
    }
	
    //TODO: Llegaban fechas con vacío y se controló manualmente
	@Override
    public List<GenericTiendaResultItemDto> asGenericTiendaResultItemDtos(List<IcmListatiendasRecord> src) {
	    List<GenericTiendaResultItemDto> list = new ArrayList<>();
	    for(IcmListatiendasRecord record : src) {
	        GenericTiendaResultItemDto mappedEntity = delegate.asGenericTiendaResultItemDto(record);
	        mappedEntity.setEsComisionable(record.getEscomisionable().trim().equals("S"));
	        if ( StringUtils.isNotEmpty(record.getFechainicio()) ) {
	            mappedEntity.setFechaInicio( java.time.LocalDateTime.parse( record.getFechainicio(), DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" ) ) );
	        }
	        if ( StringUtils.isNotEmpty(record.getFechafin())) {
	            mappedEntity.setFechaInicio( java.time.LocalDateTime.parse( record.getFechainicio(), DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" ) ) );
	        }
	        list.add(mappedEntity);
	    }
	    return list;
	}
    
	

}
