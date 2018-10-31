package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.PageableList;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmpleadosEstructuraResponseDto extends PageableListDto<EmpleadosEstructuraResultItemDto>
implements PageableList<EmpleadosEstructuraResultItemDto>, Serializable {

	private static final long serialVersionUID = -7405814714048508075L;

}
