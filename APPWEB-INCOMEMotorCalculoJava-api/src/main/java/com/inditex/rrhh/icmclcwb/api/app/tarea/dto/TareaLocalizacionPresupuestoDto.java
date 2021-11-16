package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TareaLocalizacionPresupuestoDto implements Serializable {

  private static final long serialVersionUID = -7248640494629053287L;

  @NotNull
  @ApiModelProperty(value = "Tarea", required = true)
  private Long idTarea;

  @ApiModelProperty(value = "Fecha de inicio del presupuesto", required = true,
      accessMode = ApiModelProperty.AccessMode.READ_ONLY)
  private LocalDate fechaInicio;

  @ApiModelProperty(value = "Fecha de fin del presupuesto", required = true,
      accessMode = ApiModelProperty.AccessMode.READ_ONLY)
  private LocalDate fechaFin;

  @NotBlank
  @ApiModelProperty(value = "Id de la localizacion", required = true)
  private String cclIdCodOrigen;

  @NotBlank
  @ApiModelProperty(value = "Id de la seccion", required = true)
  private String cclIdSeccion;

  @NotBlank
  @ApiModelProperty(value = "Id de empresa", required = true)
  private String stdIdLegEnt;

  @NotBlank
  @ApiModelProperty(value = "Id de pais", required = true)
  private String cclIdOrigen;

}
