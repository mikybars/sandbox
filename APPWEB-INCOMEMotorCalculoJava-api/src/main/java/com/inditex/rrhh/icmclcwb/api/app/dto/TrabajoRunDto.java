package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Modelo TrabajoRunDto")
@Data
public class TrabajoRunDto implements Serializable {

	private static final long serialVersionUID = 989087488383271807L;
	
	@ApiModelProperty(value = "Ids de las cadenas a ejecutar", required = false)
	private List<String> cadenasEmpresa;
	
	private Set<Integer> tiendasPresencia;
	
	private List<Integer> tiendasPresenciaNuevas;

}
