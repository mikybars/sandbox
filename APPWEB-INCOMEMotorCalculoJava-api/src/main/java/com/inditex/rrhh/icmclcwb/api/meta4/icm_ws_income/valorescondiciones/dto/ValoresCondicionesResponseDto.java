package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.PageableList;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ValoresCondicionesResponseDto extends PageableListDto<ValoresCondicionesResultItemDto>
implements PageableList<ValoresCondicionesResultItemDto>, Serializable {
	
	private static final long serialVersionUID = -360071315256543511L;


}
