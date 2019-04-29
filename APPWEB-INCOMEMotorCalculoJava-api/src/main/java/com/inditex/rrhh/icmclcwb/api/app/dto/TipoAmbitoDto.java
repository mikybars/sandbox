package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Modelo TipoAmbitoDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TipoAmbitoDto implements Serializable {

	private static final long serialVersionUID = 690542159104929423L;

	@ApiModelProperty(value = "Identificador del tipo ambito", required = true)
	private /* BigInteger */ Long id;

}