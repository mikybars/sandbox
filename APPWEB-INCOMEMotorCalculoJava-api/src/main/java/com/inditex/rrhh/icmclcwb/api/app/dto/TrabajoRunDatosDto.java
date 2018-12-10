package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Modelo TrabajoRunDatosDto")
@Data
public class TrabajoRunDatosDto implements Serializable {

    private static final long serialVersionUID = -7845168234640449805L;

    @ApiModelProperty(value = "Ids de las cadenas a ejecutar", required = false)
	private Set<String> cadenasEmpresa = new HashSet<>();
	
	@ApiModelProperty(value = "Ids de las tiendas localizadas en presencias", required = false)
	private Set<Integer> tiendasPresencia = new HashSet<>();
	
	@ApiModelProperty(value = "Ids de las tiendas nuevas localizadas en presencias", required = false)
	private List<Integer> tiendasPresenciaNuevas = new ArrayList<>();
		
    @ApiModelProperty(value = "Agrupacion de identificadores de los tipos de cálculo a ejecutar", required = false)
	private List<Integer> tiposCalculo;
    
    @ApiModelProperty(value = "Ids de los empleados a ejecutarr", required = false)
	private List<Integer> idsEmpleados;

}

