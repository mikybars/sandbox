package com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class GetEmpleadosTiendaFilterDTO implements Serializable {

	private static final long serialVersionUID = 8671345877698808568L;

	private Date fechaInicio;

	private Date fechaFin;

	private String idLugarTrabajo;

	private String idEstado;

	private String idEstadoMtu;

}