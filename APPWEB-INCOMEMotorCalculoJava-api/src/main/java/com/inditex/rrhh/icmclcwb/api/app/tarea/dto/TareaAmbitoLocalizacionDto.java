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
public class TareaAmbitoLocalizacionDto implements Serializable {

  private static final long serialVersionUID = 872769150714543322L;

  @ApiModelProperty(value = "Identificador del ambito localizacion del trabajo", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long id;

  @ApiModelProperty(value = "Identificador del ambito de la tarea", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long idTarea;

  @NotBlank
  @ApiModelProperty(value = "Id de la sociedad", required = true, example = "11")
  private String cclIdOrigen;

  @NotBlank
  @ApiModelProperty(value = "Id de la localizacion", required = true, example = "T57")
  private String stdIdWorkLocat;

}
