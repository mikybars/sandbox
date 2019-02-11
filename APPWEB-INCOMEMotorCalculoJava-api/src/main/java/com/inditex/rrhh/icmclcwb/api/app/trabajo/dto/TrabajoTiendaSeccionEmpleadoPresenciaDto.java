package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class TrabajoTiendaSeccionEmpleadoPresenciaDto implements Serializable {
	
	private static final long serialVersionUID = -7810063365542169868L;
	
	@ApiModelProperty(value = "Identificador de la entidad", required = false, accessMode = AccessMode.READ_ONLY)
	private Long id;
	
	@ApiModelProperty(value = "Fecha en la que se consultó la presencia", required = true, accessMode = AccessMode.READ_ONLY)
	private LocalDate fecha;
	
	@NotBlank
	@ApiModelProperty(value = "Id de empleado", required = true)
	private String idEmpleado;
	
	@NotBlank
	@ApiModelProperty(value = "Id de la seccion", required = true)
	private String idSeccion;
	
	@NotBlank
	@ApiModelProperty(value = "Id de la tienda", required = true)
	private String idTienda;

	@NotNull
	@ApiModelProperty(value = "Tiempo", required = false, accessMode = AccessMode.READ_ONLY)
	private Long minutos;
	
	@NotNull
	@ApiModelProperty(value = "Trabajo - Tipo Hora", required = true)
	private TrabajoTipoHoraDto trabajoTipoHoraDto;
	
	@NotNull
	@ApiModelProperty(value = "Trabajo", required = true)
	private TrabajoDto trabajoDto;
	
}
