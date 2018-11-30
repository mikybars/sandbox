package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericTiendaResultItemDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TiendasResponseDto extends PageableListDto<GenericTiendaResultItemDto>
implements PageableList<GenericTiendaResultItemDto>, Serializable {
	
	private static final long serialVersionUID = -8247613348197266071L;

}
