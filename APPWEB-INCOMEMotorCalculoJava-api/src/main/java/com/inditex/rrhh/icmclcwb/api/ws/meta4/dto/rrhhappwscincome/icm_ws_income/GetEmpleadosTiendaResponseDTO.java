package com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.ws.meta4.rrhhappwscincome.icm_ws_income.PageableList;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetEmpleadosTiendaResponseDTO extends PageableListDTO<GetEmpleadosTiendaResultItemDTO>
				implements PageableList<GetEmpleadosTiendaResultItemDTO>, Serializable {

	private static final long serialVersionUID = 1252904251355771615L;

}