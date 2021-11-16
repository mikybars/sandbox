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
public class TareaAmbitoDto implements Serializable {

  private static final long serialVersionUID = -5009774080452288030L;

  @ApiModelProperty(value = "Identificador del ambito origen de la tarea", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long id;

  @ApiModelProperty(value = "Identificador de la tarea", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long idTarea;

  @NotBlank
  @ApiModelProperty(value = "Id del origen", required = true, example = "11")
  private String cclIdOrigen;

}
