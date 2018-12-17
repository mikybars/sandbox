package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.tiendasempleado.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Pageable;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.generic.dto.GenericFilterDto;

public class TiendasEmpleadoRequestDto extends PageableDto<GenericFilterDto>
		implements Pageable<GenericFilterDto>, Serializable {

	private static final long serialVersionUID = -5680072178017014223L;

}
