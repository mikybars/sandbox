package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TareaPersonaHistoricoDto implements Serializable {

	private static final long serialVersionUID = 1168987218682802281L;

	@ApiModelProperty(value = "Identificador del empleado", required = false)
	private String id;

	@NotNull
	@ApiModelProperty(value = "Identificador del tarea", required = true)
	private Long idTarea;

	@NotBlank
	@ApiModelProperty(value = "Id del empleado", required = true)
	private String idEmpleado;

	@NotBlank
	private String orEmpleado;

	@NotBlank
	private String idEmpleadoLocal;

	@NotBlank
	private String idTienda;

	@NotBlank
	private String idTiendaMeta4;

	@NotNull
	private Date fechaInicio;

	@NotNull
	private Date fechaFin;
}
