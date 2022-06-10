package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

/*
 * Copyright (c) 2022. Inditex
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Modelo MailAmbitoDto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailAmbitoDto {

  @NotBlank
  @ApiModelProperty(value = "Identificador del origen", required = true)
  private String cclIdOrigen;

  @NotBlank
  @ApiModelProperty(value = "Id de la empresa", required = true, example = "8")
  private String stdIdLegEnt;

  @NotBlank
  @ApiModelProperty(value = "Direccion de correo", required = true, example = "aaa@inditex.com")
  private String mail;

  @NotNull
  @ApiModelProperty(value = "Flag es activo", required = true)
  private Boolean esActivo;

}
