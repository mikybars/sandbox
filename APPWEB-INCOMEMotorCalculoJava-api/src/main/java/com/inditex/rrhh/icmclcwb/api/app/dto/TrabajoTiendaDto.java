package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Data
public class TrabajoTiendaDto implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	@ApiModelProperty(value = "Identificador de la tienda", required = false)
	private String id;

	@NotBlank
	@ApiModelProperty(value = "Trabajo", required = false)
	private TrabajoDto trabajo;
	
	@NotBlank
	@ApiModelProperty(value = "Id de la tienda", required = false)
	private String idTienda;

}