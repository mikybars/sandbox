package com.inditex.rrhh.icmclcwb.api.app.dto;

/*
 * Copyright (c) 2022. Inditex
 */
import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class IdPersonaHIstoricoLocalizacionDto implements Serializable {

  private static final long serialVersionUID = -5601831388473931332L;

  @NotBlank
  private String stdIdHr;

  @NotBlank
  private String stdOrHrPeriod;

  private String cclIdPerson;

  private String stdIdWorkLocat;
}
