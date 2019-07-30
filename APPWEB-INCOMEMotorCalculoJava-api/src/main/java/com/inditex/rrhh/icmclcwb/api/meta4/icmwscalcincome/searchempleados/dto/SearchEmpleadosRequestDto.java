package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Pageable;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;

public class SearchEmpleadosRequestDto extends PageableDto<GenericFilterDto>
		implements Pageable<GenericFilterDto>, Serializable {

	private static final long serialVersionUID = -7913276865987490327L;

}
