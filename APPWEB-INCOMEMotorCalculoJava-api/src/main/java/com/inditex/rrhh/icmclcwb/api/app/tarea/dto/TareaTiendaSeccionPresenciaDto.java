package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Deprecated
@Data
public class TareaTiendaSeccionPresenciaDto implements Serializable {

	private static final long serialVersionUID = -265327328731996046L;

	@ApiModelProperty(value = "Identificador de la entidad", required = false, accessMode = AccessMode.READ_ONLY)
	private Long id;
	
	@NotNull
	@ApiModelProperty(value = "Tarea", required = true)
	private Long idTarea;
	
	@ApiModelProperty(value = "Fecha en la que se consultó la venta", required = true, accessMode = AccessMode.READ_ONLY)
	private LocalDate fecha;
	
	@NotBlank
	@ApiModelProperty(value = "Id de la tienda", required = true)
	private String idTienda;
	
	@NotBlank
	@ApiModelProperty(value = "Id de la seccion", required = true)
	private String idSeccion;

	@NotNull
	@ApiModelProperty(value = "Tiempo", required = false, accessMode = AccessMode.READ_ONLY)
	private Long minutos;
}
