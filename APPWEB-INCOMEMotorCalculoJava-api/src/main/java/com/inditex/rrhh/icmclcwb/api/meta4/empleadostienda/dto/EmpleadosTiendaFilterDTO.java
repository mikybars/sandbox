package com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EmpleadosTiendaFilterDTO implements Serializable {

	private static final long serialVersionUID = 8671345877698808568L;

	private LocalDateTime fechaFin;
	
	private String idEstado;
	
	private LocalDateTime fechaInicio;

	private String idEstadoMtu;
	
	private String idLugarTrabajo;

}