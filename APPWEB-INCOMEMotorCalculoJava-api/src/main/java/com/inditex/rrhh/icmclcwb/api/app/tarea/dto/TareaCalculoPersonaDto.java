package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TareaCalculoPersonaDto implements Serializable {

    private static final long serialVersionUID = -3291036377867267819L;

    @ApiModelProperty(value = "Identificador de la entidad", required = false)
	private String id;

	@NotNull
	@ApiModelProperty(value = "Identificador del tarea", required = true)
	private Long idTarea;

	@NotBlank
    @ApiModelProperty(value = "Identificador de la persona", required = true)
	private String idPersona;
	
    @NotBlank
    @ApiModelProperty(value = "Ordinal del empleado", required = true)
    private String orPersona;
	    
    @NotBlank
    @ApiModelProperty(value = "Identificador del origen", required = true)
    private String idOrigen;

    @NotNull
    @ApiModelProperty(value = "Estado de la tarea", required = true)
    private EstadoTareaPersonaDto estado;

}
