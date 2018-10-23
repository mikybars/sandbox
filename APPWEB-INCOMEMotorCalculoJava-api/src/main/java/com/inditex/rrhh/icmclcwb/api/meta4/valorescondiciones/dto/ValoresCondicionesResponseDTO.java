package com.inditex.rrhh.icmclcwb.api.meta4.valorescondiciones.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.PageableListDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.PageableList;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ValoresCondicionesResponseDTO extends PageableListDTO<ValoresCondicionesResultItemDTO>
implements PageableList<ValoresCondicionesResultItemDTO>, Serializable {
	
	private static final long serialVersionUID = -360071315256543511L;


}
