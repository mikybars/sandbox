package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.comisionempleado.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericEmpleadoResultItemDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ComisionEmpleadoResponseDto extends PageableListDto<GenericEmpleadoResultItemDto>
		implements PageableList<GenericEmpleadoResultItemDto>, Serializable {

	private static final long serialVersionUID = 6689962297446357623L;

}
