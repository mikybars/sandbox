package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.Pageable;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericFilterDto;

public class SearchTiendasRequestDto extends PageableDto<GenericFilterDto>
		implements Pageable<GenericFilterDto>, Serializable {

	private static final long serialVersionUID = -6594522575407115739L;

}
