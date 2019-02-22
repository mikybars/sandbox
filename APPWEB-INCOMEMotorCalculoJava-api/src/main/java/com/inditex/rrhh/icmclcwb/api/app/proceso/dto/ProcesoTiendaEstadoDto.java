package com.inditex.rrhh.icmclcwb.api.app.proceso.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class ProcesoTiendaEstadoDto implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	@EqualsAndHashCode.Exclude
	@ApiModelProperty(value = "Identificador de la tienda", required = false)
	private String id;

	@EqualsAndHashCode.Exclude
	@NotNull
	@ApiModelProperty(value = "Identificador del proceso", required = true)
	private Long idProceso;

	@NotBlank
	@ApiModelProperty(value = "Id de la tienda", required = true)
	private String idTienda;

	@NotBlank
	private String idTiendaMeta4;

	@NotBlank
	private String idPais;

	@NotBlank
	private String idPaisOrigen;

	@NotBlank
	private String idEmpresa;

	@NotBlank
	private String idCadena;

	@EqualsAndHashCode.Exclude
	@NotNull
	@ApiModelProperty(value = "Tipo de la tienda en la operación", required = true)
	private TipoProcesoTiendaDto tipo;

}