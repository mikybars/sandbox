package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaConfiguracionChallengeDiasMinimosDto implements Serializable {

  private static final long serialVersionUID = -4403021667905217229L;

  @ApiModelProperty(value = "Identificador de la entidad", required = false, accessMode = AccessMode.READ_ONLY)
  private Long id;

  @NotNull
  @ApiModelProperty(value = "Tarea", required = true)
  private Long idTarea;

  @NotBlank
  @ApiModelProperty(value = "Id tipo calculo", required = true)
  private String icmIdTpCalculo;

  @NotNull
  @ApiModelProperty(value = "Numero de dias minimo", required = true)
  private Integer icmMinNumDays;

  @NotNull
  @ApiModelProperty(value = "Fecha de inicio de la configuracion", required = true)
  private Date fechaInicio;

  @NotNull
  @ApiModelProperty(value = "Fecha de fin de la configuracion", required = true)
  private Date fechaFin;

  @NotBlank
  @ApiModelProperty(value = "Id origen", required = true)
  private String cclIdOrigen;

}
