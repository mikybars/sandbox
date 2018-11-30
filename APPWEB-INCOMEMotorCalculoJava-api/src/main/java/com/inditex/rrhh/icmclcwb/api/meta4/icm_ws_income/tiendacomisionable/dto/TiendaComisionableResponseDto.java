package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendacomisionable.dto;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.PageableList;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TiendaComisionableResponseDto extends PageableListDto<TiendaComisionableResultItemDto>
		implements PageableList<TiendaComisionableResultItemDto> {

	private static final long serialVersionUID = -4611183939831444267L;

}
