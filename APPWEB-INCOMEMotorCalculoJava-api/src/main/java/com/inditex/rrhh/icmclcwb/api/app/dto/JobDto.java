package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Modelo JobDto")
@Data
public class JobDto implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	@ApiModelProperty(value = "Identificador del trabajo", required = false)
	private Long id;

	@NotNull
	@ApiModelProperty(value = "Estado actual del trabajo", required = true)
	private /* BigInteger */ JobStatusDto estado;

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
	@ApiModelProperty(value = "Fecha en la que se creo el trabajo", required = false, readOnly = true)
	private LocalDateTime fechaCreacion;

	@ApiModelProperty(value = "Fecha en la que se empieza a procesar", required = false)
	private LocalDateTime fechaInicioJob;

	@ApiModelProperty(value = "Fecha en la que se termina de procesar", required = false)
	private LocalDateTime fechaFinJob;

	@NotNull
	@ApiModelProperty(value = "Fecha inicio del periodo a procesar", required = true)
	private LocalDateTime fechaInicioPeriodo;

	@NotNull
	@ApiModelProperty(value = "Fecha fin del periodo a procesar", required = true)
	private LocalDateTime fechaFinPeriodo;
	
	@ApiModelProperty(value = "Programación asociada", required = false)
	private ScheduleDto schedule;

}