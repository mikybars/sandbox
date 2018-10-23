package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Modelo EstadoTrabajoDto")
@Data
public class EstadoTrabajoDto implements Serializable {

	private static final long serialVersionUID = 690542159104929423L;

	@ApiModelProperty(value = "Identificador del estado del trabajo", required = true)
	private /* BigInteger */ Long id;

}