package com.inditex.rrhh.icmclcwb.api.app.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.validation.constraints.NotNull;

@ApiModel(description = "Modelo ProgramacionDto")
@Data
public class ProgramacionDto implements Serializable {

	private static final long serialVersionUID = 3665361916795418905L;

	@ApiModelProperty(value = "Identificador de la programación", required = false, readOnly = true)
	private Integer id;
	
	@NotNull
	@ApiModelProperty(value = "Hora planificada de ejecución", required = true)
	private LocalTime hora;

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
	@ApiModelProperty(value = "Id del usuario que planificó la ejecución", required = true)
	private String idUsuario;

	@NotNull
	@ApiModelProperty(value = "Cuantos períodos se van a lanzar", required = true)
	private Long periodo;

	@ApiModelProperty(value = "Fecha en la que se creo la planificación", required = false, readOnly = true, hidden = true)
	private LocalDateTime fechaCreacion;

	@ApiModelProperty(value = "Fecha de la siguiente ejecución", required = false, readOnly = true, hidden = true)
	private LocalDateTime fechaSiguienteEjecucion;

}