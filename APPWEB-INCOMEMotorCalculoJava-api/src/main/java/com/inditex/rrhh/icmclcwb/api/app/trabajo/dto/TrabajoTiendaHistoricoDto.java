package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TrabajoTiendaHistoricoDto implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	@ApiModelProperty(value = "Identificador de la tienda", required = false)
	private String id;

	@NotNull
	@ApiModelProperty(value = "Identificador del trabajo", required = true)
	private Long idTrabajo;

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
    private LocalDateTime fechaInicio;

	@NotNull
    private LocalDateTime fechaFin;
	
	@NotNull
	private Boolean comisionable;

}