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
public class IdTareaFaseAccionDto implements Serializable {

  private static final long serialVersionUID = 1266020308670264492L;

  @NotBlank
  private String idTareaFaseAccion;

}
