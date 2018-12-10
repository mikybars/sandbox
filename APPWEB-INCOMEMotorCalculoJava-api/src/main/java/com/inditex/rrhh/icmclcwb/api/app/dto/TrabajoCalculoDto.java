package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class TrabajoCalculoDto implements Serializable {
	

	private static final long serialVersionUID = 393530362678385905L;

	@ApiModelProperty(value = "Agrupacion de identificadores de los tipos de cálculo a ejecutar", required = false)
	private List<Integer> tiposCalculo;
    
    @ApiModelProperty(value = "Ids de los empleados a ejecutarr", required = false)
	private List<Integer> idsEmpleados;

}
