package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Modelo MailEntornoDto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailEntornoDto implements Serializable {

  @NotBlank
  @ApiModelProperty(value = "Entorno", required = true, example = "PRE")
  private String entorno;

  @NotNull
  @ApiModelProperty(value = "Flag activo", required = true)
  private Boolean activo;
}
