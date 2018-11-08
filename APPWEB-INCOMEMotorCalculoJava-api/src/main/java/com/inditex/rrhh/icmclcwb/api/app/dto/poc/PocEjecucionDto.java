package com.inditex.rrhh.icmclcwb.api.app.dto.poc;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PocEjecucionDto implements Serializable {

	private static final long serialVersionUID = -1304185252983882000L;

	private /* BigInteger */ Long id;

	private LocalDateTime fechaCreacion;

	@NotBlank
	private String sistema;

	private /* BigInteger */ Long idSistemaEjecucion;

	@NotBlank
	@ApiModelProperty(value = "Identificador del periodo", required = true, example = "1")
	private String periodo;
	
	@NotBlank
	@ApiModelProperty(value = "Identificador del país", required = true, example = "724")
	private String idPais;

	@NotBlank
	@ApiModelProperty(value = "Identificador de la empresa", required = true, example = "8")
	private String idEmpresa;

	private List<String> tiendas;

}