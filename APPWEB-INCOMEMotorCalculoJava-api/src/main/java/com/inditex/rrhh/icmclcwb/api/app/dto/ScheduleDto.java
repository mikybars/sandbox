package com.inditex.rrhh.icmclcwb.api.app.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(description = "Modelo ScheduleDto")
@Data
public class ScheduleDto implements Serializable {

	private static final long serialVersionUID = 3665361916795418905L;

	@ApiModelProperty(value = "Identificador de la planificación", required = true)
	private Integer id;
	
	@Size(max = 20)
	@NotBlank
    @ApiModelProperty(value = "Name Product", required = true)
	private String name;
	
//	@ApiModelProperty(value = "Hora planificada de ejecución", required = true)
//	private Time hora;
//
//	@ApiModelProperty(value = "Si la planificación está [activada|desactivada]", required = true)
//	private Boolean activa;
//
//	@ApiModelProperty(value = "Id del páis a ejecutar", required = false)
//	private String idPais;
//
//	@ApiModelProperty(value = "Id de la cadena a ejecutar", required = false)
//	private String idCadena;
//
//	@ApiModelProperty(value = "Id de la tienda a ejecutar", required = false)
//	private String idTienda;
//
//	@ApiModelProperty(value = "Id del empleado a ejecutar", required = false)
//	private String idEmpleado;
//
//	@ApiModelProperty(value = "Id del usuario que planificó la ejecución", required = false)
//	private String idUsuario;
//
//	@ApiModelProperty(value = "Cuantos períodos se van a lanzar", required = false)
//	private Long periodo;
//
//	@ApiModelProperty(value = "Fecha en la que se creo la planificación", required = false)
//	private Date fechaCreacion;
//
//	@ApiModelProperty(value = "Fecha de la siguiente ejecución", required = false)
//	private Date fechaSiguienteEjecucion;

}