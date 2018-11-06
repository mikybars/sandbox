package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.PageableList;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmpleadosTiendaResponseDto extends PageableListDto<EmpleadosTiendaResultItemDto>
implements PageableList<EmpleadosTiendaResultItemDto>, Serializable {

	private static final long serialVersionUID = -7405814714048508075L;

}
