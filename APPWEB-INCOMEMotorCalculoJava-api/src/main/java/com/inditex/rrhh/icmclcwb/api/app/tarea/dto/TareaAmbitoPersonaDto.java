package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TareaAmbitoPersonaDto implements Serializable {

  private static final long serialVersionUID = -5751239783803104019L;

  @ApiModelProperty(value = "Identificador del ambito persona de la tarea", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long id;

  @ApiModelProperty(value = "Identificador del ambito de la tarea", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long idTarea;

  @NotBlank
  @ApiModelProperty(value = "Id del origen", required = true, example = "11")
  private String cclIdOrigen;

  @NotBlank
  @ApiModelProperty(value = "Id de la persona", required = true, example = "1000")
  private String cclIdPerson;

  @NotBlank
  @ApiModelProperty(value = "Ordinal de la persona", required = true, example = "1")
  private String stdOrHrPeriod;

}
