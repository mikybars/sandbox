package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(description = "Modelo TrabajoRunDto")
@Data
@EqualsAndHashCode(callSuper=false)
public class TrabajoRunDto implements Serializable {

	private static final long serialVersionUID = 989087488383271807L;
	
	@ApiModelProperty(value = "Ids de las cadenas a ejecutar", required = false)
	private List<String> cadenasEmpresa;
}
