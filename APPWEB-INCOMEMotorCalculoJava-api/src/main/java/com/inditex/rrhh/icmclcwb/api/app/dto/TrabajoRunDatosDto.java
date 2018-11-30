package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ApiModel(description = "Modelo TrabajoRunDatosDto")
@Data
@ToString(callSuper = false)
public class TrabajoRunDatosDto implements Serializable {

    private static final long serialVersionUID = -7845168234640449805L;

    @ApiModelProperty(value = "Ids de las cadenas a ejecutar", required = false)
	private List<String> cadenasEmpresa;
	
	@ApiModelProperty(value = "Ids de las tiendas localizadas en presencias", required = false)
	private Set<Integer> tiendasPresencia;
	
	@ApiModelProperty(value = "Ids de las tiendas nuevas localizadas en presencias", required = false)
	private List<Integer> tiendasPresenciaNuevas;

}
