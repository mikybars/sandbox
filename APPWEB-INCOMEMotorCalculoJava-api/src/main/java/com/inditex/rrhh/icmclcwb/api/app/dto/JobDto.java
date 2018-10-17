package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Data
public class JobDto implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	@ApiModelProperty(value = "Identificador del trabajo", required = false)
	private Long id;

	@ApiModelProperty(value = "Id del páis a ejecutar", required = false)
	private String idPais;

	@ApiModelProperty(value = "Id de la cadena a ejecutar", required = false)
	private String idCadena;

	@ApiModelProperty(value = "Id de la tienda a ejecutar", required = false)
	private String idTienda;

	@ApiModelProperty(value = "Id del empleado a ejecutar", required = false)
	private String idEmpleado;

	@NotNull
	@ApiModelProperty(value = "Id del usuario que solicito el trabajo", required = false)
	private String idUsuario;

	@NotNull
	@ApiModelProperty(value = "Fecha en la que se creo el trabajo", required = false)
	private Date fechaCreacion;

}