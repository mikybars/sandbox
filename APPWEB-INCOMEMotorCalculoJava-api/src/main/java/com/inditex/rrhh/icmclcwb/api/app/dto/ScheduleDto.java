package com.inditex.rrhh.icmclcwb.api.app.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

@ApiModel(description = "Modelo ScheduleDto")
@Data
public class ScheduleDto implements Serializable {

	private static final long serialVersionUID = 3665361916795418905L;

	@ApiModelProperty(value = "Identificador de la planificación", required = true)
	private Integer id;
	
	@NotNull
	@ApiModelProperty(value = "Hora planificada de ejecución", required = true)
	private Date hora;

	@NotNull
	@ApiModelProperty(value = "Si la planificación está [activada|desactivada]", required = true)
	private Boolean activa;

	@ApiModelProperty(value = "Id del páis a ejecutar", required = false)
	private String idPais;

	@ApiModelProperty(value = "Id de la cadena a ejecutar", required = false)
	private String idCadena;

	@ApiModelProperty(value = "Id de la tienda a ejecutar", required = false)
	private String idTienda;

	@ApiModelProperty(value = "Id del empleado a ejecutar", required = false)
	private String idEmpleado;

	@NotNull
	@ApiModelProperty(value = "Id del usuario que planificó la ejecución", required = false)
	private String idUsuario;

	@NotNull
	@ApiModelProperty(value = "Cuantos períodos se van a lanzar", required = false)
	private Long periodo;

	@NotNull
	@ApiModelProperty(value = "Fecha en la que se creo la planificación", required = false)
	private Date fechaCreacion;

	@NotNull
	@ApiModelProperty(value = "Fecha de la siguiente ejecución", required = false)
	private Date fechaSiguienteEjecucion;

}