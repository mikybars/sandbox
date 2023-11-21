package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClasePersonaSilAmbitoDto implements Serializable {

  @NotBlank
  @ApiModelProperty(value = "Origen", required = true)
  private String cclIdOrigen;

  @NotBlank
  @ApiModelProperty(value = "Clase para origen/empresa", required = true)
  private Integer clase;

  @ApiModelProperty(value = "Estado para una clase")
  private Integer estado;

}
