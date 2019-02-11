package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;

@ApiModel(description = "Modelo ProgramacionDto")
@Data
public class ProgramacionDto implements Serializable {

	private static final long serialVersionUID = 3665361916795418905L;

	@ApiModelProperty(value = "Identificador de la programación", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
	private Long id;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = AppConstants.LOCAL_TIME_JSON)
	@ApiModelProperty(value = "Hora planificada de ejecución", required = true, dataType = "java.lang.String", example = "10:12")
	private LocalTime hora;

	@ApiModelProperty(value = "Huso horario de la hora planificada de ejecución", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
	private String huso;

	@NotNull
	@ApiModelProperty(value = "Si la planificación está [activada|desactivada]", required = true, example = "true")
	private Boolean activa;

	@NotBlank
	@ApiModelProperty(value = "Id del páis origen a ejecutar", required = true, example = "11")
	private String idPaisOrigen;

	@NotBlank
	@ApiModelProperty(value = "Id de la empresa a ejecutar", required = true, example = "8")
	private String idEmpresa;

	@ApiModelProperty(value = "Ids de las tiendas a ejecutar", required = false)
	private List<ProgramacionTiendaDto> tiendas;

	@ApiModelProperty(value = "Ids de los empleados a ejecutar", required = false)
	private List<ProgramacionEmpleadoDto> empleados;

	@ApiModelProperty(value = "Id del usuario que planificó la ejecución", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
	private String idUsuario;

	@ApiModelProperty(value = "Fecha en la que se creo la planificación", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
	private LocalDateTime fechaCreacion;

	@ApiModelProperty(value = "Fecha de la ultima ejecución", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
	private LocalDateTime fechaUltimaEjecucion;

	@ApiModelProperty(value = "Fecha de la siguiente ejecución", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
	private LocalDateTime fechaSiguienteEjecucion;

}