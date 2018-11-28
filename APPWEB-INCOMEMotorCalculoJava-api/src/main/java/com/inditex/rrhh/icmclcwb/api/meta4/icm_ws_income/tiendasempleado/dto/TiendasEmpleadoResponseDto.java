package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.PageableList;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TiendasEmpleadoResponseDto extends PageableListDto<TiendasEmpleadoResultItemDto>
		implements PageableList<TiendasEmpleadoResultItemDto>, Serializable {

	private static final long serialVersionUID = 7195358579420460119L;

}
