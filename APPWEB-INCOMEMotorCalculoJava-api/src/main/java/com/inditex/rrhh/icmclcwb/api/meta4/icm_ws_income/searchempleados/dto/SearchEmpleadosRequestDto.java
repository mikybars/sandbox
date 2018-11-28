package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchempleados.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.Pageable;

public class SearchEmpleadosRequestDto extends PageableDto<SearchEmpleadosFilterDto>
		implements Pageable<SearchEmpleadosFilterDto>, Serializable {

	private static final long serialVersionUID = -7913276865987490327L;

}
