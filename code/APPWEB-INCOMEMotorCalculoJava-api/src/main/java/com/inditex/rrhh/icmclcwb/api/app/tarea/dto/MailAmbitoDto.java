package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

/*
 * Copyright (c) 2022. Inditex
 */

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailAmbitoDto {

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String stdIdLegEnt;

  @NotBlank
  private String mail;

  @NonNull
  private Boolean esActivo;

}
