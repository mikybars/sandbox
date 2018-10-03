package com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class GetEmpleadosTiendaFilterDTO implements Serializable {

	private static final long serialVersionUID = 8671345877698808568L;

	private LocalDateTime fechaFin;
	
	private String idEstado;
	
	private LocalDateTime fechaInicio;

	private String idEstadoMtu;
	
	private String idLugarTrabajo;

}