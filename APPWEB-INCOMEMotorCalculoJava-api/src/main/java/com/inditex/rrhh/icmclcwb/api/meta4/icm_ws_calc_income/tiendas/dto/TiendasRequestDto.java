package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.tiendas.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Pageable;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.generic.dto.GenericFilterDto;

public class TiendasRequestDto extends PageableDto<GenericFilterDto>
implements Pageable<GenericFilterDto>, Serializable{

	private static final long serialVersionUID = 6725372222617466870L;

}
