package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaConfiguracionPrecioHoraDto implements Serializable {

  private static final long serialVersionUID = 4336409770546732390L;

  @ApiModelProperty(value = "Identificador de la entidad", required = false, accessMode = AccessMode.READ_ONLY)
  private Long id;

  @NotNull
  @ApiModelProperty(value = "Tarea", required = true)
  private Long idTarea;

  @NotNull
  @ApiModelProperty(value = "Check tipo hora", required = true)
  private Boolean icmCkTpHoraComis;

  @NotNull
  @ApiModelProperty(value = "Check tipo hora", required = true)
  private Boolean icmCkTpHoraIncPtpo;

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
