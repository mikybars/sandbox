package com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.PageableListDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.PageableList;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmpleadosTiendaResponseDTO extends PageableListDTO<EmpleadosTiendaResultItemDTO>
implements PageableList<EmpleadosTiendaResultItemDTO>, Serializable {

	private static final long serialVersionUID = -7405814714048508075L;

}
