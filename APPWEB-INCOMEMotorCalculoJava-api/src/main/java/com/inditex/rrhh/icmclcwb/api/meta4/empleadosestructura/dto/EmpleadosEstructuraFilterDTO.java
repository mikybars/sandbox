package com.inditex.rrhh.icmclcwb.api.meta4.empleadosestructura.dto;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class EmpleadosEstructuraFilterDTO implements Serializable {

	private static final long serialVersionUID = 8863830165103113764L;
	
    private LocalDateTime fechaFin;
    private String idEmpleado;
    private String orEmpleado;
    private LocalDateTime fechaInicio;
    private String idLugarTrabajo;
    private String idOrigenPresencia;

}