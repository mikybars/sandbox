package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionHistoricoDto implements Serializable {

  private static final long serialVersionUID = -5607507260079003307L;

  @ApiModelProperty(value = "Identificador de la tienda", required = false)
  private String id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotBlank
  @ApiModelProperty(value = "Id de la localizacion", required = true)
  private String cclIdCodOrigen;

  @NotBlank
  private String stdIdWorkLocat;

  @NotBlank
  private String stdIdCountry;

  private String stdIdSubGeoDiv;

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String stdIdLegEnt;

  @NotBlank
  private String cclIdCadena;

  @NotNull
  private LocalDateTime fechaInicio;

  @NotNull
  private LocalDateTime fechaFin;

}
