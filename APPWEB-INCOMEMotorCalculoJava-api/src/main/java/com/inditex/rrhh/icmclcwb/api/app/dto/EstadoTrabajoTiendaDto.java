package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Modelo EstadoTrabajoTiendaDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EstadoTrabajoTiendaDto implements Serializable {

	private static final long serialVersionUID = 690542159104929423L;

	@ApiModelProperty(value = "Identificador del estado del trabajo", required = true)
	private /* BigInteger */ Long id;

}