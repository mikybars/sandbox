package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
  private String cclIdPerson;

  @NotBlank
  @ApiModelProperty(value = "Ordinal del empleado", required = true)
  private String stdOrHrPeriod;

  @NotBlank
  @ApiModelProperty(value = "Identificador del origen", required = true)
  private String cclIdOrigen;

  @NotNull
  @ApiModelProperty(value = "Estado de la tarea", required = true)
  private EstadoTareaPersonaDto estado;

}
