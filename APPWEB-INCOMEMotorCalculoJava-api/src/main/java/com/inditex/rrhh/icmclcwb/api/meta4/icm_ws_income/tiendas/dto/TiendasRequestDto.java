package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.Pageable;

public class TiendasRequestDto extends PageableDto<TiendasFilterDto>
implements Pageable<TiendasFilterDto>, Serializable{

	private static final long serialVersionUID = 6725372222617466870L;

}
