package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Modelo TrabajoRunDatosBloqueDto")
@Data
public class TrabajoRunDatosBloqueDto implements Serializable {

    private static final long serialVersionUID = -7845168234640449805L;

	private Set<String> cadenaEmpresa = new HashSet<>();
	
	private Set<String> tiendaMeta4 = new HashSet<>();
	
	private Set<String> tiendaMtu = new HashSet<>();
	
	private boolean pivot = false;
	
	private Set<String> empleadoLocal = new HashSet<>();
	
	private Set<String> empleadoUniversal = new HashSet<>();
	
	private Set<String> tiendaPresencia = new HashSet<>();
	
	private Set<TrabajoTiendaEstadoDto> tienda = new HashSet<>();
	
	private Set<TrabajoEmpleadoEstadoDto> empleado = new HashSet<>();

}

