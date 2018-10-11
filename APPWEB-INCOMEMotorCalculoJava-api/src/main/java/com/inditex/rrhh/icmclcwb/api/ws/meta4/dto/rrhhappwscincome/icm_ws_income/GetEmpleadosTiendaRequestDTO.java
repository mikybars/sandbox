package com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.Pageable;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetEmpleadosTiendaRequestDTO extends PageableDTO<GetEmpleadosTiendaFilterDTO>
				implements Pageable<GetEmpleadosTiendaFilterDTO>, Serializable {

	private static final long serialVersionUID = -674574769419150957L;

}