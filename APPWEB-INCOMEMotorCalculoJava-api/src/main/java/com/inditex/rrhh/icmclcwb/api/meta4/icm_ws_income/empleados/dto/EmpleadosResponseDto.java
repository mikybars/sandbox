package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleados.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericEmpleadoResultItemDto;

public class EmpleadosResponseDto extends PageableListDto<GenericEmpleadoResultItemDto>
		implements PageableList<GenericEmpleadoResultItemDto>, Serializable {

	private static final long serialVersionUID = 7095948368921075557L;

}
