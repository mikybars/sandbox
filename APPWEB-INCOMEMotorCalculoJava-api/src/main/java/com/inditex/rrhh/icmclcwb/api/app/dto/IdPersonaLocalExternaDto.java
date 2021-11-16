package com.inditex.rrhh.icmclcwb.api.app.dto;

/*
 * Copyright (c) 2021. Inditex
 */
import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IdPersonaLocalExternaDto implements Serializable {

  private static final long serialVersionUID = 9192003630694997323L;

  @NotBlank
  private String idPersonaLocal;

  @NotBlank
  private LocalDate fechaDesde;

  @NotBlank
  private LocalDate fechaHasta;

}
