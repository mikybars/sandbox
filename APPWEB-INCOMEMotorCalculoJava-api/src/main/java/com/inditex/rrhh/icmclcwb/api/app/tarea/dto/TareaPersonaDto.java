package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TareaPersonaDto implements Serializable {

	private static final long serialVersionUID = 1168987218682802281L;

	@ApiModelProperty(value = "Identificador del empleado", required = false)
	private String id;

	@NotNull
	@ApiModelProperty(value = "Identificador del tarea", required = true)
	private Long idTarea;

	@NotBlank
    @ApiModelProperty(value = "Identificador del empleado local", required = true)
	private String idEmpleadoLocal;
	
    @NotBlank
    @ApiModelProperty(value = "Identificador del origen", required = true)
    private String idOrigen;

}
