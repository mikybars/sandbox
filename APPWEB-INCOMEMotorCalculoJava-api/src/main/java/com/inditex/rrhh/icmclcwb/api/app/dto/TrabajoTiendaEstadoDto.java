package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Data
public class TrabajoTiendaEstadoDto implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	@ToString.Exclude
	@ApiModelProperty(value = "Identificador de la tienda", required = false)
	private String id;

	@ToString.Exclude
	@NotNull
	@ApiModelProperty(value = "Trabajo", required = true)
	private TrabajoDto trabajo;

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

	@NotNull
	@ApiModelProperty(value = "Estado de la tienda en la operación", required = true)
	private EstadoTrabajoTiendaDto estado;

	@NotNull
	@ApiModelProperty(value = "Tipo de la tienda en la operación", required = true)
	private TipoTrabajoTiendaDto tipo;

}